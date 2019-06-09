package util;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import EBIEntity.Attachment;
import EBIEntity.BroadcastStyle;
import EBIEntity.EBI;
import EBIEntity.EBI_Area;
import EBIEntity.EBI_EBContent;
import EBIEntity.EBI_EBMainInfo;
import EBIEntity.EBI_ExtendInfo1;
import EBIEntity.EBI_ExtendInfo2;
import EBIEntity.EBI_PublishStrategy;

public class EBIParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EBIParse p= new EBIParse();
		try {
			p.EBI2Entity("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public EBI EBI2Entity(String strxml) throws Exception{

//		Test t=new Test();
//		String strxml=t.test();
		Document doc=null;
		try {
			doc = DocumentHelper.parseText(strxml);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EBI ebi=new EBI();
		ebi.setEBMainInfo(EBMainInfoParse(doc));
		ebi.setEBContent(EBContentParse(doc));
		ebi.setPublishStrategy(PublishStrategyParse(doc));
		ebi.setArea(AreaParse(doc));
		ebi.setExtendInfo1(ExtendInfo1Parse(doc));
		ebi.setExtendInfo2(ExtendInfo2Parse(doc));
//		System.out.println(ebi.toString());
//		EBIDao d= new EBIDao();
//		d.add(strxml);
		return ebi;
	}
	/*
	 * 解析EBMainInfo并返回一个EBI_EBMainInfo
	 */
	public EBI_EBMainInfo EBMainInfoParse(Document doc){
		Element root = doc.getRootElement();
		EBI_EBMainInfo ebm=new EBI_EBMainInfo();
		
		Element EBMainInfo=root.element("EBMainInfo");
		Element EBIVersion=EBMainInfo.element("EBIVersion");
		ebm.setEBIVersion(EBIVersion.getText());
		
		Element InfoID=EBMainInfo.element("InfoID");
		ebm.setInfoID(InfoID.getText());
		
		Element EBIID=EBMainInfo.element("EBIID");
		ebm.setEBIID(EBIID.getText());
		
		Element Identifier=EBMainInfo.element("Identifier");
		ebm.setIdentifier(Identifier.getText());
		
		Element Sender=EBMainInfo.element("Sender");
		ebm.setSender(Sender.getText());
		
		Element SenderCode=EBMainInfo.element("SenderCode");
		ebm.setSenderCode(SenderCode.getText());
		
		Element EventType=EBMainInfo.element("EventType");
		ebm.setEventType(EventType.getText());
		
		Element EventLevel=EBMainInfo.element("EventLevel");
		ebm.setEventLevel(EventLevel.getText());
		
		Element InfoType=EBMainInfo.element("InfoType");
		ebm.setInfoType(InfoType.getText());
		
		Element InfoStatus=EBMainInfo.element("InfoStatus");
		ebm.setInfoStatus(InfoStatus.getText());
		
		Element ReferenceID=EBMainInfo.element("ReferenceID");
		ebm.setReferenceId(ReferenceID.getText());
		
		Element Instructions=EBMainInfo.element("Instructions");
		ebm.setInstructions(Instructions.getText());
		
		Element IsMediaRes=EBMainInfo.element("IsMediaRes");
		ebm.setIsMediaRes(IsMediaRes.getText());
		
		Element IsTTS=EBMainInfo.element("IsTTS");
		ebm.setIsTTS(IsTTS.getText());
		
		//测试是否成功解析
//		System.out.print(ebm);
		return ebm;
	}
	/*
	 * 解析EBContent,并返回EBI_EBContent数组
	 */
	public EBI_EBContent[] EBContentParse(Document doc){
		Element root =doc.getRootElement();
		Element EBContents=root.element("EBContents");
		List<Element> list=EBContents.elements("EBContent");
		int l=list.size();
		EBI_EBContent ebc[]=new EBI_EBContent[l];
		for(int i=0;i<l;i++){
			ebc[i]=new EBI_EBContent();
			Element EBContent =list.get(i);
			
			Element Language=EBContent.element("Language");
			ebc[i].setLanguage(Language.getText());

			Element LanguageCode=EBContent.element("LanguageCode");
			ebc[i].setLanguageCode(LanguageCode.getText());

			Element CodeSet=EBContent.element("CodeSet");
			ebc[i].setCodeSet(CodeSet.getText());

			Element Headline=EBContent.element("Headline");
			ebc[i].setHeadline(Headline.getText());

			Element EventDescription=EBContent.element("EventDescription");
			ebc[i].setEventDescription(EventDescription.getText());

			Element ProgramNum=EBContent.element("ProgramNum");
			ebc[i].setProgramNum(ProgramNum.getText());

			Element Signer=EBContent.element("Signer");
			ebc[i].setSigner(Signer.getText());
			//解析附件
			List<Element> list2=EBContent.elements("Attachment");
			int len=list2.size();
			Attachment att[]=new Attachment[len];
			for(int j=0;j<len;j++){
				att[j]=new Attachment();
				
				Element Attachment=list2.get(j);
				
				Element AttName=Attachment.element("AttName");
				att[j].setAttName(AttName.getText());

				Element AttDescription=Attachment.element("AttDescription");
				att[j].setAttDescription(AttDescription.getText());

				Element AttSize=Attachment.element("AttSize");
				att[j].setAttSize(AttSize.getText());

				Element AttType=Attachment.element("AttType");
				att[j].setAttType(AttType.getText());

				Element AttSuffix=Attachment.element("AttSuffix");
				att[j].setAttSuffix(AttSuffix.getText());

				Element AttURL=Attachment.element("AttURL");
				att[j].setAttURL(AttURL.getText());

				Element Digest=Attachment.element("Digest");
				att[j].setDigest(Digest.getText());
			}
			ebc[i].setAttachments(att);
		}
		return ebc;
	}
	/*
	 * 解析PublishStrategy
	 */
	public EBI_PublishStrategy PublishStrategyParse(Document doc){
		Element root=doc.getRootElement();
		Element PublishStrategy=root.element("PublishStrategy");
		EBI_PublishStrategy pub=new EBI_PublishStrategy();
		
		Element PublishRegion=PublishStrategy.element("PublishRegion");
		pub.setPublishRegion(PublishRegion.getText());

		Element BroadcastDateTime=PublishStrategy.element("BroadcastDateTime");
		pub.setBroadcastDateTime(BroadcastDateTime.getText());

		Element OverDateTime=PublishStrategy.element("OverDateTime");
		pub.setOverDateTime(OverDateTime.getText());
		
		Element BroadcastStyles=PublishStrategy.element("BroadcastStyles");
		List<Element> list=BroadcastStyles.elements("BroadcastStyle");
		int l=list.size();
		BroadcastStyle bro[]=new BroadcastStyle[l];
		for(int i=0;i<l;i++){
			bro[i]=new BroadcastStyle();
			Element BroadcastStyle=list.get(i);
			
			Element PublishMeans=BroadcastStyle.element("PublishMeans");
			bro[i].setPublishMeans(PublishMeans.getText());

			Element Presentation=BroadcastStyle.element("Presentation");
			bro[i].setPresentation(Presentation.getText());

			Element PublishFrequency=BroadcastStyle.element("PublishFrequency");
			bro[i].setPublishFrequency(PublishFrequency.getText());

			Element RollFrequency=BroadcastStyle.element("RollFrequency");
			bro[i].setRollFrequency(RollFrequency.getText());
		}
		pub.setBroadcastStyle(bro);
		return pub;
	}
	/*
	 * 解析Aear
	 */
	public EBI_Area AreaParse(Document doc){
		Element root=doc.getRootElement();
		Element Area=root.element("Area");
		EBI_Area area=new EBI_Area();
		
		Element AreaDescription=Area.element("AreaDescription");
		area.setAreaDescription(AreaDescription.getText());

		Element AreaPolygon=Area.element("AreaPolygon");
		area.setAreaPolygon(AreaPolygon.getText());

		Element AreaCircle=Area.element("AreaCircle");
		area.setAreaCircle(AreaCircle.getText());
		return area;
	}
	/*
	 * 解析EBI_ExtendInfo1
	 */
	public EBI_ExtendInfo1 ExtendInfo1Parse(Document doc){
		Element root=doc.getRootElement();
		List<Element> list=root.elements("ExtendInfo");
		EBI_ExtendInfo1 ex1=new EBI_ExtendInfo1();
		for(Element ExtendInfo:list){
			Element location_code=ExtendInfo.element("location_code");
			if(location_code!=null){
				ex1.setLocation_code(location_code.getText());

				Element place=ExtendInfo.element("place");
				ex1.setPlace(place.getText());

				Element earthquake_time=ExtendInfo.element("earthquake_time");
				ex1.setEarthquake_time(earthquake_time.getText());

				Element level=ExtendInfo.element("level");
				ex1.setLevel(level.getText());

				Element depth=ExtendInfo.element("depth");
				ex1.setDepth(depth.getText());

				Element longitude=ExtendInfo.element("longitude");
				ex1.setLongitude(longitude.getText());

				Element latitude=ExtendInfo.element("latitude");
				ex1.setLatitude(latitude.getText());

				Element eq_type=ExtendInfo.element("eq_type");
				ex1.setEq_type(eq_type.getText());

				Element expedited_reporting_type=ExtendInfo.element("expedited_reporting_type");
				ex1.setExpedited_reporting_type(expedited_reporting_type.getText());

				Element nearest_provincial_capital=ExtendInfo.element("nearest_provincial_capital");
				ex1.setNearest_provincial_capital(nearest_provincial_capital.getText());

				Element Shenghui=ExtendInfo.element("Shenghui");
				ex1.setShenghui(Shenghui.getText());

				Element nearest_prefecture=ExtendInfo.element("nearest_prefecture");
				ex1.setNearest_prefecture(nearest_prefecture.getText());

				Element dijishi=ExtendInfo.element("dijishi");
				ex1.setDijishi(dijishi.getText());

				Element nearest_county=ExtendInfo.element("nearest_county");
				ex1.setNearest_county(nearest_county.getText());

				Element xianjishi=ExtendInfo.element("xianjishi");
				ex1.setXianjishi(xianjishi.getText());

				Element nearest_village=ExtendInfo.element("nearest_village");
				ex1.setNearest_village(nearest_village.getText());

				Element villages=ExtendInfo.element("villages");
				ex1.setVillages(villages.getText());

				Element nearest_town=ExtendInfo.element("nearest_town");
				ex1.setNearest_town(nearest_town.getText());

				Element towns=ExtendInfo.element("towns");
				ex1.setTowns(towns.getText());

				Element juli=ExtendInfo.element("juli");
				ex1.setJuli(juli.getText());

				Element range=ExtendInfo.element("range");
				ex1.setRange(range.getText());

				Element Seismic_information=ExtendInfo.element("Seismic_information");
				ex1.setSeismic_information(Seismic_information.getText());

				Element WEATHER=ExtendInfo.element("WEATHER");
				ex1.setWEATHER(WEATHER.getText());

				Element altitude=ExtendInfo.element("altitude");
				ex1.setAltitude(altitude.getText());

				Element population=ExtendInfo.element("population");
				ex1.setPopulation(population.getText());

				Element area=ExtendInfo.element("area");
				ex1.setArea(area.getText());

				Element gdp=ExtendInfo.element("gdp");
				ex1.setGdp(gdp.getText());

				Element five_earthquake=ExtendInfo.element("five_earthquake");
				ex1.setFive_earthquake(five_earthquake.getText());
			}
			
		}
		
		
		
		
		return ex1;
	}
	/*
	 * 解析EBI_ExtendInfo2
	 */
	public EBI_ExtendInfo2 ExtendInfo2Parse(Document doc){
		Element root=doc.getRootElement();
		EBI_ExtendInfo2 ex2=new EBI_ExtendInfo2();
		List<Element> list =root.elements("ExtendInfo");
		for(Element ExtendInfo:list){
			Element Airport=ExtendInfo.element("Airport");
			if(Airport!=null){
//				System.out.println("bucunzai");
				ex2.setAirport(Airport.getText());

				Element Airportcode=ExtendInfo.element("Airportcode");
				ex2.setAirportcode(Airportcode.getText());

				Element Inbound_flights=ExtendInfo.element("Inbound_flights");
				ex2.setInbound_flights(Inbound_flights.getText());

				Element Outbound_flights=ExtendInfo.element("Outbound_flights");
				ex2.setOutbound_flights(Outbound_flights.getText());

				Element Inbound_numberofpeople=ExtendInfo.element("Inbound_numberofpeople");
				ex2.setInbound_numberofpeople(Inbound_numberofpeople.getText());

				Element Outbound_numberofpeople=ExtendInfo.element("Outbound_numberofpeople");
				ex2.setOutbound_numberofpeople(Outbound_numberofpeople.getText());

				Element Inbound_Delayedflights=ExtendInfo.element("Inbound_Delayedflights");
				ex2.setInbound_Delayedflights(Inbound_Delayedflights.getText());

				Element Outbound_Delayedflights=ExtendInfo.element("Outbound_Delayedflights");
				ex2.setOutbound_Delayedflights(Outbound_Delayedflights.getText());

				Element AirportStatus=ExtendInfo.element("AirportStatus");
				ex2.setAirportStatus(AirportStatus.getText());

				Element Inbound_flights_number=ExtendInfo.element("Inbound_flights_number");
				ex2.setInbound_flights_number(Inbound_flights_number.getText());

				Element Outbound_flightsnumber=ExtendInfo.element("Outbound_flightsnumber");
				ex2.setOutbound_flightsnumber(Outbound_flightsnumber.getText());

				Element Time=ExtendInfo.element("Time");
				ex2.setTime(Time.getText());
			}
		}
		
		return ex2;
	}

}
