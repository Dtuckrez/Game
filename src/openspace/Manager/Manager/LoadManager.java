
package openspace.Manager.Manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import openspace.Config.Config;
import openspace.Sectors.SectorBase;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public final class LoadManager {
    Config config;
    
    public LoadManager() throws FileNotFoundException, SlickException{
        config = new Config("src/openspace/Config/Config.ini/");
        
        loadSectorBackdrops();
        loadSector();
    }
    
    public ArrayList loadSectorBackdrops() throws FileNotFoundException, SlickException{
        ArrayList<Image> backDrops = new ArrayList();
        Scanner scan = new Scanner(new File(config.getImageFolder()+"Sectors/Backdrops/Backdrops.ini"));
        int backdropAmount = scan.nextInt(); 
        for(int i = 0; i < backdropAmount; i++)
        {
            backDrops.add(new Image(config.getImageFolder()+"Sectors/Backdrops/" + String.valueOf(i) + ".png"));
        }
        return backDrops;
    }
    
    public ArrayList loadSector() throws FileNotFoundException, SlickException{
        ArrayList<SectorBase> sectorBases = new ArrayList();
        Scanner scan = new Scanner(new File(config.getSectorFolder()+"Sectors.ini"));
        int sectorAmount = scan.nextInt(); 
        for(int i = 0; i < sectorAmount; i++)
        {
            sectorBases.add(new SectorBase(config.getSectorFolder()+String.valueOf(i)+".ini", loadSectorBackdrops()));
        }
        return sectorBases;
    }
}
