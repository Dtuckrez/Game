
package openspace.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Config {
    String sectorFolder;
    String imageFolder;
    
    public Config(String file) throws FileNotFoundException{
        Scanner scan = new Scanner(new File(file));
        sectorFolder = scan.next();
        imageFolder = scan.next();
    }
    
    public String getSectorFolder(){
        return sectorFolder;
    }
    
    public String getImageFolder(){
        return imageFolder;
    }
}
