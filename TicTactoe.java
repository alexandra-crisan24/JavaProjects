import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTactoe {
static ArrayList<Integer>playerPosition=new ArrayList<Integer>(); 
static ArrayList<Integer>cpuPosition=new ArrayList<Integer>(); 
public static void main (String [] args){
	char[][] gameBoard = {
		    {' ', '|', ' ', '|', ' '},
		    {'-', '+', '-', '+', '-'},
		    {' ', '|', ' ', '|', ' '},
		    {'-', '+', '-', '+', '-'},
		    {' ', '|', ' ', '|', ' '}
		};
	printGameboard(gameBoard); 
	  
	while (true) {
		 Scanner scan = new Scanner(System.in); 
		 System.out.println(" Introduceti pozitia (1-9)");
		int Playerpos= scan.nextInt(); 
		placePliece(gameBoard, Playerpos , "player"); 
		Random random = new Random ();
		int cpuPos=random.nextInt(9)+1; 
		placePliece(gameBoard, cpuPos , "cpu"); 
		 printGameboard(gameBoard); 
		 String result=checkWinner(); 
		 System.out.println(result);
		 
	}

}
public static void printGameboard(char[][] gameboard) {
	for ( char [] row: gameboard) {
		for ( char c: row) {
			System.out.print(c); 
		}
	System.out.println(); 
	}
	}
public static void placePliece( char [] [] gameBoard, int pos, String user ) {
	char symbol = ' '; 
	if (user.equals("player")) {
		 
		 symbol='X'; 
		 playerPosition.add(pos); 
		 }
	 else if (user.equals("cpu")){
		 symbol='0';
		 cpuPosition.add(pos); 
	 }
	switch (pos ) {
	 case 1 : gameBoard[0][0]=symbol; break; 
	 case 2: gameBoard[0][2]= symbol ; break; 
	 case 3 : gameBoard[0][4]=symbol; break; 
	 case 4 : gameBoard[2][0]=symbol; break; 
	 case 5 : gameBoard[2][2]=symbol; break; 
	 case 6 : gameBoard[2][4]=symbol; break; 
	 case 7 : gameBoard[4][0]=symbol; break; 
	 case 8 : gameBoard[4][2]=symbol; break; 
	 case 9 : gameBoard[4][4]=symbol; break; 
	 default : break; 
	 }
}
public static String checkWinner () {
	List topRow=Arrays.asList(1,2,3);
	List midRow=Arrays.asList(4,5,6);
	List botRow=Arrays.asList(7,9,8);
	List leftcol=Arrays.asList(1,4,7);
	List midcol=Arrays.asList(2,5,8);
	List rightCol=Arrays.asList(3,6,9);
	List digP=Arrays.asList(1,5,9);
	List digs=Arrays.asList(3,5,7);
	List<List>winningCondition =new ArrayList<List>();
	winningCondition.add(topRow);
	winningCondition.add(midRow);
	winningCondition.add(botRow);
	winningCondition.add(rightCol);
	winningCondition.add(leftcol);
	winningCondition.add(midcol);
	winningCondition.add(digP);
	winningCondition.add(digs); 
	for (List l : winningCondition) {
		if (playerPosition.containsAll(l)) {
			return "CONGRATULATIONS!!!"; 
		}
		else if  (cpuPosition.containsAll(l)){
		 return " CPU wins ! Sorry :("; 	
		}
		else if (playerPosition.size()+ cpuPosition.size()==9) {
			return "REMIZA"; 
		}
	}
	return ""; 
}
}



