package readers.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import readers.FileContentReader;
import readers.FileContentWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class CreateUserJsonFile implements FileContentReader, FileContentWriter {

    private String tempString;
    private List<User> list = new ArrayList<>();


    @Override
    public String read(File inputFile) {
        StringJoiner temp = new StringJoiner("\n");
        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                temp.add(scanner.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tempString = temp.toString();

        return tempString;
    }

    @Override
    public void write(String str) throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String[] arrStr = str.split("\n");
        String[][] newArr = new String[arrStr.length][];

        for (int i = 0; i < arrStr.length; i++) {
            newArr[i] = arrStr[i].split(" ");
        }
        for (int i = 1; i < newArr.length; i++) {
            User user = new User(newArr[i][0], Integer.parseInt(newArr[i][1]));
            list.add(user);
        }
        FileWriter fileWriter = new FileWriter("files/output/user.json");
        fileWriter.write(gson.toJson(list));
        fileWriter.close();
    }

    public class User {

        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}




