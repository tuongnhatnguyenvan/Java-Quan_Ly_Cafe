package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TrangChuView extends JPanel {

	private JLabel menuIcon_Label;

	// contructer
	public TrangChuView() {
		this.init();

	}

	//hàm giao diện
	private void init() {
		
		this.setBackground(new Color(255, 255, 255));
		this.setBounds(10, 89, 1066, 503);
		this.setLayout(null);
		
		
		// set ảnh nền
		menuIcon_Label = new JLabel();
		menuIcon_Label.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\menu.jpg"));
		menuIcon_Label.setBounds(0, 0, 1066, 503);
		this.add(menuIcon_Label);
	}	
}
