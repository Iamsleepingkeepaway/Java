package edu.yangtzeu.lmis.dal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.yangtzeu.lmis.model.AbstractModel;
import edu.yangtzeu.lmis.model.Reader;
import edu.yangtzeu.lmis.model.ReaderType;

public class ReaderDAL extends AbstractDAL{
	@Override
	public int add(AbstractModel object) throws Exception{
		if(object instanceof Reader == false) {
			throw new Exception("Can only handle Reader");
		}
		Reader rt=(Reader) object;
		String sql = "insert into TB_Reader (rdID,"
				+"rdName,rdSex,rdType,rdDept,rdPhone,"
				+"rdEmail,rdDateReg,rdPhoto,rdStatus,"
				+"rdBorrowQty,rdPwd,rdAdminRoles) "
				+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params =new Object[13];
		params[0]=rt.getRdID();
		params[1]=rt.getRdName();
		params[2]=rt.getRdSex();
		params[3]=rt.getRdType();
		params[4]=rt.getRdDept();
		params[5]=rt.getRdPhone();
		params[6]=rt.getRdEmail();
		params[7]=rt.getRdDateReg();
		params[8]=rt.getRdPhoto();
		params[9]=rt.getRdStatus();
		params[10]=rt.getRdBorrowQty();
		params[11]=rt.getRdPwd();
		params[12]=rt.getRdAdminRoles();
		return SQLHelper.ExecSql(sql,params);
	}
	
	@Override
	public int delete(AbstractModel object) throws Exception{
		if(object instanceof Reader == false) {
			throw new Exception("Can only handle Reader");
		}
		Reader rt=(Reader) object;
		String sql="delete from TB_Reader where rdID = ?";
		Object[] params=new Object[] {rt.getRdID()};
		int rows =SQLHelper.ExecSql(sql,params);
		return rows;
	}
	
	@Override
	public int update(AbstractModel object) throws Exception{
		if(object instanceof Reader ==false) {
			throw new Exception("Can only handle Reader");
		}
		Reader rt=(Reader) object;
		String sql="update TB_Reader set rdName = ?, "
				+"rdSex = ?, rdType = ?, rdDept = ?, rdPhone = ?, "
				+"rdEmail = ?, rdDateReg = ?, rdPhoto = ?, rdStatus = ?, "
				+"rdBorrowQty = ?, rdPwd = ?, rdAdminRoles = ? where rdID = ?";
		Object[] params = new Object[] {rt.getRdName(),rt.getRdSex(),rt.getRdType(),
				rt.getRdDept(),rt.getRdPhone(),rt.getRdEmail(),rt.getRdDateReg(),
				rt.getRdPhoto(),rt.getRdStatus(),rt.getRdBorrowQty(),rt.getRdPwd(),
				rt.getRdAdminRoles(),rt.getRdID()};
		return SQLHelper.ExecSql(sql,params);
		}
	
	public Reader getObjectByID(int rdID) throws SQLException{
		Reader rt=null;
		ResultSet rs=SQLHelper
				.getResultSet("select rdID,rdName,rdSex,rdType"
						+",rdDept,rdPhone,rdEmail,rdDateReg,rdPhoto,"
						+"rdStatus,rdBorrowQty,rdPwd,"
						+"rdAdminRoles from TB_Reader where rdID="
						+rdID);
		if(rs !=null) {
			if(rs.next()) {
				rt=initReader(rs);
			}
			rs.close();
		}
		return rt;
	}

	private Reader initReader(ResultSet rs) throws SQLException{
		// TODO Auto-generated method stub
		Reader rt=new Reader();
		rt.setRdID(rs.getInt("rdID"));
		rt.setRdName(rs.getString("rdName"));
		rt.setRdSex(rs.getString("rdSex"));
		rt.setRdType(rs.getInt("rdType"));
		rt.setRdDept(rs.getString("rdDept"));
		rt.setRdPhone(rs.getString("rdPhone"));
		rt.setRdEmail(rs.getString("rdEmail"));
		rt.setRdDateReg(rs.getDate("rdDateReg"));
		rt.setRdPhoto(rs.getBytes("rdPhoto"));
		rt.setRdStatus(rs.getString("rdStatus"));
		rt.setRdBorrowQty(rs.getInt("rdBorrowQty"));
		rt.setRdPwd(rs.getString("rdPwd"));
		rt.setRdAdminRoles(rs.getInt("rdAdminRoles"));
		return rt;
	}
	
	@Override
	public AbstractModel[] getAllObjects() throws Exception{
		ArrayList<Reader> objects = new ArrayList<Reader>();
		ResultSet rs =SQLHelper.getResultSet("select * from TB_Reader");
		if(rs!=null) {
			while(rs.next()) {
				Reader rt=initReader(rs);
				objects.add(rt);
			}
			rs.close();
		}
		Reader[] types=new Reader[objects.size()];
		objects.toArray(types);
		return types;
	}
	
	private String[] dispColNames=new String[] {"ID","姓名","性别","类型","院系","电话","email","状态","已借书数量","注册日期"};
	private String[] methodNames=new String[] {"getRdID","getRdName","getRdSex","getRdType","getRdDept",
			"getRdPhone","getRdEmail","getRdStatus","getRdBorrowQty","getRdDateReg"};
	
	public String[] getPrettyColumnNames() {
		return dispColNames;
	}
	public String[] getMethodNames() {
		return methodNames;
	}
	
	public Reader[] getReadersBy(int rdType,String deptType,String userName)throws SQLException{
		ArrayList<Reader> readers=new ArrayList<Reader>();
		String sql="select * from TB_Reader WHERE rdType = ? and rdDept = ? and rdName like ?";
		Object[] params=new Object[] {rdType,deptType,"%"+userName+"%"};
		ResultSet rs=SQLHelper.getResultSet(sql,params);
		if(rs!=null) {
			while(rs.next()) {
				Reader reader=initReader(rs);
				readers.add(reader);
			}
			rs.close();
		}
		if(readers.size()>0) {
			Reader[] array=new Reader[readers.size()];
			readers.toArray(array);
			return array;
		}
		return null;
	}
	public int getReadersBy1(String rdType)throws SQLException{
		String sql="select rdType from TB_ReaderType WHERE rdTypeName = ? ";
		Object[] params=new Object[] {rdType};
		ResultSet rs=SQLHelper.getResultSet(sql,params);
		if(rs!=null) {
			while(rs.next()) {
				return rs.getInt("rdType");
			}
			rs.close();
		}
		
		return -1;
	}

	public int getTranceReaderTypeBy(String rdType) throws SQLException{
		String sql = "select rdType from TB_ReaderType where rdTypeName = ? ";
		Object[] params = new Object[] {rdType};
		ResultSet rs = SQLHelper.getResultSet(sql, params);
		if(rs != null) {
			while(rs.next()) {
				return rs.getInt("rdType");
			}
		}
		return -1;
	}
	
	public String getTranceReaderType1By(int rdType) throws SQLException{
		String sql = "select rdTypeName from TB_ReaderType where rdType = ? ";
		Object[] params = new Object[] {rdType};
		ResultSet rs = SQLHelper.getResultSet(sql, params);
		if(rs != null) {
			while(rs.next()) {
				return rs.getString("rdTypeName");
			}
		}
		return null;
	}

	
}

