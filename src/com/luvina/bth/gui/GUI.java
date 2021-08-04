package com.luvina.bth.gui;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUI extends JFrame{
	// thuoc tinh
		public static final int WIDTH_FRAME = 600;
		public static final int HEIGHT_FRAME = 250;

		// định nghĩa khung giao diện
		public GUI() {
			// gọi đến phương thức định nghĩa khung giao diện
			initGUI();
			addEvents();
			addComps();
		}

		

		// pt định nghĩa
		private void initGUI() {
			// định nghĩa kích thước của khung
			setSize(WIDTH_FRAME, HEIGHT_FRAME);
			// định nghia title
			setTitle("Sử dụng Label & Textbox");
			// định nghiã vị trí hiện thị
//			setLocation(0, 0);
			setLocationRelativeTo(null);

//			setVisible(true);
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			
			setLayout(new CardLayout());

		}

		private void addEvents() {
			

			// khuyến khích dùng
			WindowAdapter adapter = new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					int result = JOptionPane.showConfirmDialog(GUI.this, "Are you sure to close", "Exit dialog",JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.YES_OPTION) {
						dispose();
					}
				}
			};

			addWindowListener(adapter);
			
		}
		private void addComps() {
			MainPanel mainPanel = new MainPanel();
			add(mainPanel);
			
		}
}
