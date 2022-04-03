import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class CustomPrintStream extends PrintStream {
    private final PrintStream second;

    public CustomPrintStream(OutputStream main, PrintStream second) {
        super(main);
        this.second = second;
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public void flush() {
        super.flush();
        second.flush();
    }

    @Override
    public void write(byte[] buf, int off, int len) {
        super.write(buf, off, len);
        second.write(buf, off, len);
    }

    @Override
    public void write(int b) {
        super.write(b);
        second.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        super.write(b);
        second.write(b);
    }
}
