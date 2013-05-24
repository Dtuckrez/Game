/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openspace.game.objects.ship.core;

/**
 *
 * @author Dean Tucker
 */
public class BaseCore 
{
    int power;
    int maxShield;
    int shield;
    float recharge;
    
    public BaseCore(int power, int maxShield, int recharge)
    {
        this.power = power;
        this.maxShield = maxShield;
        this.recharge = recharge;
    }
}
