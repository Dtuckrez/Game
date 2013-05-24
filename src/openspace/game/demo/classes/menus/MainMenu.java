
package openspace.game.demo.classes.menus;

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

public class MainMenu 
{
    Nifty gui;
    SoundDevice soundDevice;
    SlickRenderDevice renderDevice;
    InputSystem inputSystem;
    TimeProvider timeProvider;
    
    public MainMenu(GameContainer gc)
    {
        SlickInputSystem inputSystems = new PlainSlickInputSystem();
        Input input = gc.getInput();
        inputSystems.setInput(input);
        input.addListener(inputSystems);
        initGameGui(gc);
    }
    
    public void initGameGui(GameContainer gc)
    {
        renderDevice = new SlickRenderDevice(gc);
        soundDevice = new SlickSoundDevice();
        inputSystem = new SlickSlickInputSystem(new PlainSlickInputSystem());
        timeProvider = new LWJGLTimeProvider();
        gui = new Nifty(renderDevice, soundDevice, inputSystem, timeProvider);
    }
    
    public void RenderGUI(GameContainer gc, Graphics g)
    {
        g.translate(0,0);
    }
}
