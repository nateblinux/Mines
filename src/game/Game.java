package game;

import java.awt.Color;
import java.util.Random;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import gui.Gui;

public class Game {
	public static int[] gameBoard = {
			0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,
		};
	static int flags = 0;
	public static void main(String[] args){
		new Gui();
	}
	
	public static int chooseRandom(){
		Random generator = new Random();
		return 63 - generator.nextInt(63);
	}
	
	public static void placeMines(){
		for(int i = 0; i <= 10; i++){
			int place = chooseRandom();
			gameBoard[place] = 10;
		}
	}
	public static void uncoverSquares(int squareNo){
		int chooser = 0;
		String text = Integer.toString(gameBoard[squareNo]);
		Gui.button[squareNo].setText(text);
		if(gameBoard[squareNo] == 1){
			Gui.button[squareNo].setForeground(Color.green);
		}
		if(gameBoard[squareNo] == 2){
			Gui.button[squareNo].setForeground(Color.yellow);
		}
		if(gameBoard[squareNo] >= 3){
			Gui.button[squareNo].setForeground(Color.red);
		}
		if(gameBoard[squareNo] == 10){
			Gui.button[squareNo].setText("B");
			Gui.button[squareNo].setBackground(Color.red);
			Gui.button[squareNo].setForeground(Color.yellow);
			JOptionPane.showMessageDialog(null, "Game Over");
			reset();
		}
		for(int i = 0; i < chooseRandom(); i++){
			chooser = squareNo + i;
			if(gameBoard[chooser] == 10){
				
			}else{
				text = Integer.toString(gameBoard[chooser]);
				Gui.button[chooser].setText(text);
				if(gameBoard[chooser] == 1){
					Gui.button[chooser].setForeground(Color.green);
				}
				if(gameBoard[chooser] == 2){
					Gui.button[chooser].setForeground(Color.yellow);
				}
				if(gameBoard[chooser] >= 3){
					Gui.button[chooser].setForeground(Color.red);
				}
			}
		}
	}

	protected static void reset() {
		for(int i = 0; i <= Gui.button.length; i++){
			Gui.button[i].setText(Gui.JButtonTextArray[i]);
			Gui.button[i].setBackground(Color.darkGray);
		}
		for(int i = 0; i <= gameBoard.length; i++){
			gameBoard[i] = 0;
		}
		placeMines();
		SetNumbers.setNumbers();
	}

	public static void flag(int button) {
		Gui.button[button].setText("F");
		Gui.button[button].setBackground(Color.green);
		Gui.button[button].setForeground(Color.yellow);
	}
	
	public static boolean checkForWin(){
		int correct = 0;
		if(flags == 10){
			for(int i = 0; i < Gui.flagLocations.length; i++){
				if(Gui.flagLocations[i] == 10){
					correct += 1;
				}
			}
		}
		if(correct == 10){
			return true;
		}
		return false;
	}
}
