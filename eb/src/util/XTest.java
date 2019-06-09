package util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XTest {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub

		String filepath="files/EBI.xml";
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
	        DocumentBuilder builder = null;  
	        FileInputStream inputStream = null;  
	        Document doc = null;    
	        builder = factory.newDocumentBuilder();  
	  
	        /* 通过文件方式读取,注意文件保存的编码和文件的声明编码要一致(默认文件声明是UTF-8) */  
	        File file = new File(filepath);  
	        doc = builder.parse(file);  
//	        System.out.println(make(doc));
//	            /* 通过一个URL方式读取 */  
//	            URI uri = new URI(filePath);//filePath="http://java.sun.com/index.html"  
//	            doc = builder.parse(uri.toString());  
//	  
//	            /* 通过java IO 流的读取 */  
//	            inputStream = new FileInputStream(filePath);  
//	            doc = builder.parse(inputStream);  
	        String str=make(doc);
	        Document docu=string2Doc(str);
	        XmlSignatureUtil xsu=new  XmlSignatureUtil();
	        System.out.println(xsu.validate(doc));
	}
	
	 public static Document string2Doc(String xml) {  
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
	        DocumentBuilder builder = null;  
	        Document doc = null;  
	        InputSource source = null;  
	        StringReader reader = null;  
	        try {  
	            builder = factory.newDocumentBuilder();  
	            reader = new StringReader(xml);  
	            source = new InputSource(reader);//使用字符流创建新的输入源  
	            doc = builder.parse(source);  
	            return doc;  
	        } catch (Exception e) {  
	            return null;  
	        } finally {  
	            if(reader != null){  
	                reader.close();  
	            }  
	        }  
	    }  

	public static String make(Document doc) {
		XmlSignatureUtil xsutil = new XmlSignatureUtil(); //数字签名工具
//		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); //创建DocumentBuilderFactory对象
//		DocumentBuilder builder = null;
		String res = null;
		xsutil.generate(doc);  //进行数字签名
		res = doc2String(doc);  //将document转化为字符串
		return res;
	}
	public static String doc2String(Document doc) {
		TransformerFactory tf = TransformerFactory.newInstance();  //创建TransformerFactory对象
		Transformer transformer = null;
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		try {
			transformer = tf.newTransformer();  //创建Transformer对象
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(doc), new StreamResult(outStream));
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return outStream.toString();
	}
}
