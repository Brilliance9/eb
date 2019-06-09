package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.xeustechnologies.jtar.TarEntry;
import org.xeustechnologies.jtar.TarOutputStream;

import EBIEntity.EBI;
import EBIEntity.EBString;

public class MakeFile {

//	String zpath = "E:/Myeclipse/workspace/eb/files/";
	
	String zpath = "C:/app/eb/files/";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	/*
	 * 将数据库的应急信息制作为文件
	 * 形参为从数据库读取的一条EBString
	 */
	public void  EBString2File(EBString ebs ) throws Exception{
		
		
		String ebistr=ebs.getEBI();
		String ebdstr=ebs.getEBD();
		Dom4jUtils du=new Dom4jUtils();
		Document ebidoc=null;
		Document ebddoc=null;
		String path=""+ebs.getID();
		try {
			ebidoc = DocumentHelper.parseText(ebistr);
			ebddoc=DocumentHelper.parseText(ebdstr);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 //获取EBDID
        Element ebdroot=ebddoc.getRootElement();
        Element EBDIDf=ebdroot.element("EBDID");
        String ebdid=EBDIDf.getText();
		
      //获取EBIID
        Element ebiroot=ebidoc.getRootElement();
        Element EBMainInfo=ebiroot.element("EBMainInfo");
        Element EBIID=EBMainInfo.element("EBIID");
        String ebiid=EBIID.getText();
       
        
        //获取所有附件路径
        Element EBContents=ebiroot.element("EBContents");
        Element EBContent = EBContents.element("EBContent");
        List<Element> att = EBContent.elements("Attachment");
        ArrayList<String> attpath = new ArrayList<String>();
        for(Element e:att){
        	Element url = e.element("AttURL");
        	attpath.add(url.getText());
        	System.out.println(url.getText());
        }
        //ArrayList转Array
        String[] attpaths = attpath.toArray(new String[attpath.size()]);
        
        
		String ebipath=zpath+"EBDI_"+ebiid+".xml";
		String ebdpath=zpath+"EBDB_"+ebdid+".xml";
		
		
		
		du.xmlWriters(ebipath, ebidoc);
		
		du.xmlWriters(ebdpath, ebddoc);
		
		//生成签名文件
		EBDSign(ebddoc,ebdid);
		EBISign(ebidoc,ebiid);
		
		//文件打包
		toCompress(ebdid,ebiid,attpaths);
		
		
		//删除XML文件
		deleteFile(zpath+"EBDI_"+ebiid+".xml");
		deleteFile(zpath+"EBDB_"+ebdid+".xml");
		deleteFile(zpath+"EBDS_EBDB_"+ebdid+".xml");
		deleteFile(zpath+"EBDS_EBDI_"+ebiid+".xml");
		
		
	}
	
	//应急广播消息数字签名
	public void EBDSign(Document ebddoc,String ebdid){
		Dom4jUtils du=new Dom4jUtils();
		Document doc = DocumentHelper.createDocument();

        Element root = doc.addElement("Signature");
       
        Element Version = root.addElement("Version");
        
        Version.setText("1");
        Element RelatedEBD=root.addElement("RelatedEBD");
        Element EBDID=RelatedEBD.addElement("EBDID");
        
        
        EBDID.setText(ebdid);
        Element CertSN=root.addElement("CertSN");
        CertSN.setText("");
        
        Element SignatureAlgorithm=root.addElement("SignatureAlgorithm");
        SignatureAlgorithm.setText("SM2-SM3");
        
        Element SignatureValue=root.addElement("SignatureValue");
        SignatureValue.setText("");
        
        String path=zpath+"EBDS_EBDB_"+ebdid+".xml";
        
        du.xmlWriters(path, doc);
	}
	//应急广播信息数字签名
	public void EBISign(Document ebidoc,String ebiid){
		Dom4jUtils du=new Dom4jUtils();
		Document doc = DocumentHelper.createDocument();

        Element root = doc.addElement("Signature");
       
        Element Version = root.addElement("Version");
        
        Version.setText("1");
        Element RelatedEBInfo=root.addElement("RelatedEBInfo");
        Element EBInfoID=RelatedEBInfo.addElement("EBInfoID");
        
        EBInfoID.setText(ebiid);
        
        Element CertSN=root.addElement("CertSN");
        CertSN.setText("");
        Element SignatureAlgorithm=root.addElement("SignatureAlgorithm");
        SignatureAlgorithm.setText("SM2-SM3");
        Element SignatureValue=root.addElement("SignatureValue");
        SignatureValue.setText("");
        
        String path=zpath+"EBDS_EBDI_"+ebiid+".xml";
        
        du.xmlWriters(path, doc);
	}
	
	//文件打包
	public void toCompress(String ebdid,String ebiid,String[] attpaths) {
		FileOutputStream dest;
		TarOutputStream out;
		int n = attpaths.length;
		
		
		try {
			dest = new FileOutputStream(zpath+"EBDT_"+ebdid+".tar");
			out = new TarOutputStream(new BufferedOutputStream(dest));
			File[] filesToTar = new File[4+n];
			filesToTar[0] = new File(zpath+"EBDI_"+ebiid+".xml");
			filesToTar[1] = new File(zpath+"EBDB_"+ebdid+".xml");
			filesToTar[2] = new File(zpath+"EBDS_EBDB_"+ebdid+".xml");
			filesToTar[3] = new File(zpath+"EBDS_EBDI_"+ebiid+".xml");
			//资源文件
			for(int i=0;i<n;i++){
				filesToTar[i+4] = new File(attpaths[i]);
			}
			for (File f : filesToTar) {
				out.putNextEntry(new TarEntry(f, f.getName()));
				BufferedInputStream origin = new BufferedInputStream(new FileInputStream(f));
				int count;
				byte data[] = new byte[2048];
				while ((count = origin.read(data)) != -1) {
					out.write(data, 0, count);
				}
				out.flush();
				origin.close();
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	/**
     * 删除单个文件
     *
     * @param fileName
     *            要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     * 删除XML文件留下tar文件
     */
    public  boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }

}
