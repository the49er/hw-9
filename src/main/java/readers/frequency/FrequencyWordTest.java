package readers.frequency;

import java.io.File;

public class FrequencyWordTest {
    public static void main(String[] args) {
        FrequencyWord frequencyWord = new FrequencyWord();

        String content = frequencyWord.read(new File("files/input/words.txt"));
        frequencyWord.countWords(content);


    }
}
