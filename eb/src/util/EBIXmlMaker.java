package util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import EBIEntity.Attachment;
import EBIEntity.BroadcastStyle;
import EBIEntity.EBI;
import EBIEntity.EBI_Area;
import EBIEntity.EBI_EBContent;
import EBIEntity.EBI_EBMainInfo;
import EBIEntity.EBI_ExtendInfo1;
import EBIEntity.EBI_ExtendInfo2;
import EBIEntity.EBI_PublishStrategy;

public class EBIXmlMaker {

	public static void main(String[] args) {

	}
	/*
	 * 形参EBI实体，返回xml字符串
	 */
	public String EBI2String(EBI ebi){
		Dom4jUtils du=new Dom4jUtils();
		String path="files/EBI.xml";
		//创建一个xml文档
        Document doc = DocumentHelper.createDocument();
        //添加根节点
        doc.addElement("EBI");
        //调用封装函数
        doc=makeEBMainInfo(doc,ebi.getEBMainInfo());
        doc=makeEBContent(doc,ebi.getEBContent());
        doc=makePublishStrategy(doc, ebi.getPublishStrategy());
        if(ebi.isE1()){
        	doc=makeExtendInfo1(doc, ebi.getExtendInfo1());
        }
        if(ebi.isE2()){
        	 doc=makeExtendInfo2(doc, ebi.getExtendInfo2());
        }
       
        doc=makeArea(doc,ebi.getArea());
        
        
//        du.xmlWriters(path, doc);
        System.out.println(doc.asXML().length());
		return doc.asXML();
	}
	/*
	 * 封装应急广播基础信息
	 */
	public Document makeEBMainInfo(Document doc,EBI_EBMainInfo emi){
		Element root=doc.getRootElement();
		Element ebm=root.addElement("EBMainInfo");
		
		Element EBIVersion=ebm.addElement("EBIVersion");
		EBIVersion.setText(emi.getEBIVersion());
		
		Element InfoID = ebm.addElement("InfoID");
		InfoID.setText(emi.getInfoID());
		
		Element EBIID = ebm.addElement("EBIID");
		EBIID.setText(emi.getEBIID());
		
		Element Identifier = ebm.addElement("Identifier");
		Identifier.setText(emi.getIdentifier());
		
		Element Sender = ebm.addElement("Sender");
		Sender.setText(emi.getSender());
		
		Element SenderCode = ebm.addElement("SenderCode");
		SenderCode.setText(emi.getSenderCode());
		
		Element EventType = ebm.addElement("EventType");
		EventType.setText(emi.getEventType());
		
		Element EventLevel = ebm.addElement("EventLevel");
		EventLevel.setText(emi.getEventLevel());
		
		Element InfoType = ebm.addElement("InfoType");
		InfoType.setText(emi.getInfoType());
		
		Element InfoStatus = ebm.addElement("InfoStatus");
		InfoStatus.setText(emi.getInfoStatus());
		
		Element ReferenceID = ebm.addElement("ReferenceID");
		ReferenceID.setText(emi.getReferenceId());
		
		Element Instructions = ebm.addElement("Instructions");
		Instructions.setText(emi.getInstructions());
		
		Element IsMediaRes = ebm.addElement("IsMediaRes");
		IsMediaRes.setText(emi.getIsMediaRes());
		
		Element IsTTS = ebm.addElement("IsTTS");
		IsTTS.setText(emi.getIsTTS());
		return doc;
	}
	
