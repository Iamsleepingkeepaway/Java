package edu.yangtzeu.lmis.gui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import edu.yangtzeu.lmis.bll.BookAdmin;
import edu.yangtzeu.lmis.bll.BorrowAdmin;
import edu.yangtzeu.lmis.bll.ReaderAdmin;
import edu.yangtzeu.lmis.bll.ReaderTypeAdmin;
import edu.yangtzeu.lmis.gui.commons.CustomizedTableModel;
import edu.yangtzeu.lmis.model.Book;
import edu.yangtzeu.lmis.model.Borrow;
import edu.yangtzeu.lmis.model.Reader;
import edu.yangtzeu.lmis.model.ReaderType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class BorrowPanel extends JPanel{
	private JTextField tfrdId;
	private JTextField tfrdName;
	private JTextField tfCanLendQty;
	private JTextField tfrdDept;
	private JTextField tfCanLendDay;
	private JTextField tfrdBorrowQty;
	private JTextField tfrdType;
	private JTextField tfbkID;
	private JTextField tfbkName;
	private JTable searchbooktable;
	private JScrollPane searcbookscrollPane;
	private JPanel searchbookpanel;
	private JPanel borrowbookpanel;
	private JScrollPane borrowscrollPane;
	private ReaderTypeAdmin readerTypeBll = new ReaderTypeAdmin();
	private BookAdmin bookBll=new BookAdmin();
	private ReaderAdmin readerBll = new ReaderAdmin();
	private ReaderTypeAdmin readertypeBll=new ReaderTypeAdmin();
	private BorrowAdmin borrowBll = new BorrowAdmin();
	private BorrowAdmin borrowAdmin = new BorrowAdmin();
	private BorrowAdmin borrowA = new BorrowAdmin();
	private JTable table;
	private JButton bkIdSearchbutton;
	private JButton bkNameSearchbutton;
	public  static Long borrowid =11L;
	public BorrowPanel() {
		setSize(new Dimension(1255, 757));
		setLayout(null);
		
		JPanel readerInfopanel = new JPanel();
		readerInfopanel.setBorder(new TitledBorder(null, "\u8BFB\u8005\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		readerInfopanel.setBounds(0, 0, 1162, 94);
		add(readerInfopanel);
		readerInfopanel.setLayout(null);
		
		JLabel label = new JLabel("\u8BFB\u8005\u7F16\u53F7:");
		label.setBounds(28, 41, 72, 19);
		readerInfopanel.add(label);
		
		tfrdId = new JTextField();
		tfrdId.setBounds(114, 39, 110, 21);
		readerInfopanel.add(tfrdId);
		tfrdId.setColumns(10);
		
		JButton searchbutton = new JButton("\u67E5\u8BE2");
		searchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rdid = Integer.valueOf(tfrdId.getText().trim());
				Reader reader = new Reader();
				reader=readerBll.getReader(rdid);
				tfrdName.setText(reader.getRdName());
				tfrdDept.setText(reader.getRdDept());
				tfrdBorrowQty.setText(String.valueOf(reader.getRdBorrowQty()));
				ReaderType readertype = new ReaderType();
				readertype = readerTypeBll.getReaderTypeByid(reader.getRdType());
				tfrdType.setText(readertype.getRdTypeName());
				tfCanLendQty.setText(String.valueOf(readertype.getCanLendQty()));
				tfCanLendDay.setText(String.valueOf(readertype.getCanLendDay()));
				
				Borrow borrow = new Borrow();
				borrow = borrowAdmin.getBorrowbyRdid(rdid);
				/*Format f = new SimpleDateFormat("yyyy-MM-dd"); 
				 String DateRetPlan = f.format(borrow.getLdDateRetPlan());
				 String DateRetAct = f.format(borrow.getLdDateRetAct());
				 int tag =compare_date(DateRetPlan,DateRetAct);
				 if(tag == -1)
				 {
					 int Cov = DateCov(DateRetPlan,DateRetAct);
					 Float PunishMoney=readertype.getPunishRate()*Cov;
					 borrow.setLdOverDay(Cov);
					 borrow.setLdOverMoney(PunishMoney);
					 borrowA.updateBorrow(borrow);
				 }*/
				Borrow[] hits=borrowBll.getBorrow(rdid);
				updateTable(hits);	
			}
		});
		searchbutton.setBounds(238, 39, 64, 23);
		readerInfopanel.add(searchbutton);
		
		JLabel label_1 = new JLabel("\u8BFB\u8005\u59D3\u540D:");
		label_1.setBounds(315, 22, 72, 17);
		readerInfopanel.add(label_1);
		
		tfrdName = new JTextField();
		tfrdName.setBounds(421, 19, 110, 21);
		readerInfopanel.add(tfrdName);
		tfrdName.setColumns(10);
		
		JLabel label_2 = new JLabel("\u53EF\u501F\u4E66\u6570:");
		label_2.setBounds(316, 58, 71, 17);
		readerInfopanel.add(label_2);
		
		tfCanLendQty = new JTextField();
		tfCanLendQty.setColumns(10);
		tfCanLendQty.setBounds(421, 55, 110, 21);
		readerInfopanel.add(tfCanLendQty);
		
		tfrdDept = new JTextField();
		tfrdDept.setColumns(10);
		tfrdDept.setBounds(691, 19, 110, 21);
		readerInfopanel.add(tfrdDept);
		
		JLabel label_3 = new JLabel("\u8BFB\u8005\u5355\u4F4D:");
		label_3.setBounds(578, 20, 72, 21);
		readerInfopanel.add(label_3);
		
		JLabel label_4 = new JLabel("\u53EF\u501F\u5929\u6570:");
		label_4.setBounds(579, 57, 71, 18);
		readerInfopanel.add(label_4);
		
		tfCanLendDay = new JTextField();
		tfCanLendDay.setColumns(10);
		tfCanLendDay.setBounds(691, 55, 110, 21);
		readerInfopanel.add(tfCanLendDay);
		
		tfrdBorrowQty = new JTextField();
		tfrdBorrowQty.setColumns(10);
		tfrdBorrowQty.setBounds(961, 55, 111, 21);
		readerInfopanel.add(tfrdBorrowQty);
		
		tfrdType = new JTextField();
		tfrdType.setColumns(10);
		tfrdType.setBounds(961, 19, 111, 21);
		readerInfopanel.add(tfrdType);
		
		JLabel label_5 = new JLabel("\u8BFB\u8005\u7C7B\u578B:");
		label_5.setBounds(849, 20, 72, 21);
		readerInfopanel.add(label_5);
		
		JLabel label_6 = new JLabel("\u5DF2\u501F\u4E66\u6570:");
		label_6.setBounds(849, 57, 71, 18);
		readerInfopanel.add(label_6);
		
		JLabel label_7 = new JLabel("\u5DF2\u501F\u56FE\u4E66");
		label_7.setFont(new Font("",1,20));
		label_7.setBounds(10, 95, 111, 35);
		add(label_7);

		CustomizedTableModel<Borrow> booktableModel=new CustomizedTableModel<Borrow>(
				borrowBll.getDisplayColumnNames(),borrowBll.getMethodNames());
		 borrowbookpanel = new JPanel();
		borrowbookpanel.setBounds(10, 128, 1152, 187);
		add(borrowbookpanel);
		borrowbookpanel.setLayout(null);
	   
		
		
		table = new JTable(booktableModel);
		borrowscrollPane = new JScrollPane(table);
		//borrowscrollPane.setColumnHeaderView(table);
		borrowscrollPane.setBounds(0, 0, 1152, 187);
		borrowbookpanel.add(borrowscrollPane);
		
		JPanel bookInfopanel = new JPanel();
		bookInfopanel.setBorder(new TitledBorder(null, "\u56FE\u4E66\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bookInfopanel.setBounds(10, 325, 1152, 66);
		add(bookInfopanel);
		bookInfopanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u5E8F\u53F7:");
		lblNewLabel.setBounds(76, 35, 88, 19);
		bookInfopanel.add(lblNewLabel);
		
		tfbkID = new JTextField();
		tfbkID.setBounds(204, 33, 153, 21);
		bookInfopanel.add(tfbkID);
		tfbkID.setColumns(10);
		
		JLabel label_8 = new JLabel("\u56FE\u4E66\u540D\u79F0:");
		label_8.setBounds(569, 35, 83, 19);
		bookInfopanel.add(label_8);
		
		tfbkName = new JTextField();
		tfbkName.setBounds(703, 33, 146, 21);
		bookInfopanel.add(tfbkName);
		tfbkName.setColumns(10);
		
		bkIdSearchbutton = new JButton("\u67E5\u8BE2");
		bkIdSearchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bookid=Integer.valueOf(tfbkID.getText().trim());
				Book[] hit= bookBll.getBook2(bookid);
				updateResultTable(hit);
			}
		});
		bkIdSearchbutton.setBounds(440, 33, 66, 23);
		bookInfopanel.add(bkIdSearchbutton);
		
		bkNameSearchbutton = new JButton("\u67E5\u8BE2");
		bkNameSearchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookname=tfbkName.getText().trim();
				Book[] hit= bookBll.getBookName(bookname);
				updateResultTable(hit);
			}
		});
		bkNameSearchbutton.setBounds(925, 33, 66, 23);
		bookInfopanel.add(bkNameSearchbutton);
		CustomizedTableModel<Book> tableModel=new CustomizedTableModel<Book>(
				bookBll.getDisplayColumnNames(),bookBll.getMethodNames());
		searchbookpanel = new JPanel();
		searchbookpanel.setBounds(10, 401, 1152, 257);
		add(searchbookpanel);
		searchbookpanel.setLayout(null);
		
		searchbooktable = new JTable(tableModel);
		searchbooktable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		searcbookscrollPane = new JScrollPane(searchbooktable);
		searcbookscrollPane.setBounds(0, 0, 1160, 257);
		searchbookpanel.add(searcbookscrollPane);
		
		JButton Borrowbutton = new JButton("\u501F\u9605");
		Borrowbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow=searchbooktable.getSelectedRow();
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(null,"请先选中一条记录");
					return;
				}
				
			int rdid = Integer.valueOf(tfrdId.getText().trim());
			int bkID =Integer.valueOf((searchbooktable.getValueAt(selectedRow,0).toString()));
			Book book = new Book();
			book = bookBll.getBook(bkID);
			book.setBkStatus("借出");
			bookBll.updateBook(book);
			Borrow borrow = new Borrow();
			borrow.setRdID(rdid);
			borrow.setBkID(bkID);
			borrow.setBkName(book.getBkName());
			borrow.setBorrowID(borrowid);
			BorrowPanel borrowpanel = new BorrowPanel();
			borrowpanel.borrowid++;
			Calendar a=Calendar.getInstance();
			java.util.Date d=a.getTime();
			Format f = new SimpleDateFormat("yyyy-MM-dd"); 
			 String dateNowStr = f.format(d);
			borrow.setLdDateOut(Date.valueOf(dateNowStr));
			a.setTime(d);
			a.add(Calendar.DAY_OF_MONTH,10);
			borrow.setLdDateRetPlan(Date.valueOf(f.format(a.getTime())));
			borrowBll.NewBorrow(borrow);  
			Reader reader = new Reader();
			reader=readerBll.getReader(rdid);
			if(reader.getRdStatus().equals("无效")) {
				JOptionPane.showMessageDialog(null,"该证件属于挂失状态，无法借阅!");
			}else {
			int temp =reader.getRdBorrowQty()+1;
			reader.setRdBorrowQty(temp);
			readerBll.updateReader(reader);
	 		JOptionPane.showMessageDialog(null,"借书成功");
			}
			}
		});
		Borrowbutton.setBounds(582, 677, 93, 23);
		add(Borrowbutton);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.setBounds(716, 677, 93, 23);
		add(button_1);
		
		JButton Retbookbutton = new JButton("\u8FD8\u4E66");
		Retbookbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedRow=table.getSelectedRow();
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(null,"请先选中一条记录");
					return;
				}
				
				int rdid = Integer.valueOf(tfrdId.getText());
				int bkid =Integer.valueOf((table.getValueAt(selectedRow,0).toString()));
				Borrow borrow = new Borrow();
				borrow = borrowBll.getBorrowbyBorrowid(borrowBll.retrieveBorrowId(rdid,bkid));
				Calendar a=Calendar.getInstance();
				java.util.Date d=a.getTime();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		        String dateNowStr = sdf.format(d);
		        borrow.setLdDateRetAct(Date.valueOf(dateNowStr));
		        
		        ReaderType readertype = new ReaderType();
		        Format f = new SimpleDateFormat("yyyy-MM-dd"); 
				 String DateRetPlan = f.format(borrow.getLdDateRetPlan());
				 String DateRetAct = f.format(borrow.getLdDateRetAct());
				 int tag =compare_date(DateRetPlan,DateRetAct);
				 if(tag == -1)
				 {
					 int Cov = DateCov(DateRetPlan,DateRetAct);
					 Float PunishMoney=readertype.getPunishRate()*Cov;
					 borrow.setLdOverDay(Cov);
					 borrow.setLdOverMoney(PunishMoney);
					 borrowA.updateBorrow(borrow);
				 }
				 JOptionPane.showMessageDialog(null,"需付金额："+borrow.getLdPunishMoney()+"元！");
		        
		        
				borrowBll.deleteBorrow(borrow);
				Reader reader = new Reader();
				reader=readerBll.getReader(rdid);
				int temp =reader.getRdBorrowQty()-1;
				reader.setRdBorrowQty(temp);
				readerBll.updateReader(reader);
				JOptionPane.showMessageDialog(null,"还书成功");
				Book book = new Book();
				book = bookBll.getBook(bkid);
				book.setBkStatus("在馆");
				bookBll.updateBook(book);
			}
		});
		Retbookbutton.setBounds(447, 677, 93, 23);
		add(Retbookbutton);
		
		JButton CTbutton = new JButton("\u7EED\u501F");
		CTbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(null,"请先选中一条记录");
					return;
				}
				int rdid = Integer.valueOf(tfrdId.getText());
				int bkid =Integer.valueOf((table.getValueAt(selectedRow,0).toString()));
				Borrow borrow = new Borrow();
				Reader reader=readerBll.getReader(rdid);
				ReaderType readertype=new ReaderType();
				readertype=readertypeBll.getReaderTypeByid(reader.getRdType());
				borrow = borrowBll.getBorrowbyBorrowid(borrowBll.retrieveBorrowId(rdid,bkid));
				borrow.setLdContinueTimes(borrow.getLdContinueTimes()+1);
				int a=0;
				a=readertype.getCanContinueTimes();
				if(borrow.getLdContinueTimes()<=a) {
				Format f = new SimpleDateFormat("yyyy-MM-dd"); 
				Calendar c = Calendar.getInstance();
				c.setTime(borrow.getLdDateRetPlan());
				c.add(Calendar.DAY_OF_MONTH,5);
				borrow.setLdDateRetPlan(Date.valueOf(f.format(c.getTime())));
				borrowAdmin.updateBorrow(borrow);
				JOptionPane.showMessageDialog(null,"续借成功");
				}else {
					JOptionPane.showMessageDialog(null,"续借次数超出");
				}
			}
		});
		CTbutton.setBounds(311, 677, 93, 23);
		add(CTbutton);
	}
	private void updateResultTable(Book[] books) {
		if(books==null) {
			JOptionPane.showMessageDialog(null, "数据库中为空");
			return;
		}
		CustomizedTableModel<Book> tableModel=(CustomizedTableModel<Book>) searchbooktable.getModel();
		tableModel.setRecords(books);
		tableModel.fireTableDataChanged();
	}
	private void updateTable(Borrow[] books) {
		if(books==null) {
			JOptionPane.showMessageDialog(null, "数据库中为空");
			return;
		}
		CustomizedTableModel<Borrow> tableModel=(CustomizedTableModel<Borrow>) table.getModel();
		tableModel.setRecords(books);
		tableModel.fireTableDataChanged();
	}
	public static int DateCov(String dateStr1, String dateStr2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
		dateStr1 = sdf.format(sdf2.parse(dateStr1));
		dateStr2 = sdf.format(sdf2.parse(dateStr2));
		} catch (ParseException e) {
		e.printStackTrace();
		}
		int year1 = Integer.parseInt(dateStr1.substring(0, 4));
		int month1 = Integer.parseInt(dateStr1.substring(4, 6));
		int day1 = Integer.parseInt(dateStr1.substring(6, 8));
		int year2 = Integer.parseInt(dateStr2.substring(0, 4));
		int month2 = Integer.parseInt(dateStr2.substring(4, 6));
		int day2 = Integer.parseInt(dateStr2.substring(6, 8));
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, year1);
		c1.set(Calendar.MONTH, month1 - 1);
		c1.set(Calendar.DAY_OF_MONTH, day1);
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, year2);
		c2.set(Calendar.MONTH, month2 - 1);
		c2.set(Calendar.DAY_OF_MONTH, day2);
		long mills =
		c1.getTimeInMillis() > c2.getTimeInMillis()
		? c1.getTimeInMillis() - c2.getTimeInMillis()
		: c2.getTimeInMillis() - c1.getTimeInMillis();
		return (int) (mills / 1000 / 3600 / 24);
		}
public static int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	java.util.Date dt1 =  df.parse(DATE1);
        	java.util.Date dt2 =  df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
		
}
