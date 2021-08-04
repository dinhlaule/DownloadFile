package com.luvina.bth.gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ProgressBarEx extends JPanel{
	private JProgressBar progress;
	
	public ProgressBarEx() {
		initGUI();
		addComps();
	}

	private void initGUI() {
		setBackground(Color.GRAY);
		setLayout(null);
		
	}

	private void addComps() {
		progress = new JProgressBar();
		progress.setBounds(100,80,300,30);
		progress.setStringPainted(true);
		progress.setString(progress.getValue()+"");
		
		progress.setForeground(Color.GREEN);
		progress.setMinimum(0);
		progress.setMaximum(1000);
		progress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				progress.setValue(progress.getValue()+100);
				progress.setString(progress.getValue()+"");
				if(progress.getValue()>=progress.getMaximum()) {
					JOptionPane.showMessageDialog(progress, "Đã đạt giá trị max, không thể click thêm");
				}
			}
		});
		
		add(progress);
		
	}
	
}
