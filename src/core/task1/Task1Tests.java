package core.task1;

import java.lang.reflect.Method;

public class Task1Tests {
    public void runAllTests() {
        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method m: methods) {
            try {
                System.out.println("Running tests...");
                if (m.getReturnType() == boolean.class) {
                    boolean result = (boolean) m.invoke(this);
                    System.out.println(m.getName() + ": " + result);
                }
            } catch (Exception e) {
                System.out.println("Something went wrong during tests run: " + e.getMessage());
            }
        }
    }

    public boolean ifCaretakerIsEmptyItReturnsEmptyString() {
        CareTaker careTaker = new CareTaker();
        return careTaker.toString().isEmpty();
    }

    public boolean ifAppendSeveralStringsThenCaretakerReturnsThemAllInSingleString() {
        CareTaker careTaker = new CareTaker();
        careTaker.append("str1");
        careTaker.append("str2");
        return careTaker.toString().equals("str1str2");
    }

    public boolean ifUndoFirstStepThenCaretakerReturnsEmptyString() {
        CareTaker careTaker = new CareTaker();
        careTaker.append("str1");
        careTaker.undo();;
        return careTaker.toString().isEmpty();
    }

    public boolean ifUndoStepThenCaretakerReturnsPreviousState() {
        CareTaker careTaker = new CareTaker();
        careTaker.append("str1");
        careTaker.append("str2");
        careTaker.undo();;
        return careTaker.toString().equals("str1");
    }

    public boolean ifUndoTwiceFrom3AttemptsThenCaretakerReturnsStringAfterFirstAppend() {
        CareTaker careTaker = new CareTaker();
        careTaker.append("str1");
        careTaker.append("str2");
        careTaker.append("str3");
        careTaker.undo();
        careTaker.undo();

        return careTaker.toString().equals("str1");
    }
}
