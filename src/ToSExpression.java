import clojure.lang.Compiler;
import clojure.lang.RT;
import clojure.lang.Var;

import java.io.StringReader;

/**
 * User: johnsingleton
 * Date: 9/19/12
 */

public class ToSExpression {

    public static final String evalFunction = "(ns example) (defn doval [expr] (eval (read-string expr)))";

    public static Object eval(String expr) {

        Compiler.load(new StringReader(evalFunction));

        return RT.var("example", "doval").invoke(expr);
    }
}
