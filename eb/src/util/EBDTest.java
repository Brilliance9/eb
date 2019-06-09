package util;

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

public class EBDTest {

	/*
	 * 用来测试EBDMaker制作xml
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	public EBD test(){
		EBD ebd =new EBD();
		ebd.setEBDVersion("1");
		ebd.setEBDID("10234000000000001010101010000000000000001");
		ebd.setEBDType("EBM");
		EBD_SRC src=new EBD_SRC();
		src.setEBRID("23400000000000101010101");
		src.setURL("http://192.168.5.58:8080/EmergencyServer/receive/ebd");
		ebd.setSRC(src);
		
		EBD_DEST dest= new EBD_DEST();
		dest.setEBRID("33415000000000101010101");
		ebd.setDEST(dest);
		
		ebd.setEBDTime("2017-06-07 13:40:36");
		EBDXmlMaker xm=new EBDXmlMaker();
		
		EBD_RelatedEBD r=new EBD_RelatedEBD();
		r.setEBDID("34154364");
		ebd.setRelatedEBD(r);
		
		EBD_EBM ebm=new EBD_EBM();
		ebm.setEBMVersion("1.0000");
		ebm.setEBMID("23400000000000101010101201701010001");
		EBM_RelatedInfo re=new EBM_RelatedInfo();
		re.setEBIID("EBD.EBM.RelatedInfo.EBIID");
		re.setEBMID("EBD.EBM.RelatedInfo>EBMID");
		ebm.setRelatedInfo(re);
		
		EBM_MsgBasicInfo msg=new EBM_MsgBasicInfo();
		msg.setMsgType("1");
		msg.setSenderName("安徽省应急广播中心");
		msg.setSenderCode("0001");
		msg.setSendTime("2017-06-07 13:37:44");
		msg.setEventType("11B06");
		msg.setSeverity("1");
		msg.setStartTime("2017-01-01 13:37:44");
		msg.setEndTime("2017-01-01 14:37:44");
		ebm.setMsgBasicInfo(msg);
		
		EBM_MsgContent mc=new EBM_MsgContent();
		mc.setLanguageCode("zho");
		mc.setMsgTitle("气象预警");
		mc.setMsgDesc("安徽省气象局发布气象预警");
		mc.setAreaCode("340000000000");
		mc.setProgramNum("1");
		EBM_MsgC_Auxiliary au=new EBM_MsgC_Auxiliary();
		au.setAuxiliaryDesc("AuxiliaryDesc");
		au.setAuxiliaryType("AuxiliaryType");
		au.setDigest("Digest");
		au.setSize("Size");
		mc.setAuxiliary(au);
		ebm.setMsgContent(mc);
		
		EBM_D_EBRAS as=new EBM_D_EBRAS();
		as.setEBRID("EBM_D_EBRAS");
		EBM_D_EBRBS bs=new EBM_D_EBRBS();
		bs.setBrdSysInfo("BrdSysInfo");
		bs.setBrdSysType("BrdSysType");
		EBM_D_EBRPS ps=new EBM_D_EBRPS();
		ps.setEBRID("EBM_D_EBRPS");
		EBM_D_EBRRTS rs=new EBM_D_EBRRTS();
		rs.setEBRID("EBM_D_EBRRTS");
		
		EBM_Dispatch dis=new EBM_Dispatch();
		dis.setLanguageCode("LanguageCode");
		dis.setEBRAS(as);
		dis.setEBRBS(bs);
		dis.setEBRPS(ps);
		dis.setEBRRTS(rs);
		ebm.setDispatch(dis);
		ebd.setEBM(ebm);
		//调用封装函数
		String s=xm.EBD2String(ebd);
		return ebd;
	}

}
