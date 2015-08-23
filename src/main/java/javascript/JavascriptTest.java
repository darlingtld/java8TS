package javascript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by darlingtld on 2015/8/23 0023.
 */
public class JavascriptTest {

    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        System.out.println(engine.getClass().getName());
        String js = "function f() {" +
                "        return 1; " +
                "   }; " +
                "   f() + 1;";

        System.out.println("Result:" + engine.eval("function f() { return 1; }; f() + 1;"));
    }
}
