package edu.yangtzeu.lmis.bll;

import java.sql.SQLException;

import edu.yangtzeu.lmis.dal.ReaderTypeDAL;
import edu.yangtzeu.lmis.model.ReaderType;

public class ReaderTypeAdmin extends LibraryBLL {

	private ReaderTypeDAL dal =  new ReaderTypeDAL();
	public ReaderTypeAdmin()
	   {
		   dal = new ReaderTypeDAL();
	   }
	public ReaderType[] getReaderType() {
		try {
		return  (ReaderType[])  dal.getAllObjects();
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
		}
	public ReaderType getReaderTypeByid(int rdtype) {
		try {
		return  (ReaderType)  dal.getObjectByID(rdtype);
		} catch  (SQLException e) {
		e.printStackTrace( );
		}
		return null;
		}
	 public void NewReaderType(ReaderType readertype)
	  {
		  try {
			dal.add(readertype);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		  
	  }
	 public void deleteReaderType(ReaderType readertype)
	    {
	    	try {
				dal.delete(readertype);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    }
	 public void updateReaderType(ReaderType readertype)
	    {
	    	try {
				dal.update(readertype);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    }
	 public String[] getDisplayColumnNames()
	 {  
	 	  return dal.getPrettyColumnNames();
	 }
	    public String[] getMethodNames()
	    {  
	    	  return dal.getMethodNames();
	    }
	    
	    public ReaderType[] retrieveReaderType() {
	    	try {
				return dal.getReaderTypeBy();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	    }
}

