package game;

public class SetNumbers {
	int trys = 0;
	public static void setNumbers(){
		for(int i = 0; i < Game.gameBoard.length; i++){
			int number = 0;
			try{
				if(i >= 9 && Game.gameBoard[i] != 10){
					if(Game.gameBoard[i - 9] == 10){
						number += 1;
					}
				}
				if(i >= 8 && Game.gameBoard[i] != 10){
					if(Game.gameBoard[i - 8] == 10){
						number += 1;
					}
				}
				if(i >= 7 && Game.gameBoard[i] != 10){
					if(Game.gameBoard[i - 7] == 10){
						number += 1;
					}
				}
				if(i >= 1 && Game.gameBoard[i] != 10){
					if(Game.gameBoard[i -1] == 10){
						number += 1;
					}
				}
				if(i < 63 && Game.gameBoard[i] != 10){
					if(Game.gameBoard[i + 1] == 10){
						number += 1;
					}
				}
				if(i <= 54 && Game.gameBoard[i] != 10){
					if(Game.gameBoard[i + 9] == 10){
						number += 1;
					}
				}
				if(i <= 55){
					if(Game.gameBoard[i + 8] == 10){
						number += 1;
					}
				}
				if(i <= 56){
					if(Game.gameBoard[i + 7] == 10){
						number += 1;
					}
				}
				if(Game.gameBoard[i] != 10){
					Game.gameBoard[i] = number;
				}else{
					
				}
			}catch(ArrayIndexOutOfBoundsException e){
				
			}catch(IndexOutOfBoundsException e){
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
