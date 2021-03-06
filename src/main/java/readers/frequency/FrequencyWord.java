package readers.frequency;

import readers.FileContentReader;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

public class FrequencyWord implements FileContentReader {

    private String tempString;

    @Override
    public String read(File file) {
        StringJoiner temp = new StringJoiner(" ");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                temp.add(scanner.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tempString = temp.toString();
        return tempString;
    }

    public void countWords(String str) {
        str = str.replaceAll("\\.|\\,", "").toLowerCase();
        List<String> myList = Arrays.asList(str.split(" "));
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : myList) {
            if (map.containsKey(s)){
                map.put(s, map.get(s)+1);
            }else{
                map.put(s, 1);
            }
        }
        map.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

    }


}
