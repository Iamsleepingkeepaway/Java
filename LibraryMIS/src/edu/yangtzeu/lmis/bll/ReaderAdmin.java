package edu.yangtzeu.lmis.bll;

import java.sql.SQLException;

import edu.yangtzeu.lmis.dal.ReaderDAL;
import edu.yangtzeu.lmis.model.Reader;

public class ReaderAdmin extends LibraryBLL{

	
	public ReaderAdmin() {
		dal=new ReaderDAL();
	}
	private ReaderDAL dall=new ReaderDAL();
	
	public Reader getReader(int rdID) {
		try {
			return (Reader) ((ReaderDAL) dal).getObjectByID(rdID);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Reader[] retrieveReaders(String rdType,String deptType,String userName) {
		int a=0;
		try {
			a= dall.getReadersBy1(rdType);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			return dall.getReadersBy(a,deptType,userName);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Object getObjectByID(int rdType) {
		// TODO Auto-generated method stub
		
		try {
			return dall.getTranceReaderType1By(rdType);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	public int getrdtypename(String string) {
		// TODO Auto-generated method stub
		int a = 0;
		try {
			a = dall.getTranceReaderTypeBy(string);
			return a;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;

	}

	public void newReader(Reader reader) {
		// TODO Auto-generated method stub
		try {
			dal.add(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateReader(Reader reader) {
		// TODO Auto-generated method stub
		try {
			dal.update(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteReader(Reader reader) {
		try {
			dal.delete(reader);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

