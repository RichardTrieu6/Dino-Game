import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Obstacle extends JPanel
{
	ImageIcon obstacles = new ImageIcon("Dino_game/obstacles.png");
	Random rand = new Random();
	int next_ob = rand.nextInt(7);
	int pter_width = 93;
	int pter_height = 80;
	int scacti_width = 34;
	int scacti_height = 70;
	int bcacti_width = 50;
	int bcacti_height = 100;
	int x = 2000;
	int y;
	int sprtX;
	int sprtY;
	Rectangle hb = new Rectangle();
	int speed;
	public void drawobstacle(Graphics g)
	{
		//Pteradactyl 
		if(next_ob == 0)
		{
			sprtX = 0;
			y = 480;
			g.drawImage(obstacles.getImage(),x,y,x+pter_width,y+pter_height,sprtX,sprtY,sprtX+pter_width,sprtY+pter_height,null);
			hb.setBounds(x,y,pter_width,pter_height);
		}
		//1 small cacti
		else if(next_ob == 1)
		{
			sprtX = 186;
			y = 580;
			g.drawImage(obstacles.getImage(),x,y,x+scacti_width,y+scacti_height,sprtX,sprtY,sprtX+scacti_width,sprtY+scacti_height,null);
			hb.setBounds(x,y,scacti_width,scacti_height);
		}
		//2 small cacti
		else if(next_ob == 2)
		{
			sprtX = 186;
			y = 580;
			g.drawImage(obstacles.getImage(),x,y,x+scacti_width*2,y+scacti_height,sprtX,sprtY,sprtX+scacti_width*2,sprtY+scacti_height,null);
			hb.setBounds(x,y,scacti_width*2,scacti_height);
		}
		//3 small cacti
		else if(next_ob == 3)
		{
			sprtX = 186;
			y = 580;
			g.drawImage(obstacles.getImage(),x,y,x+scacti_width*3,y+scacti_height,sprtX,sprtY,sprtX+scacti_width*3,sprtY+scacti_height,null);
			hb.setBounds(x,y,scacti_width*3,scacti_height);
		}
		//1 big cacti
		else if(next_ob == 4)
		{
			sprtX = 290;
			y = 550;
			g.drawImage(obstacles.getImage(),x,y,x+bcacti_width,y+bcacti_height,sprtX,sprtY,sprtX+bcacti_width,sprtY+bcacti_height,null);
			hb.setBounds(x,y,bcacti_width,bcacti_height);
		}
		//2 big cacti
		else if(next_ob == 5)
		{
			sprtX = 290;
			y = 550;
			g.drawImage(obstacles.getImage(),x,y,x+bcacti_width*2,y+bcacti_height,sprtX,sprtY,sprtX+bcacti_width*2,sprtY+bcacti_height,null);
			hb.setBounds(x,y,bcacti_width*2,bcacti_height);
		}
		//3 big cacti
		else if(next_ob == 6)
		{
			sprtX = 290;
			y = 550;
			g.drawImage(obstacles.getImage(),x,y,x+bcacti_width*3,y+bcacti_height,sprtX,sprtY,sprtX+bcacti_width*3,sprtY+bcacti_height,null);
			hb.setBounds(x,y,bcacti_width*3,bcacti_height);
		}

	}
	public void newObstacle()
	{
		next_ob = rand.nextInt(7);
		x = 2000;
	}
}
