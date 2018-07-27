package model;

public class Time implements Runnable{

	Board b2=new Board();
	int p;
	
	public Time(int player) {
		// TODO Auto-generated constructor stub
		this.p=player;
		//System.out.println("time in Time.java: " + p);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.runTime();
		
	}

	private void runTime() {
		// TODO Auto-generated method stub
		//p=b2.getPlayer();

		int i = 5;	
		boolean run = true;
		
		while(i >= 0 && run){
			//System.out.println(i);
			try {
				System.out.println(b2);
				b2.jTextFieldTime.setText("Hello");
				b2.display(i,p);
				i--;
				Thread.sleep(1000L);
			} catch (InterruptedException e){
				System.out.println("Interrupt");
				run=false;
			}
		}
	}
	
}