package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import thu.ThoiGian;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.CardLayout;

public class MenuView extends JFrame {
   
	// các thành phần
	private JPanel contentPane, menu_Panel, main_panel, south_Panel;
	private JButton trangChu_Button, bangHang_Button, quanLy_Button, thongKe_Button, caiDat_Button, dangXuat_Button;
    private JLabel sologen_Label, anhCafeGoc_Label, thanhVienIcon_Label, thanhVien_Label, time_Label;
	private TrangChuView p1;
	private BanHangView p2;
	private QuanLyView p3;
	private ThongKeView p4;
	private CaiDatView p5;



    // contructer
	public MenuView() throws HeadlessException {
		this.setTitle("Cafe");
		this.init();
		this.time();
	}



	    // hàm giao diện
	public void init() {
        this.setBackground(new Color(255, 255, 255));
        this.setUndecorated(true);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\menu.jpg"));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1087,634);
		this.setLocationRelativeTo(null);
		
		//
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// VÙNG SOUTH
		south_Panel = new JPanel();
		south_Panel.setBackground(new Color(214, 196, 165));
		south_Panel.setBounds(10, 594, 1066, 30);
		south_Panel.setLayout(null);
		contentPane.add(south_Panel);
		
		sologen_Label = new JLabel("Tuong Nhat - RiNa - Duc Hung");
		sologen_Label.setFont(new Font("Arial", Font.ITALIC, 10));
		sologen_Label.setHorizontalAlignment(SwingConstants.RIGHT);
		sologen_Label.setBounds(836, 0, 230, 30);
		south_Panel.add(sologen_Label);
		
		
		anhCafeGoc_Label = new JLabel();
		anhCafeGoc_Label.setHorizontalAlignment(SwingConstants.CENTER);
		anhCafeGoc_Label.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\coffee-cup.png"));
		anhCafeGoc_Label.setBounds(0, 0, 122, 30);
		south_Panel.add(anhCafeGoc_Label);
		
		
		time_Label = new JLabel("dd/mm/yyyy        hh : mm : ss AM");
		time_Label.setHorizontalAlignment(SwingConstants.CENTER);
		time_Label.setForeground(new Color(255, 0, 0));
		time_Label.setFont(new Font("Arial", Font.BOLD, 15));
		time_Label.setBounds(374, -1, 327, 30);
		south_Panel.add(time_Label);
		
		// HẾT VÙNG SOUTH
		
		
		// VÙNG TRUNG TÂM
		
		main_panel = new JPanel();
		main_panel.setBackground(new Color(255, 255, 255));
		main_panel.setBounds(10, 89, 1066, 503);
		contentPane.add(main_panel);
		main_panel.setLayout(new CardLayout(0, 0));
		
		
		 p1 = new TrangChuView();
		 p2 = new BanHangView();
		 p3 = new QuanLyView();
		 p4 = new ThongKeView();
		 p5 = new CaiDatView();
	
		
		main_panel.add(p1);
		main_panel.add(p2);
		main_panel.add(p3);
		main_panel.add(p4);
		main_panel.add(p5);

        // HẾT VÙNG TRUNG TÂM
		
		
		// VÙNG THANH MENU PHÍA TRÊN
		
		menu_Panel = new JPanel();
		menu_Panel.setBackground(new Color(214, 196, 165));
		menu_Panel.setBounds(10, 10, 1066, 78);
		contentPane.add(menu_Panel);
		menu_Panel.setLayout(null);
		
		// Button trang chủ
	    trangChu_Button = new JButton("Trang chủ");
		trangChu_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\Graphicloads-Colorful-Long-Shadow-Home.32.png"));
		trangChu_Button.setFont(new Font("Arial", Font.BOLD, 15));
		trangChu_Button.setForeground(new Color(255, 128, 0));
		trangChu_Button.setBounds(10, 10, 150, 57);
		menu_Panel.add(trangChu_Button);
		trangChu_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firts();
			}
		});
		
		
		// Button bán hàng
		bangHang_Button = new JButton("Bán hàng");
		bangHang_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\Graphicloads-Colorful-Long-Shadow-Dollar.32.png"));
		bangHang_Button.setForeground(new Color(255, 128, 0));
		bangHang_Button.setFont(new Font("Arial", Font.BOLD, 15));
		bangHang_Button.setBounds(170, 10, 150, 57);
		menu_Panel.add(bangHang_Button);
		bangHang_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firts(); 
				next();
			}
		});
		
		
		// Button quản lý
		quanLy_Button = new JButton("Quản lý");
		quanLy_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\Martz90-Circle-Addon1-Task-manager.32.png"));
		quanLy_Button.setForeground(new Color(255, 128, 0));
		quanLy_Button.setFont(new Font("Arial", Font.BOLD, 15));
		quanLy_Button.setBounds(330, 10, 150, 57);
		menu_Panel.add(quanLy_Button);
		quanLy_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firts(); 
				next(); 
				next();
			}
		});
		
		
		// Button thống kê
		thongKe_Button = new JButton("Thống kê");
		thongKe_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\Graphicloads-Colorful-Long-Shadow-Analytics.32.png"));
		thongKe_Button.setForeground(new Color(255, 128, 0));
		thongKe_Button.setFont(new Font("Arial", Font.BOLD, 15));
		thongKe_Button.setBounds(490, 10, 150, 57);
		menu_Panel.add(thongKe_Button);
		thongKe_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last();  
				previous();
			}
		});
		
		
		// Button cài đặt
		caiDat_Button = new JButton("Cài đặt");
		caiDat_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\Grafikartes-Flat-Retro-Modern-Settings.32.png"));
		caiDat_Button.setForeground(new Color(255, 128, 0));
		caiDat_Button.setFont(new Font("Arial", Font.BOLD, 15));
		caiDat_Button.setBounds(650, 10, 150, 57);
		menu_Panel.add(caiDat_Button);
		caiDat_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last();
			}
		});
		
		
		// Button đăng xuất
		dangXuat_Button = new JButton("Đăng xuất");
		dangXuat_Button.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\logout-icon.png"));
		dangXuat_Button.setFont(new Font("Arial", Font.BOLD, 15));
		dangXuat_Button.setForeground(new Color(255, 128, 0));
		dangXuat_Button.setBounds(919, 42, 137, 25);
		menu_Panel.add(dangXuat_Button);
		dangXuat_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangNhapView dngd = new DangNhapView();
				dngd.setVisible(true);
				dispose();
				
			}
		});
		
		
		// Label icon thành viên
		thanhVienIcon_Label = new JLabel();
		thanhVienIcon_Label.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\Aha-Soft-Free-Large-Boss-Manager.32.png"));
		thanhVienIcon_Label.setFont(new Font("Arial", Font.BOLD, 15));
		thanhVienIcon_Label.setForeground(new Color(255, 128, 0));
		thanhVienIcon_Label.setHorizontalAlignment(SwingConstants.CENTER);
		thanhVienIcon_Label.setBounds(882, 0, 34, 48);
		menu_Panel.add(thanhVienIcon_Label);
		
		
		
		// Lable thành viên
		thanhVien_Label = new JLabel("Thành viên");
		thanhVien_Label.setFont(new Font("Arial", Font.BOLD, 15));
		thanhVien_Label.setForeground(new Color(255, 128, 0));
		thanhVien_Label.setHorizontalAlignment(SwingConstants.CENTER);
		thanhVien_Label.setBounds(919, 0, 137, 41);
		menu_Panel.add(thanhVien_Label);
		
		// HẾT THANH MENU PHÍA TRÊN
		

		this.setVisible(false);

}
		
		
        // các hàm gọi panel
		


	
	public JButton getQuanLy_Button() {
		return quanLy_Button;
	}



	public void setQuanLy_Button(JButton quanLy_Button) {
		this.quanLy_Button = quanLy_Button;
	}



	public JButton getThongKe_Button() {
		return thongKe_Button;
	}



	public void setThongKe_Button(JButton thongKe_Button) {
		this.thongKe_Button = thongKe_Button;
	}



	public void setChucNang() {
		this.thongKe_Button.setEnabled(false);
		this.quanLy_Button.setEnabled(false);
	}



		public JLabel getThanhVien_Label() {
		return thanhVien_Label;
	}



	public void setThanhVien_Label(String thanhVien_Label) {
		this.thanhVien_Label.setText(thanhVien_Label);
	}



		private void firts() {
        	CardLayout card = (CardLayout) main_panel.getLayout();
        	card.first(main_panel);
        }

        private void next() {
        	CardLayout card = (CardLayout) main_panel.getLayout();
        	card.next(main_panel);
        }
        
        private void previous() {
        	CardLayout card = (CardLayout) main_panel.getLayout();
        	card.previous(main_panel);
        }
        
        private void last() {
        	CardLayout card = (CardLayout) main_panel.getLayout();
        	card.last(main_panel);
        }
        
        public void hienThiNguoiDung(String ten) {
        	p5.getHienThiNguoiDung_Label().setText(ten);
        }
        
        // thời gian
        private void time() {        	
	    	new ThoiGian(time_Label).start();		
	}             
}
