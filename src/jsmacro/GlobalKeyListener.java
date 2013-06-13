package jsmacro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 * 
 * @author Ben Cochrane
 */
public class GlobalKeyListener implements NativeKeyListener {

    private JsMacroWindow gui;
    private Macro macro;
    
    public GlobalKeyListener(JsMacroWindow gui) {
        this.gui = gui;
    }
    
    public GlobalKeyListener register() {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            Console.Log("There was a problem registering native access the keyboard.");
            ex.printStackTrace();
            System.exit(1);
        }
        GlobalScreen.getInstance().addNativeKeyListener(this);
        return this;
    }
    
    private void toggleRun() {
        switch (gui.getMacroState()) {
            case Loading: break;
            case Ready:
                gui.setMacroState(JsMacroWindow.State.Running);
                macro = new Macro(new File(gui.getMacro()), gui.genModel());
                macro.run();
                gui.setMacroState(JsMacroWindow.State.Loading);
                break;
            case Running:
                gui.setMacroState(JsMacroWindow.State.Loading);
                macro.abort();
                macro = null;
                break;
        }
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {
        switch (nke.getKeyCode()) {
            case NativeKeyEvent.VK_F5: toggleRun(); break;
        }
    }
    @Override public void nativeKeyReleased(NativeKeyEvent nke) {}
    @Override public void nativeKeyTyped(NativeKeyEvent nke) {}
    
}
