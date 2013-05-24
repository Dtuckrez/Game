
package openspace.game.screens;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.button.builder.ButtonBuilder;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.TextRenderer;
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
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;

public class BaseScreen 
{
    SlickInputSystem inputSystems;
    Nifty gui;
    SoundDevice soundDevice;
    SlickRenderDevice renderDevice;
    InputSystem inputSystem;
    TimeProvider timeProvider;
    
    boolean isScreenActive;
    String screenName;
    
    //String text = textField.getText();
    public BaseScreen(GameContainer gc, String fileIn, String screen) throws SlickException
    {
        initGameAndGUI(gc);
        screenName = "start";
        gui.fromXml("src/openspace/MainState.xml","start");  
        gui.addControlsWithoutStartScreen();
    }
    
    public void useScreen()
    {
        isScreenActive = true;
        if(isScreenActive)
            gui.gotoScreen(screenName);
    }
    private Element getElement(final String id) 
    {
	return gui.getCurrentScreen().findElementByName(id);
        
    }
    
    public void updateScreen(GameContainer gc)
    {
        Input input = gc.getInput();
        inputSystems = new PlainSlickInputSystem();
//        
//        inputSystems.setInput(input);
//        input.addListener(inputSystems);
    }
    
    protected void initGameAndGUI(GameContainer gc) throws SlickException
    {
        renderDevice = new SlickRenderDevice(gc);
        soundDevice = new SlickSoundDevice();
        inputSystem = new SlickSlickInputSystem(new PlainSlickInputSystem());
        timeProvider = new LWJGLTimeProvider();
        gui = new Nifty(renderDevice, soundDevice, inputSystem, timeProvider);
    }
    
    public void drawScreen()
    {
        gui.render(true);
    }
}
