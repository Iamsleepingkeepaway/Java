package edu.yangtzeu.lmis.dal;
import edu.yangtzeu.lmis.model.Book;
import edu.yangtzeu.lmis.model.Reader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.yangtzeu.lmis.model.AbstractModel;


public class BookDAL extends AbstractDAL{
	@Override
	public int add(AbstractModel object) throws Exception{
		if(object instanceof Book == false) {
			throw new Exception("Can only handle Reader");
		}
		Book rt=(Book) object;
		String sql = "insert into TB_Book ("
				+"bkCode,bkName,bkAuthor,bkPress,bkDatePress,"
				+"bkISBN,bkCatalog,bkLanuage,bkPages,bkPrice,"
				+"bkDateIn,bkBrief,bkCover,bkStatus) "
				+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params =new Object[14];
		//params[0]=rt.getBkID();
		params[0]=rt.getBkCode();
		params[1]=rt.getBkName();
		params[2]=rt.getBkAuthor();
		params[3]=rt.getBkPress();
		params[4]=rt.getBkDatePress();
		params[5]=rt.getBkISBN();
		params[6]=rt.getBkCatalog();
		params[7]=rt.getBkLanuage();
		params[8]=rt.getBkPages();
		params[9]=rt.getBkPrice();
		params[10]=rt.getBkDateIn();
		params[11]=rt.getBkBrief();
		params[12]=rt.getBkCover();
		params[13]=rt.getBkStatus();
		return SQLHelper.ExecSql(sql,params);
	}
	
	@Override
	public int delete(AbstractModel object) throws Exception{
		if(object instanceof Book == false) {
			throw new Exception("Can only handle Book");
		}
		Book rt=(Book) object;
		String sql="delete from TB_Book where bkID = ?";
		Object[] params=new Object[] {rt.getBkID()};
		int rows =SQLHelper.ExecSql(sql,params);
		return rows;
	}
	
	@Override
	public int update(AbstractModel object) throws Exception{
		if(object instanceof Book==false) {
			throw new Exception("Can only handle Book");
		}
		Book rt=(Book) object;
		String sql="update TB_Book set bkCode = ?, bkName = ?, bkAuthor = ?, "
				+"bkPress = ?, bkDatePress = ?, bkISBN = ?, bkCatalog = ?, "
				+"bkLanuage = ?, bkPages = ?, bkPrice = ?, bkDateIn = ?, "
				+"bkBrief = ?, bkCover = ?, bkStatus = ? where bkID = ?";
		Object[] params = new Object[] {rt.getBkCode(),rt.getBkName(),rt.getBkAuthor(),
				rt.getBkPress(),rt.getBkDatePress(),rt.getBkISBN(),rt.getBkCatalog(),
				rt.getBkLanuage(),rt.getBkPages(),rt.getBkPrice(),rt.getBkDateIn(),
				rt.getBkBrief(),rt.getBkCover(),rt.getBkStatus(),rt.getBkID()};
		return SQLHelper.ExecSql(sql,params);
		}
	
	public Book getObjectByID(int bkID) throws SQLException{
		Book rt=null;
		ResultSet rs=SQLHelper
				.getResultSet("select bkID,bkCode,bkName,bkAuthor,bkPress,bkDatePress"
						+",bkISBN,bkCatalog,bkLanuage,bkPages,bkPrice,"
						+"bkDateIn,bkBrief,bkCover,"
						+"bkStatus from TB_Book where bkID="
						+bkID);
		if(rs !=null) {
			if(rs.next()) {
				rt=initBook(rs);
			}
			rs.close();
		}
		return rt;
	}
	public Book[] getBookBy(int bkID) throws SQLException{
		ArrayList<Book> books=new ArrayList<Book>();
		String sql="select * from TB_Book WHERE bkID = ?";
		Object[] params=new Object[] {bkID};
		ResultSet rs=SQLHelper.getResultSet(sql,params);
		if(rs!=null) {
			while(rs.next()) {
				Book book=initBook(rs);
				books.add(book);
			}
			rs.close();
		}
		if(books.size()>0) {
			Book[] array=new Book[books.size()];
			books.toArray(array);
			return array;
		}
		return null;

	}
	
	public int getMaxID() throws SQLException{
		String sql="select MAX(bkID) from TB_Book";
		ResultSet a=SQLHelper.getResultSet(sql);
		if(a!=null) {
			while (a.next()) {
				return a.getInt(1);
			}
			a.close();
		}
		return 0;
	}

	private Book initBook(ResultSet rs) throws SQLException{
		// TODO Auto-generated method stub
		Book rt=new Book();
		rt.setBkID(rs.getInt("bkID"));
		rt.setBkCode(rs.getString("bkCode"));
		rt.setBkName(rs.getString("bkName"));
		rt.setBkAuthor(rs.getString("bkAuthor"));
		rt.setBkPress(rs.getString("bkPress"));
		rt.setBkDatePress(rs.getDate("bkDatePress"));
		rt.setBkISBN(rs.getString("bkISBN"));
		rt.setBkCatalog(rs.getString("bkCatalog"));
		rt.setBkPages(rs.getInt("bkPages"));
		rt.setBkPrice(rs.getFloat("bkPrice"));
		rt.setBkDateIn(rs.getDate("bkDateIn"));
		rt.setBkBrief(rs.getString("bkBrief"));
		rt.setBkCover(rs.getBytes("bkCover"));
		rt.setBkStatus(rs.getString("bkStatus"));
		return rt;
	}
	
