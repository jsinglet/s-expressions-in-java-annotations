import java.lang.reflect.Method;

/**
 * User: johnsingleton
 * Date: 9/19/12
 */
public class AnnotationExample {


    // define "fact"
    @SExpression(expr = "(defn fact [n] (if (<= n 1) 1 (* (fact (- n 1)) n)))")
    public void method1() {
        // do stuff
    }


    // note that "fact" stays in context, later...
    @SExpression(expr = "(fact 10)")
    public void method2() {
        // do stuff
    }

    @SExpression(expr = "(+ 1 2 3 4)")
    public void method3() {
        // do more stuff

        // this works in JDK 8
        @SExpression(expr = "(+ 1 2 3 4)")
        int interestingVariable;


    }

    /**
     * Shows how to consume the s-expressions
     *
     * @param args
     */
    public static void main(String args[]) {

        AnnotationExample target = new AnnotationExample();


        // consume all the method s-expressions
        for (Method m : target.getClass().getMethods()) {

            SExpression sExp = m.getAnnotation(SExpression.class);

            if (sExp != null) {
                System.out.println(ToSExpression.eval(sExp.expr()));
            }
        }


        // if JDK 8, consume local variable s-expressions, etc...
    }
}
