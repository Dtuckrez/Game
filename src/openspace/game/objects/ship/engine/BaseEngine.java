/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openspace.game.objects.ship.engine;

/**
 *
 * @author Dean Tucker
 */
public class BaseEngine 
{
    protected float acceleration;
    protected float maxSpeed;
    protected float turnSpeed;
    
    public BaseEngine(float acceleration, float maxSpeed, float turnSpeed)
    {
        this.acceleration = acceleration;
        this.maxSpeed = maxSpeed;
        this.turnSpeed = turnSpeed;
    }

    public float getAcceleration() 
    {
        return acceleration;
    }

    public void setAcceleration(float acceleration) 
    {
        this.acceleration = acceleration;
    }

    public float getMaxSpeed() 
    {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) 
    {
        this.maxSpeed = maxSpeed;
    }
    
    
    
}
