package core.task1;

import java.util.Arrays;

public class Snapshot {
    private final byte[] buffer;
    private final int length;

    Snapshot(byte[] buffer, int length) {
        this.buffer = Arrays.copyOf(buffer, length);
        this.length = length;
    }

    byte[] getBuffer() {
        return Arrays.copyOf(this.buffer, this.length);
    }

    int getLength() {
        return this.length;
    }
}
