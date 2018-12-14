package edu.yangtzeu.lmis.gui;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {
	private final String blankPanelName="Blank";
	private final String readerPanelName="Reader";
	private final String readerTypePanelName="ReaderType";
	private final String bookPanelName="Book";
	private final String borrowPanelName="Borrow";
	private final String userPanelName="User";
	private final String searchBookPanelName="SearchBook";
	
	private JPanel cards;
	private ReaderPanel readerPanel;
	private ReaderTypePanel readerTypePanel;
	private BookPanel bookPanel;
	private BorrowPanel borrowPanel;
	private UserPanel userPanel;
	private SearchBookPanel searchBookPanel;
	private JMenuItem MI_NewBook;
	
	
	private JMenu MN_ReaderMgt;
	private JMenu MN_BookMgt;
	private JMenu MN_BorrowMgt;
	
	
	public Main() {
		
		
		setSize(new Dimension(1180, 784));
		setTitle("\u957F\u6C5F\u5927\u5B66\u56FE\u4E66\u9986\u7BA1\u7406\u4FE1\u606F\u7CFB\u7EDF");
		//initComponents();
		//initMenu();
		
		initCardPanels();
		initMenu();
	}
	private void initMenu() {
		MN_ReaderMgt.setEnabled(Login.reader.isReaderAdmin());
		MN_BookMgt.setEnabled(Login.reader.isBookAdmin());
		MN_BorrowMgt.setEnabled(Login.reader.isBorrowAdmin());
	}
	
	private void initCardPanels() {
	    JPanel blankPanel=new JPanel();
	    

		
		readerPanel=new ReaderPanel();
		readerPanel.setVisible(false);
		
		readerTypePanel=new ReaderTypePanel();
		readerTypePanel.setVisible(false);
		
		bookPanel=new BookPanel();
		bookPanel.setVisible(false);
		
		borrowPanel=new BorrowPanel();
		borrowPanel.setVisible(false);
		
		userPanel =new UserPanel();
		userPanel.setVisible(false);
		
		searchBookPanel =new SearchBookPanel();
		searchBookPanel.setVisible(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setBounds(0, 0, 1230, 26);
		
		MN_ReaderMgt = new JMenu("\u8BFB\u8005\u7BA1\u7406");
		menuBar.add(MN_ReaderMgt);
		
		JMenuItem MI_NewReader = new JMenuItem("\u8BFB\u8005\u4FE1\u606F\u7BA1\u7406");
		MI_NewReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c1=(CardLayout)(cards.getLayout());
				c1.show(cards,readerPanelName);
			}
		});
		MN_ReaderMgt.add(MI_NewReader);
		
		JMenuItem MI_ReaderTypeMgt = new JMenuItem("\u8BFB\u8005\u7C7B\u578B\u7BA1\u7406");
		MI_ReaderTypeMgt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1=(CardLayout)(cards.getLayout());
				c1.show(cards,readerTypePanelName);
			}
		});
		MN_ReaderMgt.add(MI_ReaderTypeMgt);
		
		MN_BookMgt = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menuBar.add(MN_BookMgt);
		
		MI_NewBook = new JMenuItem("\u56FE\u4E66\u67E5\u8BE2");
		MI_NewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1=(CardLayout)(cards.getLayout());
				c1.show(cards,searchBookPanelName);
			}
		});
		
		MN_BookMgt.add(MI_NewBook);
		
		MN_BorrowMgt = new JMenu("\u501F\u9605\u7BA1\u7406");
		menuBar.add(MN_BorrowMgt);
		
		JMenuItem MI_Borrow = new JMenuItem("\u501F\u9605\u56FE\u4E66");
		MI_Borrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1=(CardLayout)(cards.getLayout());
				c1.show(cards,borrowPanelName);
			}
		});
		MN_BorrowMgt.add(MI_Borrow);
		cards=new JPanel(new CardLayout());
		cards.add(blankPanel,blankPanelName);
		cards.add(readerPanel,readerPanelName);
		cards.add(readerTypePanel,readerTypePanelName);
		
		
		
		//cards.add(bookPanel,bookPanelName);
		cards.add(borrowPanel,borrowPanelName);
		cards.add(userPanel,userPanelName);
		cards.add(searchBookPanel,searchBookPanelName);
		
		getContentPane().add(cards);
	}

/*	private void loadBookGUI() {
		// TODO Auto-generated method stub
		this.dispose();
		BookPanel BookGUI =new BookPanel();
		BookGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BookGUI.setLocationRelativeTo(null);
		BookGUI.setVisible(true);
	}*/
}
