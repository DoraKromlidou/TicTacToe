import java.util.Scanner;
import java.util.Random;

public class Main {
	
	static char Table[][] = new char [3][3];
	
	public static void main(String[] args) {
		
		//Dimiourgia kenou pinaka
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				Table[i][j]=' ';
			}
		}
			
		System.out.println("************");
		System.out.println("Tic-Tac-Toe!");
		System.out.println("************");
		System.out.println("Please enter the column (A, B or C) and then the row (1, 2, or 3) of your move.");
		System.out.println(" ");
		
		printTable(Table);
		
		int count = 0;
		char winner = ' ';
		while (true) {
			
			playerMove();
			
			winner = checkWinner(Table);
			if(winner!=' ') {
				break;
			}
			count++;
			if(count == 9)
				break;
			
			printTable(Table);
			
			computerMove();
			
			winner = checkWinner(Table);
			if(winner!=' ') {
				break;
			}
			
			count++;
			
			printTable(Table); 
			
		}
		printTable(Table);
		
		//Ektupwsi nikiti	
		if(winner=='x') {
			System.out.println("You win!");
		}else if(winner=='o') {
			System.out.println("Computer wins!");
		}else
			System.out.println("It's a tie!");			
	}
	
	//Ektupwsi pinaka
	public static void printTable(char Table[][]) {
		
		System.out.println("   A   B   C");
		for (int i=0; i<3; i++) {
			System.out.print( i+1 +"| " );
			for (int j=0; j<3; j++) {
				System.out.print( Table[i][j] +" | " );
			}
			System.out.println();
		}
	}
	//Epilogi kinisis paikti
	public static void playerMove() {
		
		boolean flag=false;
		String move =" ";
		System.out.print("Player Move (X): ");
		Scanner input = new Scanner(System.in);
		move = input.nextLine();
		
		while(!flag) {
			//Elegxos eisodou
			if (move.equals("A1") ) {
				if (Table[0][0]==' ') {
					Table[0][0] = 'x';
					flag = true;
				}else
					System.out.println("The space entered is already taken.");
			}else if(move.equals("B1")) {
				if (Table[0][1]==' ') {
					Table[0][1] = 'x';
					flag = true;
				}else
					System.out.println("The space entered is already taken.");
			}else if(move.equals("C1")) {
				if (Table[0][2]==' ') {
					Table[0][2] = 'x';
					flag = true;
				}else
					System.out.println("The space entered is already taken.");
			}else if(move.equals("A2")) {
				if (Table[1][0]==' ') {
					Table[1][0] = 'x';
					flag = true;
				}else
					System.out.println("The space entered is already taken.");
			}else if(move.equals("B2")) {
				if (Table[1][1]==' ') {
					Table[1][1] = 'x';
					flag = true;
				}else
					System.out.println("The space entered is already taken.");
			}else if(move.equals("C2")) {
				if (Table[1][2]==' ') {
					Table[1][2] = 'x';
					flag = true;
				}else
					System.out.println("The space entered is already taken.");
			}else if(move.equals("A3")) {
				if (Table[2][0]==' ') {
					Table[2][0] = 'x';
					flag = true;
				}else
					System.out.println("The space entered is already taken.");
			}else if(move.equals("B3")) {
				if (Table[2][1]==' ') {
					Table[2][1] = 'x';
					flag = true;
				}else
					System.out.println("The space entered is already taken.");
			}else if(move.equals("C3")) {
				if (Table[2][2]==' ') {
					Table[2][2] = 'x';
					flag = true;
				}else
					System.out.println("The space entered is already taken.");
			}else
				System.out.println("Invalid Input: Please enter the column and row of your move (Example: A1).");
			if(!flag) {
				Scanner input2 = new Scanner(System.in);
				move = input2.nextLine();
			}
				
		}
	}
	//Tyxaia epilogi kinisis ypologisti
	public static void computerMove() {
		Random rand = new Random();
		boolean flag =true;
		String cMove = " ";
		int k = 99;
		int m = 99;
		
		while(flag) {
			k = rand.nextInt(3);
			m = rand.nextInt(3);
			flag =true;
			if (Table[k][m]==' ') {
				Table[k][m] = 'o';
				flag = false;
				
			}
		}
		if(Table[k][m]==Table[0][0]) {
			cMove = "A1";
		}else if(Table[k][m]==Table[0][1]){
			cMove = "B1";
		}else if(Table[k][m]==Table[0][2]){
			cMove = "C1";
		}else if(Table[k][m]==Table[1][0]){
			cMove = "A2";
		}else if(Table[k][m]==Table[1][1]){
			cMove = "B2";
		}else if(Table[k][m]==Table[1][2]){
			cMove = "C2";
		}else if(Table[k][m]==Table[2][0]){
			cMove = "A3";
		}else if(Table[k][m]==Table[2][1]){
			cMove = "B3";
		}else
			cMove = "C3";
		
		System.out.println("Computer Move (O): " + cMove);
	}
	//Elegxos gia nikiti
	public static char checkWinner(char Table[][]) {
		
		//Orizontia
		for(int i=0; i<3; i++) {
			if((Table[i][0]!=' ') && (Table[i][0]==Table[i][1]) && (Table[i][0]==Table[i][2])) {
				return Table[i][0];
			}
        }
		//Katheti
		for(int i=0; i<3; i++) {
			if((Table[0][i]!=' ') && (Table[0][i]==Table[1][i]) && (Table[0][i]==Table[2][i])) {
				return Table[0][i];
			}
		}
		//Diagwnia
		if((Table[0][0]!=' ') && (Table[0][0]==Table[1][1]) && (Table[1][1]==Table[2][2])) {
			return Table[0][0];
		}
		//Diagwnia
		if((Table[0][2]!=' ') && (Table[0][2]==Table[1][1]) && (Table[1][1]==Table[2][0])) {
			return Table[0][2];
		}
		
		return ' ';
	}
}
