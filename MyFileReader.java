import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader extends FileReader {
    public MyFileReader(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    @Override
    public void close() throws IOException {
        System.out.println("my close1");
        super.close();
    }
}
