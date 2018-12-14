package edu.yangtzeu.lmis.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.border.LineBorder;

import edu.yangtzeu.lmis.bll.ReaderAdmin;
import edu.yangtzeu.lmis.gui.commons.CustomizedTableModel;
import edu.yangtzeu.lmis.gui.commons.ImageFilter;
import edu.yangtzeu.lmis.model.Reader;
import edu.yangtzeu.lmis.model.ReaderType;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class ReaderPanel extends JPanel {
	private JTextField tfUserName;
	private JTable searchResultTable;
	private JTextField tfReaderID;
	private JTextField tfReaderName;
	private JTextField passwordField;
	private JTextField tfNumBorrowed;
	private JTextField tfStatus;
	private JTextField tfReaderRole;
	private JTextField tfReaderPhone;
	private JTextField tfEmail;
	private JTextField tfDate;
	private JComboBox cbGender;
	private JComboBox cbReaderType;
	private JComboBox cbDeptType;
	private JComboBox rdTypeComboBox;
	private JComboBox deptTypeComboBox;
	private JButton btnLoadPictureFile;
	private JButton btnQuery;
	private JButton btnUpdateReader;
	private JLabel lblPhoto;
	private JButton btnNewReader;
	private JButton btnLost;
	private JButton btnFound;
	private JButton btnCancelReader;
	private JButton btnClose;
	
	private JPanel searchPanel;
	private JPanel searchResultPanel;
	private JPanel functionCtrlPanel;
	private JPanel readerInfoPanel;
	private JPanel editCtrlPanel;
	private JScrollPane searchResultScrollPane;
	private JButton btnSubmitUpdate;
	private JButton btnAddReader;
	private ReaderAdmin readerBll=new ReaderAdmin();
	private ReaderAdmin readerAdmin=new ReaderAdmin();
	
	//private ReaderTypeAdmin readerTypeBll=new ReaderTypeAdmin();
	//private DepartmentTypeAdmin deptTypeBll=new OepartmentTypeAdmin();
	
	public ReaderPanel() {
		setSize(new Dimension(1180, 784));
		/*initSearchPanel();
		initSearchResultPanel();
		initReaderInfoPanel();
		initFunctionControlsPanel();
		initEditControlsPanel():
			
		setStatus(OpStatus.inSelect);
		addActionListeners();    */
		setLayout(null);
		
		searchPanel = new JPanel();
		searchPanel.setBounds(14, 13, 1092, 56);
		add(searchPanel);
		searchPanel.setLayout(null);
		
		JLabel lableReaderType = new JLabel("\u8BFB\u8005\u7C7B\u522B\uFF1A");
		lableReaderType.setBounds(14, 13, 75, 30);
		searchPanel.add(lableReaderType);
		String a[]= {"教师","本科生","专科生","硕士研究生","博士研究生"};
		rdTypeComboBox = new JComboBox(a);
		rdTypeComboBox.setBounds(88, 13, 135, 30);
		searchPanel.add(rdTypeComboBox);
		
		JLabel lableDept = new JLabel("\u5355\u4F4D\uFF1A");
		lableDept.setBounds(250, 13, 45, 30);
		searchPanel.add(lableDept);
		
		String b[]= {"图书馆","计科院","计科11001班","硕科11001班"};
		deptTypeComboBox = new JComboBox(b);
		deptTypeComboBox.setBounds(296, 13, 160, 30);
		searchPanel.add(deptTypeComboBox);
		
		JLabel lableName = new JLabel("\u59D3\u540D\uFF1A");
		lableName.setBounds(491, 13, 45, 30);
		searchPanel.add(lableName);
		
		tfUserName = new JTextField();
		tfUserName.setBounds(536, 13, 122, 30);
		searchPanel.add(tfUserName);
		tfUserName.setColumns(10);
		
		btnQuery = new JButton("\u67E5\u627E");
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String rdType=(String) rdTypeComboBox.getSelectedItem();
				String deptType=(String) deptTypeComboBox.getSelectedItem();
				String userName=tfUserName.getText().trim();
				Reader[] hits=readerBll.retrieveReaders(rdType,deptType,userName);
				updateResultTable(hits);
			}
		});
		btnQuery.setBounds(693, 13, 92, 30);
		searchPanel.add(btnQuery);
		
		JButton btnToExcel = new JButton("Excel");
		btnToExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnToExcel.setBounds(812, 13, 92, 30);
		searchPanel.add(btnToExcel);
		
		
		
		CustomizedTableModel<Reader> tableModel=new CustomizedTableModel<Reader>(
				readerBll.getDisplayColumnNames(),readerBll.getMethodNames());
		
		searchResultPanel = new JPanel();
		searchResultPanel.setBounds(24, 91, 717, 424);
		searchResultPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u67E5\u8BE2\u7ED3\u679C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(searchResultPanel);
		searchResultPanel.setLayout(null);

		searchResultTable = new JTable(tableModel);
		searchResultTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		searchResultScrollPane=new JScrollPane(searchResultTable);
		searchResultScrollPane.setBounds(0,24,703,387);
		searchResultPanel.add(searchResultScrollPane);

		
		searchResultTable.setBounds(0, 394, 581, -380);
	
		
		readerInfoPanel = new JPanel();
		readerInfoPanel.setBounds(755, 82, 357, 433);
		readerInfoPanel.setBorder(new TitledBorder(null, "\u8BFB\u8005\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		readerInfoPanel.setToolTipText("");
		add(readerInfoPanel);
		readerInfoPanel.setLayout(null);
		readerInfoPanel.setVisible(false);
		
		lblPhoto = new JLabel();
		lblPhoto.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblPhoto.setBounds(212, 13, 131, 226);
		readerInfoPanel.add(lblPhoto);
		
		btnLoadPictureFile = new JButton("\u56FE\u7247\u6587\u4EF6");
		btnLoadPictureFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc=new JFileChooser();
				fc.addChoosableFileFilter(new ImageFilter());
				int returVal=fc.showOpenDialog(ReaderPanel.this);
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
		btnLoadPictureFile.setBounds(234, 243, 93, 25);
		readerInfoPanel.add(btnLoadPictureFile);
		
		JLabel lableBorrowID = new JLabel("\u501F\u4E66\u8BC1\u53F7");
		lableBorrowID.setBounds(14, 13, 60, 25);
		readerInfoPanel.add(lableBorrowID);
		
		tfReaderID = new JTextField();
		tfReaderID.setBounds(88, 13, 110, 25);
		readerInfoPanel.add(tfReaderID);
		tfReaderID.setColumns(10);
		
		JLabel lblName = new JLabel("\u59D3\u540D");
		lblName.setBounds(14, 44, 60, 25);
		readerInfoPanel.add(lblName);
		
		tfReaderName = new JTextField();
		tfReaderName.setBounds(88, 44, 110, 25);
		readerInfoPanel.add(tfReaderName);
		tfReaderName.setColumns(10);
		
		JLabel lblpassword = new JLabel("\u5BC6\u7801");
		lblpassword.setBounds(14, 75, 60, 25);
		readerInfoPanel.add(lblpassword);
		
		passwordField = new JTextField();
		passwordField.setBounds(88, 75, 110, 25);
		readerInfoPanel.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblSex = new JLabel("\u6027\u522B");
		lblSex.setBounds(14, 106, 60, 27);
		readerInfoPanel.add(lblSex);
		
		String s[]= {"男","女"};
		cbGender = new JComboBox(s);
		cbGender.setBounds(88, 106, 110, 25);
		readerInfoPanel.add(cbGender);
		
		JLabel lblNewLabel = new JLabel("\u5DF2\u501F\u4E66");
		lblNewLabel.setBounds(14, 141, 60, 25);
		readerInfoPanel.add(lblNewLabel);
		
		tfNumBorrowed = new JTextField();
		tfNumBorrowed.setBounds(88, 141, 110, 25);
		readerInfoPanel.add(tfNumBorrowed);
		tfNumBorrowed.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BC1\u4EF6\u72B6\u6001");
		lblNewLabel_1.setBounds(14, 174, 60, 25);
		readerInfoPanel.add(lblNewLabel_1);
		
		tfStatus = new JTextField();
		tfStatus.setBounds(88, 174, 110, 25);
		readerInfoPanel.add(tfStatus);
		tfStatus.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BFB\u8005\u89D2\u8272");
		lblNewLabel_2.setBounds(14, 212, 60, 25);
		readerInfoPanel.add(lblNewLabel_2);
		
		tfReaderRole = new JTextField();
		tfReaderRole.setBounds(88, 212, 110, 25);
		readerInfoPanel.add(tfReaderRole);
		tfReaderRole.setColumns(10);
		
		JLabel label = new JLabel("\u8BFB\u8005\u7C7B\u522B");
		label.setBounds(14, 243, 72, 25);
		readerInfoPanel.add(label);
		
		String t[]= {"教师","本科生","专科生","硕士研究生","博士研究生"};
		cbReaderType = new JComboBox(t);
		cbReaderType.setBounds(88, 243, 110, 25);
		readerInfoPanel.add(cbReaderType);
		
		JLabel lblNewLabel_3 = new JLabel("\u5355\u4F4D");
		lblNewLabel_3.setBounds(14, 275, 60, 25);
		readerInfoPanel.add(lblNewLabel_3);
		
		String d[]= {"图书馆","计科院","计科11001班","硕科11001班"};
		cbDeptType = new JComboBox(d);
		cbDeptType.setBounds(88, 275, 178, 25);
		readerInfoPanel.add(cbDeptType);
		
		JLabel label_1 = new JLabel("\u7535\u8BDD\u53F7\u7801");
		label_1.setBounds(14, 313, 60, 25);
		readerInfoPanel.add(label_1);
		
		tfReaderPhone = new JTextField();
		tfReaderPhone.setBounds(88, 313, 178, 25);
		readerInfoPanel.add(tfReaderPhone);
		tfReaderPhone.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7535\u5B50\u90AE\u4EF6");
		label_2.setBounds(14, 351, 72, 25);
		readerInfoPanel.add(label_2);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(88, 351, 178, 25);
		readerInfoPanel.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u529E\u8BC1\u65E5\u671F");
		lblNewLabel_4.setBounds(14, 389, 72, 25);
		readerInfoPanel.add(lblNewLabel_4);
		
		tfDate = new JTextField();
		tfDate.setBounds(88, 389, 178, 25);
		readerInfoPanel.add(tfDate);
		tfDate.setColumns(10);
		
		functionCtrlPanel = new JPanel();
		functionCtrlPanel.setBounds(65, 528, 605, 54);
		add(functionCtrlPanel);
		functionCtrlPanel.setLayout(null);
		
		btnNewReader = new JButton("\u529E\u7406\u501F\u4E66\u8BC1");
		btnNewReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfReaderID.setText("");
				tfReaderName.setText("");
				passwordField.setText("123");
				tfNumBorrowed.setText("0");
				tfStatus.setText("有效");
				tfReaderRole.setText("1");
				tfReaderPhone.setText("");
				tfEmail.setText("");
				Calendar a=Calendar.getInstance();
				java.util.Date d=a.getTime();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		        String dateNowStr = sdf.format(d);
				tfDate.setText(dateNowStr);
				setStatus(OpStatus.inNew);
			}
		});
		btnNewReader.setBounds(34, 13, 107, 27);
		functionCtrlPanel.add(btnNewReader);
		
		btnUpdateReader = new JButton("\u53D8\u66F4\u501F\u4E66\u8BC1");
		btnUpdateReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedRow=searchResultTable.getSelectedRow();
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(null,"请先选中一条记录:");
					return;
				}
				int rdID=Integer.valueOf(searchResultTable.getValueAt(selectedRow, 0).toString());
				setReaderToText(readerAdmin.getReader(rdID));
				setStatus(OpStatus.inChange);
			}
		});
		btnUpdateReader.setBounds(145, 13, 107, 27);
		functionCtrlPanel.add(btnUpdateReader);
		
		btnLost = new JButton("\u6302\u5931");
		btnLost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow=searchResultTable.getSelectedRow();
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(null,"请先选中一条记录:");
					return;
				}
				int rdID=Integer.valueOf(searchResultTable.getValueAt(selectedRow, 0).toString());
				Reader reader=new Reader();
				reader=readerAdmin.getReader(rdID);
				String rdstatus=reader.getRdStatus();
				if(rdstatus.equals("有效"))
				{
					rdstatus="无效";
					reader.setRdStatus(rdstatus);
					readerBll.updateReader(reader);
					String rdType=(String) rdTypeComboBox.getSelectedItem();
					String deptType=(String) deptTypeComboBox.getSelectedItem();
					String userName=tfUserName.getText().trim();
					Reader[] hits=readerBll.retrieveReaders(rdType,deptType,userName);
					updateResultTable(hits);
					JOptionPane.showMessageDialog(null,"挂失成功！");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"证件已为挂失状态！");
				}
			}
		});
		btnLost.setBounds(256, 13, 63, 27);
		functionCtrlPanel.add(btnLost);
		
		btnFound = new JButton("\u89E3\u9664\u6302\u5931");
		btnFound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow=searchResultTable.getSelectedRow();
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(null,"请先选中一条记录:");
					return;
				}
				int rdID=Integer.valueOf(searchResultTable.getValueAt(selectedRow, 0).toString());
				Reader reader=new Reader();
				reader=readerAdmin.getReader(rdID);
				String rdstatus=reader.getRdStatus();
				if(rdstatus.equals("无效"))
				{
					rdstatus="有效";
					reader.setRdStatus(rdstatus);
					readerBll.updateReader(reader);
					String rdType=(String) rdTypeComboBox.getSelectedItem();
					String deptType=(String) deptTypeComboBox.getSelectedItem();
					String userName=tfUserName.getText().trim();
					Reader[] hits=readerBll.retrieveReaders(rdType,deptType,userName);
					updateResultTable(hits);
					JOptionPane.showMessageDialog(null,"解除挂失成功！");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"证件已为有效状态！");
				}
			}
		});
		btnFound.setBounds(322, 13, 107, 27);
		functionCtrlPanel.add(btnFound);
		
		btnCancelReader = new JButton("\u6CE8\u9500");
		btnCancelReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow=searchResultTable.getSelectedRow();
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(null,"请先选中一条记录:");
					return;
				}
				int rdID=Integer.valueOf(searchResultTable.getValueAt(selectedRow, 0).toString());
				Reader reader=new Reader();
				reader=readerAdmin.getReader(rdID);
				readerBll.deleteReader(reader);
				String rdType=(String) rdTypeComboBox.getSelectedItem();
				String deptType=(String) deptTypeComboBox.getSelectedItem();
				String userName=tfUserName.getText().trim();
				Reader[] hits=readerBll.retrieveReaders(rdType,deptType,userName);
				updateResultTable(hits);
				setStatus(OpStatus.inSelect);
				JOptionPane.showMessageDialog(null,"注销成功！");
			}
		});
		btnCancelReader.setBounds(432, 13, 71, 27);
		functionCtrlPanel.add(btnCancelReader);
		
		btnClose = new JButton("\u9000\u51FA");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnClose.setBounds(505, 13, 66, 27);
		functionCtrlPanel.add(btnClose);
		
		editCtrlPanel = new JPanel();
		editCtrlPanel.setBounds(755, 528, 347, 54);
		add(editCtrlPanel);
		editCtrlPanel.setLayout(null);
		
		btnAddReader = new JButton("\u786E\u8BA4\u529E\u8BC1");
		btnAddReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reader reader=new Reader();
				reader=getReaderFromText();
				readerBll.newReader(reader);
				String rdType=(String) rdTypeComboBox.getSelectedItem();
				String deptType=(String) deptTypeComboBox.getSelectedItem();
				String userName=tfUserName.getText().trim();
				Reader[] hits=readerBll.retrieveReaders(rdType,deptType,userName);
				updateResultTable(hits);
				setStatus(OpStatus.inSelect);
				JOptionPane.showMessageDialog(null,"办理证完成！");
			}
		});
		btnAddReader.setBounds(25, 14, 99, 27);
		editCtrlPanel.add(btnAddReader);
		
		btnSubmitUpdate = new JButton("\u786E\u5B9A\u53D8\u66F4");
		btnSubmitUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reader reader=new Reader();
				reader=getReaderFromText();
				readerBll.updateReader(reader);
				String rdType=(String) rdTypeComboBox.getSelectedItem();
				String deptType=(String) deptTypeComboBox.getSelectedItem();
				String userName=tfUserName.getText().trim();
				Reader[] hits=readerBll.retrieveReaders(rdType,deptType,userName);
				updateResultTable(hits);
				setStatus(OpStatus.inSelect);
				JOptionPane.showMessageDialog(null,"修改成功！");
			}
		});
		btnSubmitUpdate.setBounds(138, 14, 99, 27);
		editCtrlPanel.add(btnSubmitUpdate);
		
		JButton btnCancelEdit = new JButton("\u53D6\u6D88");
		btnCancelEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setStatus(OpStatus.inSelect);
			}
		});
		btnCancelEdit.setBounds(251, 14, 70, 27);
		editCtrlPanel.add(btnCancelEdit);
	}
	
	/*private void initSearchPanel() {
		// TODO Auto-generated method stub
		rdTypeComboBox=new JComboBox<ReaderType>(
				readerTypeBll.getReaderTypes());
		rdTypeComboBox.setBounds(71,5,130,23);
		searchPanel.add(rdTypeComboBox);
		
		deptTypeComboBox=new JComboBox<DepartmentType>(
				deptTypeBll.getDepartmentTypes());
		deptTypeComboBox.setBounds(246,5,143,23);
		searchPanel.add(deptTypeComboBox);
	}*/

	private enum OpStatus{
		inSelect,inNew,inChange
		//,inCancel
//		,inLost
	}
	private OpStatus ops;
	

	
	private void setStatus(OpStatus opst) {
		ops=opst;
		switch(ops) {
		case inSelect:
			searchPanel.setEnabled(true);
			searchResultPanel.setEnabled(true);
			functionCtrlPanel.setEnabled(true);
			
			setComponentStatusInPanel(functionCtrlPanel,true);
			readerInfoPanel.setEnabled(false);
			readerInfoPanel.setVisible(false);
			editCtrlPanel.setEnabled(false);
			editCtrlPanel.setVisible(false);
			setComponentStatusInPanel(editCtrlPanel,false);
			break;
		case inNew:
			searchPanel.setEnabled(false);
			searchResultPanel.setEnabled(false);
			functionCtrlPanel.setEnabled(false);
			setComponentStatusInPanel(functionCtrlPanel,false);
			readerInfoPanel.setEnabled(true);
			readerInfoPanel.setVisible(true);
			setComponentStatusInPanel(readerInfoPanel,true);
			editCtrlPanel.setVisible(true);
			editCtrlPanel.setEnabled(true);
			setComponentStatusInPanel(editCtrlPanel,true);
			btnSubmitUpdate.setEnabled(false);
			break;
		case inChange:
			searchPanel.setEnabled(false);
			searchResultPanel.setEnabled(false);
			functionCtrlPanel.setEnabled(false);
			setComponentStatusInPanel(functionCtrlPanel,false);
			readerInfoPanel.setEnabled(true);
			readerInfoPanel.setVisible(true);
			setComponentStatusInPanel(readerInfoPanel,true);
			editCtrlPanel.setEnabled(true);
			editCtrlPanel.setVisible(true);
			setComponentStatusInPanel(editCtrlPanel,true);
			btnAddReader.setEnabled(false);
			break;
//		case inCancel:
//			searchPanel.setEnabled(false);
//			searchResultPanel.setEnabled(false);
//			functionCtrlPanel.setEnabled(true);
//			setComponentStatusInPanel(functionCtrlPanel,true);
//			readerInfoPanel.setEnabled(false);
//			readerInfoPanel.setVisible(true);
//			setComponentStatusInPanel(readerInfoPanel,false);
//			editCtrlPanel.setVisible(true);
//			editCtrlPanel.setEnabled(false);
//			setComponentStatusInPanel(editCtrlPanel,false);
//			//btnSubmitUpdate.setEnabled(false);
//			break;
//		case inLost:
//			searchPanel.setEnabled(false);
//			searchResultPanel.setEnabled(false);
//			functionCtrlPanel.setEnabled(false);
//			setComponentStatusInPanel(functionCtrlPanel,false);
//			readerInfoPanel.setEnabled(true);
//			readerInfoPanel.setVisible(true);
//			editCtrlPanel.setEnabled(true);
//			editCtrlPanel.setVisible(true);
//			setComponentStatusInPanel(editCtrlPanel,true);
//			btnAddReader.setEnabled(false);
//			tfReaderID.setEnabled(false);
//			tfReaderName.setEditable(false);
//			passwordField.setEnabled(false);
//			cbGender.setEnabled(false);
//			tfNumBorrowed.setEnabled(false);
//			tfReaderRole.setEnabled(false);
//			cbReaderType.setEnabled(false);
//			cbDeptType.setEnabled(false);
//			tfReaderPhone.setEnabled(false);
//			tfEmail.setEnabled(false);
//			tfDate.setEnabled(false);
//			break;
		}
	}
	private void setComponentStatusInPanel(JPanel panel,boolean status) {
		for(Component comp:panel.getComponents()) {
			comp.setEnabled(status);
		}
	}
	
	private void updateResultTable(Reader[] readers) {
		if(readers==null) {
			JOptionPane.showMessageDialog(null, "没有找到符合要求的记录：");
			return;
		}
		CustomizedTableModel<Reader> tableModel=(CustomizedTableModel<Reader>) searchResultTable.getModel();
		tableModel.setRecords(readers);
		tableModel.fireTableDataChanged();
	}
	
	    private void setReaderToText(Reader reader) {
		tfReaderID.setText(String.valueOf(reader.getRdID()));
		tfReaderName.setText(reader.getRdName());
		passwordField.setText(reader.getRdPwd());
		tfNumBorrowed.setText(String.valueOf(reader.getRdBorrowQty()));
		tfStatus.setText(reader.getRdStatus());
		tfReaderRole.setText(String.valueOf(reader.getRdAdminRoles()));
		tfReaderPhone.setText(reader.getRdPhone());
		tfEmail.setText(reader.getRdEmail());
		tfDate.setText(reader.getRdDateReg().toString());
		cbGender.setSelectedItem(reader.getRdSex());
		cbReaderType.setSelectedItem(reader.getRdType());
		cbDeptType.setSelectedItem(reader.getRdDept());
		
		if(reader.getRdPhoto()!=null) {
			ByteArrayInputStream bais = new ByteArrayInputStream(reader.getRdPhoto());
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
	    

	    
        private Reader getReaderFromText() {
		Reader reader=new Reader();
		reader.setRdID(Integer.valueOf(tfReaderID.getText()));
		reader.setRdName(tfReaderName.getText().trim());
		reader.setRdPwd(String.valueOf(passwordField.getText()));
		reader.setRdSex(cbGender.getSelectedItem().toString());
		reader.setRdBorrowQty(Integer.valueOf(tfNumBorrowed.getText().trim()));
		reader.setRdStatus(String.valueOf(tfStatus.getText()));
		reader.setRdAdminRoles(Integer.valueOf(tfReaderRole.getText()));
		reader.setRdType(readerBll.getrdtypename(((String)cbReaderType.getSelectedItem())));
		reader.setRdDept(((String)cbDeptType.getSelectedItem()));
		reader.setRdPhone(tfReaderPhone.getText().trim());
		reader.setRdEmail(tfEmail.getText().trim());
		reader.setRdDateReg(Date.valueOf(tfDate.getText().trim()));
		/*DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String str=null;
		str=tfDate.getText();
		try {
			reader.setRdDateReg(format.parse(str));
		}catch(ParseException e) {
			e.printStackTrace();
		}*/
		
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
				reader.setRdPhoto(InputStreamToByte(fis));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return reader;
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
        
}
