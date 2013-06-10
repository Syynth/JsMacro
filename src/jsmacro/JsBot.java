package jsmacro;

import java.awt.event.KeyEvent;

/**
 *
 * @author Ben Cochrane
 */
public class JsBot {
    
    private SmartRobot bot;
    
    public JsBot(SmartRobot bot) {
        this.bot = bot;
    }
    
    public JsBot type(String s) {
        bot.type(s);
        return this;
    }
    
    public JsBot key(int c) {
        bot.keyPress(c);
        bot.keyRelease(c);
        return this;
    }
    
    public JsBot press(int c) {
        bot.keyPress(c);
        return this;
    }
    
    public JsBot release(int c) {
        bot.keyRelease(c);
        return this;
    }
    
}
