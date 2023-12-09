package view;

import java.awt.Color;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.JList;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import DAO.AccountDAO;
import DAO.DrinksDAO;
import DAO.InvoicesDAO;
import DAO.MenuDAO;
import DAO.OrdersDAO;
import DAO.TablesDAO;
import DTO.Tables;
import DTO.Account;
import DTO.Drinks;
import DTO.Menu;
import Utilities.DBUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


public class BanHangView extends JPanel {
	 int idTable = -1;
     DefaultComboBoxModel<Drinks> comboBoxModel;
     DefaultTableModel tableModelTables;
     DefaultTableModel tableModelDrinks;
     int totalPrice = 0;
     
	private JTable table;
	private JScrollPane scrollPane;
	private JScrollPane thongKe_ScrollPane;
	private JScrollPane thongKe_ScrollPane1;
	private JTable table1;
	private JComboBox comboBox;
	private JSpinner spinner;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
    private JTextField tongTien;
	private JLabel lblNewLabel_2;
   
	public BanHangView() {
		this.init();
		tableModelTables = new DefaultTableModel();
        tableModelTables.addColumn("STT");
        tableModelTables.addColumn("Tên bàn");
        tableModelTables.addColumn("Trạng thái");
        tableModelTables.addColumn("Ghi chú");
        table.setModel(tableModelTables);
        displayTables();

        tableModelDrinks = new DefaultTableModel();
        tableModelDrinks.addColumn("STT");
        tableModelDrinks.addColumn("Tên đồ uống");
        tableModelDrinks.addColumn("Giá");
        tableModelDrinks.addColumn("Số lượng");
        tableModelDrinks.addColumn("Thành tiền");
        table1.setModel(tableModelDrinks);

        comboBoxModel = new DefaultComboBoxModel<>();
        Drinks mChon = new Drinks(-1, "---- Chọn đồ uống ----");
        comboBoxModel.addElement(mChon);
        comboBox.setModel(comboBoxModel);
        loadDrinks();
		 

    }
	
	private void init() {
		this.setBackground(new Color(255, 255, 255));
		this.setBounds(10, 89, 1066, 503);
		this.setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 1046, 483);
		add(panel);
		panel.setLayout(null);
		
		
		
