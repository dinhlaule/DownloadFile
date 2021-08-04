package com.luvina.bth.gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class CheckBoxEx extends JPanel {
	MouseAdapter mouseAdapter;
	JCheckBox chkRed, chkBlue, chkGreen;
	int color1 = 0;
	int color2 =0;
	int color3 =0;

	public CheckBoxEx() {
		initGUI();

		addEvents();
		addComps();
	}

	private void initGUI() {
//		setBackground(Color.GRAY);
		setLayout(null);

	}

	private void addEvents() {
		mouseAdapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (chkRed.isSelected()) {
					color1 = Color.RED.getRed();
					setBackground(Color.red);
				} else {
					color1 = 0;
				}
				if (chkBlue.isSelected()) {
					color2 = Color.BLUE.getBlue();
				} else {
					color2 = 0;
				}
				if (chkGreen.isSelected()) {
					color3 = Color.GREEN.getGreen();
				} else {
					color3 = 0;
				}

				System.out.println(color1 + "," + color3 + "," + color2);
				setBackground(new Color(color1, color3, color2));
			}
		};

	}

	private void addComps() {

		chkRed = new JCheckBox("RED");
		chkRed.setForeground(Color.RED);
		chkRed.setBounds(10, 20, 150, 30);
		chkRed.setBackground(Color.WHITE);
		chkRed.addMouseListener(mouseAdapter);

		chkBlue = new JCheckBox("BLUE");
		chkBlue.setForeground(Color.BLUE);
		chkBlue.setBounds(10, 50, 150, 30);
		chkBlue.setBackground(Color.WHITE);
		chkBlue.addMouseListener(mouseAdapter);

		chkGreen = new JCheckBox("GREEN");
		chkGreen.setForeground(Color.GREEN);
		chkGreen.setBounds(10, 80, 150, 30);
		chkGreen.setBackground(Color.WHITE);
		chkGreen.addMouseListener(mouseAdapter);

		add(chkRed);
		add(chkBlue);
		add(chkGreen);

	}
}
