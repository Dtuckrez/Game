package openspace;


import openspace.game.manager.GameManager;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public class Main extends BasicGame
{
    GameManager gameManager;
    
    public Main()
    {
        super("Open Space");
    }
 
    @Override
    public void init(GameContainer gc)throws SlickException 
    {
        gameManager = new GameManager(gc);
    }
    
    @Override
    public void update(GameContainer gc, int delta)throws SlickException
    {
        //gameManager.update(gc, delta);
    }
    
    @Override
    public void render(GameContainer gc, Graphics g)throws SlickException
    {
        gameManager.draw(gc,g);
    }
    
    public static void main(String[] args)throws SlickException
    {
        AppGameContainer app = new AppGameContainer(new Main());
        app.setDisplayMode(800, 600, false);
        app.setSmoothDeltas(false);
        app.setTargetFrameRate(60);
        //app.setShowFPS(true);
        app.start();
    }
}