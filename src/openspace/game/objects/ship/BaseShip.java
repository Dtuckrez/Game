/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openspace.game.objects.ship;

import java.util.logging.Level;
import java.util.logging.Logger;
import openspace.game.objects.ship.core.BaseCore;
import openspace.game.objects.ship.engine.BaseEngine;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Dean Tucker
 */
public class BaseShip 
{
    //Ship Related Atributes
    protected Image image;
    protected String name;
    protected String race;
    protected String type;
    protected int weaponBayAmount;
    // WeaponBay[] weapon Bay.. contains weapon
    // Cargo[] cargo; // every item has a type...
     protected BaseEngine engine;
     protected BaseCore core;
     //Core core;
     //Engine engine;
    
    // Ship stats
    protected int hull;
    protected int maxHull;
    protected float rotation;
    protected Vector2f position;
    
    public BaseShip(String name, String race, String type, int weaponBayAmount,
            int hull, Vector2f position)
    {
        this.name = name;
        this.race = race;
        this.type = type;
        this.weaponBayAmount = weaponBayAmount;
        this.hull = hull;
        this.position = position;
        
        loadImage(this.race, this.type);
        engine = new BaseEngine(00.2f, 1f, 1f);
        core = new BaseCore(0, 0, 0);
    }
    
    private void loadImage(String race, String type)
    {
        try 
        {
            image = new Image("src/openspace/game/images/ships/"+race+"/"+type+".png");
        } 
        catch (SlickException ex) 
        {
            Logger.getLogger(BaseShip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public void draw()
   {
       image.draw();
   }
    
}
