package util;

import java.io.FileInputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Collections;
import java.util.List;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dom.DOMStructure;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlSignatureUtil {

	public Document generate(Document doc) {
		
		//XMLSignatureFactory 是与签名相关的 XML 元素对象的创建工厂
		XMLSignatureFactory xsfactory = XMLSignatureFactory.getInstance();

		Transform envelopedTransform;
		try {
			/* 创建 Reference 的时候将 URI参数指定为 "" 表示对整个 XML 文档进行引用
			 * 摘要算法指定为 SHA1
			 * 转换方式指定为 ENVELOPED，这样在对整个文档进行引用并生成摘要值的时候，
			 * <Signature> 元素不会被计算在内。
			 * */
			envelopedTransform = xsfactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null);
			DigestMethod sha1DigMethod = xsfactory.newDigestMethod(DigestMethod.SHA1, null);
			Reference refToRootDoc = xsfactory.newReference("", sha1DigMethod,
					Collections.singletonList(envelopedTransform), null, null);
			
			/*
			 * <Reference> 元素创建好之后，下一步是创建 <SignedInfo> 元素
			 * 
			 * 需要指定该 XML 元素的规范化方法，以确定最终被处理的数据。这里指定为INCLUSIVE_WITH_COMMENTS,
			 *  表示在规范化 XML 内容的时候会将 XML 注释也包含在内。
			 * */
			//指定标准化方法
			CanonicalizationMethod c14nWithCommentMethod = xsfactory.newCanonicalizationMethod(
					CanonicalizationMethod.INCLUSIVE_WITH_COMMENTS, (C14NMethodParameterSpec) null);
			//指定签名方法
			SignatureMethod dsa_sha1SigMethod = xsfactory.newSignatureMethod(SignatureMethod.DSA_SHA1, null);
			SignedInfo signedInfo = xsfactory.newSignedInfo(c14nWithCommentMethod, dsa_sha1SigMethod,
					Collections.singletonList(refToRootDoc));
			
			KeyPairGenerator kpGen = KeyPairGenerator.getInstance("DSA"); //生成密钥对
			kpGen.initialize(512);
			KeyPair keyPair = kpGen.generateKeyPair(); 
			KeyInfoFactory keyInfoFac = xsfactory.getKeyInfoFactory();
			KeyValue keyValue = keyInfoFac.newKeyValue(keyPair.getPublic());
			//在keyinfo中放入公钥，用于接收方验证
			KeyInfo keyInfo = keyInfoFac.newKeyInfo(Collections.singletonList(keyValue));
			//设置私钥和签名的内容，用于签名
			DOMSignContext dsc = new DOMSignContext(keyPair.getPrivate(), doc.getDocumentElement());

			XMLSignature sign = xsfactory.newXMLSignature(signedInfo, keyInfo);
			sign.sign(dsc);

			return doc;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (KeyException e) {
			e.printStackTrace();
		} catch (MarshalException e) {
			e.printStackTrace();
		} catch (XMLSignatureException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean validate(Document doc) throws Exception {

		// Search the Signature element(找到dom中的signature元素)
		NodeList nl = doc.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");
		if (nl.getLength() == 0) {
			throw new Exception("Cannot find Signature element");
		}
		Node signatureNode = nl.item(0);

		//将signature元素构建为XMLSignature
		XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
		XMLSignature signature = fac.unmarshalXMLSignature(new DOMStructure(signatureNode));

		// Get the public key for signature validation(从keyinfo中获取公钥)
		KeyValue keyValue = (KeyValue) signature.getKeyInfo().getContent().get(0);
		PublicKey pubKey = keyValue.getPublicKey();

		// Create ValidateContext(生成验证内容)
		DOMValidateContext valCtx = new DOMValidateContext(pubKey, signatureNode);

		// Validate the XMLSignature(验证)
		boolean coreValidity = signature.validate(valCtx);

		// Check core validation status
		if (coreValidity == false) {
			System.err.println("Core validation failed");
			// Check the signature validation status
			boolean sv = signature.getSignatureValue().validate(valCtx);
			System.out.println("Signature validation status: " + sv);
			// check the validation status of each Reference
			List refs = signature.getSignedInfo().getReferences();
			for (int i = 0; i < refs.size(); i++) {
				Reference ref = (Reference) refs.get(i);
				boolean refValid = ref.validate(valCtx);
				System.out.println("Reference[" + i + "] validity status: " + refValid);
			}
			return false;
		} else {
			System.out.println("Signature passed core validation");
			return true;
		}
	}

}
