package edu.yangtzeu.lmis.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import edu.yangtzeu.lmis.bll.ReaderTypeAdmin;
import edu.yangtzeu.lmis.gui.commons.CustomizedTableModel;
import edu.yangtzeu.lmis.model.Reader;
import edu.yangtzeu.lmis.model.ReaderType;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReaderTypePanel extends JPanel {
	private JTextField tftypeName;
	private JTextField tfcancontinueTimes;
	private JTextField tfcanlendQty;
	private JTextField tfpunishRate;
	private JTextField tfdateValid;
	private JTextField tfcanlendDay;
	
	private JPanel readerInfoPanel;
	private JPanel searchResultPanel;
	private JTable searchResultTable;
	private JScrollPane searchResultscrollPane;
	private JPanel functionCtrlPanel;
	
	
	private ReaderTypeAdmin readerTypeBll=new ReaderTypeAdmin();
	private ReaderTypeAdmin readerTypeAdmin = new ReaderTypeAdmin();
	
	public ReaderTypePanel() {
		setLayout(null);
		
		readerInfoPanel = new JPanel();
		readerInfoPanel.setBounds(116, 0, 886, 100);
		add(readerInfoPanel);
		readerInfoPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7C7B\u578B\u540D\u79F0:");
		lblNewLabel.setBounds(45, 13, 72, 25);
		readerInfoPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u53EF\u7EED\u501F\u6B21\u6570:");
		lblNewLabel_1.setBounds(45, 69, 83, 25);
		readerInfoPanel.add(lblNewLabel_1);
		
		tftypeName = new JTextField();
		tftypeName.setBounds(169, 13, 107, 24);
		readerInfoPanel.add(tftypeName);
		tftypeName.setColumns(10);
		
		tfcancontinueTimes = new JTextField();
		tfcancontinueTimes.setBounds(169, 69, 107, 24);
		readerInfoPanel.add(tfcancontinueTimes);
		tfcancontinueTimes.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u53EF\u501F\u6570\u91CF\uFF1A");
		lblNewLabel_2.setBounds(297, 13, 83, 25);
		readerInfoPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u7F5A\u91D1\u7387\uFF1A");
		lblNewLabel_3.setBounds(297, 69, 72, 25);
		readerInfoPanel.add(lblNewLabel_3);
		
		tfcanlendQty = new JTextField();
		tfcanlendQty.setBounds(394, 13, 107, 24);
		readerInfoPanel.add(tfcanlendQty);
		tfcanlendQty.setColumns(10);
		
		tfpunishRate = new JTextField();
		tfpunishRate.setBounds(394, 69, 107, 24);
		readerInfoPanel.add(tfpunishRate);
		tfpunishRate.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u53EF\u501F\u5929\u6570\uFF1A");
		lblNewLabel_4.setBounds(566, 13, 83, 25);
		readerInfoPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u8BC1\u4EF6\u6709\u6548\u671F\uFF1A");
		lblNewLabel_5.setBounds(559, 69, 90, 25);
		readerInfoPanel.add(lblNewLabel_5);
		
		tfdateValid = new JTextField();
		tfdateValid.setBounds(676, 69, 107, 24);
		readerInfoPanel.add(tfdateValid);
		tfdateValid.setColumns(10);
		
		tfcanlendDay = new JTextField();
		tfcanlendDay.setBounds(676, 13, 107, 24);
		readerInfoPanel.add(tfcanlendDay);
		tfcanlendDay.setColumns(10);
		
		CustomizedTableModel<ReaderType> tableModel=new CustomizedTableModel<ReaderType>(
				readerTypeBll.getDisplayColumnNames(),readerTypeBll.getMethodNames());
		
		
		searchResultPanel = new JPanel();
		searchResultPanel.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u7ED3\u679C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		searchResultPanel.setBounds(116, 113, 886, 369);
		add(searchResultPanel);
		searchResultPanel.setLayout(null);
		
		searchResultTable = new JTable(tableModel);
		searchResultTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectedRow=searchResultTable.getSelectedRow();
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(null,"请先选中一条记录:");
					return;
				}
				int rdID=Integer.valueOf(searchResultTable.getValueAt(selectedRow, 0).toString());
				setReaderTypeToText(readerTypeAdmin.getReaderTypeByid(rdID));
			}
		});
		searchResultTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
		ReaderType[] hits=readerTypeBll.retrieveReaderType();
		updateResultTable(hits);
		
		searchResultscrollPane = new JScrollPane(searchResultTable);
		searchResultscrollPane.setBounds(0, 23, 886, 345);
		searchResultPanel.add(searchResultscrollPane);
		
		functionCtrlPanel = new JPanel();
		functionCtrlPanel.setBounds(116, 495, 886, 50);
		add(functionCtrlPanel);
		functionCtrlPanel.setLayout(null);
		
		JButton btnadd = new JButton("\u6DFB\u52A0");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnadd.setBounds(145, 13, 113, 27);
		functionCtrlPanel.add(btnadd);
		btnadd.setEnabled(false);
		
		JButton btnupdate = new JButton("\u4FEE\u6539");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				}
		});
		btnupdate.setBounds(272, 13, 113, 27);
		functionCtrlPanel.add(btnupdate);
		btnupdate.setEnabled(false);
		
		JButton btndelete = new JButton("\u5220\u9664");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btndelete.setBounds(399, 13, 113, 27);
		functionCtrlPanel.add(btndelete);
		btndelete.setEnabled(false);
		
		JButton btncancle = new JButton("\u53D6\u6D88");
		btncancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btncancle.setBounds(526, 13, 113, 27);
		functionCtrlPanel.add(btncancle);
		
		JButton btnclose = new JButton("\u8FD4\u56DE");
		btnclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnclose.setBounds(653, 13, 113, 27);
		functionCtrlPanel.add(btnclose);
		btnclose.setEnabled(false);
	}
	private void updateResultTable(ReaderType[] readertypes) {
		if(readertypes==null) {
			JOptionPane.showMessageDialog(null, "数据库中为空");
			return;
		}
		CustomizedTableModel<ReaderType> tableModel=(CustomizedTableModel<ReaderType>) searchResultTable.getModel();
		tableModel.setRecords(readertypes);
		tableModel.fireTableDataChanged();
	}
	private ReaderType getReaderTypeFromText() {
		//String rdtype = tfrdTypeName.getText().trim();
		ReaderTypePanel readertypepanel = new ReaderTypePanel();
		//readertypepanel.rdid++;
		ReaderType readertype=new ReaderType();
		//readertype.setRdType(tftype);
		readertype.setRdTypeName(tftypeName.getText().trim());
		readertype.setCanLendQty(Integer.valueOf(tfcanlendQty.getText()));
		readertype.setCanLendDay(Integer.valueOf(tfcanlendDay.getText()));
		readertype.setCanContinueTimes(Integer.valueOf(tfcancontinueTimes.getText()));
		readertype.setPunishRate(Float.valueOf(tfpunishRate.getText()));
		readertype.setDateValid(Integer.valueOf(tfdateValid.getText()));
		return readertype;
	}
	private ReaderType UpdategetReaderTypeFromText() {
		String rdtype = tftypeName.getText().trim();
		ReaderType readertype=new ReaderType();
		//readertype.setRdType(readerBll.retrieveRdType(rdtype));
		readertype.setRdTypeName(tftypeName.getText().trim());
		readertype.setCanLendQty(Integer.valueOf(tfcanlendQty.getText()));
		readertype.setCanLendDay(Integer.valueOf(tfcanlendDay.getText()));
		readertype.setCanContinueTimes(Integer.valueOf(tfcancontinueTimes.getText()));
		readertype.setPunishRate(Float.valueOf(tfpunishRate.getText()));
		readertype.setDateValid(Integer.valueOf(tfdateValid.getText()));
		return readertype;
	}
	private void setReaderTypeToText(ReaderType readertype) {
		tftypeName.setText(readertype.getRdTypeName());
		tfcanlendQty.setText(String.valueOf(readertype.getCanLendQty()));
		tfcanlendDay.setText(String.valueOf(readertype.getCanLendDay()));
		tfcancontinueTimes.setText(String.valueOf(readertype.getCanContinueTimes()));
		tfpunishRate.setText(String.valueOf(readertype.getPunishRate()));
		tfdateValid.setText(String.valueOf(readertype.getDateValid()));
		
	}
}
