
package openspace.Ships;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import openspace.ParticleEngine.ParticleEngine;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class ShipBaseClass {
    public Image image;
    public int shipID;
    public int raceID;
    public int classID;
    
    public Vector2f position;
    public float rotation;
    public float speed;
    public float maxSpeed;
    public float turnSpeed;
    public float currentRotation;
    
    public ParticleEngine particleEngine;
    
    public ShipBaseClass(String fileIn) throws FileNotFoundException, SlickException{
        Scanner file;
        file = new Scanner(new File(fileIn));
        raceID = file.nextInt();
        image = new Image("src/openspace/Images/Ships/Human/" + String.valueOf(file.nextInt()) + ".png");
        raceID = file.nextInt();
        classID = file.nextInt();
        
        particleEngine = new ParticleEngine(null);
    }
    
    public void draw(GameContainer gc, Graphics g){
        image.draw();
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getShipID() {
        return shipID;
    }

    public void setShipID(int shipID) {
        this.shipID = shipID;
    }

    public int getRaceID() {
        return raceID;
    }

    public void setRaceID(int raceID) {
        this.raceID = raceID;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public Vector2f getPosition() {
        return position;
    }

    public void setPosition(Vector2f position) {
        this.position = position;
    }

    public float getXPosition(){
        return position.getX();
    }
    
    public void setXPosition(float x){
        position.x = x;
    }
    
    public float getYPosition(){
        return position.getY();
    }
    
    public void setYPosition(float y){
        position.y = y;
    }
    
    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getTurnSpeed() {
        return turnSpeed;
    }

    public void setTurnSpeed(float turnSpeed) {
        this.turnSpeed = turnSpeed;
    }

    public float getCurrentRotation() {
        return currentRotation;
    }

    public void setCurrentRotation(float currentRotation) {
        this.currentRotation = currentRotation;
    }

    public ParticleEngine getParticleEngine() {
        return particleEngine;
    }

    public void setParticleEngine(ParticleEngine particleEngine) {
        this.particleEngine = particleEngine;
    }
    
    
}