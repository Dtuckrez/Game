package openspace.game.demo.classes.gamestates;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.slick2d.input.PlainSlickInputSystem;
import de.lessvoid.nifty.slick2d.input.SlickInputSystem;
import de.lessvoid.nifty.slick2d.input.SlickSlickInputSystem;
import de.lessvoid.nifty.slick2d.render.SlickRenderDevice;
import de.lessvoid.nifty.slick2d.sound.SlickSoundDevice;
import de.lessvoid.nifty.slick2d.time.LWJGLTimeProvider;
import de.lessvoid.nifty.spi.input.InputSystem;
import de.lessvoid.nifty.spi.sound.SoundDevice;
import de.lessvoid.nifty.spi.time.TimeProvider;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;



public class TestState1 extends BasicGameState 
{
   public static final int ID = 1;
   
    Nifty gui;
    SoundDevice soundDevice;
    SlickRenderDevice renderDevice;
    InputSystem inputSystem;
    TimeProvider timeProvider;
   
   @Override
   public int getID(){
      return ID;
   }
   
   @Override
   public void init(GameContainer gc, StateBasedGame game) throws SlickException{
       SlickInputSystem inputSystem = new PlainSlickInputSystem();
       Input input = gc.getInput();
       inputSystem.setInput(input);
       input.addListener(inputSystem);
       initGameAndGUI(gc);
       gui.addXml("src/openspace/MainState.xml");
   }
   
   @Override
   public void render(GameContainer container, StateBasedGame game, Graphics g){
       gui.render(true);
   }

   @Override
   public void update(GameContainer container, StateBasedGame game, int delta){
   }

    
    protected void initGameAndGUI(GameContainer gc) throws SlickException{
        renderDevice = new SlickRenderDevice(gc);
        soundDevice = new SlickSoundDevice();
        inputSystem = new SlickSlickInputSystem(new PlainSlickInputSystem());
        timeProvider = new LWJGLTimeProvider();
        gui = new Nifty(renderDevice, soundDevice, inputSystem, timeProvider);
    }
}