package service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import EBDEntity.EBD;
import EBIEntity.EB;
import EBIEntity.EBI;
import EBIEntity.EBString;
import dao.EBDao;
import util.EBDParse;
import util.EBDXmlMaker;
import util.EBIParse;
import util.EBIXmlMaker;
import util.MakeFile;

public class EBService {

	EBDao ebd=new EBDao();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * 获取所有记录
	 */
	public List<EB> findAll() throws Exception{
		List<EB> eb=new ArrayList<EB>();
		List<EBString> list=ebd.findAll();
		EBIParse ebip=new EBIParse();
		EBDParse ebdp=new EBDParse();
		for(int i=0;i<list.size();i++){
			EB ebsi=new EB();
			String id=""+list.get(i).getID();
			ebsi.setID(id);
			
			String ebistr=list.get(i).getEBI();
			EBI ebi=ebip.EBI2Entity(ebistr);
			ebsi.setEBI(ebi);
			
			String restr=list.get(i).getResource();
			ebsi.setResource(restr);
			
			String ebdstr=list.get(i).getEBD();
			EBD ebd=ebdp.EBD2Entity(ebdstr);
			ebsi.setEBD(ebd);
			
			eb.add(ebsi);
		}
//		System.out.print(eb.get(0).getEBI().getEBMainInfo().getEBIID());
		return eb;
		
	}
	/*
	 * 根据ID查询记录
	 */
	public EB detail(String id) throws Exception{
		EB eb=new EB();

		EBIParse ebip=new EBIParse();
		EBDParse ebdp=new EBDParse();
		EBString ebs=ebd.findById(id);
		
//		System.out.println(ebs.toString());
		eb.setID(id);
		
		String ebistr=ebs.getEBI();
		EBI ebi=ebip.EBI2Entity(ebistr);
		eb.setEBI(ebi);
		
		String restr=ebs.getResource();
		eb.setResource(restr);
		
		String ebdstr=ebs.getEBD();
		EBD ebd=ebdp.EBD2Entity(ebdstr);
		eb.setEBD(ebd);
		
		return eb;
	}
	/*
	 * 增加一条记录
	 */
	public void add(EB eb){
		EBIXmlMaker ebixm=new EBIXmlMaker();
		EBDXmlMaker ebdxm=new EBDXmlMaker();
		EBString ebs=new EBString();
		EBDao ebd=new EBDao();
		
		
		
		String ebixmlstr=ebixm.EBI2String(eb.getEBI());
		ebs.setEBI(ebixmlstr);
		
		ebs.setResource(eb.getResource());
		
		String ebdxmlstr=ebdxm.EBD2String(eb.getEBD());
		ebs.setEBD(ebdxmlstr);

		ebd.add(ebs);
	}
	/*
	 * 删除一条记录
	 */
	public void delete(String id){
		ebd.delete(id);
	}
	/*
	 * 制作应急文件
	 */
	public void make(String id) throws Exception {
		
		MakeFile mf= new MakeFile();
		try {
			EBString ebs=ebd.findById(id);
			mf.EBString2File(ebs);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
