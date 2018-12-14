package edu.yangtzeu.lmis.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import edu.yangtzeu.lmis.model.AbstractModel;
import edu.yangtzeu.lmis.model.Borrow;


public class BorrowDAL extends AbstractDAL{


	public AbstractModel[] getAll0bjects() throws Exception {
		ArrayList<Borrow> objects = new ArrayList<Borrow>();
		ResultSet rs = SQLHelper .getResultSet("select * from TB_Borrow");
		if (rs != null) {
		while (rs.next()) {
			Borrow rt = initBorrow(rs);
		objects.add(rt);
		}
		rs.close( );
		}
		Borrow[ ] types = new Borrow[objects.size()];objects.toArray( types);
		return types;
	}
	public Borrow[] getBorrowBy(int rdID)throws SQLException{
		ArrayList<Borrow> books=new ArrayList<Borrow>();
		String sql="select * from TB_Borrow WHERE rdID = ?";
		Object[] params=new Object[] {rdID};
		ResultSet rs=SQLHelper.getResultSet(sql,params);
		if(rs!=null) {
			while(rs.next()) {
				Borrow book=initBorrow (rs);
				books.add(book);
			}
			rs.close();
		}
		if(books.size()>0) {
			Borrow[] array=new Borrow[books.size()];
			books.toArray(array);
			return array;
		}
		return null;
	}
	

	public int add(AbstractModel object) throws Exception {
		if(object instanceof Borrow == false) {
			throw new Exception("Can only handle Borrow");
		}
		Borrow  rt=(Borrow) object;
		String sql = "insert into TB_Borrow (rdID,bkID,bkName,ldContinueTimes" 
			    +",ldDateOut,ldDateRetPlan,ldDateRetAct,ldOverDay," 
				+"ldPunishMoney,ldOverMoney,lsHasReturn,OperatorLend," 
				+"OperatorRet ) "
				+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params =new Object[13];
		//params[0]=rt.getBorrowID();
		params[0]=rt.getRdID();
		params[1]=rt.getBkID();
		params[2]=rt.getBkName();
		params[3]=rt.getLdContinueTimes();
		params[4]=rt.getLdDateOut();
		params[5]=rt.getLdDateRetPlan();
		params[6]=rt.getLdDateRetAct();
		params[7]=rt.getLdOverDay() ;
		params[8]=rt.getLdOverMoney();
		params[9]=rt.getLdPunishMoney();
		params[10]=rt.isLsHasReturn() ;
		params[11]=rt.getOperatorLend();
		params[12]=rt.getOperatorRet();
		return SQLHelper.ExecSql(sql,params);
	}
//	public int add(AbstractModel object) throws Exception {
//		if(object instanceof Borrow == false) {
//			throw new Exception("Can only handle Book");
//		}
//		Borrow  rt=(Borrow) object;
//		String sql = "insert into TB_Borrow (BorrowID,rdID,bkID,bkName" 
//			    +",ldDateOut,ldDateRetPlan) "
//				+"VALUES(?,?,?,?,?,?)";
//		Object[] params =new Object[6];
//		params[0]=rt.getBorrowID();
//		params[1]=rt.getBkID();
//		params[2]=rt.getRdID();
//		params[3]=rt.getBkName();
//		params[4]=rt.getLdDateOut();
//		params[5]=rt.getLdDateRetPlan();
//
//		return SQLHelper.ExecSql(sql,params);
//	}

	public int delete(AbstractModel object) throws Exception {
		if(object instanceof Borrow == false) {
			throw new Exception("Can only handle Borrow");
		}
		Borrow rt=(Borrow) object;
		String sql="delete from TB_Borrow where BorrowID = ?";
		Object[] params=new Object[] {rt.getBorrowID()};
		int rows =SQLHelper.ExecSql(sql,params);
		return rows;

	}


