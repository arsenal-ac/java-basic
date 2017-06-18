package com.yqc.js;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by yangqc on 2017/6/18.
 */
public class JsCalculate {

    public static void main(String[] args) {
        try {
            boolean result;
            FileReader fileReader = new FileReader("C:\\Users\\yangqc\\IdeaProjects\\java-basic\\src\\main\\resource\\thresholdCalculate.js");
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("javascript");
            Invocable invocableEngine = (Invocable) engine;
            String jsonValue = "{Humidity: 11,l:90,pp:90}";
            engine.eval(fileReader);
            System.out.println(invocableEngine.invokeFunction("expressionCalculate", "Humidity<12", jsonValue));
//            System.out.println(result);
        } catch (ScriptException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
