package util;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import EBDEntity.EBD;
import EBIEntity.Attachment;
import EBIEntity.BroadcastStyle;
import EBIEntity.EB;
import EBIEntity.EBI;
import EBIEntity.EBI_Area;
import EBIEntity.EBI_EBContent;
import EBIEntity.EBI_EBMainInfo;
import EBIEntity.EBI_ExtendInfo1;
import EBIEntity.EBI_ExtendInfo2;
import EBIEntity.EBI_PublishStrategy;
import EBIEntity.EBString;
import dao.EBDao;
import service.EBService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t=new Test();
		EBDTest dt=new EBDTest();
		EBI ebi=t.test();
		EBD ebdd=dt.test();
		EBIXmlMaker ebixm=new EBIXmlMaker();
		EBDXmlMaker ebdxm=new EBDXmlMaker();
		String ebisrtxml=ebixm.EBI2String(ebi);
		String ebdstrxml=ebdxm.EBD2String(ebdd);
		EBString ebs=new EBString();
		ebs.setEBI(ebisrtxml);
		
		ebs.setResource("");
		ebs.setEBD(ebdstrxml);
		
		EBDao ebd=new EBDao();
//		ebd.add(ebs);
//		ebd.delete("8");
		try {
			EB eb=new EBService().detail("7");
			EBI ebi2=eb.getEBI();
			System.out.println(eb.toString());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		try {
//			List<EB> list=new EBService().findAll();
//			for(EB eb:list){
//				System.out.println(eb.toString());
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	public EBI  test(){
		EBI ebi = new EBI();
		EBI_EBMainInfo ebm=new EBI_EBMainInfo();
		ebm.setEBIVersion("1");
		ebm.setInfoID("111000000000001021020120150624001");
		ebm.setEBIID("111000000000001021020120150624001");
		ebm.setIdentifier("gailun");
		ebm.setSender("jiawensishi");
		ebm.setSenderCode("36070041600024");
		ebm.setEventType("10201");
		ebm.setEventLevel("02");
		ebm.setInfoType("01");
		ebm.setInfoStatus("01");
		ebm.setReferenceId("111000000000001021020120150624002");
		ebm.setInstructions("天崩地裂");
		ebm.setIsMediaRes("1");
		ebm.setIsTTS("1");
		ebi.setEBMainInfo(ebm);
		
		Attachment att[]=new Attachment[2];
		for(int i=0;i<2;i++){
			att[i]= new Attachment();
		}
		att[0].setAttName("first");
		att[0].setAttDescription("MVP");
		att[0].setAttSize("8");
		att[0].setAttType("1");
		att[0].setAttSuffix(".wma");
		att[0].setAttURL("www.baidu.com");
		att[0].setDigest("1");
		att[1].setAttName("second");
		att[1].setAttDescription("MVP+");
		att[1].setAttSize("8+");
		att[1].setAttType("1+");
		att[1].setAttSuffix(".wma+");
		att[1].setAttURL("www.baidu.com+");
		att[1].setDigest("1+");
		
		Attachment att1[]=new Attachment[1];
		for(int i=0;i<1;i++){
			att1[i]= new Attachment();
		}
		att1[0].setAttName("harden");
		att1[0].setAttDescription("MVP");
		att1[0].setAttSize("8");
		att1[0].setAttType("1");
		att1[0].setAttSuffix(".wma");
		att1[0].setAttURL("www.baidu.com");
		att1[0].setDigest("1");
	
		
		EBI_EBContent ebc[]=new EBI_EBContent[2];
		for(int i=0;i<2;i++){
			ebc[i]=new EBI_EBContent();
		}
		ebc[0].setLanguage("中文");
		ebc[0].setAttachments(att);
		ebc[0].setLanguageCode("zh-CN");
		ebc[0].setCodeSet("UTF-8");
		ebc[0].setHeadline("北海市气象局发布台风蓝色预警");
		ebc[0].setEventDescription("北海市气象台 2015 年 6 月 24 日 15 时 30 分更新台风"
				+ "黄色预警信号为台风蓝色预警信号：受 8 号台风“鲸鱼”环流影响，预计未来"
				+ " 24 小时内我市沿海及北部湾海面将出现8 级以上阵风，请注意防范。");
		ebc[0].setProgramNum("paul");
		ebc[0].setSigner("klay");
		
		ebc[1].setLanguage("中文+");
		ebc[1].setAttachments(att1);
		ebc[1].setLanguageCode("zh-CN+");
		ebc[1].setCodeSet("UTF-8+");
		ebc[1].setHeadline("北海市气象局发布台风蓝色预警+");
		ebc[1].setEventDescription("北海市气象台 2015 年 6 月 24 日 15 时 30 分更新台风"
				+ "黄色预警信号为台风蓝色预警信号：受 8 号台风“鲸鱼”环流影响，预计未来"
				+ " 24 小时内我市沿海及北部湾海面将出现8 级以上阵风，请注意防范。+");
		ebc[1].setProgramNum("paul+");
		ebc[1].setSigner("klay+");

		ebi.setEBContent(ebc);
		
		BroadcastStyle bs[] = new BroadcastStyle[2];
		for(int i=0;i<bs.length;i++){
			bs[i]=new BroadcastStyle();
		}
		bs[0].setPresentation("0102");
		bs[0].setPublishFrequency("一天两次");
		bs[0].setPublishMeans("0203");
		bs[0].setRollFrequency("一次两次");
		bs[1].setPresentation("0102+");
		bs[1].setPublishFrequency("一天两次+");
		bs[1].setPublishMeans("0203+");
		bs[1].setRollFrequency("一次两次+");
		
		EBI_PublishStrategy pub=new EBI_PublishStrategy();
		pub.setPublishRegion("450000000001,450000000002");
		pub.setBroadcastDateTime("2015-06-24 17:30:00");
		pub.setOverDateTime("2015-06-24 23:30:00");
		pub.setBroadcastStyle(bs);
		ebi.setPublishStrategy(pub);
		
		EBI_Area area=new EBI_Area();
		area.setAreaCircle("地理区域描述");
		area.setAreaDescription("地 理 区 域 多 边形表示");
		area.setAreaPolygon("地 理 区 域 椭 圆形表示");
		ebi.setArea(area);
		
		EBI_ExtendInfo1 ex1=new EBI_ExtendInfo1();
		ex1.setLocation_code("Location_code");
		ex1.setPlace("Place");
		ex1.setEarthquake_time("Earthquake_time");
		ex1.setLevel("Level");
		ex1.setDepth("Depth");
		ex1.setLongitude("Longitude");
		ex1.setLatitude("Latitude");
		ex1.setEq_type("Eq_type");
		ex1.setExpedited_reporting_type("Expedited_reporting_type");
		ex1.setNearest_provincial_capital("Nearest_provincial_capital");
		ex1.setShenghui("Shenghui");
		ex1.setNearest_prefecture("Nearest_prefecture");
		ex1.setDijishi("Dijishi");
		ex1.setNearest_county("Nearest_county");
		ex1.setXianjishi("Xianjishi");
		ex1.setNearest_village("Nearest_village");
		ex1.setVillages("Villages");
		ex1.setNearest_town("Nearest_town");
		ex1.setTowns("Towns");
		ex1.setJuli("Juli");
		ex1.setRange("Range");
		ex1.setSeismic_information("Seismic_information");
		ex1.setWEATHER("WEATHER");
		ex1.setAltitude("Altitude");
		ex1.setPopulation("Population");
		ex1.setArea("Area");
		ex1.setGdp("Gdp");
		ex1.setFive_earthquake("Five_earthquake");
		ebi.setExtendInfo1(ex1);
		
		EBI_ExtendInfo2 ex2 =new EBI_ExtendInfo2();
		ex2.setAirport("Airport");
		ex2.setAirportcode("Airportcode");
		ex2.setInbound_flights("Inbound_flights");
		ex2.setOutbound_flights("Outbound_flights");
		ex2.setInbound_numberofpeople("Inbound_numberofpeople");
		ex2.setOutbound_numberofpeople("Outbound_numberofpeople");
		ex2.setInbound_Delayedflights("Inbound_Delayedflights");
		ex2.setOutbound_Delayedflights("Outbound_Delayedflights");
		ex2.setAirportStatus("AirportStatus");
		ex2.setInbound_flights_number("Inbound_flights_number");
		ex2.setOutbound_flightsnumber("Outbound_flightsnumber");
		ex2.setTime("time");
		ebi.setExtendInfo2(ex2);
		//测试
//		System.out.println(ebi.getPublishStrategy().getPublishRegion());
//		EBIXmlMaker xm=new EBIXmlMaker();
//		String strxml=xm.EBI2String(ebi);
//		EBIDao d= new EBIDao();
//		d.add(strxml);
		return ebi;
//		Document doc=null;
//		try {
//			doc = DocumentHelper.parseText(strxml);
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//得到根节点
//		Element root =doc.getRootElement();
//		Element Area=root.element("Area");
//		Element AreaDescription=Area.element("AreaDescription");
//		String s=AreaDescription.getText();
//		System.out.print(s);
		

	}

}
