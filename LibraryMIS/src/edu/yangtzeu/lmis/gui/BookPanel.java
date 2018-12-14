package edu.yangtzeu.lmis.gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import edu.yangtzeu.lmis.bll.BookAdmin;
import edu.yangtzeu.lmis.gui.commons.ImageFilter;
import edu.yangtzeu.lmis.model.Book;
import edu.yangtzeu.lmis.model.Reader;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class BookPanel extends JFrame {
	private JTextField tfbkID;
	private JTextField tfbkCode;
	private JTextField tfbkName;
	private JTextField tfbkAuthor;
	private JTextField tfbkPress;
	private JTextField tfbkDatePress;
	private JTextField tfISBN;
	private JTextField tfbkCatalog;
	private JTextField tfbkPages;
	private JTextField tfbkPrice;
	private JTextField tfbkDateIn;
	private JTextField tfbkNumber;
	private JTextPane tfbkBrief;
	private JButton btnadd;
	private JComboBox cbbkLanuage;
	private JComboBox cbbkCataName;
	private JLabel lblPhoto;
	private JButton btnchange;
	private JButton btnLoadPictureFile;
	
	private BookAdmin bookBll=new BookAdmin();
	
	public BookPanel() {
		setSize(new Dimension(1172, 662));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u8D77\u59CB\u5E8F\u53F7\uFF1A");
		lblNewLabel.setBounds(14, 13, 119, 18);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7D22\u4E66\u53F7\uFF1A");
		lblNewLabel_1.setBounds(14, 44, 72, 18);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		label.setBounds(14, 75, 85, 18);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		label_1.setBounds(14, 106, 85, 18);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u51FA\u7248\u793E\uFF1A");
		label_2.setBounds(14, 137, 72, 18);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u51FA\u7248\u65E5\u671F\uFF1A");
		label_3.setBounds(14, 168, 85, 18);
		getContentPane().add(label_3);
		
		JLabel lblIsbn = new JLabel("ISBN\uFF1A");
		lblIsbn.setBounds(14, 199, 72, 18);
		getContentPane().add(lblIsbn);
		
		JLabel label_4 = new JLabel("\u5206\u7C7B\u540D\uFF1A");
		label_4.setBounds(14, 230, 72, 18);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u5206\u7C7B\u53F7\uFF1A");
		label_5.setBounds(14, 261, 72, 18);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u8BED\u79CD\uFF1A");
		label_6.setBounds(14, 292, 72, 18);
		getContentPane().add(label_6);
		
		JLabel label_8 = new JLabel("\u56FE\u4E66\u9875\u6570\uFF1A");
		label_8.setBounds(14, 323, 85, 18);
		getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("\u56FE\u4E66\u4EF7\u683C\uFF1A");
		label_9.setBounds(14, 354, 85, 18);
		getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("\u5165\u9986\u65E5\u671F\uFF1A");
		label_10.setBounds(14, 385, 85, 18);
		getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("\u56FE\u4E66\u672C\u6570\uFF1A");
		label_11.setBounds(14, 416, 85, 18);
		getContentPane().add(label_11);
		
		int n=0;
		n=bookBll.getMax();
		String m=String.valueOf(n);
		tfbkID = new JTextField(m);
		tfbkID.setBounds(122, 10, 139, 24);
		getContentPane().add(tfbkID);
		tfbkID.setColumns(10);
		tfbkID.setEnabled(false);
		
		tfbkCode = new JTextField();
		tfbkCode.setBounds(100, 41, 202, 24);
		getContentPane().add(tfbkCode);
		tfbkCode.setColumns(10);
		
		tfbkName = new JTextField();
		tfbkName.setBounds(100, 72, 202, 24);
		getContentPane().add(tfbkName);
		tfbkName.setColumns(10);
		
		tfbkAuthor = new JTextField();
		tfbkAuthor.setText("");
		tfbkAuthor.setBounds(100, 103, 202, 24);
		getContentPane().add(tfbkAuthor);
		tfbkAuthor.setColumns(10);
		
		tfbkPress = new JTextField();
		tfbkPress.setBounds(100, 134, 202, 24);
		getContentPane().add(tfbkPress);
		tfbkPress.setColumns(10);
		
		tfbkDatePress = new JTextField();
		tfbkDatePress.setBounds(100, 165, 202, 24);
		getContentPane().add(tfbkDatePress);
		tfbkDatePress.setColumns(10);
		
		tfISBN = new JTextField();
		tfISBN.setBounds(100, 196, 202, 24);
		getContentPane().add(tfISBN);
		tfISBN.setColumns(10);
		
		String b[]= {"自动化技术、计算机技术","计算技术、计算机技术","计算机软件","程序设计、软件工程","程序语言、算法语言","数据库理论与系统","数据库理论"};
		cbbkCataName = new JComboBox(b);
		cbbkCataName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbbkCataName.getSelectedItem().equals("自动化技术、计算机技术"))
					tfbkCatalog.setText("TP");
				if(cbbkCataName.getSelectedItem().equals("计算技术、计算机技术"))
					tfbkCatalog.setText("TP3");
				if(cbbkCataName.getSelectedItem().equals("计算机软件"))
					tfbkCatalog.setText("TP31");
				if(cbbkCataName.getSelectedItem().equals("程序设计、软件工程"))
					tfbkCatalog.setText("TP311");
				if(cbbkCataName.getSelectedItem().equals("程序语言、算法语言"))
					tfbkCatalog.setText("TP312");
				if(cbbkCataName.getSelectedItem().equals("数据库理论与系统"))
					tfbkCatalog.setText("TP311.13");
				if(cbbkCataName.getSelectedItem().equals("数据库理论"))
					tfbkCatalog.setText("TP311.131");
			}
		});
		cbbkCataName.setBounds(100, 227, 202, 24);
		getContentPane().add(cbbkCataName);
		
		tfbkCatalog = new JTextField();
		tfbkCatalog.setBounds(100, 258, 202, 24);
		getContentPane().add(tfbkCatalog);
		tfbkCatalog.setColumns(10);
		
		String a[]= {"中文","英文","日文","俄文","德文","法文"};
		cbbkLanuage = new JComboBox(a);
		cbbkLanuage.setBounds(100, 289, 202, 24);
		getContentPane().add(cbbkLanuage);
		
		tfbkPages = new JTextField();
		tfbkPages.setBounds(100, 320, 202, 24);
		getContentPane().add(tfbkPages);
		tfbkPages.setColumns(10);
		
		tfbkPrice = new JTextField();
		tfbkPrice.setBounds(100, 351, 202, 24);
		getContentPane().add(tfbkPrice);
		tfbkPrice.setColumns(10);
		
		tfbkDateIn = new JTextField();
		tfbkDateIn.setBounds(100, 382, 202, 24);
		getContentPane().add(tfbkDateIn);
		tfbkDateIn.setColumns(10);
		
		tfbkNumber = new JTextField();
		tfbkNumber.setBounds(100, 413, 202, 24);
		getContentPane().add(tfbkNumber);
		tfbkNumber.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5185\u5BB9\u7B80\u4ECB\uFF1A");
		lblNewLabel_2.setBounds(339, 13, 85, 18);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5C01\u9762\uFF1A");
		lblNewLabel_3.setBounds(796, 13, 72, 18);
		getContentPane().add(lblNewLabel_3);
		
		lblPhoto = new JLabel("");
		lblPhoto.setBounds(796, 44, 321, 359);
		getContentPane().add(lblPhoto);
		
		btnLoadPictureFile = new JButton("\u6DFB\u52A0\u56FE\u7247");
		btnLoadPictureFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc=new JFileChooser();
				fc.addChoosableFileFilter(new ImageFilter());
				int returVal=fc.showOpenDialog(BookPanel.this);
				if(returVal==JFileChooser.APPROVE_OPTION) {
					File file=fc.getSelectedFile();
					try {
						BufferedImage img=ImageIO.read(file);
						Image dimg=img.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon icon=new ImageIcon(dimg);
						lblPhoto.setIcon(icon);
					}catch(IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnLoadPictureFile.setBounds(912, 421, 113, 27);
		getContentPane().add(btnLoadPictureFile);
		
		btnadd = new JButton("\u6DFB\u52A0");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Book book=new Book();
				book=getBookFromText();
				bookBll.newBook(book);
				JOptionPane.showMessageDialog(null,"添加成功！");
			}
		});
		btnadd.setBounds(380, 461, 78, 27);
		getContentPane().add(btnadd);
		
		JButton btncancle = new JButton("\u53D6\u6D88");
		btncancle.setBounds(564, 461, 78, 27);
		getContentPane().add(btncancle);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadMainGUI();
			}
		});
		
		btnNewButton.setBounds(656, 461, 78, 27);
		getContentPane().add(btnNewButton);
		
		btnchange = new JButton("\u4FEE\u6539");
		btnchange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book book=new Book();
				book=getBookFromText();
				bookBll.updateBook(book);
				JOptionPane.showMessageDialog(null,"修改成功！");
			}
		});
		btnchange.setBounds(472, 461, 78, 27);
		getContentPane().add(btnchange);
		
		tfbkBrief = new JTextPane();
		tfbkBrief.setBounds(349, 44, 428, 393);
		getContentPane().add(tfbkBrief);
	}
	void setBookToText(Book book) {
		tfbkID.setText(String.valueOf(book.getBkID()));
		tfbkCode.setText(book.getBkCode());
		tfbkName.setText(book.getBkName());
		tfbkAuthor.setText(String.valueOf(book.getBkAuthor()));
		tfbkPress.setText(book.getBkPress());
		tfbkDatePress.setText(book.getBkDatePress().toString());
		tfISBN.setText(book.getBkISBN());
		tfbkCatalog.setText(book.getBkCatalog());
		String b="";
		if(book.getBkCatalog().equals("TP"))
			b="自动化技术、计算机技术";
		if(book.getBkCatalog().equals("TP3"))
			b="计算技术、计算机技术";
		if(book.getBkCatalog().equals("TP31"))
			b="计算机软件";
		if(book.getBkCatalog().equals("TP311"))
			b="程序设计、软件工程";
		if(book.getBkCatalog().equals("TP312"))
			b="程序语言、算法语言";
		if(book.getBkCatalog().equals("TP311.13"))
			b="数据库理论与系统";
		if(book.getBkCatalog().equals("TP311.131"))
			b="数据库理论";
		cbbkCataName.setSelectedItem(b);
		String a="";
		if(book.getBkLanuage()==0) {
			a="中文";
		}
		if(book.getBkLanuage()==1) {
			a="英文";
		}
		if(book.getBkLanuage()==2) {
			a="日文";
		}
		if(book.getBkLanuage()==3) {
			a="俄文";
		}
		if(book.getBkLanuage()==4) {
			a="德文";
		}
		if(book.getBkLanuage()==5) {
			a="法文";
		}
		cbbkLanuage.setSelectedItem(a);
		tfbkPages.setText(String.valueOf(book.getBkPages()));
		tfbkPrice.setText(String.valueOf(book.getBkPrice()));
		tfbkDateIn.setText(book.getBkDateIn().toString());
		tfbkBrief.setText(book.getBkBrief());
		
		if(book.getBkCover()!=null) {
			ByteArrayInputStream bais = new ByteArrayInputStream(book.getBkCover());
			BufferedImage bImage = null;
			try {
				bImage = ImageIO.read(bais);
			}catch (IOException e) {
				e.printStackTrace();
			}
			Image image = (Image)bImage;
			lblPhoto.setIcon(new ImageIcon(image));
		}else {
			lblPhoto.setIcon(null);
		}
	}
	
	private Book getBookFromText() {
		Book book=new Book();
		//book.setBkID(Integer.valueOf(tfbkID.getText()));
		book.setBkCode(tfbkCode.getText().trim());
		book.setBkName(tfbkName.getText().trim());
		book.setBkAuthor(tfbkAuthor.getText().trim());
		book.setBkPress(tfbkPress.getText().trim());
		book.setBkDatePress(Date.valueOf(tfbkDatePress.getText().trim()));
		book.setBkISBN(tfISBN.getText().trim());
		book.setBkCatalog(tfbkCatalog.getText().trim());
		int a=0;
		if(String.valueOf(cbbkLanuage.getSelectedItem()).equals("中文"))
			a=0;
		if(String.valueOf(cbbkLanuage.getSelectedItem()).equals("英文"))
			a=1;
		if(String.valueOf(cbbkLanuage.getSelectedItem()).equals("日文"))
			a=2;
		if(String.valueOf(cbbkLanuage.getSelectedItem()).equals("俄文"))
			a=3;
		if(String.valueOf(cbbkLanuage.getSelectedItem()).equals("德文"))
			a=4;
		if(String.valueOf(cbbkLanuage.getSelectedItem()).equals("法文"))
			a=5;
		book.setBkLanuage(a);
		book.setBkPages(Integer.valueOf(tfbkPages.getText()));
		book.setBkPrice(Integer.valueOf(tfbkPrice.getText()));
		book.setBkDateIn(Date.valueOf(tfbkDateIn.getText()));
		book.setBkBrief(tfbkBrief.getText());
		book.setBkStatus("有效");
		if(lblPhoto.getIcon()!=null) {
			Image image=((ImageIcon)lblPhoto.getIcon()).getImage();
			BufferedImage bi=new BufferedImage(image.getWidth(null),
					image.getHeight(null),BufferedImage.TYPE_4BYTE_ABGR);
			Graphics2D g2=bi.createGraphics();
			g2.drawImage(image, 0, 0, null);
			g2.dispose();
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			try {
				ImageIO.write(bi, "jpg", os);
			}catch(IOException e) {
				e.printStackTrace();
			}
			InputStream fis=new ByteArrayInputStream(os.toByteArray());
			try {
				book.setBkCover(InputStreamToByte(fis));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return book;
	}
	public static byte[] InputStreamToByte(InputStream in)throws IOException{
		   ByteArrayOutputStream outStream=new ByteArrayOutputStream();
		   byte[] data=new byte[4096];
		   int count=-1;
		   while((count=in.read(data,0,4096))!=-1) {
			   outStream.write(data,0,4096);
		   }
		   data=null;
		   return outStream.toByteArray();
	   }
	private void loadMainGUI() {
		// TODO Auto-generated method stub
		this.dispose();
		Main mainGUI =new Main();
		mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainGUI.setLocationRelativeTo(null);
		mainGUI.setVisible(true);
	}
}
