package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JTextField;

import DAO.TablesDAO;
import DTO.Tables;
import Utilities.DBUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DAO.AccountDAO;
import DAO.DrinksDAO;
import DTO.Account;
import DTO.Drinks;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLyView extends JPanel {
	
	// table bàn
	DefaultTableModel tableModel1;
    int idSave1 = -1;
	
    // table tài khoản
    DefaultTableModel tableModel2;
    int idSave2 = -1;
    
    // table món
    DefaultTableModel tableModel;
    int idSave = -1;
    
    
	//Phần chung
	private JPanel chuaChucNang_Panel;
	private JPanel chuaButon_Panel;
	private JLabel menu_Label;
	
	//Phần 4 button điều khiển
	private JButton qLThucDon_Button , qLBan_Button , qLTaiKhoan_Button;
	
	// Phần panel quản lí thực đơn
	private JPanel qLThucDon_Panel;
	private JScrollPane qLTD_ScrollPane;
	private JTable qLTD_Table ;
	private JLabel qLTD_Label;
	private JButton themThucDon_Button, suaThucDon_Button, xoaThucDon_Button;
	
	// Phần panel quản lí bàn
	private JPanel qLban_Panel;
	private JScrollPane qLBan_ScrollPane;
	private JTable qLBan_Table ;
	private JLabel qLBan_Label;
	private JButton themBan_Button, suaBan_Button, xoaBan_Button;
	
	// Phần panel quản lí tài khoản
	private JPanel qLTaiKhoan_Panel;
	private JScrollPane qLTK_ScrollPane;
	private JTable qLTK_Table;
	private JLabel qLTK_Label;
	private JButton suaTK_Button, xoaTK_Button;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_2;
	private JTextField textField_3;
	private JButton themBan_Button_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_6;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	
	
	// contructer
	public QuanLyView() {
		this.init();
	}
	
	
    // hàm giao diện
	private void init() {
		this.setBackground(new Color(255, 255, 255));
		this.setBounds(10, 89, 1066, 503);
		this.setLayout(null);
		
		// Set font
		Font font = new Font("Arial", Font.BOLD, 15);
		
		// PHANEL BÊN TRÁI
		
		// Panel chứa 4 button điều khiển
		chuaButon_Panel = new JPanel();
		chuaButon_Panel.setBounds(10, 10, 221, 483);
		this.add(chuaButon_Panel);
		chuaButon_Panel.setLayout(null);
		
		
		// Button Quản lí thực đơn
		qLThucDon_Button = new JButton("Quản lý thực đơn\r\n");
		qLThucDon_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\poinsettia.png"));
		qLThucDon_Button.setHorizontalAlignment(SwingConstants.LEFT);
		qLThucDon_Button.setForeground(new Color(255, 0, 0));
		qLThucDon_Button.setFont(font);
		qLThucDon_Button.setBackground(new Color(255, 255, 255));
		qLThucDon_Button.setBounds(5, 121, 211, 47);
		chuaButon_Panel.add(qLThucDon_Button);
		qLThucDon_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firts();
				tableModel = new DefaultTableModel();
		        tableModel.addColumn("STT");
		        tableModel.addColumn("Tên đồ uống");
		        tableModel.addColumn("Giá");
		        qLTD_Table.setModel(tableModel);
		        displayTable();
			}
		});
		
		
		// Button Quản lí bàn
		qLBan_Button = new JButton("Quản lý bàn");
		qLBan_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\round-table (1).png"));
		qLBan_Button.setHorizontalAlignment(SwingConstants.LEFT);
		qLBan_Button.setForeground(Color.RED);
		qLBan_Button.setFont(font);
		qLBan_Button.setBackground(Color.WHITE);
		qLBan_Button.setBounds(5, 197, 211, 47);
		chuaButon_Panel.add(qLBan_Button);
		qLBan_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last();  previous();
				tableModel1 = new DefaultTableModel();
				tableModel1.addColumn("STT");
				tableModel1.addColumn("Số bàn");
				tableModel1.addColumn("Trạng thái");
				tableModel1.addColumn("Ghi chú");
		        qLBan_Table.setModel(tableModel1);
		        displayTableBan();
			}
		});
		
		
		// Button quản lí tài khoản
		qLTaiKhoan_Button = new JButton("Quản lý tài khoản");
		qLTaiKhoan_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\megaphone.png"));
		qLTaiKhoan_Button.setHorizontalAlignment(SwingConstants.LEFT);
		qLTaiKhoan_Button.setForeground(Color.RED);
		qLTaiKhoan_Button.setFont(font);
		qLTaiKhoan_Button.setBackground(Color.WHITE);
		qLTaiKhoan_Button.setBounds(5, 270, 211, 47);
		chuaButon_Panel.add(qLTaiKhoan_Button);
		qLTaiKhoan_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last();
				tableModel2 = new DefaultTableModel();
		        tableModel2.addColumn("STT");
		        tableModel2.addColumn("Tên");
		        tableModel2.addColumn("Tài khoản");
		        qLTD_Table.setModel(tableModel2);
		        hienThiThongTinTaiKhoan();
			}
		});
		
		// HẾT PANEL BÊN TRÁI
		
		
		
		// PANEL BÊN PHẢI
		
		
		// Panel chứa các bảng chức năng
		chuaChucNang_Panel = new JPanel();
		chuaChucNang_Panel.setBounds(234, 10, 822, 483);
		this.add(chuaChucNang_Panel);
		chuaChucNang_Panel.setLayout(new CardLayout(0, 0));
		
		
		// PANEL 1 : QUẢN LÍ THỰC ĐƠN
		
		// Panel quản lí thực đơn
		qLThucDon_Panel = new JPanel();
		chuaChucNang_Panel.add(qLThucDon_Panel, "name_169455841573700");
		qLThucDon_Panel.setLayout(null);
				
		
		// Table quản lí thực đơn
		qLTD_Table = new JTable();
		qLTD_Table.setEnabled(true);
		
		qLTD_Table.setForeground(new Color(0, 0, 0));
		qLTD_Table.setBackground(new Color(255, 255, 255));
		qLTD_Table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"M\u00E3 m\u00F3n", "T\u00EAn m\u00F3n", "Giá tiền"
						
			}
		));
		qLTD_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            hienThiMonClick(evt);
            }
        });
		qLTD_Table.getColumnModel().getColumn(0).setPreferredWidth(59);
		qLTD_Table.getColumnModel().getColumn(1).setPreferredWidth(139);
		qLTD_Table.setFont(new Font("Arial", Font.BOLD, 10));
		
		
		// ScrollPane của table quản lí thực đơn
		qLTD_ScrollPane = new JScrollPane(qLTD_Table);
		qLTD_ScrollPane.setBounds(384, 47, 428, 382);
		qLThucDon_Panel.add(qLTD_ScrollPane);
		
		
		// Label quản lí thực đơn
		qLTD_Label = new JLabel("Quản lý thực đơn");
		qLTD_Label.setForeground(new Color(255, 0, 0));
		qLTD_Label.setFont(new Font("Arial", Font.BOLD, 20));
		qLTD_Label.setHorizontalAlignment(SwingConstants.CENTER);
		qLTD_Label.setBounds(85, 31, 200, 42);
		qLThucDon_Panel.add(qLTD_Label);
		
		
		// Button thêm thực đơn
		themThucDon_Button = new JButton("Thêm");
		themThucDon_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themMon(evt);
            }
        });
		themThucDon_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\add.png"));
		themThucDon_Button.setForeground(new Color(255, 0, 0));
		themThucDon_Button.setFont(new Font("Arial", Font.BOLD, 20));
		themThucDon_Button.setBounds(38, 277, 127, 51);
		qLThucDon_Panel.add(themThucDon_Button);
		
		
		// Button sửa thực đơn
		suaThucDon_Button = new JButton("Sửa");
		suaThucDon_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              suaMon(evt);
            }
        });
		suaThucDon_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\edit.png"));
		suaThucDon_Button.setForeground(Color.RED);
		suaThucDon_Button.setFont(new Font("Arial", Font.BOLD, 20));
		suaThucDon_Button.setBounds(199, 277, 127, 51);
		qLThucDon_Panel.add(suaThucDon_Button);
		
		
		// Button xóa thực đơn
		xoaThucDon_Button = new JButton("Xóa");
		xoaThucDon_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              xoaMon(evt);
            }
        });
		xoaThucDon_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\garbage-bin.png"));
		xoaThucDon_Button.setForeground(Color.RED);
		xoaThucDon_Button.setFont(new Font("Arial", Font.BOLD, 20));
		xoaThucDon_Button.setBounds(119, 354, 127, 51);
		qLThucDon_Panel.add(xoaThucDon_Button);
		
		lblNewLabel = new JLabel("Tên món");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 97, 89, 36);
		qLThucDon_Panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 15));
		textField.setBounds(98, 97, 242, 36);
		qLThucDon_Panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(98, 165, 242, 36);
		qLThucDon_Panel.add(textField_1);
		
		JLabel lblGi = new JLabel("Giá");
		lblGi.setHorizontalAlignment(SwingConstants.CENTER);
		lblGi.setFont(new Font("Arial", Font.BOLD, 15));
		lblGi.setBounds(10, 165, 89, 36);
		qLThucDon_Panel.add(lblGi);
		
		
		
		// HÉT PANEL 2
		
		
		// PANEL 3 : QUẢN LÍ BÀN
		
		// Panel quản lí bàn
		qLban_Panel = new JPanel();
		chuaChucNang_Panel.add(qLban_Panel, "name_169455859752500");
		qLban_Panel.setLayout(null);
		
		
		// Table quản lí bàn
		
		qLBan_Table = new JTable();
		qLBan_Table.setEnabled(true);
		qLBan_Table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "STT", "Số bàn", "Trạng thái", "Ghi chú"
                }
        ));
		qLBan_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                   hienThiThongTinBan(evt);
            }
    });
		qLBan_Table.setForeground(new Color(0, 0, 0));
		qLBan_Table.setFont(new Font("Arial", Font.BOLD, 10));
		qLBan_Table.setBackground(Color.WHITE);
		
		
		// ScrollPane của table quản lí bàn
		qLBan_ScrollPane = new JScrollPane(qLBan_Table);
		
		qLBan_ScrollPane.setBounds(386, 60, 426, 392);
		qLban_Panel.add(qLBan_ScrollPane);
		
		
		// Label quản lí bàn
		qLBan_Label = new JLabel("Quản lý bàn");
		qLBan_Label.setHorizontalAlignment(SwingConstants.CENTER);
		qLBan_Label.setForeground(Color.RED);
		qLBan_Label.setFont(new Font("Arial", Font.BOLD, 20));
		qLBan_Label.setBounds(109, 30, 173, 36);
		qLban_Panel.add(qLBan_Label);
		
		
		// Button thêm bàn
		themBan_Button = new JButton("Thêm");
		themBan_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                   themBan(evt);
            }
    });
		themBan_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\add.png"));
		themBan_Button.setForeground(Color.RED);
		themBan_Button.setFont(new Font("Arial", Font.BOLD, 20));
		themBan_Button.setBounds(51, 284, 124, 49);
		qLban_Panel.add(themBan_Button);
		
		
		// Button sửa bàn
		suaBan_Button = new JButton("Sửa");
		suaBan_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                   updateBan(evt);
            }
    });
		suaBan_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\edit.png"));
		suaBan_Button.setForeground(Color.RED);
		suaBan_Button.setFont(new Font("Arial", Font.BOLD, 20));
		suaBan_Button.setBounds(216, 284, 124, 49);
		qLban_Panel.add(suaBan_Button);
		
		
		// Button xóa bàn
		xoaBan_Button = new JButton("Xóa");
		xoaBan_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 xoaBan(evt);
            }
    });
		xoaBan_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\garbage-bin.png"));
		xoaBan_Button.setForeground(Color.RED);
		xoaBan_Button.setFont(new Font("Arial", Font.BOLD, 20));
		xoaBan_Button.setBounds(139, 355, 124, 49);
		qLban_Panel.add(xoaBan_Button);
		
		lblNewLabel_1 = new JLabel("Tên bàn");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 92, 76, 36);
		qLban_Panel.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.BOLD, 15));
		textField_2.setBounds(122, 92, 242, 36);
		qLban_Panel.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Ghi chú");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 163, 76, 36);
		qLban_Panel.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.BOLD, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(122, 163, 242, 36);
		qLban_Panel.add(textField_3);
		
		
		// HẾT PANEL 3
		
		
		// PANEL 4 : QUẢN LÍ TÀI KHOẢN
		
		
		//Panel quản lí tài khoản
		qLTaiKhoan_Panel = new JPanel();
		chuaChucNang_Panel.add(qLTaiKhoan_Panel, "name_169455868057500");
		qLTaiKhoan_Panel.setLayout(null);
		
	
		// Table quản lí tài khoản
		qLTK_Table = new JTable();
		qLTK_Table.setEnabled(true);
		qLTK_Table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				
			},
			new String[] {
				"STT", "Tên", "Tài khoản"
			}
		));
		qLTK_Table.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	            hienThiTaiKhoan(evt);
	            }
	        });
		qLTK_Table.setForeground(new Color(0, 0, 0));
		qLTK_Table.setFont(new Font("Arial", Font.BOLD, 10));
		qLTK_Table.setBackground(Color.WHITE);
		
		
		// ScrollPane của table quản lí tài khoản
		qLTK_ScrollPane = new JScrollPane(qLTK_Table);
		qLTK_ScrollPane.setBounds(379, 63, 433, 410);
		qLTaiKhoan_Panel.add(qLTK_ScrollPane);
		
		
		//Label quản lí tài khoản
		qLTK_Label = new JLabel("Quản lý tài khoản");
		qLTK_Label.setHorizontalAlignment(SwingConstants.CENTER);
		qLTK_Label.setForeground(Color.RED);
		qLTK_Label.setFont(new Font("Arial", Font.BOLD, 20));
		qLTK_Label.setBounds(85, 31, 178, 36);
		qLTaiKhoan_Panel.add(qLTK_Label);
		
		
		//Button sửa tài khoản
		suaTK_Button = new JButton("Sửa");
		suaTK_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               updateTaiKhoan(evt);
            }
    });
		suaTK_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\edit.png"));
		suaTK_Button.setForeground(Color.RED);
		suaTK_Button.setFont(new Font("Arial", Font.BOLD, 20));
		suaTK_Button.setBounds(199, 313, 124, 49);
		qLTaiKhoan_Panel.add(suaTK_Button);
		
		
		//Button xóa tài khoản
		xoaTK_Button = new JButton("Xóa");
		xoaTK_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaTaiKhoan(evt);
            }
    });
		xoaTK_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\garbage-bin.png"));
		xoaTK_Button.setForeground(Color.RED);
		xoaTK_Button.setFont(new Font("Arial", Font.BOLD, 20));
		xoaTK_Button.setBounds(120, 393, 124, 49);
		qLTaiKhoan_Panel.add(xoaTK_Button);
		
		themBan_Button_1 = new JButton("Thêm");
		themBan_Button_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themTaiKhoan(evt);
            }
    });
		themBan_Button_1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\add.png"));
		themBan_Button_1.setForeground(Color.RED);
		themBan_Button_1.setFont(new Font("Arial", Font.BOLD, 20));
		themBan_Button_1.setBounds(41, 313, 124, 49);
		qLTaiKhoan_Panel.add(themBan_Button_1);
		
		lblNewLabel_3 = new JLabel("Tên hiển thị");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 77, 112, 36);
		qLTaiKhoan_Panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Tên đăng nhập");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 133, 112, 36);
		qLTaiKhoan_Panel.add(lblNewLabel_4);
		
		lblNewLabel_6 = new JLabel("Mật khẩu");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 192, 112, 36);
		qLTaiKhoan_Panel.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.BOLD, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(134, 77, 235, 36);
		qLTaiKhoan_Panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.BOLD, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(134, 133, 235, 36);
		qLTaiKhoan_Panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Arial", Font.BOLD, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(132, 192, 235, 36);
		qLTaiKhoan_Panel.add(textField_6);
		
		
		//HẾT PANEL 4
		
		// Ảnh nền
		menu_Label = new JLabel();
		menu_Label.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\menu.jpg"));
		menu_Label.setHorizontalAlignment(SwingConstants.CENTER);
		menu_Label.setBounds(0, 0, 1066, 503);
		this.add(menu_Label);
		
		
	}
	
	
	// Các hàm gọi panel
	private void firts() {
		CardLayout card = (CardLayout) chuaChucNang_Panel.getLayout();
		card.first(chuaChucNang_Panel);
	}
	
	private void next() {
		CardLayout card = (CardLayout) chuaChucNang_Panel.getLayout();
		card.next(chuaChucNang_Panel);
	}
	
	private void previous() {
		CardLayout card = (CardLayout) chuaChucNang_Panel.getLayout();
		card.previous(chuaChucNang_Panel);
	}
	
	private void last() {
		CardLayout card = (CardLayout) chuaChucNang_Panel.getLayout();
		card.last(chuaChucNang_Panel);
	}
	
	public void themBan(java.awt.event.ActionEvent evt) {
		 Connection con = DBUtility.openConnection();
	        try {
	            Statement stmt = con.createStatement();
	            int i = stmt.executeUpdate("INSERT INTO tables(table_name, note, status) VALUES ('" + textField_2.getText() + "','" + textField_3.getText() + "',0)");
	            if (i > 0) {
	                JOptionPane.showMessageDialog(null, "Thêm mới thành công!");
	                displayTableBan();
	            } else {
	                JOptionPane.showMessageDialog(null, "Lỗi!!");
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(QuanLyView.class.getName()).log(Level.SEVERE, null, ex);
	        }
	}
	
	public void xoaBan(java.awt.event.ActionEvent evt) {
		Connection con;
        PreparedStatement pstmt;

        if (idSave1 >= 0) {
            con = DBUtility.openConnection();
            try {
                pstmt = con.prepareStatement("Delete from tables where ID=?");
                pstmt.setInt(1, idSave1);
                int i = pstmt.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Delete Succesful!!");
                    displayTableBan();
                    idSave1 = -1;

                    textField_2.setText("");
                    textField_3.setText("");

                } else {
                    JOptionPane.showMessageDialog(null, "Delete fail!!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanLyView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selete to Delete!!");
        }
	}
	
	public void updateBan(java.awt.event.ActionEvent evt) {
		if (idSave1 >= 0) {
            Connection con;
            PreparedStatement pstmt;

            con = DBUtility.openConnection();
            try {
                pstmt = con.prepareStatement("update tables set table_name=?, note=? where ID=?");
                pstmt.setString(1, textField_2.getText());
                pstmt.setString(2, textField_3.getText());

                pstmt.setInt(3, idSave1);

                int i = pstmt.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Update Succesful!!");
                    displayTableBan();
                } else {
                    JOptionPane.showMessageDialog(null, "Update fail!!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanLyView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selete ID to update");
        }
	}
	
	 public void hienThiThongTinBan(java.awt.event.MouseEvent evt) {                                        

	       
	        int row = qLBan_Table.getSelectedRow();
	        List<Tables> listTable = TablesDAO.getInstance().LoadListTables();
	        idSave1 = listTable.get(row).getTableId();
	        textField_2.setText(qLBan_Table.getValueAt(row, 1) + "");
	        textField_3.setText(qLBan_Table.getValueAt(row, 3) + "");
	    }        
	 
	 
	public void displayTableBan() {
		 tableModel1.setRowCount(0);
	        List<Tables> listTable = TablesDAO.getInstance().LoadListTables();

	        for (int i = 0; i < listTable.size(); i++) {
	            Tables tables = listTable.get(i);
	            Object[] dt = {i + 1, tables.getTableName(), tables.getTableStatus(), tables.getTableNote()};
	            tableModel1.addRow(dt);
	        }
	}
	
	private void updateTaiKhoan(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        if (idSave2 >= 0) {
            if (textField_4.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Chưa nhập tên tài khoản!");
                return;
            }
            if (textField_5.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Chưa nhập mật khẩu!");
                return;
            }
            
            if (AccountDAO.getInstance().Update(idSave2, textField_4.getText(), textField_5.getText())) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công!!");
                hienThiThongTinTaiKhoan();
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi!!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Chọn tài khoản để sửa");
        }
    }                                         

	public void themTaiKhoan(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        if (textField_4.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa nhập tên hiển thị!");
            return;
        }
        if (textField_5.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa nhập tên tài khoản!");
            return;
        }
        if (textField_6.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chưa nhập mật khẩu!");
            return;
        }

        if (AccountDAO.getInstance().Add(textField_4.getText(), textField_5.getText(), textField_6.getText())) {
            JOptionPane.showMessageDialog(null, "Thêm mới thành công!!");
            hienThiThongTinTaiKhoan();
        } else {
            JOptionPane.showMessageDialog(null, "Lỗi!!");
        }
    }                                      

    public void xoaTaiKhoan(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        if (idSave2 >= 0) {
            if (AccountDAO.getInstance().Delete(idSave2)) {
              hienThiThongTinTaiKhoan();
                idSave2 = -1;
                textField_4.setText("");
                textField_5.setText("");
                textField_6.setText("");
                JOptionPane.showMessageDialog(null, "Xóa tài khoản thành công!!");
            } else {
                JOptionPane.showMessageDialog(null, "Xóa tài khoản không thành công!!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seletet to Delete!!");
        }
    }                                         

    public void hienThiTaiKhoan(java.awt.event.MouseEvent evt) {                                        
           
            int row = qLTK_Table.getSelectedRow();
            List<Account> list = AccountDAO.getInstance().listAccount();
            idSave2 = list.get(row).getId();

            textField_4.setText(list.get(row).getName());
            textField_5.setText(list.get(row).getUsername());
            textField_6.setText(list.get(row).getPassword());
            //qLTK_Table.getValueAt(row, 1) + ""
          //qLTK_Table.getValueAt(row, 2) + ""
           
        }     
        
        public void hienThiThongTinTaiKhoan() {
        	tableModel2.setRowCount(0);
            List<Account> list = AccountDAO.getInstance().listAccount();
            for (int i = 0; i < list.size(); i++) {
                Account account = list.get(i);
                Object[] dt = {i + 1, account.getName(), account.getUsername()};
                tableModel2.addRow(dt);
                
              
            }
         }
        
        public void themMon(java.awt.event.ActionEvent evt) {                                            
          
            Connection con;
            Statement stmt;

            con = DBUtility.openConnection();
            try {
                stmt = con.createStatement();
                int i = stmt.executeUpdate("INSERT INTO drinks(name, price, start_date,end_date) VALUES ('" + textField.getText() + "'," + Integer.parseInt(textField_1.getText()) + ",'" + "2023-02-03" + "','" +"2023-02-03" + "')");
                if (i > 0) {
                    displayTable();
                    JOptionPane.showMessageDialog(null, "Insert Succesful!!");
                } else {
                    JOptionPane.showMessageDialog(null, "Insert fail!!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanLyView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                                           

        public void xoaMon(java.awt.event.ActionEvent evt) {                                               
            // TODO add your handling code here:
            Connection con;
            PreparedStatement pstmt;

            if (idSave >= 0) {
                con = DBUtility.openConnection();
                try {
                    pstmt = con.prepareStatement("Delete from drinks where ID=?");
                    pstmt.setInt(1, idSave);
                    int i = pstmt.executeUpdate();
                    if (i > 0) {
                        displayTable();
                        idSave = -1;
                        textField.setText("");
                        textField_1.setText("");
                      
                        JOptionPane.showMessageDialog(null, "Delete Succesful!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Delete fail!!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLyView.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seletet to Delete!!");
            }
        }                                              

        public void hienThiMonClick(java.awt.event.MouseEvent evt) {                                        

            // TODO add your handling code here:
            int row = qLTD_Table.getSelectedRow();
            Connection con;
            con = DBUtility.openConnection();
            List<Drinks> list = DrinksDAO.getInstance().GetListDrink();
            idSave = list.get(row).getId();
            textField.setText(qLTD_Table.getValueAt(row, 1) + "");
            textField_1.setText(qLTD_Table.getValueAt(row, 2) + "");
            
        }                                       

        public void suaMon(java.awt.event.ActionEvent evt) {                                          

            // TODO add your handling code here:
            if (idSave >= 0) {
                Connection con = DBUtility.openConnection();
                try {
                    PreparedStatement pstmt = con.prepareStatement("update drinks set name=?, price=?, start_date=?, end_date=? where ID=?");
                    pstmt.setString(1, textField.getText());
                    pstmt.setString(2, textField_1.getText());
                    pstmt.setString(3, "2023-03-02");
                    pstmt.setString(4,"2023-03-02");
                    pstmt.setInt(5, idSave);
                    int i = pstmt.executeUpdate();
                    if (i > 0) {
                        displayTable();
                        JOptionPane.showMessageDialog(null, "Update Succesful!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Update fail!!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLyView.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seletet ID to update");
            }
        }
        
        public void displayTable() {
            tableModel.setRowCount(0);
            List<Drinks> list = DrinksDAO.getInstance().GetListDrink();
            for (int i = 0; i < list.size(); i++) {
                Drinks drinks = list.get(i);
                Object[] dt = {i + 1, drinks.getName(), drinks.getPrice(), drinks.getStartDate(), drinks.getEndDate()};
                tableModel.addRow(dt);
            }
        }
}
