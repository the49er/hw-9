package readers.json;

import readers.FileContentReader;
import readers.FileContentWriter;

import java.io.File;

public class CreateUserJasonFileTest {
    public static void main(String[] args) throws Exception {
        FileContentReader fileContentReader = new CreateUserJsonFile();
        FileContentWriter fileContentWriter = new CreateUserJsonFile();


        String contentRead = fileContentReader.read(new File("files/input/json.txt"));
        fileContentWriter.write(contentRead);






    }
}