package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import game.Game;
import game.SetNumbers;

public class Gui extends JFrame implements MouseListener {
	JFrame mainFrame;
	public static JButton[] button = new JButton[64];
	int buttonClicked;
	public static String[] JButtonTextArray = {
			"", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", ""			
	};
	public static int[] flagLocations;
	public Gui() {
		mainFrame = new JFrame();
		GridLayout layout = new GridLayout(8, 8);;
		mainFrame.setSize(500, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(layout);
		for(int i = 0; i < 64; i++){
			button[i] = new JButton();
			button[i].setText(JButtonTextArray[i]);
			button[i].addMouseListener(this);
			button[i].setSize(1, 1);
			button[i].setBackground(Color.darkGray);
			button[i].setForeground(Color.white);
		}
		for(int i = 0; i <= 63; i++){
			gamePanel.add(button[i]);
		}
		mainFrame.add(gamePanel);
		mainFrame.setVisible(true);
		Game.placeMines();
		SetNumbers.setNumbers();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i = 0; i < button.length; i++){
			if(e.getSource() == button[i]){
				if(e.getButton() == 1){
					Game.uncoverSquares(i);
				}else{
					Game.flag(i);
					flagLocations[i] += i;
					if(Game.checkForWin() == true){
						JOptionPane.showMessageDialog(null, "you have flaged all of the mines");
					}
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
