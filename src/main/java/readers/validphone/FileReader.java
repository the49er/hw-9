package readers.validphone;

import readers.FileContentReader;

import java.io.File;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Pattern;

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

    public boolean isPhone(String str){
        boolean validPhone = false;

        Pattern pattern1 =  Pattern.compile("\\(\\d\\d\\d\\)\\s\\d\\d\\d\\-\\d\\d\\d\\d");
        Pattern pattern2 =  Pattern.compile("\\d\\d\\d\\-\\d\\d\\d\\-\\d\\d\\d\\d");

        if (pattern1.matcher(str).matches() || pattern2.matcher(str).matches()) {
            validPhone = true;
        }

        return validPhone;
    }
}

