
package openspace.Manager.Manager;

import java.io.FileNotFoundException;
import openspace.Sectors.SectorBase;
import openspace.Weapons.Projectile.BulletBaseClass;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class GameManager {
    
    LoadManager loadManager;
    SectorBase[] sectors;
    
    public GameManager() throws FileNotFoundException, SlickException{
        loadManager = new LoadManager();
        sectors = new SectorBase[loadManager.loadSector().size()];
        loadManager.loadSector().toArray(sectors);
    }
    
    public void drawSector(int sectorToDraw, GameContainer gc, Graphics g){
        sectors[sectorToDraw].drawSector(gc, g);
    }
    public void drawSectorAstroids(int sectorToDraw, GameContainer gc, Graphics g){
        sectors[sectorToDraw].drawSectorAstroids(gc, g);
    }
    public void destroyAstroids(int sectorToDraw,BulletBaseClass[] bullet){
        sectors[sectorToDraw].hitAstroids(bullet);
    }
}
    