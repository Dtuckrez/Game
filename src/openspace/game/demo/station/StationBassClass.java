
package openspace.game.demo.station;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class StationBassClass {
    Image lower;
    Image mid;
    Image trans;
    Image upper;
    
    float upperRotation;
    float lowerRotation;
    
    Vector2f position;
    //ArrayItems[]
    //ArrayItemsEquiped
    
    public StationBassClass(String fileIn) throws FileNotFoundException, SlickException{
        Scanner file = new Scanner(new File(fileIn));
        
        int imageNumber = file.nextInt();
        
        this.lower = new Image("src/openspace/Images/Station/Human/" + 
                String.valueOf(imageNumber) + 
                "_lower.png");
        this.mid = new Image("src/openspace/Images/Station/Human/" + 
                String.valueOf(imageNumber) + 
                "_mid.png");
        this.trans = new Image("src/openspace/Images/Station/Human/" + 
                String.valueOf(imageNumber) + 
                "_trans.png");
        this.upper = new Image("src/openspace/Images/Station/Human/" + 
                String.valueOf(imageNumber) + 
                "_upper.png");
        
        position = new Vector2f(file.nextFloat(),file.nextFloat());
    }
    
    public void update(GameContainer gc, int delta){
        rotateStation(gc, delta);
    }
    
    public void rotateStation(GameContainer gc, int delta){
        upperRotation -= 0.04f;
        if(upperRotation < 0)
            upperRotation = 360;
        if(upperRotation > 360)
            upperRotation = 0;
        
        lowerRotation += 0.04f;
        if(lowerRotation < 0)
            lowerRotation = 360;
        if(lowerRotation > 360)
            lowerRotation = 0;
    }
    
    public void draw(GameContainer gc, Graphics g){
        drawLower(gc,g);
        drawUpper(gc, g);
        drawTrans(gc, g);
        
    }
    
    public void drawUpper(GameContainer gc, Graphics g){
        upper.setCenterOfRotation(upper.getWidth()/2, upper.getHeight()/2);
        upper.setRotation(upperRotation);
        upper.draw(position.x, position.y);
    }
    
    public void drawLower(GameContainer gc, Graphics g){
        lower.setCenterOfRotation(lower.getWidth()/2, lower.getHeight()/2);
        lower.setRotation(lowerRotation);
        lower.draw(position.x, position.y);
    }

    public void drawTrans(GameContainer gc, Graphics g){
        trans.setCenterOfRotation(lower.getWidth()/2, lower.getHeight()/2);
        trans.draw(position.x, position.y);
    }
}
    