		table = new JTable();
		table.setEnabled(true);
		table.setModel(new DefaultTableModel(
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
					"STT", "Tên Bàn", "Trạng Thái", "Ghi Chú"
			}
		));
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                tblTablesMouseClicked(evt);
	            }
	        });
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Arial", Font.BOLD, 10));
		table.setBackground(Color.WHITE);
	
		
		// ScrollPane thống kê
		thongKe_ScrollPane = new JScrollPane(table);
		thongKe_ScrollPane.setBounds(10, 30, 445, 426);
		panel.add(thongKe_ScrollPane);
		
		
		table1 = new JTable();
		
		table1.setEnabled(false);
		 table1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"STT", "Tên đồ uống", "Giá", "Số lượng", "Thành tiền"
			}
		));
		
		table1.setForeground(new Color(0, 0, 0));
		table1.setFont(new Font("Arial", Font.BOLD, 10));
		table1.setBackground(Color.WHITE);
	
		
		// ScrollPane thống kê
		thongKe_ScrollPane1 = new JScrollPane(table1);
		thongKe_ScrollPane1.setBounds(465, 150, 571, 306);
		panel.add(thongKe_ScrollPane1);
		
		spinner = new JSpinner();
		spinner.setFont(new Font("Arial", Font.BOLD, 20));
		spinner.setBounds(463, 94, 211, 46);
		panel.add(spinner);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Chọn đồ uống"}));
		comboBox.setMaximumRowCount(10);
		comboBox.setFont(new Font("Arial", Font.BOLD, 20));
		comboBox.setBounds(463, 30, 211, 54);
		panel.add(comboBox);
		
		btnNewButton = new JButton("Thêm đồ uống");
		btnNewButton.setEnabled(true);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\add.png"));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBounds(685, 30, 203, 54);
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               themDoUong(evt);
            }
        });
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Thanh toán");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\dollar-collection-icon.png"));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	 thanhToan(evt);
            }
        });
		btnNewButton_1.setBounds(695, 94, 193, 46);
		panel.add(btnNewButton_1);
		
		tongTien = new JTextField("0");
		tongTien.setFont(new Font("Arial", Font.BOLD, 15));
		tongTien.setHorizontalAlignment(SwingConstants.CENTER);
		tongTien.setBounds(898, 92, 138, 46);
		tongTien.setEnabled(false);
		tongTien.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                txtTotalPriceActionPerformed(evt);
	            }
	        });
		panel.add(tongTien);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setBounds(898, 32, 138, 52);
		panel.add(lblNewLabel_2);
		
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Java\\baitaplon\\src\\thu\\menu.jpg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1066, 503);
		this.add(lblNewLabel);
		
	
		
		

	}
	
	 private void themDoUong(java.awt.event.ActionEvent evt) {                                       
         // TODO add your handling code here:
         int invoiceId = InvoicesDAO.getInstance().GetUncheckInvoiceByTableId(idTable);
         Drinks drinks = (Drinks) comboBox.getSelectedItem();

         if (invoiceId == -1) {
                 InvoicesDAO.getInstance().Insert(idTable, AccountDAO.getInstance().GetAccount().getId());
                 OrdersDAO.getInstance().Insert(drinks.getId(), InvoicesDAO.getInstance().GetMaxIdInvoice(), Integer.parseInt(spinner.getValue().toString()));
         } else {
                 OrdersDAO.getInstance().Insert(drinks.getId(), invoiceId, Integer.parseInt(spinner.getValue().toString()));
         }
         Connection con = DBUtility.openConnection();
         PreparedStatement pstmt;
         try {
                 pstmt = con.prepareStatement("update tables set status=1 where ID=?");
                 pstmt.setInt(1, idTable);
                 pstmt.executeUpdate();
                 displayTables();
                 displayTableDrinks();
                 btnNewButton_1.setEnabled(true);
                 spinner.setValue(0);
                 comboBox.setSelectedIndex(0);
         } catch (SQLException ex) {
                 Logger.getLogger(BanHangView.class.getName()).log(Level.SEVERE, null, ex);
         }
 }                                      

                                        

 private void tblTablesMouseClicked(java.awt.event.MouseEvent evt) {                                       
        
         int row = table.getSelectedRow();
         btnNewButton.setEnabled(true);
         if ((table.getValueAt(row, 2) + "").equals("Đã đặt")) {
        	 btnNewButton_1.setEnabled(true);
         } else {
        	
        	 btnNewButton_1.setEnabled(false);
         }
         List<Tables> listTable = TablesDAO.getInstance().LoadListTables();
         idTable = listTable.get(row).getTableId();
          totalPrice = new Menu().getTotalPrice();
         displayTableDrinks();
         spinner.setValue(0);
         lblNewLabel_2.setText(TablesDAO.getInstance().getTables().getTableName());
        
 }                                      

 private void  thanhToan(java.awt.event.ActionEvent evt) {                                       
         try {
                 // TODO add your handling code here:
                 int invoiceId = InvoicesDAO.getInstance().GetUncheckInvoiceByTableId(idTable);
                 InvoicesDAO.getInstance().Update(invoiceId, totalPrice);
                 Connection con = DBUtility.openConnection();
                 PreparedStatement pstmt = con.prepareStatement("update tables set status=0 where ID=?");
                 pstmt.setInt(1, idTable);
                 pstmt.executeUpdate();
                 displayTables();
                 displayTableDrinks();
                 totalPrice = 0;
                 tongTien.setText("0");
                 spinner.setValue(0);
         } catch (SQLException ex) {
                 Logger.getLogger(BanHangView.class.getName()).log(Level.SEVERE, null, ex);
         }
 }                                      

                                       

      
 
 private void displayTables() {
     tableModelTables.setRowCount(0);
     List<Tables> listTable = TablesDAO.getInstance().LoadListTables();
     for (int i = 0; i < listTable.size(); i++) {
             Tables tables = listTable.get(i);
             Object[] dt = {i + 1, tables.getTableName(), tables.getTableStatus(), tables.getTableNote()};
             tableModelTables.addRow(dt);
     }
}

private void displayTableDrinks() {
     tableModelDrinks.setRowCount(0);

     List<Menu> listMenu = MenuDAO.getInstance().GetListMenuByTableId(idTable);
     for (int i = 0; i < listMenu.size(); i++) {
             Menu menu = listMenu.get(i);
             Object[] dt = {i + 1, menu.getDrinkName(), menu.getPrice(), menu.getCount(), menu.getTotalPrice()};
             totalPrice += menu.getTotalPrice();
             tableModelDrinks.addRow(dt);
     }
   
     tongTien.setText(totalPrice + "");
}

private void loadDrinks() {
     List<Drinks> listDrink = DrinksDAO.getInstance().GetListDrink();
     for (Drinks drinks : listDrink) {
             comboBoxModel.addElement(drinks);
     }
}

private void cboDrinksActionPerformed(java.awt.event.ActionEvent evt) {                                          


}  

private void txtTotalPriceActionPerformed(java.awt.event.ActionEvent evt) {                                              

}   
}
