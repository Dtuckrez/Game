
package openspace.game.screens.station;

import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class InformationPage 
{
    protected int order;
    protected boolean isActive;
    
    protected List<String> informationLines = new ArrayList<>();
    
    public InformationPage()
    {
        order = 0;
        isActive = false;
        informationLines.add("Name: Java Contole Center");
        informationLines.add("Hull: 1000/1000");
        informationLines.add("Shields 1000/1000");
        informationLines.add("Owner: Player");
        informationLines.add("Race: Human");
        informationLines.add("Ships: 0/1000");
    }
    
    public void draw(GameContainer gc, Graphics g)
    {
        g.translate(0, 0);
        g.setColor(Color.gray);
        g.fillRoundRect(gc.getWidth()-250,0,410,gc.getHeight(),8);
        drawInfoText(gc, g);
    }
    
    protected void drawInfoText(GameContainer gc, Graphics g)
    {
        for(int i = 0; i < informationLines.size(); i++)
        {
            g.setColor(Color.black);
            g.drawString(informationLines.get(i), gc.getWidth() -240, (i*15 + 25));
        }
    }
}
