package edu.yangtzeu.lmis.bll;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.yangtzeu.lmis.dal.BookDAL;
import edu.yangtzeu.lmis.dal.ReaderDAL;
import edu.yangtzeu.lmis.dal.SQLHelper;
import edu.yangtzeu.lmis.model.Book;
import edu.yangtzeu.lmis.model.Reader;

public class BookAdmin extends LibraryBLL{
	public BookAdmin() {
		dal=new BookDAL();
	}
	private BookDAL dall=new BookDAL();
	public void newBook(Book book) {
		// TODO Auto-generated method stub
		try {
			dal.add(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		try {
			dal.update(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteBook(Book book) {
		try {
			dal.delete(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Book[] simpleSelectedBooks(String cb, String text) {
		// TODO Auto-generated method stub
		try {
			return dall.getSimpleBookBy(cb,text);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Book[] advencedselectedBooks(String bkName, String bkPress, String bkAuthor, String bkCatalog,
			String bkBrief, String bkDatePress) {
		// TODO Auto-generated method stub
		try {
			return dall.getAdvancedBookBy(bkName,bkPress,bkAuthor,bkCatalog,bkBrief,bkDatePress);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Book getBook(int bkID) {
		try {
			return (Book) ((BookDAL) dal).getObjectByID(bkID);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	 public Book[] getBookName(String bkName) {
		try {
			return  (Book[]) dall.getBookByName(bkName);
			} catch  (SQLException e) {
				e.printStackTrace( );
				}
			return null;
		}
	 public Book[] getBook2(int bkID) {
			try {
			return  (Book[]) dall.getBookBy(bkID);
			} catch  (SQLException e) {
			e.printStackTrace( );
			}
			return null;
			}

	 public int getMax() {
		 try {
			return dall.getMaxID();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	 }
	
	
}
