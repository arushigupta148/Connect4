package model;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.Dimension;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Component;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class Board extends JFrame{

	Board b;
	private int player;
	JPanel Boardpanel;
	static JLayeredPane layeredBoard;
	static JLayeredPane layeredGameBoard;
	int[][] matrix = new int[6][7];
	int row, col;
	BoardManager bm;
	String player1name, player2name;
	Runnable r1;
	Thread timer;
	JPanel panel;
	JLabel Label;
	JLabel P1Label, P2Label;
	JFrame frame;
	
	JButton button1, button2, button3, button4, button5, button6, button7;
	int currPlayerNum;
	JTextField jTextFieldTime = new JTextField();
	
	public Board(Board b) {
			this.b = b;
			bm = new BoardManager(b);
			layeredBoard = createLayeredBoard();
			wel();
			initialize();
			createBoard();
	}
	
	public Board() {
		
		
		
//		super();
//		System.out.println("Board constructor without parameter:"+b);

	}
	
//	public void reset() {
//		matrix = new int[6][7];
//		bm = new BoardManager(b);
//		layeredBoard = createLayeredBoard();
//		wel();
//		initialize();
//		createBoard();
//		
//	}
	
	// pop up window to enter players' names and start the game
	public void wel(){
        player1name = JOptionPane.showInputDialog(null, "Enter Player1's name", null);
        player2name = JOptionPane.showInputDialog(null, "Enter Player2's name", null);
        bm.setPlayerName(player1name, player2name);
        timer = new Thread(r1);
        timer.start();
	}
	

	// set up the game window
	public void initialize() {
		
		
		if (frame != null) frame.dispose();
		frame = new JFrame("Connect 4");
		P1Label = new JLabel("Player 1: " + player1name);
		P2Label = new JLabel("Player 2: " + player2name);
		P1Label.setBounds(120, 620, 100, 20);
		P2Label.setBounds(350, 620, 100, 20);
		frame.getContentPane().add(P1Label);
		frame.getContentPane().add(P2Label);
		
		JLabel labelHeader = new JLabel("Welcome to Connect 4!");
		labelHeader.setBounds(200, 0, 300, 100);
		frame.getContentPane().add(labelHeader);
		
		panel = new JPanel();
		panel.setBounds(21, 679, 954, 20);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		
		
		
		
//		jTextFieldTime = new JTextField();
//		jTextFieldTime.setEditable(true);
//		jTextFieldTime.setBounds(156, 23, 130, 26);
//		frame.getContentPane().add(jTextFieldTime);
//		jTextFieldTime.setColumns(10);
//		
		

		frame.setBounds(300, 50, 560, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

	}
	
	
	public static JLayeredPane createLayeredBoard() {
		layeredGameBoard = new JLayeredPane();
		layeredGameBoard.setPreferredSize(new Dimension(800, 670));
		
	
		ImageIcon imageBoard = new ImageIcon(ResourceLoader.load("Images/Board.gif"));
		JLabel imageBoardLabel = new JLabel(imageBoard);

		imageBoardLabel.setBounds(20, 20, imageBoard.getIconWidth(), imageBoard.getIconHeight());
		layeredGameBoard.add(imageBoardLabel, new Integer (0), 1);
		return layeredGameBoard;
	}
			
			
	public void createBoard() {
		Boardpanel = new JPanel();
		Boardpanel.setBounds(10, 120, 768, 547);
		Boardpanel.add(layeredGameBoard);
		frame.getContentPane().add(Boardpanel);
		
		button1 = new JButton("1");
		button1.setBounds(10, 88, 80, 35);
		frame.getContentPane().add(button1);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				currPlayerNum = bm.getCurrentPlayer() ? 1 : 2;
				System.out.println("inside button 1: "+currPlayerNum);
				
				Runnable r1 = new Time(currPlayerNum);
				timer.interrupt();
				timer = new Thread(r1);
				timer.start();

				columnButtonAction(0);
			}
		});
		
		button2 = new JButton("2");
		button2.setBounds(86, 88, 80, 35);
		frame.getContentPane().add(button2);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				currPlayerNum = bm.getCurrentPlayer() ? 1 : 2;
				System.out.println("inside button 2: "+currPlayerNum);
				
				Runnable r1 = new Time(currPlayerNum);
				timer.interrupt();
				timer = new Thread(r1);
				timer.start();
				columnButtonAction(1);
			}
		});
	
		button3 = new JButton("3");
		button3.setBounds(161, 88, 80, 35);
		frame.getContentPane().add(button3);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				currPlayerNum = bm.getCurrentPlayer() ? 1 : 2;
				System.out.println("inside button 3: "+currPlayerNum);
				
				Runnable r1 = new Time(currPlayerNum);
				timer.interrupt();
				timer = new Thread(r1);
				timer.start();
				columnButtonAction(2);
			}
		});
	
		button4 = new JButton("4");
		button4.setBounds(237, 88, 80, 35);
		frame.getContentPane().add(button4);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				currPlayerNum = bm.getCurrentPlayer() ? 1 : 2;
				System.out.println("inside button 4: "+currPlayerNum);
				
				Runnable r1 = new Time(currPlayerNum);
				timer.interrupt();
				timer = new Thread(r1);
				timer.start();
				columnButtonAction(3);
			}
		});
	
		button5 = new JButton("5");
		button5.setBounds(313, 88, 80, 35);
		frame.getContentPane().add(button5);
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				currPlayerNum = bm.getCurrentPlayer() ? 1 : 2;
				System.out.println("inside button 5: "+currPlayerNum);
				
				Runnable r1 = new Time(currPlayerNum);
				timer.interrupt();
				timer = new Thread(r1);
				timer.start();
				columnButtonAction(4);
			}
		});
	
		button6 = new JButton("6");
		button6.setBounds(389, 88, 80, 35);
		frame.getContentPane().add(button6);
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				currPlayerNum = bm.getCurrentPlayer() ? 1 : 2;
				System.out.println("inside button 6: "+currPlayerNum);
				
				Runnable r1 = new Time(currPlayerNum);
				timer.interrupt();
				timer = new Thread(r1);
				timer.start();
				columnButtonAction(5);
			}
		});
	
		button7 = new JButton("7");
		button7.setBounds(465, 88, 80, 35);
		frame.getContentPane().add(button7);
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				currPlayerNum = bm.getCurrentPlayer() ? 1 : 2;
				System.out.println("inside button 7: "+currPlayerNum);
				
				Runnable r1 = new Time(currPlayerNum);
				timer.interrupt();
				timer = new Thread(r1);
				timer.start();
				columnButtonAction(6);
			}
		});
		
	}
	
	
	// set up the column which the player clicks
	public void columnButtonAction(int colNum) {
		bm.setColumnNum(colNum);
	}

	
	public void display(int i, int p) {
		
		//System.out.println(bm);
		//boolean currPlayer = bm.getCurrentPlayer();
		
		//System.out.println(currPlayerNum);
//		int currPlayerNum = currPlayer? 1 : 2;
		//System.out.println("in display: "+currPlayerNum);
		
		//timer expires
//		System.out.println("text: "+ jTextFieldTime.getText());
		jTextFieldTime.setText("" + i);
		
		
		if (i == 0) {
			System.out.println("time is 0: "+ p);
			
			
			
//			if (p == 1) {
//				
//				BoardManager bmm = new BoardManager();
//				System.out.println(bmm);
//				bmm.replay(1);
//				
//			} else if (p == 2) {
//				BoardManager bmm = new BoardManager();
//				System.out.println(bmm);
//			
//				bmm.replay(2);
//			}	
			
			BoardManager bmm = new BoardManager();
			System.out.println(bmm);
			bmm.replay(p);
			
		} else {
			
			System.out.println("time: "+i + "; player " + p);
		}
		
	}

	public void placeChecker(int player, int row, int col) {
		
		setPlayer(player);
		String color;
		if (player == 1) color = "RED";
		else color = "YELLOW";
		int xOffset = 75 * col;
		int yOffset = 75 * row;
		ImageIcon checkerIcon = new ImageIcon(ResourceLoader.load("Images/" + color + ".gif"));
		JLabel checkerLabel = new JLabel(checkerIcon);
		checkerLabel.setBounds(27 + xOffset, 27 + yOffset, checkerIcon.getIconWidth(), checkerIcon.getIconHeight());
		layeredGameBoard.add(checkerLabel, new Integer(0), 0);
		paint(getGraphics());
	}

	public void setPlayer(int player) {
		this.player=player;
		
	}
	int getPlayer() {
		return player;
	}
}