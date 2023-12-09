package view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
//import com.toedter.calendar.JCalendar;
//import com.toedter.calendar.JDateChooser;
//import com.toedter.components.JLocaleChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JSeparator;


import DAO.DrinksDAO;
import DTO.Drinks;
import Utilities.DBUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;



public class ThongKeView extends JPanel {
	
	DefaultTableModel tableModel;

	
	// Panel chính
	private JPanel main_Panel;
	
	// Table
	private JScrollPane thongKe_ScrollPane;
	private JTable table;
		
	// ảnh nền
	private JLabel menu_Label;

	
	// contructer
	public ThongKeView() {
		this.init();
		 tableModel = new DefaultTableModel();
	        tableModel.addColumn("STT");
	        tableModel.addColumn("Nhân viên");
	        tableModel.addColumn("Tên bàn");
	        tableModel.addColumn("Tổng tiền");
	        tableModel.addColumn("Ngày thanh toán");
	        table.setModel(tableModel);
	        LoadTableThongKe();

	}

	
	// hàm giao diện
	private void init() {
		this.setBackground(new Color(255, 255, 255));
		this.setBounds(10, 89, 1066, 503);
		this.setLayout(null);
		
		main_Panel = new JPanel();
		main_Panel.setBounds(10, 10, 1046, 483);
		this.add(main_Panel);
		main_Panel.setLayout(null);
		
		
		// Table Thống kê
		table = new JTable();
		table.setEnabled(false);
		
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Arial", Font.BOLD, 10));
		table.setBackground(Color.WHITE);
	
		
		// ScrollPane thống kê
    	thongKe_ScrollPane = new JScrollPane(table);
		thongKe_ScrollPane.setBounds(71, 64, 903, 381);
		main_Panel.add(thongKe_ScrollPane);
		
		
		// ảnh nền
		menu_Label = new JLabel();
		menu_Label.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\menu.jpg"));
		menu_Label.setBounds(0, 0, 1066, 503);
		this.add(menu_Label);
		
		
	}
	
	private void LoadTableThongKe() {
        tableModel.setRowCount(0);
        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT `account`.`name`, `tables`.`table_name`, `invoice`.`total_price`, `invoice`.`invoice_date` FROM `invoice`, `tables`,`account` WHERE `invoice`.`tables_id`=`tables`.`ID` AND `invoice`.`account_ID`=`account`.`ID` AND `invoice`.`status`=1");
            ResultSet rs = pstmt.executeQuery();
            int i = 1;
            while (rs.next()) {
                Object[] dt = {i++, rs.getString(1), rs.getString(2), rs.getInt(3), rs.getTimestamp(4)};
                tableModel.addRow(dt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
