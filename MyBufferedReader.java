import java.io.*;

public class MyBufferedReader extends BufferedReader {
    public MyBufferedReader(FileReader fileReader) {
        super(fileReader);
    }

    @Override
    public void close() throws IOException {
        System.out.println("my close2");
        super.close();
    }
}
