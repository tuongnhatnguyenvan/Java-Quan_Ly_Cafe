package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

import DAO.AccountDAO;
import Utilities.DBUtility;

public class CaiDatView extends JPanel {
	
	
	// Ảnh nền
	private JLabel menuIcon_Label;
	
	
	// Panel bên trái
	private JPanel chuaButton_Panel;
	private JButton thonTin_Button, doiMK_Button ;
	
	
	// Panel bên phải
	private JPanel chuaChucNang_Panel;
	
	
	// Panel chứa thông tin
	private JPanel thongTin_Panel;
	private JLabel thongTin_Label, javaIcon_Label;
	
	
	// Panel đổi mật khẩu
	private JPanel  doiMK_Panel;
	private JPasswordField nhapMK_PasswordField, nhapMKMoi_PasswordField;
	private JButton chapNhan_Button;
	private JLabel nguoiDung_Label, hienThiNguoiDung_Label, nhapMKCu_Label, nhapMKMoi_Label, eyeIcon_Label;


	private ImageIcon icon;


	private ResultSet ResultSet;
	
	
	// contructer
	public CaiDatView() {
		this.init();

	}
	
	
	// hàm giao diện
	private void init() {
		this.setBackground(new Color(206, 103, 0));
		this.setBounds(10, 89, 1066, 503);
		this.setLayout(null);
		
		
		// PANEL 1 : CHỨA BUTTON
		
		// Panel chứa button
		chuaButton_Panel = new JPanel();
		chuaButton_Panel.setLayout(null);
		chuaButton_Panel.setBackground(SystemColor.menu);
		chuaButton_Panel.setBounds(10, 10, 282, 483);
		this.add(chuaButton_Panel);
		
		
		// Button thông tin
		thonTin_Button = new JButton("Thông tin");
		thonTin_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\info.png"));
		thonTin_Button.setForeground(Color.RED);
		thonTin_Button.setFont(new Font("Arial", Font.BOLD, 20));
		thonTin_Button.setBounds(36, 48, 194, 47);
		chuaButton_Panel.add(thonTin_Button);
		thonTin_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first();
			}
		});
		
		
		// Button đổi mật khẩu
		doiMK_Button = new JButton("Đổi mật khẩu");
		doiMK_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\exchange.png"));
		doiMK_Button.setForeground(Color.RED);
		doiMK_Button.setFont(new Font("Arial", Font.BOLD, 20));
		doiMK_Button.setBounds(37, 120, 193, 43);
		chuaButton_Panel.add(doiMK_Button);
		doiMK_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last();
			}
		});
		
		
		//HẾT PANEL 1
		
		
		// PANEL 2 : CHỨA CHỨC NĂNG
		
		//Panel chứa chức năng
		chuaChucNang_Panel = new JPanel();
		chuaChucNang_Panel.setBounds(293, 10, 763, 483);
		this.add(chuaChucNang_Panel);
		chuaChucNang_Panel.setLayout(new CardLayout(0, 0));
		
		
		//PANEL 2_1 : CHỨA THÔNG TIN
		
		//Panel chứa thông tin
		thongTin_Panel = new JPanel();
		chuaChucNang_Panel.add(thongTin_Panel, "name_155600606972400");
		thongTin_Panel.setLayout(null);
		
		
		//Label chứa thông tin
		thongTin_Label = new JLabel("COFFEE SHOP MANAGERMENT JAVA PROGRAM\r\n");
		thongTin_Label.setForeground(new Color(255, 0, 0));
		thongTin_Label.setHorizontalAlignment(SwingConstants.CENTER);
		thongTin_Label.setFont(new Font("Arial", Font.BOLD, 25));
		thongTin_Label.setBounds(84, 41, 602, 89);
		thongTin_Panel.add(thongTin_Label);
		
		
		//Label chứa icon
		javaIcon_Label = new JLabel();
		javaIcon_Label.setHorizontalAlignment(SwingConstants.CENTER);
		javaIcon_Label.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\java-logo (1).png"));
		javaIcon_Label.setBounds(398, 158, 324, 293);
		thongTin_Panel.add(javaIcon_Label);
		
		
		// HẾT PANEL 2_1
		
		
		// PHANEL 2_2 : CHỨA CHỨC NĂNG ĐỔI MẬT KHẨU
		
		// Panel chức năng đổi mật khẩu
		doiMK_Panel = new JPanel();
		chuaChucNang_Panel.add(doiMK_Panel, "name_155647224749800");
		doiMK_Panel.setLayout(null);
		
		
		//Label người dùng
		nguoiDung_Label = new JLabel("Người dùng ");
		nguoiDung_Label.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\Manager-icon.png"));
		nguoiDung_Label.setForeground(new Color(255, 0, 0));
		nguoiDung_Label.setHorizontalAlignment(SwingConstants.CENTER);
		nguoiDung_Label.setFont(new Font("Arial", Font.BOLD, 15));
		nguoiDung_Label.setBounds(121, 94, 129, 26);
		doiMK_Panel.add(nguoiDung_Label);
		
		
		//Label hiển thị người dùng
		hienThiNguoiDung_Label = new JLabel("");
		hienThiNguoiDung_Label.setHorizontalAlignment(SwingConstants.CENTER);
		hienThiNguoiDung_Label.setForeground(Color.RED);
		hienThiNguoiDung_Label.setFont(new Font("Arial", Font.BOLD, 15));
		hienThiNguoiDung_Label.setBounds(339, 94, 188, 26);
		doiMK_Panel.add(hienThiNguoiDung_Label);
		
		
		//Label nhập mật khẩu cũ
		nhapMKCu_Label = new JLabel("Nhập mật khẩu cũ");
		nhapMKCu_Label.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\key.png"));
		nhapMKCu_Label.setHorizontalAlignment(SwingConstants.LEFT);
		nhapMKCu_Label.setForeground(Color.RED);
		nhapMKCu_Label.setFont(new Font("Arial", Font.BOLD, 15));
		nhapMKCu_Label.setBounds(118, 154, 161, 26);
		doiMK_Panel.add(nhapMKCu_Label);
		
		
		//Label nhập mật khẩu mới
		nhapMKMoi_Label = new JLabel("Nhập mật khẩu mới");
		nhapMKMoi_Label.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\key.png"));
		nhapMKMoi_Label.setHorizontalAlignment(SwingConstants.LEFT);
		nhapMKMoi_Label.setForeground(Color.RED);
		nhapMKMoi_Label.setFont(new Font("Arial", Font.BOLD, 15));
		nhapMKMoi_Label.setBounds(118, 214, 171, 26);
		doiMK_Panel.add(nhapMKMoi_Label);
		
		
		//PasswordField để nhập mật khẩu cũ
		nhapMK_PasswordField = new JPasswordField();
		nhapMK_PasswordField.setFont(new Font("Arial", Font.BOLD, 15));
		nhapMK_PasswordField.setBounds(341, 154, 188, 26);
		doiMK_Panel.add(nhapMK_PasswordField);
		
		
		//PasswordField để nhập mật khẩu mới
		nhapMKMoi_PasswordField = new JPasswordField();
		nhapMKMoi_PasswordField.setFont(new Font("Arial", Font.BOLD, 15));
		nhapMKMoi_PasswordField.setBounds(341, 214, 188, 26);
		doiMK_Panel.add(nhapMKMoi_PasswordField);
		
		
		//Button chấp nhận
		chapNhan_Button = new JButton("Chấp nhận");
		chapNhan_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiMatKhau();
			
			}

			
		});
		chapNhan_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\check-mark.png"));
		chapNhan_Button.setForeground(new Color(255, 0, 0));
		chapNhan_Button.setFont(new Font("Arial", Font.BOLD, 20));
		chapNhan_Button.setBounds(264, 343, 171, 37);
		doiMK_Panel.add(chapNhan_Button);
		
		
		// Label icon hiện mật khẩu
		eyeIcon_Label = new JLabel("");
		eyeIcon_Label.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\invisible.png"));
		eyeIcon_Label.setBounds(573, 183, 30, 26);
		doiMK_Panel.add(eyeIcon_Label);
		
		
		// CheckBox để hiện mật khẩu
		JCheckBox eyeIcon_CheckBox = new JCheckBox("");
		eyeIcon_CheckBox.setBounds(609, 169, 42, 53);
		doiMK_Panel.add(eyeIcon_CheckBox);
		eyeIcon_CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (eyeIcon_CheckBox.isSelected()) {
					eyeIcon_Label.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\eye.png"));
					nhapMK_PasswordField.setEchoChar((char) 0);
					nhapMKMoi_PasswordField.setEchoChar((char) 0);
					
				} else {
					eyeIcon_Label.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\invisible.png"));
					nhapMK_PasswordField.setEchoChar('*');
					nhapMKMoi_PasswordField.setEchoChar('*');
					
				}
			}
		});
		
		
		// ảnh nền
		menuIcon_Label = new JLabel("");
		menuIcon_Label.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\menu.jpg"));
		menuIcon_Label.setHorizontalAlignment(SwingConstants.CENTER);
		menuIcon_Label.setBounds(0, 0, 1066, 503);
		add(menuIcon_Label);
		
	}
	
	
	// hàm chuyển đổi panel
	private void first() {
		CardLayout card = (CardLayout) chuaChucNang_Panel.getLayout();
		card.first(chuaChucNang_Panel);
	}
	
	private void last() {
		CardLayout card = (CardLayout) chuaChucNang_Panel.getLayout();
		card.last(chuaChucNang_Panel);
	}


	public JLabel getHienThiNguoiDung_Label() {
		return hienThiNguoiDung_Label;
	}


	public void setHienThiNguoiDung_Label(String NguoiDung_Label) {
		this.hienThiNguoiDung_Label.setText(NguoiDung_Label);
	}

	public void doiMatKhau() {
		 // TODO add your handling code here:
        if (nhapMK_PasswordField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa nhập mật khẩu cũ!");
            return;
        }
        if (nhapMKMoi_PasswordField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa nhập mật khẩu mới!");
            return;
        }
        if (!nhapMK_PasswordField.getText().equals(AccountDAO.getInstance().GetAccount().getPassword())) {
            JOptionPane.showMessageDialog(null, "Mật khẩu cũ chưa chính xác!");
            nhapMK_PasswordField.setText("");
            return;
        }
        
        if (AccountDAO.getInstance().DoiMatKhau(AccountDAO.getInstance().GetAccount().getId(), nhapMKMoi_PasswordField.getText())) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!!");
            nhapMK_PasswordField.setText("");
            nhapMKMoi_PasswordField.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Lỗi!!");
        }
        
       
	}
		
	}

