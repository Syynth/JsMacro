package jsmacro;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 
 * @author Ben Cochrane
 */
public class Macro extends Thread {

    private RecordModel model;
    private ScriptEngine js;
    private String script;
    private SmartRobot robot;
    private JsBot jsbot;
    
    public Macro(File macro, RecordModel model) {
        BufferedReader br = null;
        this.model = model;
        try {
            br = new BufferedReader(new FileReader(macro));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            script = sb.toString();
            br.close();
            try {
                jsbot = new JsBot(new SmartRobot());
            } catch (AWTException ex) {
                Console.Log("Couldn't created the robot.");
            }
            js = new ScriptEngineManager().getEngineByName("JavaScript");
        } catch (FileNotFoundException ex) {
            Console.Log("Couldn't find the .js file.");
        } catch (IOException ex) {
            Console.Log("Oops! IOException in Macro constructor.");
        }finally {
            try {
                br.close();
            } catch (IOException | NullPointerException ex) {
                Console.Log("Failed to close the .js file stream.");
            }
        }
    }
    
    public RecordModel getModel() {
        return model;
    }

    @Override
    public void run() {
        try {
            js.put("data", model);
            js.put("bot", jsbot);
            js.put("keys", new JsKeys());
            js.put("window", this);
            js.eval(script);
        } catch (ScriptException ex) {
            Console.Log("There was an error in your macro file.");
            Console.Log(ex.toString());
        }
    }
    
    public void abort() {
        stop();
    }
    
    
    
}
