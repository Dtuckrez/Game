/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openspace.ParticleEngine;

import openspace.Particle.BaseParticleClass;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Dean Tucker
 */
public class BoltProjectileParticleEngine extends ParticleEngine{
    int lifeTime;
    int size;
    Color color;
    
    public BoltProjectileParticleEngine(Vector2f location, int lifeTime,
            int size, Color color){
        super(location);
        this.lifeTime = lifeTime;
        this.size = size;
        this.color = color;
    }
        
    @Override
    public BaseParticleClass GenerateNewParticle(){
        Vector2f position = emitterLocation;
        Vector2f velocity = new Vector2f(
                .2f * (float)(random.nextDouble() * 2 -1),
                .2f * (float)(random.nextDouble() * 2 -1));
        
        float outSize = (float)random.nextInt(size);
        int ttl = random.nextInt(lifeTime);
        
        return new BaseParticleClass(position, velocity, outSize, ttl);
    }
    
    @Override
    public void draw(GameContainer gc, Graphics g){
        for(int i = 0; i < particles.size(); i++)
        {
            g.setColor(color);
            particles.get(i).draw(gc, g);
        }
    }
}