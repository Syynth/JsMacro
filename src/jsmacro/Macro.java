package jsmacro;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * 
 * @author Ben Cochrane
 */
public class Macro {

    private RecordModel model;
    private ScriptEngine js;
    private String script;
    private SmartRobot robot;
    
    public Macro(File macro, File model) {
        BufferedReader br = null;
        try {
            try {
                this.model = new RecordModel(model);
            } catch (FileNotFoundException ex) {
                Console.Log("Could not find .csv file.");
            } catch (IOException ex) {
                Console.Log("Could not open data file.");
            }
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
            js = new ScriptEngineManager().getEngineByName("JavaScript");
            try {
                robot = new SmartRobot();
            } catch (AWTException ex) {
                Console.Log("Couldn't created the robot.");
            }
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
    
}
