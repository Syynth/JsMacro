package jsmacro;

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
    
    public GlobalKeyListener(JsMacroWindow gui) {
        this.gui = gui;
    }
    
    public GlobalKeyListener register() {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.out.println("There was a problem registering the native hook;");
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
                break;
            case Running:
                gui.setMacroState(JsMacroWindow.State.Loading);
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