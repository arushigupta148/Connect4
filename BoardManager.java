package model;

import javax.swing.JOptionPane;

public class BoardManager{
	
	Board b;
	int input;
	int winner;
	int player;
	protected boolean playerFlag;
	Validation v;
	protected String player1name;
	protected String player2name;
	Runnable r1;
	static Thread timer;
	
	
	public BoardManager(Board b) {
		
		this.b = b;
		startManager();
	}
	
	public BoardManager() {
		
	}
	
	// set up the column that has been clicked 
	public void setColumnNum(int col) {
		this.input=col;
		validate();
	}
	
	public int getColumnNum() {
		return input;
	}

	
	public void startManager() {
		
		player = 1;
		v = new Validation(b);
		winner = 0;
		playerFlag = true;
		
	}
	
	// validate the move
	public void validate() {

		//System.out.println("playerFlag here " + playerFlag);
		if (winner == 0 || winner == 99 && !v.checkBoardFull()) {
			if(winner != 99)
			{
				if (playerFlag) {
					player = 1;
					playerFlag = false;
				} else {
					player = 2;
					playerFlag = true;
				}
				b.setPlayer(player);
			}
			input = getColumnNum();
			winner = v.updateMove(input, player);
			System.out.println("winner "+winner);
			if(winner == 1 || winner == 2) {
				replay(winner);
			}
		}
		if (v.checkBoardFull()) {
			System.out.println("board is full");
			replay(99);
		}
		
	}
	
//	public void getinputs(String inp) {
//		//System.out.println(inp);
//	}
	
	// set up players names
	public void setPlayerName(String player1name, String player2name) {
		this.player1name = player1name;
		this.player2name = player2name;
		//System.out.println(player1name + " " + player2name);
	}

	
	// replay the game 
	public void replay(int winner) {
//		System.out.println(player1name);
//		System.out.println(player2name);

		String msg = "";
		if (winner == 99) {
			msg = "Board is Full!";
		} else if (winner == 1){
			if (player1name == null || player1name.equals("null")) player1name = "";
			msg = "Player1 " + player1name + " wins!";
		} else if (winner == 2){
			if (player2name == null ||player2name.equals("null")) player2name = "";
			msg = "Player2 " + player2name + " wins!";
		}
		msg += " Do you want to play again?";
		Object[] choice= {"YES","QUIT"};
		int n = JOptionPane.showOptionDialog(null,
                msg,
                null, JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                choice,
                choice[0]);
		if(n == 0) {
			Main.start();
//			b.initialize();
//			b.createBoard();
			//b.reset();
		} else {
			System.exit(0);
		}
	}
	
	
	
	public boolean getCurrentPlayer() {
		System.out.println("Playerflag :" + playerFlag);
		return playerFlag;
	}
	
}