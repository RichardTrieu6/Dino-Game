import javax.swing.*;
class Main 
{
	public static void main(String args[])
	{
		JFrame window = new JFrame("PO");
		window.setSize(1920,700);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Game game = new Game();
	    window.add(game);
	    window.setVisible(true);
	    while(true)
	    {
	    	try
	    	{
	    		game.update();
	    		Thread.sleep(15);
	    	}
	    	catch(InterruptedException e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
	}
}
