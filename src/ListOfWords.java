import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListOfWords {
 //  List<String> listOfWords = List.of("Adrian");
        private List<String> listOfWords = new ArrayList<>();

            //  LOADING LIST FROM FILE
    ArrayList<String> fill() throws FileNotFoundException {
        String fileName = "C:\\Users\\zbign\\OneDrive\\Dokumenty\\JavaExercises\\namespl.txt";
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        ArrayList<String> strings = new ArrayList<>();
        while(scanner.hasNextLine()){
                strings.add(scanner.nextLine());
            };
        return strings;
    }



    public List<String> getListOfWords() {
        return listOfWords;
    }

    public void setListOfWords(List<String> listOfWords) {
        this.listOfWords = listOfWords;
//    }
    }
}
