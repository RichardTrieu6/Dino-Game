import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;
public class Dino extends JPanel 
{
	protected ImageIcon image;
	int x = 100;
	int y = 0;
	boolean jumping = false;
	int sprtX = 0;
	int sprtY = 0;
	int width = 93;
	int height = 100;
	int speed_y = 4;
	
	Rectangle hitbox = new Rectangle(x+15,y,width-15,height);
	public void gravity()
	{
			speed_y++;
			y = y+speed_y;
	}
	public void jump()
	{
		speed_y = -20;
		speed_y++;
		y = y + speed_y;
	}
	public Dino()
	{
		image = new ImageIcon("Dino_game/Dino.png");
	}
	public void drawDino(Graphics g)
	{
		g.drawImage(image.getImage(), x, y, x+width, y+height, sprtX, sprtY, sprtX+width, sprtY+height, null);
	}
}

