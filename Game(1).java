import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Game extends JPanel implements KeyListener
{
	int run = 0;
	int score = 0;
	Dino dino = new Dino();
	Obstacle obstacle1 = new Obstacle();
	Obstacle obstacle2 = new Obstacle();
	Path path = new Path();
	Path path2 = new Path();
	int obstacle_speed = -8;
	boolean grounded = false;
    boolean S_Press = false;
    boolean W_Press = false;
	boolean lose = false;
    Rectangle ground = new Rectangle(0,650,1920,1000);
	Game()
	{
		super();
		super.setFocusable(true);
		super.addKeyListener(this);
	}
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.clearRect(0, 0, getWidth(), getHeight());
		g2.setColor(Color.GRAY);
		Font font = new Font("Dialog",Font.BOLD,50);
		g2.setFont(font);
		g2.drawString(Integer.toString(score),1700, 50);
		obstacle1.drawobstacle(g2);
		obstacle2.drawobstacle(g2);
		path.drawPath(g2);
		path2.drawPath(g2);
		dino.drawDino(g2);
	}
	@Override
    public void keyPressed(KeyEvent e)
    {
        //If statements to check which button is pressed
        if(e.getKeyCode()== KeyEvent.VK_S)
        {
          S_Press = true;
        }
        
        if(e.getKeyCode()== KeyEvent.VK_W)
        {
          W_Press = true;
        }
        
    }
    @Override
    public void keyReleased(KeyEvent e)
    {
      //If statements to check when the button gets released 
      if(e.getKeyCode()== KeyEvent.VK_S)
        {
          S_Press = false;
        }
        
        if(e.getKeyCode()== KeyEvent.VK_W)
        {
          W_Press = false;
        }
        
     
    } 
    @Override
    public void keyTyped(KeyEvent e)
    {
      
    } 
    public void update()
    {
		update_obstacle();
		sprite_ani();
		physics();
		check_lose();
		score++;
    	repaint();
		
    }
	public void sprite_ani()
	{
		dino.width = 93;
		dino.height = 100;
		dino.sprtY = 0;
		dino.hitbox.setBounds(dino.x+15,dino.y,dino.width-15,dino.height);
    	//Sprite animations
		if(grounded)
		{
			if(run <= 5)
			{
				dino.sprtX = 128;
				run++;
			}
			else if(run >= 5)
			{
				dino.sprtX = 256;
				run++;
			}
			if(run == 10)
			{
				run = 0;
			}
		}
		
		path.x = path.x + obstacle_speed;
		path2.x = path2.x + obstacle_speed;
		path2.x = path.x+2400;
		if(path.x<-2400)
		{
			path.x = 0;
		}
		
	}
	public void physics()
	{
		if(dino.hitbox.intersects(ground))
		{
			dino.y = 550;
			dino.speed_y = 0;
			grounded = true;
		}
    	if(W_Press)
    	{
			dino.sprtY = 0;
			dino.sprtX = 0;
			if(grounded)
			{
				dino.jump();
				grounded = false;
				W_Press = false;
			}
			dino.hitbox.setBounds(dino.x+15,dino.y,dino.width-15,dino.height);
			W_Press = false;
    	}
    	if(S_Press)
    	{
    		if(grounded)
    		{
				dino.sprtY = 40;
				dino.y = 590;
				dino.width = 127;
				dino.height= 127;
    			if(run <= 5)
    			{
    				dino.sprtX = 477;
    			}
    			else if(run >= 5)
    			{
    				dino.sprtX = 604;
    			}
    			dino.hitbox.setBounds(dino.x+15,dino.y,dino.width-15,dino.height);
    		}
    			
    		else
    			dino.speed_y++;	
    	}
		if(!(grounded && lose))
			dino.gravity();
		dino.hitbox.setLocation(dino.x,dino.y);
	}
	public void update_obstacle()
	{
		obstacle1.x = obstacle1.x +obstacle_speed;
		if(score > 100)
			obstacle2.x = obstacle2.x + obstacle_speed;
		if(obstacle1.x<-100)
			obstacle1.newObstacle();
		if((score%100)==0)
			obstacle_speed--;
		if(score<1500)
		{
			if(obstacle2.x<-100 && (score%100)==0)
				obstacle2.newObstacle();
		}
		else if(score>1000)
		{
			obstacle2.y = 1000;
			obstacle2.hb.setLocation(obstacle2.x,1000);
		}
	}
	public void check_lose()
	{
		if(dino.hitbox.intersects(obstacle1.hb) || dino.hitbox.intersects(obstacle2.hb))
		{
			if(grounded)
				dino.y = 550;  
			dino.sprtX = 384;
			dino.sprtY = 0;
			dino.width = 93;
			dino.height = 100;
			dino.speed_y = 0;
			repaint();
			if(!(lose))
			{
				JOptionPane.showConfirmDialog(null,"Reset?","MESSAGE",JOptionPane.DEFAULT_OPTION);
				obstacle1.hb.setLocation(2000,obstacle1.y);
				obstacle1.hb.setLocation(2000,obstacle2.y);
				obstacle1.newObstacle();
				obstacle2.newObstacle();
				obstacle_speed = -7;
				obstacle1.x = 2000;
				dino.y = 550;
				grounded = true;
				S_Press = false;
				W_Press = false;
				score = 0;
				lose = false;
			}
		}
	}
}
