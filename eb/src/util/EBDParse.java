package util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import EBDEntity.EBD;
import EBDEntity.EBD_DEST;
import EBDEntity.EBD_EBM;
import EBDEntity.EBD_RelatedEBD;
import EBDEntity.EBD_SRC;
import EBDEntity.EBM_D_EBRAS;
import EBDEntity.EBM_D_EBRBS;
import EBDEntity.EBM_D_EBRPS;
import EBDEntity.EBM_D_EBRRTS;
import EBDEntity.EBM_Dispatch;
import EBDEntity.EBM_MsgBasicInfo;
import EBDEntity.EBM_MsgC_Auxiliary;
import EBDEntity.EBM_MsgContent;
import EBDEntity.EBM_RelatedInfo;

public class EBDParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EBDParse p=new EBDParse();
		EBD ebd=p.EBD2Entity("");
		System.out.println(ebd.toString());
	}
	public EBD EBD2Entity (String str){
		EBD ebd=new EBD();
//		EBDTest t=new EBDTest();
//		String s=t.test();
//		System.out.println(s.length());
		Document doc=null;
		try {
			doc = DocumentHelper.parseText(str);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Element root =doc.getRootElement();
		
		Element  EBDVersion=root.element("EBDVersion");
		ebd.setEBDVersion(EBDVersion.getText());

		Element EBDID =root.element("EBDID");
		ebd.setEBDID(EBDID.getText());

		Element  EBDType=root.element("EBDType");
		ebd.setEBDType(EBDType.getText());
		
		EBD_SRC src=new EBD_SRC();
		Element SRC=root.element("SRC");
		Element EBRID=SRC.element("EBRID");
		src.setEBRID(EBRID.getText());
		Element URL=SRC.element("URL");
		src.setURL(URL.getText());
		ebd.setSRC(src);

		EBD_DEST dest=new EBD_DEST();
		Element DEST=root.element("DEST");
		Element EBRID2=DEST.element("EBRID");
		dest.setEBRID(EBRID2.getText());
		ebd.setDEST(dest);
		
		Element  EBDTime=root.element("EBDTime");
		ebd.setEBDTime(EBDTime.getText());
		
		EBD_RelatedEBD re=new EBD_RelatedEBD();
		Element RelatedEBD=root.element("RelatedEBD");
		Element EBDID2=RelatedEBD.element("EBDID");
		re.setEBDID(EBDID2.getText());
		ebd.setRelatedEBD(re);
		
		ebd.setEBM(EBMParse(doc));
		return ebd;
	}

	/*
	 * 解析EBM
	 */
	public EBD_EBM EBMParse(Document doc){
		EBD_EBM ebm=new EBD_EBM();
		Element root =doc.getRootElement();
		Element EBM=root.element("EBM");
		
		Element EBMVersion=EBM.element("EBMVersion");
		ebm.setEBMVersion(EBMVersion.getText());
		
		Element EBMID=EBM.element("EBMID");
		ebm.setEBMID(EBMID.getText());
		
		EBM_RelatedInfo re=new EBM_RelatedInfo();
		Element RelatedInfo =EBM.element("RelatedInfo");
		if(RelatedInfo==null)
			System.out.println("Kong");
		Element EBIID=RelatedInfo.element("EBIID");
		re.setEBIID(EBIID.getText());
		Element EBMID2=RelatedInfo.element("EBMID");
		re.setEBMID(EBMID2.getText());
		ebm.setRelatedInfo(re);
		
		//解析MsgBasicInfo
		EBM_MsgBasicInfo msg=new EBM_MsgBasicInfo();
		Element MsgBasicInfo=EBM.element("MsgBasicInfo");
		
		Element MsgType=MsgBasicInfo.element("MsgType");
		msg.setMsgType(MsgType.getText());

		Element SenderName=MsgBasicInfo.element("SenderName");
		msg.setSenderName(SenderName.getText());

		Element SenderCode=MsgBasicInfo.element("SenderCode");
		msg.setSenderCode(SenderCode.getText());

		Element SendTime=MsgBasicInfo.element("SendTime");
		msg.setSendTime(SendTime.getText());

		Element EventType=MsgBasicInfo.element("EventType");
		msg.setEventType(EventType.getText());

		Element Severity=MsgBasicInfo.element("Severity");
		msg.setSeverity(Severity.getText());

		Element StartTime=MsgBasicInfo.element("StartTime");
		msg.setStartTime(StartTime.getText());

		Element EndTime=MsgBasicInfo.element("EndTime");
		msg.setEndTime(EndTime.getText());
		ebm.setMsgBasicInfo(msg);
		
		//解析MsgContent
		Element MsgContent=EBM.element("MsgContent");
		EBM_MsgContent mc=new EBM_MsgContent();
		
		Element LanguageCode=MsgContent.element("LanguageCode");
		mc.setLanguageCode(LanguageCode.getText());

		Element MsgTitle=MsgContent.element("MsgTitle");
		mc.setMsgTitle(MsgTitle.getText());

		Element MsgDesc=MsgContent.element("MsgDesc");
		mc.setMsgDesc(MsgDesc.getText());

		Element AreaCode=MsgContent.element("AreaCode");
		mc.setAreaCode(AreaCode.getText());

		Element ProgramNum=MsgContent.element("ProgramNum");
		mc.setProgramNum(ProgramNum.getText());
		
		EBM_MsgC_Auxiliary au=new EBM_MsgC_Auxiliary();
		Element Auxiliary=MsgContent.element("Auxiliary");
		Element AuxiliaryType=Auxiliary.element("AuxiliaryType");
		au.setAuxiliaryType(AuxiliaryType.getText());
		Element AuxiliaryDesc=Auxiliary.element("AuxiliaryDesc");
		au.setAuxiliaryDesc(AuxiliaryDesc.getText());
		Element Size=Auxiliary.element("Size");
		au.setSize(Size.getText());
		Element Digest=Auxiliary.element("Digest");
		au.setDigest(Digest.getText());
		mc.setAuxiliary(au);
		ebm.setMsgContent(mc);
		
		
		//解析Dispatch
		Element Dispatch=EBM.element("Dispatch");
		EBM_Dispatch dis=new EBM_Dispatch();
		EBM_D_EBRAS as=new EBM_D_EBRAS();
		EBM_D_EBRBS bs=new EBM_D_EBRBS();
		EBM_D_EBRPS ps=new EBM_D_EBRPS();
		EBM_D_EBRRTS ts=new EBM_D_EBRRTS();
		Element LanguageCode2=Dispatch.element("LanguageCode");
		dis.setLanguageCode(LanguageCode2.getText());
		
		Element EBRAS=Dispatch.element("EBRAS");
		Element EBRID=EBRAS.element("EBRID");
		as.setEBRID(EBRID.getText());
		
		Element EBRBS=Dispatch.element("EBRBS");
		Element BrdSysInfo=EBRBS.element("BrdSysInfo");
		bs.setBrdSysInfo(BrdSysInfo.getText());
		Element BrdSysType=EBRBS.element("BrdSysType");
		bs.setBrdSysType(BrdSysType.getText());
		
		Element EBRPS=Dispatch.element("EBRPS");
		Element EBRID2=EBRPS.element("EBRID");
		ps.setEBRID(EBRID2.getText());
		
		Element EBRRTS =Dispatch.element("EBRRTS");
		Element EBRID3=EBRRTS.element("EBRID");
		ts.setEBRID(EBRID3.getText());
		dis.setEBRAS(as);
		dis.setEBRBS(bs);
		dis.setEBRPS(ps);
		dis.setEBRRTS(ts);
		ebm.setDispatch(dis);
		return ebm;
	}
}
