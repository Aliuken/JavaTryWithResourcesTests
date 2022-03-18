import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyBufferedReaderWithCloseError extends BufferedReader {
    public MyBufferedReaderWithCloseError(FileReader fileReader) {
        super(fileReader);
    }

    @Override
    public void close() throws IOException {
        System.out.println("MyBufferedReaderWithCloseError close");
        throw new IOException("MyBufferedReaderWithCloseError close error");
    }
}