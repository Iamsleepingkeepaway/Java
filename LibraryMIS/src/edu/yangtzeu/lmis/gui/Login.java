package edu.yangtzeu.lmis.gui;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.yangtzeu.lmis.bll.ReaderAdmin;
import edu.yangtzeu.lmis.model.Reader;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {
	private JTextField tfUserName;
	
	private int loginTimes=0;//登录次数
	private ReaderAdmin readerBLL=new ReaderAdmin();
	public static Reader reader=null;
	private JPasswordField pwdField;
	
	private JLabel labelLoginInfo;
	private JButton btnLogin;
	private JButton btnClose;

	public Login() {
		setSize(new Dimension(393, 290));
		setResizable(false);
		setTitle("\u957F\u6C5F\u5927\u5B66\u56FE\u4E66\u9986\u7BA1\u7406\u4FE1\u606F\u7CFB\u7EDF");
		getContentPane().setLayout(null);
		
		JLabel labelUserName = new JLabel("\u7528\u6237\u7F16\u53F7\uFF1A");
		labelUserName.setBounds(86, 61, 75, 25);
		getContentPane().add(labelUserName);
		
		JLabel labelPassword = new JLabel("\u7528\u6237\u5BC6\u7801\uFF1A");
		labelPassword.setBounds(86, 112, 75, 25);
		getContentPane().add(labelPassword);
		
		tfUserName = new JTextField();
		tfUserName.setBounds(197, 61, 105, 24);
		getContentPane().add(tfUserName);
		tfUserName.setColumns(10);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(197, 112, 105, 25);
		getContentPane().add(pwdField);
		
		JButton btnLogin = new JButton("\u767B\u5F55");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				++loginTimes;
				String errorMsg="";
				int rdId=-1;
				try {
					rdId=Integer.valueOf(tfUserName.getText().trim());
					}catch(NumberFormatException e) {
						errorMsg ="用户名无效";
						tfUserName.requestFocus();
					}
				if(rdId!=-1) {
					reader=readerBLL.getReader(rdId);
					if(reader==null) {
						errorMsg="用户名无效";
						tfUserName.requestFocus();
					}else if(reader.getRdPwd().equals(
							new String(pwdField.getPassword()).trim())){
						loadMainGUI();
					}else {
						errorMsg="密码错误或不能为空";
						pwdField.requestFocus();
					}
				}
				if(errorMsg.length()>0)
					labelLoginInfo.setText(errorMsg);
			}
		});
		btnLogin.setBounds(86, 161, 75, 27);
		getContentPane().add(btnLogin);
		
		JButton btnClose = new JButton("\u9000\u51FA");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnClose.setBounds(227, 161, 75, 27);
		getContentPane().add(btnClose);
		
		labelLoginInfo = new JLabel("");
		labelLoginInfo.setForeground(new Color(255, 0, 0));
		labelLoginInfo.setBounds(183, 139, 149, 18);
		getContentPane().add(labelLoginInfo);
		setLocationRelativeTo(null);
	}
	private void loadMainGUI() {
		// TODO Auto-generated method stub
		this.dispose();
		Main mainGUI =new Main();
		mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainGUI.setLocationRelativeTo(null);
		mainGUI.setVisible(true);
	}
	public static void main(String[] args) {
		Login login = new Login();
		login.start();
	}
	public void start() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
