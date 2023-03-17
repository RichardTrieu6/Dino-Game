import java.awt.Graphics;
import javax.swing.*;
public class Path extends JPanel
{
    int x = 0;
    int y = 630;
    int sprtX = 0;
    int sprtY = 102;
    int height = 24;
    int width = 2400;
    ImageIcon path = new ImageIcon("Dino_game/obstacles.png");
    public void drawPath(Graphics g)
    {
        g.drawImage(path.getImage(), x, y, x+width, y+height, sprtX, sprtY, sprtX+width, sprtY+height, null);
    }
}
