import java.io.*;

public class Main {
    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.call(false, false);
        main.call(true, false);
        main.call(false, true);
    }

    public void call(boolean fileReaderErrorCondition, boolean bufferedReaderErrorCondition) throws Exception {
        String filePath = "./aaa.txt";
        System.out.println("fileReaderErrorCondition: " + fileReaderErrorCondition + ", bufferedReaderErrorCondition: " + bufferedReaderErrorCondition + ", filePath: " + filePath);

        System.out.println("-----------------------------------------------------------------------------------------");

        try (FileReader fileReader = this.getMyFileReader(fileReaderErrorCondition, filePath);
             BufferedReader bufferedReader = this.getMyBufferedReader(bufferedReaderErrorCondition, fileReader)) {
            String aaa = bufferedReader.readLine();
            System.out.println("file 'aaa.txt' content: " + aaa);
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());;
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        try (FileReader fileReader = this.getMyFileReaderWithCloseError(fileReaderErrorCondition, filePath);
             BufferedReader bufferedReader = this.getMyBufferedReader(bufferedReaderErrorCondition, fileReader)) {
            String aaa = bufferedReader.readLine();
            System.out.println("file 'aaa.txt' content: " + aaa);
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());;
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        try (FileReader fileReader = this.getMyFileReader(fileReaderErrorCondition, filePath);
             BufferedReader bufferedReader = this.getMyBufferedReaderWithCloseError(bufferedReaderErrorCondition, fileReader)) {
            String aaa = bufferedReader.readLine();
            System.out.println("file 'aaa.txt' content: " + aaa);
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());;
        }

        System.out.println("-----------------------------------------------------------------------------------------");
    }

    private BufferedReader getMyBufferedReader(boolean errorCondition, FileReader fileReader) throws Exception {
        BufferedReader bufferedReader = new MyBufferedReader(fileReader);
        if(errorCondition) {
            throw new Exception("getMyBufferedReader condition error");
        } else {
            System.out.println("getMyBufferedReader condition ok");
        }
        return bufferedReader;
    }

    private FileReader getMyFileReader(boolean errorCondition, String fileName) throws Exception {
        FileReader fileReader = new MyFileReader(fileName);
        if(errorCondition) {
            throw new Exception("getMyFileReader condition error");
        } else {
            System.out.println("getMyFileReader condition ok");
        }
        return fileReader;
    }

    private BufferedReader getMyBufferedReaderWithCloseError(boolean errorCondition, FileReader fileReader) throws Exception {
        BufferedReader bufferedReader = new MyBufferedReaderWithCloseError(fileReader);
        if(errorCondition) {
            throw new Exception("getMyBufferedReaderWithCloseError condition error");
        } else {
            System.out.println("getMyBufferedReaderWithCloseError condition ok");
        }
        return bufferedReader;
    }

    private FileReader getMyFileReaderWithCloseError(boolean errorCondition, String fileName) throws Exception {
        FileReader fileReader = new MyFileReaderWithCloseError(fileName);
        if(errorCondition) {
            throw new Exception("getMyFileReaderWithCloseError condition error");
        } else {
            System.out.println("getMyFileReaderWithCloseError condition ok");
        }
        return fileReader;
    }
}