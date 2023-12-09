package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.AccountDAO;
import Utilities.DBUtility;
import thu.ThoiGian;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.CardLayout;

public class DangNhapView extends JFrame {

	// PHẦN PANEL CẢ 2
	private JPanel contentPane ,menuDangNhap;

 
	
	// PHẦN MENU ĐANG NHẬP
	private JButton thoat_Button , dangNhap_Button;
	private JLabel dangNhap_Label,tenTKDN_Label, MKDN_Label, hienThiMKDN_Label, mainDN_Label, time_Label;
	private JTextField tenTKDN_TextField;
	private JPasswordField MKDN_PasswordField;
	private JCheckBox hienThiMKDN_CheckBox;

	
	
	// contructer
	public DangNhapView() throws HeadlessException {
		this.setTitle("Đăng nhập");
		this.init();
		this.time();
	}
	
	
	
	// Giao diện
	private void init() {
		this.setUndecorated(true);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\coffee.png"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 501, 304);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(new Color(214, 196, 165));
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(214, 196, 165));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// ADD PANEL ĐĂNG NHẬP
		menuDangNhap = new JPanel();
		menuDangNhap.setBounds(5, 5, 491, 294);
		menuDangNhap.setLayout(null);
		contentPane.add(menuDangNhap);
		
		
		
		
		// NÚT THOÁT KHỎI GIAO DIỆN ĐĂNG NHẬP
		thoat_Button = new JButton();
		thoat_Button.setFont(new Font("Arial Black", Font.BOLD, 15));
		thoat_Button.setText("Thoát");
		thoat_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\power (1).png"));
		thoat_Button.setBounds(362, 10, 119, 41);
		menuDangNhap.add(thoat_Button);
		thoat_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hoi = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát khỏi chương trình không!", null,
						JOptionPane.YES_NO_OPTION);
				if (hoi == JOptionPane.YES_OPTION) {
					System.exit(0);

				}
			}
		});
		
		
		// TẠO TIÊU ĐỀ
		dangNhap_Label = new JLabel("Đăng nhập");
		dangNhap_Label.setFont(new Font("Arial", Font.BOLD, 20));
		dangNhap_Label.setBounds(182, 11, 102, 24);
		menuDangNhap.add(dangNhap_Label);
		
		
		
		// DÒNG LABEL TÊN ĐĂNG NHẬP
		tenTKDN_Label = new JLabel("Tên tài khoản ");
		tenTKDN_Label.setBackground(new Color(255, 255, 255));
        tenTKDN_Label.setForeground(new Color(255, 0, 0));
        tenTKDN_Label.setFont(new Font("Arial", Font.BOLD, 15));
		tenTKDN_Label.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\Manager-icon.png"));
		tenTKDN_Label.setBounds(10, 83, 133, 24);
		menuDangNhap.add(tenTKDN_Label);
				
		
		
		// VÙNG TEXT FIELD HIỂN THỊ TÊN NGƯỜI DÙNG
		tenTKDN_TextField = new JTextField();
		tenTKDN_TextField.setFont(new Font("Arial", Font.BOLD, 12));
		tenTKDN_TextField.setBounds(153, 84, 154, 24);
		tenTKDN_TextField.setColumns(10);
		menuDangNhap.add(tenTKDN_TextField);
		
		
		
		// DÒNG LABEL MẬT KHẨU 
		MKDN_Label = new JLabel("Mật khẩu");
		MKDN_Label.setFont(new Font("Arial", Font.BOLD, 15));
		MKDN_Label.setForeground(new Color(255, 0, 0));
		MKDN_Label.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\key.png"));
		MKDN_Label.setBounds(10, 123, 96, 24);
		menuDangNhap.add(MKDN_Label);
		
		
		// VÙNG NHẬP MẬT KHẨU
		MKDN_PasswordField = new JPasswordField();
		MKDN_PasswordField.setFont(new Font("Arial", Font.BOLD, 12));
		MKDN_PasswordField.setBounds(153, 124, 154, 24);
		menuDangNhap.add(MKDN_PasswordField);
		
		
		// ICON ĐÔI MẮT HIỂN THỊ MẬT KHẨU
		hienThiMKDN_Label = new JLabel();
		hienThiMKDN_Label.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\invisible.png"));
		hienThiMKDN_Label.setBounds(334, 123, 24, 24);
		menuDangNhap.add(hienThiMKDN_Label);
		
		
		// TẠO CHECKBOX HIỂN THỊ MẬT KHẨU KHI ĐĂNG NHẬP
		hienThiMKDN_CheckBox = new JCheckBox("");
		hienThiMKDN_CheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		hienThiMKDN_CheckBox.setFont(new Font("Arial", Font.BOLD, 15));
		hienThiMKDN_CheckBox.setForeground(new Color(255, 0, 0));
		hienThiMKDN_CheckBox.setBounds(362, 123, 21, 24);
		menuDangNhap.add(hienThiMKDN_CheckBox);
		hienThiMKDN_CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hienThiMKDN_CheckBox.isSelected()) {
					hienThiMKDN_Label.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\eye.png"));
					MKDN_PasswordField.setEchoChar((char) 0);
				} else {
					hienThiMKDN_Label.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\invisible.png"));
					MKDN_PasswordField.setEchoChar('*');
				}
			}
		});
		
		
		// BUTTON ĐĂNG NHẬP
		dangNhap_Button = new JButton("Đăng Nhập");
		dangNhap_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\login.png"));
		dangNhap_Button.setForeground(new Color(255, 0, 0));
		dangNhap_Button.setFont(new Font("Arial", Font.BOLD, 15));
		dangNhap_Button.setBounds(153, 194, 154, 41);
		menuDangNhap.add(dangNhap_Button);
		dangNhap_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dangNhap();
			}	
		});

		
		
		
		 //Thời gian
		time_Label = new JLabel("dd/mm/yyyy        hh : mm : ss AM");
		time_Label.setHorizontalAlignment(SwingConstants.LEFT);
		time_Label.setForeground(new Color(0, 0, 0));
		time_Label.setFont(new Font("Arial", Font.BOLD, 12));
		time_Label.setBounds(10, 254, 246, 30);
		menuDangNhap.add(time_Label);

		
		
		// TẠO ẢNH NỀN 
		mainDN_Label = new JLabel();
		mainDN_Label.setHorizontalAlignment(SwingConstants.CENTER);
		mainDN_Label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		mainDN_Label.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\dgdangnhap.jpg"));
		mainDN_Label.setBounds(0, 0, 491, 294);
		menuDangNhap.add(mainDN_Label);
		
		this.setVisible(false);
	}
	
	
	// thời gian
	private void time() {
		new ThoiGian(time_Label).start();
	
	}



	public JTextField getTenTKDN_TextField() {
		return tenTKDN_TextField;
	}



	public void setTenTKDN_TextField(JTextField tenTKDN_TextField) {
    	this.tenTKDN_TextField = tenTKDN_TextField;
	}



	public JPasswordField getMKDN_PasswordField() {
		return MKDN_PasswordField;
	}



	public void setMKDN_PasswordField(JPasswordField mKDN_PasswordField) {
		MKDN_PasswordField = mKDN_PasswordField;
	}



	

	
	public void dangNhap() {
		 if (tenTKDN_TextField.getText().isEmpty()) {
			 JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên tài khoản!");
	            return;
	        }
	        if (MKDN_PasswordField.getText().isEmpty()) {
	        	JOptionPane.showMessageDialog(null, "Bạn chưa nhập mật khẩu!");
	        	   return;
	        }

	        if (!AccountDAO.getInstance().Login(tenTKDN_TextField.getText(), MKDN_PasswordField.getText())) {
	        	JOptionPane.showMessageDialog(null,"Sai tên đăng nhập hoặc mật khẩu!");
	            return;
	        }
	        MenuView menu = new MenuView();
	        menu.setVisible(true);
	        menu.setThanhVien_Label(AccountDAO.getInstance().GetAccount().getName());
	        menu.hienThiNguoiDung(AccountDAO.getInstance().GetAccount().getName());
	        truyCap(menu);
	        this.dispose();
	
	}
	
	     public void truyCap(MenuView menu) {
	    	 if(AccountDAO.getInstance().GetAccount().getName().equals("admin")||AccountDAO.getInstance().GetAccount().getName().equals("Admin")) {
		    	 menu.getQuanLy_Button().setEnabled(true);
		    	 menu.getThongKe_Button().setEnabled(true);
		      }else {
		    	  menu.getQuanLy_Button().setEnabled(false);
			    	 menu.getThongKe_Button().setEnabled(false);
		      }
	     }
	
	   
}
