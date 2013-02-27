package jmacro;

import java.awt.Color;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyListener implements NativeKeyListener {
    
        public GlobalKeyListener(MacroTyperWindow window) {
            macroWindow = window;
        }
        
        private MacroTyperWindow macroWindow;
        private MacroData macroData;
        private Macro activeMacro;
        private boolean canStart;
        
        public void linkData(MacroData macroData) {
            this.macroData = macroData;
        }
        
        public void setReadyToStart() {
            canStart = true;
        }
    
        @Override
        public void nativeKeyPressed(NativeKeyEvent e) {
            if (e.getKeyCode() == NativeKeyEvent.VK_F6) {
                if (macroData != null && activeMacro != null) {
                    activeMacro.abort();
                    canStart = false;
                    macroWindow.resetWindowColor();
                }
            }
            if (e.getKeyCode() == NativeKeyEvent.VK_F7) {
                if (macroData != null && activeMacro != null) {
                    activeMacro.pause();
                    macroWindow.setWindowColor(Color.yellow);
                }
            }
            if (e.getKeyCode() == NativeKeyEvent.VK_F8) { 
                if (macroData != null && activeMacro != null) {
                    activeMacro.proceed();
                    macroWindow.setWindowColor(Color.green);
                }
            }
            if (e.getKeyCode() == NativeKeyEvent.VK_F5 && canStart) {
                activeMacro = new Macro(macroData);
                activeMacro.start();
                canStart = false;
                macroWindow.setWindowColor(Color.green);
            }
        }
        @Override
        public void nativeKeyReleased(NativeKeyEvent e) { }
        @Override
        public void nativeKeyTyped(NativeKeyEvent e) { }
}