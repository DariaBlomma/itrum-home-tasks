package tests;

import java.lang.reflect.Method;

public interface Testable {
    default void runAllTests() {
        Method[] methods = this.getClass().getDeclaredMethods();
        System.out.println("Running tests...");
        for (Method m: methods) {
            try {
                if (m.getReturnType() == boolean.class) {
                    boolean result = (boolean) m.invoke(this);
                    System.out.println(m.getName() + ": " + result);
                }
            } catch (Exception e) {
                System.out.println("Something went wrong during tests run: " + e.getMessage());
            }
        }
    }
}