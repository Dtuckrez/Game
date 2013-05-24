
package openspace.game.demo.classes.level;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import openspace.game.demo.classes.level.astroids.AstroidBaseClass;
import openspace.game.demo.classes.level.ships.EnemyShip;
import openspace.game.demo.station.StationBassClass;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Level 
{
    //Background
    public int levelNumber;
    
    public String name;
    
    public EnemyShip[] enemyShips;
    public int shipCount;
    
    public StationBassClass[] stations;
    public int stationCount;
    
    public AstroidBaseClass[] astroids;
    public int astroidCount;
    
    
    public Level(int currentLevel) throws FileNotFoundException, SlickException
    {
        levelNumber = currentLevel;
        // gets attributes from parsed in file
        Scanner file = new Scanner(new File(
                "src/openspace/game/demo/files/levels/level_" 
                + String.valueOf(currentLevel)+".txt"));
        
        this.name= file.nextLine();
        
        shipCount = file.nextInt();
        this.enemyShips = new EnemyShip[shipCount];
        
        stationCount = file.nextInt();
        this.stations = new StationBassClass[stationCount];
        
        astroidCount = file.nextInt();
        this.astroids = new AstroidBaseClass[astroidCount];
        
        setUpShips();
        setUpAstroids();
        setUpStations();
    }
    
    public final void setUpShips() throws FileNotFoundException, SlickException
    {
        
        for(int i = 0; i < shipCount; i++)
        {
            //"src/openspace/Images/Ships/Human/" + String.valueOf(file.nextInt()) + ".png"
            enemyShips[i] = new EnemyShip("src/openspace/game/demo/files/levels/ships/level_" 
                    + String.valueOf(levelNumber) 
                    + "_ship_" 
                    + String.valueOf(shipCount)
                    + ".txt");
        }
    }
    
    public final void setUpAstroids() throws FileNotFoundException, SlickException
    {
        for(int i = 0; i < astroidCount; i++)
        {
            astroids[i] = new AstroidBaseClass("src/openspace/game/demo/files/levels/astroids/level_" 
                    + String.valueOf(levelNumber) 
                    + "_astroid_" 
                    + String.valueOf(shipCount)
                    + ".txt");
        }
    }
    
    public final void setUpStations() throws FileNotFoundException, SlickException
    {
        for(int i = 0; i < stationCount; i++)
        {
            stations[i] = new StationBassClass("src/openspace/game/demo/files/levels/stations/level_" 
                    + String.valueOf(levelNumber) 
                    + "_station_" 
                    + String.valueOf(stationCount)
                    + ".txt");
        }
    }
    
    public void runLevel(GameContainer gc, int delta){
        for(StationBassClass station : stations)
        {
            station.update(gc, delta);
        }
    }
    
    public void drawLevel(GameContainer gc, Graphics g)
    {
        drawAstroids(gc, g);
        drawStations(gc, g);
        drawShips(gc, g);
    }
    
    public void drawShips(GameContainer gc, Graphics g){
        for(EnemyShip enemy : enemyShips)
        {
            enemy.draw(gc, g);
        }
    }
    
    public void drawAstroids(GameContainer gc, Graphics g){
        for(AstroidBaseClass astroid : astroids)
        {
            astroid.draw(gc, g);
        }
    }
    
    public void drawStations(GameContainer gc, Graphics g){
        for(StationBassClass station : stations)
        {
            station.draw(gc, g);
        }
    }
}
