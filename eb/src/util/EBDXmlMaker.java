package util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import EBDEntity.EBD;
import EBDEntity.EBD_EBM;

public class EBDXmlMaker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String EBD2String (EBD ebd){
		Dom4jUtils du=new Dom4jUtils();
		String path="files/EBD.xml";
		//创建一个xml文档
        Document doc = DocumentHelper.createDocument();
        //添加根节点
        doc.addElement("EBD");
        //调用封装函数

        doc=EBDMaker(doc,ebd);

        
        
//        du.xmlWriters(path, doc);
//        System.out.println(doc.asXML());
		return doc.asXML();
	}
	/*
	 * 封装应急广播消息指令文件
	 */
	public Document EBDMaker(Document doc,EBD ebd){
		Element root =doc.getRootElement();
		
		Element EBDVersion=root.addElement("EBDVersion");
		EBDVersion.setText(ebd.getEBDVersion());
		
		Element EBDID=root.addElement("EBDID");
		EBDID.setText(ebd.getEBDID());

		Element EBDType=root.addElement("EBDType");
		EBDType.setText(ebd.getEBDType());

		Element SRC=root.addElement("SRC");
		Element EBRID=SRC.addElement("EBRID");
		EBRID.setText(ebd.getSRC().getEBRID());
		Element URL =SRC.addElement("URL");
		URL.setText(ebd.getSRC().getURL());
		
		Element DEST=root.addElement("DEST");
		Element EBRID2=DEST.addElement("EBRID");
		EBRID2.setText(ebd.getDEST().getEBRID());
		
		Element EBDTime=root.addElement("EBDTime");
		EBDTime.setText(ebd.getEBDTime());

		Element RelatedEBD=root.addElement("RelatedEBD");
		Element EBDID2=RelatedEBD.addElement("EBDID");
		EBDID2.setText(ebd.getRelatedEBD().getEBDID());
		
		doc=EBMMaker(doc,ebd.getEBM());
		return doc;
	}
	/*
	 * 封装应急广播消息
	 */
	public Document EBMMaker(Document doc,EBD_EBM ebm){
		Element root =doc.getRootElement();
		Element EBM =root.addElement("EBM");
		
		Element EBMVersion=EBM.addElement("EBMVersion");
		EBMVersion.setText(ebm.getEBMVersion());
		
		Element EBMID=EBM.addElement("EBMID");
		EBMID.setText(ebm.getEBMID());
		
		Element RelatedInfo=EBM.addElement("RelatedInfo");
		Element EBIID=RelatedInfo.addElement("EBIID");
		EBIID.setText(ebm.getRelatedInfo().getEBIID());
		Element EBMID2 =RelatedInfo.addElement("EBMID");
		EBMID2.setText(ebm.getRelatedInfo().getEBMID());
		
		//封装消息基本信息（EBD.EBM.MsgBasicInfo）
		Element MsgBasicInfo=EBM.addElement("MsgBasicInfo");
		
		Element MsgType=MsgBasicInfo.addElement("MsgType");
		MsgType.setText(ebm.getMsgBasicInfo().getMsgType());

		Element SenderName=MsgBasicInfo.addElement("SenderName");
		SenderName.setText(ebm.getMsgBasicInfo().getSenderName());

		Element SenderCode=MsgBasicInfo.addElement("SenderCode");
		SenderCode.setText(ebm.getMsgBasicInfo().getSenderCode());

		Element SendTime=MsgBasicInfo.addElement("SendTime");
		SendTime.setText(ebm.getMsgBasicInfo().getSendTime());

		Element EventType=MsgBasicInfo.addElement("EventType");
		EventType.setText(ebm.getMsgBasicInfo().getEventType());

		Element Severity=MsgBasicInfo.addElement("Severity");
		Severity.setText(ebm.getMsgBasicInfo().getSeverity());

		Element StartTime=MsgBasicInfo.addElement("StartTime");
		StartTime.setText(ebm.getMsgBasicInfo().getStartTime());

		Element EndTime=MsgBasicInfo.addElement("EndTime");
		EndTime.setText(ebm.getMsgBasicInfo().getEndTime());
		
		//封装应急广播消息内容（EBD.EBM.MsgContent）
		Element MsgContent=EBM.addElement("MsgContent");
		
		Element LanguageCode=MsgContent.addElement("LanguageCode");
		LanguageCode.setText(ebm.getMsgContent().getLanguageCode());

		Element MsgTitle=MsgContent.addElement("MsgTitle");
		MsgTitle.setText(ebm.getMsgContent().getMsgTitle());

		Element MsgDesc=MsgContent.addElement("MsgDesc");
		MsgDesc.setText(ebm.getMsgContent().getMsgDesc());

		Element AreaCode=MsgContent.addElement("AreaCode");
		AreaCode.setText(ebm.getMsgContent().getAreaCode());

		Element ProgramNum=MsgContent.addElement("ProgramNum");
		ProgramNum.setText(ebm.getMsgContent().getProgramNum());
		
		Element Auxiliary=MsgContent.addElement("Auxiliary");
		
		Element AuxiliaryType=Auxiliary.addElement("AuxiliaryType");
		AuxiliaryType.setText(ebm.getMsgContent().getAuxiliary().getAuxiliaryType());

		Element AuxiliaryDesc=Auxiliary.addElement("AuxiliaryDesc");
		AuxiliaryDesc.setText(ebm.getMsgContent().getAuxiliary().getAuxiliaryDesc());

		Element Size=Auxiliary.addElement("Size");
		Size.setText(ebm.getMsgContent().getAuxiliary().getSize());

		Element Digest=Auxiliary.addElement("Digest");
		Digest.setText(ebm.getMsgContent().getAuxiliary().getDigest());
		
		//封装调用资源信息（EBD.EBM.Dispatch）
		Element Dispatch=EBM.addElement("Dispatch");
		
		Element LanguageCode2=Dispatch.addElement("LanguageCode");
		LanguageCode2.setText(ebm.getDispatch().getLanguageCode());
		
		Element EBRPS=Dispatch.addElement("EBRPS");
		Element EBRID3=EBRPS.addElement("EBRID");
		EBRID3.setText(ebm.getDispatch().getEBRPS().getEBRID());

		Element EBRRTS=Dispatch.addElement("EBRRTS");
		Element EBRID4=EBRRTS.addElement("EBRID");
		EBRID4.setText(ebm.getDispatch().getEBRRTS().getEBRID());

		Element EBRAS=Dispatch.addElement("EBRAS");
		Element EBRID5=EBRAS.addElement("EBRID");
		EBRID5.setText(ebm.getDispatch().getEBRAS().getEBRID());

		Element EBRBS=Dispatch.addElement("EBRBS");
		Element BrdSysType=EBRBS.addElement("BrdSysType");
		BrdSysType.setText(ebm.getDispatch().getEBRBS().getBrdSysType());
		Element BrdSysInfo=EBRBS.addElement("BrdSysInfo");
		BrdSysInfo.setText(ebm.getDispatch().getEBRBS().getBrdSysInfo());
		return doc;
	}

}
