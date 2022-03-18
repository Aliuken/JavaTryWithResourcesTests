import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReaderWithCloseError extends FileReader {
    public MyFileReaderWithCloseError(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    @Override
    public void close() throws IOException {
        System.out.println("MyFileReaderWithCloseError close");
        throw new IOException("MyFileReaderWithCloseError close error");
    }
}