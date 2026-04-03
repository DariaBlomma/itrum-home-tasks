package collection.task1;

import tests.Testable;
import java.util.Arrays;

public class FilterTest implements Testable {
    public boolean ifProvidedStringReplacementImplThenReturnsListWithAllStringsReplaced() {
        MyFilter<String> filterImpl = new MyFilter<>();
        String[] array = new String[]{"one", "two", "three"};
        String[] filtered = filterImpl.filter(array, s -> "new string");

        String[] expected = new String[]{"new string", "new string", "new string"};

        return Arrays.deepEquals(filtered, expected);
    }
}
