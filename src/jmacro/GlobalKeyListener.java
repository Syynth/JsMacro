package jmacro;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyListener implements NativeKeyListener {
    
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
                }
            }
            if (e.getKeyCode() == NativeKeyEvent.VK_F7) {
                if (macroData != null && activeMacro != null) {
                    activeMacro.pause();
                }
            }
            if (e.getKeyCode() == NativeKeyEvent.VK_F8) { 
                if (macroData != null && activeMacro != null) {
                    activeMacro.proceed();
                }
            }
            if (e.getKeyCode() == NativeKeyEvent.VK_F5 && canStart) {
                activeMacro = new Macro(macroData);
                activeMacro.start();
                canStart = false;
            }
        }
        @Override
        public void nativeKeyReleased(NativeKeyEvent e) { }
        @Override
        public void nativeKeyTyped(NativeKeyEvent e) { }
}