	/*
	 * 封装应急广播内容
	 */
	public Document makeEBContent(Document doc,EBI_EBContent[] ebc){
		Element root=doc.getRootElement();
		Element ebcs=root.addElement("EBContents");
		
		for(int i=0;i<ebc.length;i++){
			Element ebco=ebcs.addElement("EBContent");
			
			Element Language=ebco.addElement("Language");
			Language.setText(ebc[i].getLanguage());
			
			Element LanguageCode=ebco.addElement("LanguageCode");
			LanguageCode.setText(ebc[i].getLanguageCode());
			
			Element CodeSet=ebco.addElement("CodeSet");
			CodeSet.setText(ebc[i].getCodeSet());
			
			Element Headline=ebco.addElement("Headline");
			Headline.setText(ebc[i].getHeadline());
			
			Element EventDescription=ebco.addElement("EventDescription");
			EventDescription.setText(ebc[i].getEventDescription());
			
			Element ProgramNum=ebco.addElement("ProgramNum");
			ProgramNum.setText(ebc[i].getProgramNum());
			
			Element Signer=ebco.addElement("Signer");
			Signer.setText(ebc[i].getSigner());
			//封装附件
			Attachment att[]=ebc[i].getAttachments();
			for(int j=0;j<att.length;j++){
 				Element Attachment =ebco.addElement("Attachment");
				
 				Element AttName=Attachment.addElement("AttName");
				AttName.setText(att[j].getAttName());
				
				Element AttDescription=Attachment.addElement("AttDescription");
				AttDescription.setText(att[j].getAttDescription());
				
				Element AttSize=Attachment.addElement("AttSize");
				AttSize.setText(att[j].getAttSize());
				
				Element AttType=Attachment.addElement("AttType");
				AttType.setText(att[j].getAttType());
				
				Element AttSuffix=Attachment.addElement("AttSuffix");
				AttSuffix.setText(att[j].getAttSuffix());
				
				Element AttURL=Attachment.addElement("AttURL");
				AttURL.setText(att[j].getAttURL());
				
				Element Digest=Attachment.addElement("Digest");
				Digest.setText(att[j].getDigest());
			}
		}
		
		return doc;
	}
	/*
	 * 封装信息建议性发布策略
	 */
	public Document makePublishStrategy(Document doc,EBI_PublishStrategy ep){
		Element root =doc.getRootElement();
		Element pub=root.addElement("PublishStrategy");
		
		Element PublishRegion=pub.addElement("PublishRegion");
		PublishRegion.setText(ep.getPublishRegion());
		
		Element BroadcastDateTime=pub.addElement("BroadcastDateTime");
		BroadcastDateTime.setText(ep.getBroadcastDateTime());
		
		Element verDateTime=pub.addElement("OverDateTime");
		verDateTime.setText(ep.getOverDateTime());
		
		Element BroadcastStyles=pub.addElement("BroadcastStyles");
		BroadcastStyle bro[]=ep.getBroadcastStyle();
		for(int i=0;i<bro.length;i++){
			Element BroadcastStyle=BroadcastStyles.addElement("BroadcastStyle");
			Element PublishMeans=BroadcastStyle.addElement("PublishMeans");
			PublishMeans.setText(bro[i].getPublishMeans());
			
			Element Presentation=BroadcastStyle.addElement("Presentation");
			Presentation.setText(bro[i].getPresentation());
			
			Element PublishFrequency=BroadcastStyle.addElement("PublishFrequency");
			PublishFrequency.setText(bro[i].getPublishFrequency());
			
			Element RollFrequency=BroadcastStyle.addElement("RollFrequency");
			RollFrequency.setText(bro[i].getRollFrequency());
		}
		
		return doc;
	}
	/*
	 * 封装区域信息
	 */
	public Document makeArea(Document doc,EBI_Area area){
		Element root = doc.getRootElement();
		Element Area = root.addElement("Area");
		
		Element AreaDescription=Area.addElement("AreaDescription");
		AreaDescription.setText(area.getAreaDescription());
		
		Element AreaPolygon=Area.addElement("AreaPolygon");
		AreaPolygon.setText(area.getAreaPolygon());
		
		Element AreaCircle=Area.addElement("AreaCircle");
		AreaCircle.setText(area.getAreaCircle());
		return doc;
	}
	
