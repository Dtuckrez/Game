/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openspace.game.manager;

import java.util.ArrayList;
import openspace.game.objects.camera.BaseCamera;
import openspace.game.objects.sector.Sector.Sector;
import openspace.game.objects.ship.PlayerShip;
import openspace.game.screens.station.InformationPage;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Dean Tucker
 */
public class GameManager 
{
    /**
     * Has multiple as some are AI controlled 
     */
    ArrayList<PlayerShip> playerShips;
    InformationPage info;
    BaseCamera camera;
    Sector[] sectors;
    public GameManager(GameContainer gc)
    {
        initObjects();
        info = new InformationPage();
        camera = new BaseCamera();
    }
    
    private void initObjects()
    {
        initPlayerShips();
        initSectors();
    }
    
    private void initSectors()
    {
        sectors = new Sector[1];
        sectors[0] = new Sector("0", "test", "test", 600);
    }
    
    private void initPlayerShips()
    {
        playerShips = new ArrayList<>();
        
        // new game will give a human ship with scout class
        playerShips.add(new PlayerShip("", "human", "scout", 0, 0, new Vector2f(100,100)));
    }
    
    /*
     * get sectorToDraw from playersCurrentSector
     * this is draw first so it is not effected by the translate
     */
    
    public void update(GameContainer gc, int delta)
    {
        updatePlayerShips(gc, delta);
    }
    
    public void draw(GameContainer gc, Graphics g)
    {
        int sectorToDraw = -1;
        for(PlayerShip playerShip : playerShips)
        {
            if(playerShip.isPlayerControlled())
            {   
                sectorToDraw = playerShip.getSector();
                drawSectors(sectorToDraw, gc, g);
                camera.translate(gc, g, -playerShip.getPosition().x, -playerShip.getPosition().y);
                // draw game over if no human ship is found. TODO
            }       
        }
        drawSectorObjects(sectorToDraw, gc, g);
        drawPlayerShip();
        info.draw(gc, g);
    }
    
    public void drawSectors(int sectorToDraw, GameContainer gc, Graphics g)
    {
        sectors[sectorToDraw].drawSector(gc, g);
    }
    
    public void drawSectorObjects(int sectorToDraw, GameContainer gc, Graphics g)
    {
        sectors[sectorToDraw].drawSectorObjects(gc, g);
    }
    
    public void drawPlayerShip()
    {
        for(PlayerShip playership : playerShips)
        {
            playership.draw();
        }
    }
    
    public void updatePlayerShips(GameContainer gc, int delta)
    {
        for(PlayerShip playerShip : playerShips)
        {
            playerShip.move(gc, delta);
        }
    }
    
}
