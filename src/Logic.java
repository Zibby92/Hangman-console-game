import jdk.dynalink.linker.ConversionComparator;

import java.io.FileNotFoundException;
import java.util.*;

public class Logic {
    private final int HOW_MANY_COULD_TRY = 8;
    Scanner scanner = new Scanner(System.in);
    int counter = 0;

    int charTry (Character actualCharacter,String actualWord, int counter) {
        char[] chars = actualWord.toCharArray();
        boolean ifTheSame= true;
        for (int i = 0; i <chars.length ; i++) {
            if (actualCharacter == chars[i]) {
                System.out.println("podawałeś juz taki znak, ta próba nie będzie brana pod uwagę");
                ifTheSame = false;
                break;} };
      //  if(ifTheSame){this.counter++;};
        return this.counter;
    }



    void printWhichTry (int counter) {
        System.out.println("To twoja " + counter + " próba, pozostało: " + (HOW_MANY_COULD_TRY - counter));
    }

    boolean whenTheEnd(String mainWord, String wordAfter, int counter){
        if(this.counter == HOW_MANY_COULD_TRY) {
            System.out.println("Przekroczyłes dopuszczalna liczbe prób");
            return false;
        }
        if(mainWord.equals(wordAfter)){
            System.out.println("Gratulacje, odgałeś szukane słowo");
            return false;
        }
        return true;
    }
    void repeatUntilFoughtAllWords() throws FileNotFoundException {
        String randomWord = randomWord();
      //  System.out.println(randomWord);
        String wordInStars = showStars(randomWord);
        System.out.println(wordInStars);

        Character c;
        List<Character> charactersWithWas = new ArrayList<>();
        List<Integer> charsPlace = new ArrayList<>();

        //int counter = 0;
        do {
            c = takeLetter();
            this.counter = charTry(c,wordInStars,this.counter);
            charactersWithWas.add(c);
            charsPlace = findCharsPlace(randomWord,c);
            wordInStars = replaceStarsToLetters(wordInStars, randomWord, charsPlace);
            System.out.println(wordInStars);
            printWhichTry(this.counter);
        } while(whenTheEnd(wordInStars,randomWord,this.counter));
    }

    String replaceStarsToLetters(String stars,String word, List<Integer> list){
        char[] chars = word.toCharArray();
        char[] starsarray = stars.toCharArray();
        for (int i = 0; i <list.size() ; i++) {
            Arrays.fill(starsarray,list.get(i),list.get(i)+1,chars[list.get(i)]);

        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: starsarray) {
            stringBuilder.append(c);
        }
        String string = stringBuilder.toString();
        return string;
    }
    List<Integer> findCharsPlace (String string, char sign) {
        this.counter++;
        boolean ifTru = false;
        List<Integer> numbersOfCorrectLetters = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == sign) {
                numbersOfCorrectLetters.add(i);
                ifTru = true;
            }
        } if(ifTru) this.counter--;
        return numbersOfCorrectLetters;
    }

    char takeLetter () {
        System.out.println("podaj szukana litere: ");
        Character sign = scanner.next().charAt(0);
        return sign;
    }

    String showStars (String string) {
        int lengthString = string.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <lengthString ; i++) {
            stringBuilder.append("*");
        }
        return stringBuilder.toString();
    }

    String randomWord() throws FileNotFoundException {
        ListOfWords listOfWords = new ListOfWords();

       List<String> listOfWords1 =listOfWords.fill();

        Random random = new Random();
        int i = random.nextInt(listOfWords1.size());
        return listOfWords1.get(i);
    }

//    void menu(){
//        System.out.println("Witamy w grze wisielec. Proszę wybrać opcję: ");
//        System.out.println("1. Nowa gra");
//        System.out.println("2. Koniec programu");
//        int chose = scanner.nextInt();
//        switch (chose){
//            case 1->;
//            case 2->;
//        }
//
//    }
}
