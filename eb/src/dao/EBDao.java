package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import EBIEntity.EBString;
import util.DataSourceUtils;
public class EBDao {

	public static void main(String[] args) {
		

	}
	/*
	 * 增加一条EB
	 */
	public void add(EBString eb){
		QueryRunner qr= new QueryRunner(DataSourceUtils.getDataSource());
		try{
			String sql="insert into eb (EBI,Resource,EBD) values(?,?,?)";

			qr.update(sql,eb.getEBI(),eb.getResource(),eb.getEBD());
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
	}
	/*
	 * 根据ID获取一条EB
	 */
	public EBString findById(String id) throws Exception{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from eb where ID=?";
		return runner.query(sql, new BeanHandler<EBString>(EBString.class), id);
	}
	/*
	 * 获取所有EB信息
	 */
	public List<EBString> findAll() throws SQLException {
//		System.out.print("service");
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from eb";
		return runner.query(sql, new BeanListHandler<EBString>(EBString.class));
	}
	/*
	 * 根据ID删除EB
	 */
	public int delete(String id){
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from eb where ID=?";
		try {
			int row=runner.update(sql,id);
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
