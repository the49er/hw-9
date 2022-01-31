package readers.validphone;

import readers.FileContentReader;

import java.io.File;
import java.util.Scanner;
import java.util.StringJoiner;

public class FileReader implements FileContentReader {


    @Override
    public String read(File file) {
        StringJoiner temp = new StringJoiner("\n");
        StringJoiner result = new StringJoiner("\n");
        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                temp.add(scanner.nextLine());

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String[] strArr =  temp.toString().split("\n");
        for (String str: strArr) {
            if (isPhone(str)){
                result.add(str);
            }
        }
        return result.toString();
    }

    public boolean isPhone(String line){
        boolean validPhone = false;

        char[] charArr =  line.toCharArray();
        for (int i = 0; i < line.length()-1; i++) {
            if (charArr[3] == '-' || charArr[4] == ')') {
                validPhone = true;
            }

        }

        return validPhone;
    }
}

