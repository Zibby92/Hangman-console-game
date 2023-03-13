import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Logic logic = new Logic();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witamy w grze wisielec. Proszę wybrać opcję: ");
        System.out.println("1. Nowa gra");
        System.out.println("2. Koniec programu");
        int chose = scanner.nextInt();
        switch (chose){
            case 1-> logic.repeatUntilFoughtAllWords();
            case 2-> System.out.println("dziekuje za uruchowmienie tej zacnej gry");
        }



    }
}