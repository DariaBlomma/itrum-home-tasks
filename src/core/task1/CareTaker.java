package core.task1;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;

public class CareTaker {
    private final MyStringBuilder stringBuilder = new MyStringBuilder();
    Deque<Snapshot> history = new ArrayDeque<>();

    public void append(String str) {
        Snapshot snapshot =  stringBuilder.createSnapshot();
        history.push(snapshot);
        stringBuilder.append(str);
    }

    public void undo() {
        if (!history.isEmpty()) {
            Snapshot prevState = history.pop();
            stringBuilder.restoreFromSnapshot(prevState);
        }
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
