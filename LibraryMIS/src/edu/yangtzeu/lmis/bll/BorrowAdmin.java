package edu.yangtzeu.lmis.bll;

import java.sql.SQLException;
import edu.yangtzeu.lmis.dal.BorrowDAL;
import edu.yangtzeu.lmis.model.Borrow;



public class BorrowAdmin extends LibraryBLL{
	
	private BorrowDAL dal =  new BorrowDAL();
	public BorrowAdmin()
	   {
		   dal = new BorrowDAL();
	   }
	public Borrow[] getBorrow(int rdID) {
		try {
		return  (Borrow[]) dal.getBorrowBy(rdID);
		} catch  (SQLException e) {
		e.printStackTrace( );
		}
		return null;
	}
	public Borrow getBorrowbyBorrowid(int borrowID) {
		try {
		return  (Borrow) dal.getObjectByBorrowID(borrowID);
		} catch  (SQLException e) {
		e.printStackTrace( );
		}
		return null;
	}
	public Borrow getBorrowbyRdid(int rdID) {
		try {
		return  (Borrow) dal.getObjectByID(rdID);
		} catch  (SQLException e) {
		e.printStackTrace( );
		}
		return null;
	}
	 public void NewBorrow(Borrow book)
	  {
		  try {
			dal.add(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	  public void deleteBorrow(Borrow borrow)
	    {
	    	try {
				dal.delete(borrow);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    }
	  public int retrieveBorrowId(int rdId,int bkId)
	    {
	    	
	    	try {
				return dal.getBorrowId(rdId,bkId);
			}catch(SQLException e) {
				e.printStackTrace();
			}
	    	return 0;
	    }
	  public void updateBorrow(Borrow borrow)
	    {
	    	try {
				dal.update(borrow);
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

}
