package core.task1;

import java.nio.charset.StandardCharsets;

public class MyStringBuilder {
    private byte[] buffer;
    private int length;

    private final static int DEFAULT_CAPACITY = 16;

    MyStringBuilder() {
        this.buffer = new byte[DEFAULT_CAPACITY];
        this.length = 0;
    }

    @Override
    public String toString() {
        return new String(buffer, 0, length, StandardCharsets.ISO_8859_1);
    }

    void append(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);

        if (bytes.length == str.length()) {
            appendToBuffer(bytes);
        } else {
            throw new RuntimeException("Only Latin encoding is supported");
        }
    }

    Snapshot createSnapshot() {
        return new Snapshot(this.buffer, this.length);
    }

    void restoreFromSnapshot(Snapshot snapshot) {
        this.buffer = snapshot.getBuffer();
        this.length = snapshot.getLength();
    }

    private void appendToBuffer(byte[] newBytes) {
        int newLength = this.length + newBytes.length;

        if (this.buffer.length < newLength) {
            byte[] newBuffer = new byte[Math.max(this.buffer.length * 2, newLength)];
            System.arraycopy(this.buffer, 0, newBuffer, 0, this.length);
            System.arraycopy(newBytes, 0, newBuffer, this.length, newBytes.length);
            this.buffer = newBuffer;
        } else  {
            System.arraycopy(newBytes, 0, this.buffer, this.length, newBytes.length);
        }
        this.length = newLength;
    }
}
