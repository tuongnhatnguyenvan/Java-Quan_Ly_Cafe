package test;

import java.sql.Connection;

import javax.swing.UIManager;


import view.DangNhapView;
import view.MenuView;

public class main {
	public static void main(String[] args) {
		try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new DangNhapView().setVisible(true);
		
    } catch (Exception e) {
		e.printStackTrace();
	}
}
}