	/*
	 * 封装地震类扩展信息
	 */
	public Document makeExtendInfo1(Document doc,EBI_ExtendInfo1 ex1){
		Element root = doc.getRootElement();
		Element ExtendInfo = root.addElement("ExtendInfo");
		
		Element location_code= ExtendInfo.addElement("location_code");
		location_code.setText(ex1.getLocation_code());
		
		Element place= ExtendInfo.addElement("place");
		place.setText(ex1.getPlace());
		
		Element earthquake_time= ExtendInfo.addElement("earthquake_time");
		earthquake_time.setText(ex1.getEarthquake_time());

		Element level= ExtendInfo.addElement("level");
		level.setText(ex1.getLevel());

		Element depth= ExtendInfo.addElement("depth");
		depth.setText(ex1.getDepth());

		Element longitude= ExtendInfo.addElement("longitude");
		longitude.setText(ex1.getLongitude());

		Element latitude= ExtendInfo.addElement("latitude");
		latitude.setText(ex1.getLatitude());

		Element eq_type= ExtendInfo.addElement("eq_type");
		eq_type.setText(ex1.getEq_type());

		Element expedited_reporting_type= ExtendInfo.addElement("expedited_reporting_type");
		expedited_reporting_type.setText(ex1.getExpedited_reporting_type());

		Element nearest_provincial_capital= ExtendInfo.addElement("nearest_provincial_capital");
		nearest_provincial_capital.setText(ex1.getNearest_provincial_capital());

		Element Shenghui= ExtendInfo.addElement("Shenghui");
		Shenghui.setText(ex1.getShenghui());

		Element nearest_prefecture= ExtendInfo.addElement("nearest_prefecture");
		nearest_prefecture.setText(ex1.getNearest_prefecture());

		Element dijishi= ExtendInfo.addElement("dijishi");
		dijishi.setText(ex1.getDijishi());

		Element nearest_county= ExtendInfo.addElement("nearest_county");
		nearest_county.setText(ex1.getNearest_county());

		Element xianjishi= ExtendInfo.addElement("xianjishi");
		xianjishi.setText(ex1.getXianjishi());

		Element nearest_village= ExtendInfo.addElement("nearest_village");
		nearest_village.setText(ex1.getNearest_village());

		Element villages= ExtendInfo.addElement("villages");
		villages.setText(ex1.getVillages());

		Element nearest_town= ExtendInfo.addElement("nearest_town");
		nearest_town.setText(ex1.getNearest_town());

		Element towns= ExtendInfo.addElement("towns");
		towns.setText(ex1.getTowns());

		Element juli= ExtendInfo.addElement("juli");
		juli.setText(ex1.getJuli());

		Element range= ExtendInfo.addElement("range");
		range.setText(ex1.getRange());

		Element Seismic_information= ExtendInfo.addElement("Seismic_information");
		Seismic_information.setText(ex1.getSeismic_information());

		Element WEATHER= ExtendInfo.addElement("WEATHER");
		WEATHER.setText(ex1.getWEATHER());

		Element altitude= ExtendInfo.addElement("altitude");
		altitude.setText(ex1.getAltitude());

		Element population= ExtendInfo.addElement("population");
		population.setText(ex1.getPopulation());

		Element area= ExtendInfo.addElement("area");
		area.setText(ex1.getArea());

		Element gdp= ExtendInfo.addElement("gdp");
		gdp.setText(ex1.getGdp());

		Element five_earthquake= ExtendInfo.addElement("five_earthquake");
		five_earthquake.setText(ex1.getFive_earthquake());
		return doc;
	}
	
	/*
	 * 封装民航机场类扩展信息
	 */
	public Document makeExtendInfo2(Document doc,EBI_ExtendInfo2 ex2){
		Element root = doc.getRootElement();
		Element ExtendInfo=root.addElement("ExtendInfo");
		
		Element Airport=ExtendInfo.addElement("Airport");
		Airport.setText(ex2.getAirport());

		Element Airportcode=ExtendInfo.addElement("Airportcode");
		Airportcode.setText(ex2.getAirportcode());

		Element Inbound_flights=ExtendInfo.addElement("Inbound_flights");
		Inbound_flights.setText(ex2.getInbound_flights());

		Element Outbound_flights=ExtendInfo.addElement("Outbound_flights");
		Outbound_flights.setText(ex2.getOutbound_flights());

		Element Inbound_numberofpeople=ExtendInfo.addElement("Inbound_numberofpeople");
		Inbound_numberofpeople.setText(ex2.getInbound_numberofpeople());

		Element Outbound_numberofpeople=ExtendInfo.addElement("Outbound_numberofpeople");
		Outbound_numberofpeople.setText(ex2.getOutbound_numberofpeople());

		Element Inbound_Delayedflights=ExtendInfo.addElement("Inbound_Delayedflights");
		Inbound_Delayedflights.setText(ex2.getInbound_Delayedflights());

		Element Outbound_Delayedflights=ExtendInfo.addElement("Outbound_Delayedflights");
		Outbound_Delayedflights.setText(ex2.getOutbound_Delayedflights());

		Element AirportStatus=ExtendInfo.addElement("AirportStatus");
		AirportStatus.setText(ex2.getAirportStatus());

		Element Inbound_flights_number=ExtendInfo.addElement("Inbound_flights_number");
		Inbound_flights_number.setText(ex2.getInbound_flights_number());

		Element Outbound_flightsnumber=ExtendInfo.addElement("Outbound_flightsnumber");
		Outbound_flightsnumber.setText(ex2.getOutbound_flightsnumber());

		Element Time=ExtendInfo.addElement("Time");
		Time.setText(ex2.getTime());
		
		return doc;
	}

}
//Element =ebco.addElement("");
//.setText(ebc[i].get());