/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openspace.ParticleEngine;

import java.util.ArrayList;
import java.util.Random;
import openspace.Particle.BaseParticleClass;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Dean Tucker
 */
public class ParticleEngine {
    public Random random;
    public Vector2f emitterLocation;
    public Color particleColours;
    public int lifeTime;
    public boolean isActive;
    public ArrayList<BaseParticleClass> particles = new ArrayList<BaseParticleClass>();

    public ParticleEngine(Vector2f location){
        emitterLocation = location;
        
        this.particles = new ArrayList<>();
        
        this.particleColours = new Color(0.0f,0.2f,1f,0.07f);
        
        lifeTime = 25;
        
        isActive = true;
        
        random = new Random();
    }
    
    public void resetEngine(){
        this.particleColours = new Color(0.0f,0.2f,1f,0.7f);
        lifeTime = 25;
        isActive = true;
    }
        
    public BaseParticleClass GenerateNewParticle(){
        Vector2f position = emitterLocation;
        Vector2f velocity = new Vector2f(
                .2f * (float)(random.nextDouble() * 2 -1),
                .2f * (float)(random.nextDouble() * 2 -1));
        
        float size = (float)random.nextInt(8);
        int ttl = random.nextInt(lifeTime);
        
        return new BaseParticleClass(position, velocity, size, ttl);
    }
    
    public void update(){
        int total = 45;
        for(int i = 0; i < total; i++)
        {
            if(isActive)
            particles.add(GenerateNewParticle());
        }
        for(int j = 0; j < particles.size(); j++)
        {
            particles.get(j).update();
            if(particles.get(j).TTL <= 0)
            {
                particles.remove(j);
                j--;
            }
        }
    }
    
    public void setColor(float r, float g, float b){
    }
    
    public void draw(GameContainer gc, Graphics g){
        for(int i = 0; i < particles.size(); i++)
        {
            particleColours = this.particleColours = new Color(
                1f
                ,random.nextFloat()
                ,0.0f, 0.4f);
            g.setColor(particleColours);
            particles.get(i).draw(gc, g);
        }
    }
}