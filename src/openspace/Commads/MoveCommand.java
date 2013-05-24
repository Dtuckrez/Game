
package openspace.Commads;

import openspace.Ships.NPCShip;
import openspace.Ships.PlayerShip;
import org.newdawn.slick.geom.Vector2f;

public class MoveCommand {
    
    int sectorIndex;
    float xPos;
    float yPos;
    int StationTypeIndex;
    int stationIndex;
    public boolean hasBeenExecuted;
    
    public MoveCommand(){
        
    }
    
    public void moveToLocationInSector(NPCShip shipIn, int sectorIndex, float xPos, float yPos, int delta){
        if(!hasBeenExecuted){
            if(rotate(shipIn, xPos, yPos, delta))
            {
                if(shipIn.position.x + shipIn.image.getWidth() / 2 != xPos && shipIn.position.y +shipIn.image.getHeight() / 2 != yPos)
                {
                    shipIn.speed = 0.02f;
                    float angle = shipIn.speed * delta;
                    shipIn.position.x+= angle * Math.sin(Math.toRadians(shipIn.rotation));
                    shipIn.position.y-= angle * Math.cos(Math.toRadians(shipIn.rotation));
                }
                else
                {
                    hasBeenExecuted = true;
                }
            }
                
        }
    }
    
    public boolean rotate(NPCShip shipIn, float xPos, float yPos, int delta){
                Vector2f ship;
                Vector2f target;
              
                ship = new Vector2f(shipIn.position.x, shipIn.position.y);
                target = new Vector2f(xPos, yPos);
                target.sub(ship);
                float finalRotation = (int) target.getTheta();
                                               
                if(!(shipIn.currentRotation <= finalRotation + 1 && shipIn.currentRotation >= finalRotation - 1))
                {
                    double tempVal;
                    if(shipIn.currentRotation  < finalRotation)
                    {
                        tempVal = finalRotation - shipIn.currentRotation;

                        if(tempVal > 180)
                        {
                            shipIn.currentRotation-=shipIn.turnSpeed*delta;
                        }
                        else if(tempVal < 180)
                        {
                            shipIn.currentRotation+=shipIn.turnSpeed*delta;
                        }
                        else if(tempVal == 180)
                        {
                        }
                    }
                    else if(shipIn.currentRotation > finalRotation)
                    {
                        tempVal = shipIn.currentRotation - finalRotation;
                        if(tempVal < 180)
                        {
                            shipIn.currentRotation-=shipIn.turnSpeed*delta;
                        }
                        else
                        {
                            shipIn.currentRotation+=shipIn.turnSpeed*delta;
                        }
                    }
                }
                else
                {
                    return true;
                }
                if(shipIn.currentRotation < 0)
                    shipIn.currentRotation = 359;

                if(shipIn.currentRotation > 360)
                    shipIn.currentRotation = 1;
                shipIn.rotation = ((int) (shipIn.currentRotation+90));
                return false;
           }
}
