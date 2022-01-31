package readers.validphone;

import readers.FileContentReader;

import java.io.File;

public class FileReaderTest {
    public static void main(String[] args) {
        FileContentReader fileContentReader = new FileReader();

        fileContentReader.read(new File("files/input/text.txt"));
        String content = fileContentReader.read(new File("files/input/text.txt"));
        System.out.println(content);

    }
}