	public int update(AbstractModel object) throws Exception {
		if(object instanceof Borrow == false) {
			throw new Exception("Can only handle Borrow ");
		}
		Borrow  rt=(Borrow) object;
		String sql="update TB_Borrow  set rdID = ?,bkID = ?,bkName = ?,ldContinueTimes = ?" 
										+",ldDateOut = ? ,ldDateRetPlan = ? ,ldDateRetAct = ?,ldOverDay = ?," 
										+"ldOverMoney=?,ldPunishMoney = ?,lsHasReturn = ?,OperatorLend = ?,"  
										+"OperatorRet = ? where BorrowID = ?";
		Object[] params = new Object[] {rt.getRdID(),rt.getBkID(),rt.getBkName(),
				rt.getLdContinueTimes(),rt.getLdDateOut(),rt.getLdDateRetPlan(),rt.getLdDateRetAct(),
				rt.getLdOverDay(),rt.getLdOverMoney(),rt.getLdPunishMoney(),
				rt.isLsHasReturn(),rt.getOperatorLend(),rt.getOperatorRet(),rt.getBorrowID()};
		return SQLHelper.ExecSql(sql,params);
	}

	public AbstractModel getObjectByID(int rdID) throws SQLException {
		Borrow rt=null;
		ResultSet rs=SQLHelper
				.getResultSet("select BorrowID,rdID,bkID,bkName,ldContinueTimes"
						+",ldDateOut,ldDateRetPlan,ldDateRetAct,ldOverDay,"
						+"ldPunishMoney,ldOverMoney,lsHasReturn,OperatorLend,"
						+"OperatorRet from TB_Borrow where rdID="
						+rdID);
		if(rs !=null) {
			if(rs.next()) {
				rt=initBorrow(rs);
			}
			rs.close();
		}
		return rt;
	}
	public AbstractModel getObjectByBorrowID(int BorowID) throws SQLException {
		Borrow rt=null;
		ResultSet rs=SQLHelper
				.getResultSet("select BorrowID,rdID,bkID,bkName,ldContinueTimes"
						+",ldDateOut,ldDateRetPlan,ldDateRetAct,ldOverDay,"
						+"ldPunishMoney,ldOverMoney,lsHasReturn,OperatorLend,"
						+"OperatorRet from TB_Borrow where BorrowID="
						+BorowID);
		if(rs !=null) {
			if(rs.next()) {
				rt=initBorrow(rs);
			}
			rs.close();
		}
		return rt;
	}

	private Borrow initBorrow(ResultSet rs)  throws SQLException{
		Borrow rt=new Borrow();
		rt.setBorrowID(rs.getLong("BorrowID"));
		rt.setRdID(rs.getInt("rdID"));
		rt.setBkID(rs.getInt("bkID"));
		rt.setBkName(rs.getString("bkName"));
		rt.setLdContinueTimes(rs.getInt("ldContinueTimes"));
		rt.setLdDateOut(rs.getDate("ldDateOut"));
		rt.setLdDateRetPlan(rs.getDate("ldDateRetPlan"));
		rt.setLdDateRetAct(rs.getDate("ldDateRetAct"));
		rt.setLdOverDay(rs.getInt("ldOverDay"));
		rt.setLdPunishMoney(rs.getFloat("ldPunishMoney"));
		rt.setLdOverMoney(rs.getFloat("ldOverMoney"));
		rt.setLsHasReturn(rs.getBoolean("lsHasReturn") );
		rt.setOperatorLend(rs.getString("OperatorLend"));
		rt.setOperatorRet(rs.getString("OperatorRet"));
		return rt;
	}
	public int getBorrowId(int rdId,int bkId)throws SQLException{
		String sql ="select BorrowID from TB_Borrow WHERE rdID=? and bkID=?";
		Object[] params = new Object[] {rdId,bkId};
		ResultSet rs = SQLHelper.getResultSet(sql,params);
		if(rs!=null)
		{
			while(rs.next()) {
				return rs.getInt("BorrowID");
			}
			rs.close();
		}
		return -1;
	}

	
	private String[] dispColNames=new String[] { "图书序号", "图书名称", "续借次数","借阅日期","应还日期","超期天数","超期金额"};
	private String[] methodNames=new String[] {"getBkID","getBkName","getLdContinueTimes","getLdDateOut","getLdDateRetPlan","getLdOverDay","getLdOverMoney"};
	
public String[] getPrettyColumnNames() {
	return dispColNames;
}
public String[] getMethodNames() {
	return methodNames;
}
@Override
public AbstractModel[] getAllObjects() throws Exception {
	// TODO Auto-generated method stub
	return null;
}
	

	

}