	@Override
	public AbstractModel[] getAllObjects() throws Exception{
		ArrayList<Book> objects = new ArrayList<Book>();
		ResultSet rs =SQLHelper.getResultSet("select * from TB_Book");
		if(rs!=null) {
			while(rs.next()) {
				Book rt=initBook(rs);
				objects.add(rt);
			}
			rs.close();
		}
		Book[] types=new Book[objects.size()];
		objects.toArray(types);
		return types;
	}

	private String[] dispColNames=new String[] {"ID","索书号","书名","作者","出版社","出版日期","ISBN","分类号","语种","页数","价格","入馆时间","状态"};
	private String[] methodNames=new String[] {"getBkID","getBkCode","getBkName","getBkAuthor","getBkPress",
			"getBkDatePress","getBkISBN","getBkCatalog","getBkLanuage","getBkPages","getBkPrice","getBkDateIn","getBkStatus"};
	
	public String[] getPrettyColumnNames() {
		return dispColNames;
	}
	public String[] getMethodNames() {
		return methodNames;
	}
	
	

	public Book[] getBooksBy(String bkName, String bkPress, String bkAuthor, String bkCatalog, String bkBrief,String bkDatePress) throws SQLException{
		ArrayList<Book> books=new ArrayList<>();
		String sql="select * from TB_Book WHERE bkName like ? and bkPress like ? and bkAuthor like ? and bkCatalog like ? and bkBrief like ? and bkDatePress like ?";
		Object[] params=new Object[] {"%"+bkName+"%","%"+bkPress+"%","%"+bkAuthor+"%","%"+bkCatalog+"%","%"+bkBrief+"%","%"+bkDatePress+"%"};
		ResultSet rs=SQLHelper.getResultSet(sql,params);
		if(rs!=null) {
			while(rs.next()) {
				Book book=initBook(rs);
				books.add(book);
			}
			rs.close();
		}
		if(books.size()>0) {
			Book[] array=new Book[books.size()];
			books.toArray(array);
			return array;
		}
		return null;
		// TODO Auto-generated method stub
		
	}

	public Book[] getSimpleBookBy(String cb, String text) throws SQLException{
		// TODO Auto-generated method stub
		String sql="";
		ArrayList<Book> book = new ArrayList<>();
		if(cb.equals("书名")) {
			sql = "select * from TB_Book where bkName like ?";
		}
		if(cb.equals("作者")) {
			sql = "select * from TB_Book where bkAuthor like ?";
		}
		if(cb.equals("出版社")) {
			sql = "select * from TB_Book where bkPress like ?";
		}
		if(text == null) {
			text = "%";
		}
		else {
			text = "%" + text + "%";
		}
		Object[] params = new Object[] {text};
		ResultSet rs = SQLHelper.getResultSet(sql, params);
		if(rs != null) {
			while(rs.next()) {
				Book book1 = initBook(rs);
				book.add(book1);
			}
			rs.close();
		}
		if(book.size() > 0) {
			Book[] array = new Book[book.size()];
			book.toArray(array);
			return array;
		}
		return null;

	}

	public Book[] getAdvancedBookBy(String bkName, String bkPress, String bkAuthor, String bkCatalog, String bkBrief,
			String bkDatePress) throws SQLException{
		// TODO Auto-generated method stub
		ArrayList<Book> book = new ArrayList<>();
		String sql = "select * from TB_Book where bkName like ? and bkPress like ? and bkAuthor like ? and bkCatalog like ? and bkBrief like ? and bkDatePress like ?";
		if(bkName == null) {bkName = "%";}
		else {bkName = "%" + bkName + "%";}
		
		if(bkPress == null) {bkPress = "%";}
		else {bkPress = "%"+ bkPress +"%";}
		
		if(bkAuthor == null) {bkAuthor = "%";}
		else {bkAuthor = "%" + bkAuthor + "%";}
		
		if(bkCatalog == null) {bkCatalog = "%";}
		else {bkCatalog = "%"+ bkCatalog +"%";}
		
		if(bkBrief == null) {bkBrief = "%";}
		else {bkBrief = "%" + bkBrief + "%";}
		
		if(bkDatePress == null) {bkDatePress = "%";}
		else {bkDatePress = "%"+ bkDatePress +"%";}
		Object[] params = new Object[] {"%"+bkName+"%","%"+bkPress+"%","%"+bkAuthor+"%","%"+bkCatalog+"%","%"+bkBrief+"%","%"+bkDatePress+"%"};
		ResultSet rs = SQLHelper.getResultSet(sql, params);
		if(rs != null) {
			while(rs.next()) {
				Book books = initBook(rs);
				book.add(books);
			}
			rs.close();
		}
		if(book.size() > 0) {
			Book[] array = new Book[book.size()];
			book.toArray(array);
			return array;
		}
	

		return null;
	}

	public Book[] getBookByName(String bkName) throws SQLException{
		ArrayList<Book> books=new ArrayList<Book>();
		String sql="select * from TB_Book WHERE bkName  like ? ";
		Object[] params=new Object[] {"%"+bkName+"%"};
		ResultSet rs=SQLHelper.getResultSet(sql,params);
		if(rs!=null) {
			while(rs.next()) {
				Book book=initBook(rs);
				books.add(book);
			}
			rs.close();
		}
		if(books.size()>0) {
			Book[] array=new Book[books.size()];
			books.toArray(array);
			return array;
		}
		return null;

	}
}


