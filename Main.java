import java.io.*;

public class Main {
    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.call(false, false);
        main.call(true, false);
        main.call(false, true);
        main.call(true, true);
    }

    public void call(boolean fileReaderErrorCondition, boolean bufferedReaderErrorCondition) throws Exception {
        System.out.println("fileReaderErrorCondition: " + fileReaderErrorCondition + ", bufferedReaderErrorCondition: " + bufferedReaderErrorCondition);
        try {
            try (FileReader fileReader = this.getMyFileReader(fileReaderErrorCondition, "./aaa.txt");
                 BufferedReader bufferedReader = this.getMyBufferedReader(bufferedReaderErrorCondition, fileReader)) {
                String aaa = bufferedReader.readLine();
                System.out.println("file aaa: " + aaa);
            }
            System.out.println("end");
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());;
        }
    }

    private BufferedReader getMyBufferedReader(boolean errorCondition, FileReader fileReader) throws Exception {
        BufferedReader bufferedReader = new MyBufferedReader(fileReader);
        if(errorCondition) {
            throw new Exception("ddd");
        }
        return bufferedReader;
    }

    private FileReader getMyFileReader(boolean errorCondition, String fileName) throws Exception {
        FileReader fileReader = new MyFileReader(fileName);
        if(errorCondition) {
            throw new Exception("ccc");
        }
        return fileReader;
    }
}