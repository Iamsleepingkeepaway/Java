package edu.yangtzeu.lmis.gui;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import edu.yangtzeu.lmis.bll.BookAdmin;
import edu.yangtzeu.lmis.gui.commons.CustomizedTableModel;
import edu.yangtzeu.lmis.model.Book;
import edu.yangtzeu.lmis.model.Reader;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchBookPanel extends JPanel {
	private JTextField tfText;
	private JPanel searchResultpanel;
	private JScrollPane searchscrollPane;
	private JPanel Simplesearchpanel;
	private JPanel Advancedsearchoanel;
	private JTable searchResultTable;
	private Book book;
	private BookAdmin bookBll=new BookAdmin();
	private JPanel editpanel;
	private JButton btnNewBook;
	private JButton btnChangeBook;
	private JButton btnDeleteBook;
	private JButton btnReturn;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField tfbkName;
	private JTextField tfbkPress;
	private JLabel lblNewLabel_3;
	private JLabel label;
	private JTextField tfbkAuthor;
	private JTextField tfbkCatalog;
	private JLabel label_1;
	private JLabel lblNewLabel_4;
	private JTextField tfbkBrief;
	private JTextField tfbkDatePress;
	private JButton btnselected;
	private JButton btnsearch;
	private JComboBox cbsearch;
	

	
	public SearchBookPanel() {
		setSize(new Dimension(1172, 662));
		setLayout(null);
		
		JTabbedPane SearchPanel = new JTabbedPane(JTabbedPane.TOP);
		SearchPanel.setBounds(0, 0, 1172, 165);
		add(SearchPanel);
		
		Simplesearchpanel = new JPanel();
		SearchPanel.addTab("\u7B80\u5355\u67E5\u8BE2", null, Simplesearchpanel, null);
		Simplesearchpanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u68C0\u7D22\u5B57\u6BB5\uFF1A");
		lblNewLabel.setBounds(14, 49, 85, 18);
		Simplesearchpanel.add(lblNewLabel);
		
		String a[]= {"书名","作者","出版社"};
		cbsearch = new JComboBox(a);
		cbsearch.setBounds(113, 46, 161, 24);
		Simplesearchpanel.add(cbsearch);
		
		tfText = new JTextField();
		tfText.setBounds(321, 46, 451, 24);
		Simplesearchpanel.add(tfText);
		tfText.setColumns(10);
		
		btnsearch = new JButton("\u67E5\u8BE2");
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cb=(String) cbsearch.getSelectedItem();
				String text=(String) tfText.getText().trim();
				Book[] hits=bookBll.simpleSelectedBooks(cb,text);
				updateResultTable(hits);
				
			}
		});
		btnsearch.setBounds(847, 45, 113, 27);
		Simplesearchpanel.add(btnsearch);
		
		Advancedsearchoanel = new JPanel();
		SearchPanel.addTab("\u9AD8\u7EA7\u67E5\u8BE2", null, Advancedsearchoanel, null);
		Advancedsearchoanel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel_1.setBounds(14, 23, 84, 18);
		Advancedsearchoanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\u51FA\u7248\u793E\u540D\uFF1A");
		lblNewLabel_2.setBounds(14, 71, 84, 18);
		Advancedsearchoanel.add(lblNewLabel_2);
		
		tfbkName = new JTextField();
		tfbkName.setBounds(112, 20, 183, 24);
		Advancedsearchoanel.add(tfbkName);
		tfbkName.setColumns(10);
		
		tfbkPress = new JTextField();
		tfbkPress.setBounds(112, 68, 183, 24);
		Advancedsearchoanel.add(tfbkPress);
		tfbkPress.setColumns(10);
		
		lblNewLabel_3 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		lblNewLabel_3.setBounds(309, 23, 84, 18);
		Advancedsearchoanel.add(lblNewLabel_3);
		
		label = new JLabel("\u5206\u7C7B\u53F7\uFF1A");
		label.setBounds(309, 71, 84, 18);
		Advancedsearchoanel.add(label);
		
		tfbkAuthor = new JTextField();
		tfbkAuthor.setBounds(407, 20, 180, 24);
		Advancedsearchoanel.add(tfbkAuthor);
		tfbkAuthor.setColumns(10);
		
		tfbkCatalog = new JTextField();
		tfbkCatalog.setBounds(407, 68, 180, 24);
		Advancedsearchoanel.add(tfbkCatalog);
		tfbkCatalog.setColumns(10);
		
		label_1 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		label_1.setBounds(624, 23, 84, 18);
		Advancedsearchoanel.add(label_1);
		
		lblNewLabel_4 = new JLabel("\u51FA\u7248\u65E5\u671F\uFF1A");
		lblNewLabel_4.setBounds(624, 71, 84, 18);
		Advancedsearchoanel.add(lblNewLabel_4);
		
		tfbkBrief = new JTextField();
		tfbkBrief.setBounds(740, 20, 180, 24);
		Advancedsearchoanel.add(tfbkBrief);
		tfbkBrief.setColumns(10);
		
		tfbkDatePress = new JTextField();
		tfbkDatePress.setBounds(740, 68, 180, 24);
		Advancedsearchoanel.add(tfbkDatePress);
		tfbkDatePress.setColumns(10);
		
		btnselected = new JButton("\u67E5\u8BE2");
		btnselected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bkName=tfbkName.getText().trim();
				String bkPress=tfbkPress.getText().trim();
				String bkAuthor=tfbkAuthor.getText().trim();
				String bkCatalog=tfbkCatalog.getText().trim();
				String bkBrief=tfbkBrief.getText().trim();
				String bkDatePress=tfbkPress.getText().trim();
				Book[] hits=bookBll.advencedselectedBooks(bkName,bkPress,bkAuthor,bkCatalog,bkBrief,bkDatePress);
				updateResultTable(hits);
			}
		});
		btnselected.setBounds(988, 42, 113, 27);
		Advancedsearchoanel.add(btnselected);
		
		CustomizedTableModel<Book> tableModel=new CustomizedTableModel<Book>(
				bookBll.getDisplayColumnNames(),bookBll.getMethodNames());
		
		searchResultTable = new JTable(tableModel);
		searchResultTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		searchResultTable.setBounds(0, 0, 1172, 328);
		
		searchResultpanel = new JPanel();
		searchResultpanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u67E5\u8BE2\u7ED3\u679C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		searchResultpanel.setBounds(0, 167, 1172, 339);
		add(searchResultpanel);
		searchResultpanel.setLayout(null);
		
		searchscrollPane = new JScrollPane(searchResultTable);
		searchscrollPane.setBounds(0, 23, 1172, 303);
		searchResultpanel.add(searchscrollPane);
		
		editpanel = new JPanel();
		editpanel.setBounds(0, 519, 1172, 62);
		add(editpanel);
		editpanel.setLayout(null);
		
		btnNewBook = new JButton("\u65B0\u4E66\u5165\u5E93");
		btnNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadBookGUI2();
			}
		});
		btnNewBook.setBounds(290, 22, 113, 27);
		editpanel.add(btnNewBook);
		
		btnChangeBook = new JButton("\u56FE\u4E66\u4FE1\u606F\u7EF4\u62A4");
		btnChangeBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookPanel bookPanel=new BookPanel();
				int selectedRow=searchResultTable.getSelectedRow();
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(null,"请先选中一条记录:");
					return;
				}
				int bkID=Integer.valueOf(searchResultTable.getValueAt(selectedRow, 0).toString());
				book=bookBll.getBook(bkID);
				
				loadBookGUI();
			}
		});
		btnChangeBook.setBounds(417, 22, 123, 27);
		editpanel.add(btnChangeBook);
		
		btnDeleteBook = new JButton("\u5220\u9664");
		btnDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedRow=searchResultTable.getSelectedRow();
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(null,"请先选中一条记录:");
					return;
				}
				int bkID=Integer.valueOf(searchResultTable.getValueAt(selectedRow, 0).toString());
				Book book=new Book();
				book=bookBll.getBook(bkID);
				bookBll.deleteBook(book);
				JOptionPane.showMessageDialog(null,"删除成功！");
			}
		});
		btnDeleteBook.setBounds(554, 22, 113, 27);
		editpanel.add(btnDeleteBook);
		
		btnReturn = new JButton("\u8FD4\u56DE");
		btnReturn.setBounds(681, 22, 113, 27);
		editpanel.add(btnReturn);
	}

	private void updateResultTable(Book[] books) {
		if(books==null) {
			JOptionPane.showMessageDialog(null, "没有找到符合要求的记录：");
			return;
		}
		CustomizedTableModel<Book> tableModel=(CustomizedTableModel<Book>) searchResultTable.getModel();
		tableModel.setRecords(books);
		tableModel.fireTableDataChanged();
	}
	private void loadBookGUI() {
		// TODO Auto-generated method stub
		//this.dispose();
		
		BookPanel BookGUI =new BookPanel();
		BookGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BookGUI.setLocationRelativeTo(null);
		BookGUI.setVisible(true);
		BookGUI.setBookToText(book);
	}
	private void loadBookGUI2() {
		// TODO Auto-generated method stub
		//this.dispose();
		
		BookPanel BookGUI =new BookPanel();
		BookGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BookGUI.setLocationRelativeTo(null);
		BookGUI.setVisible(true);
	}
}
