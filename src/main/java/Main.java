import org.apache.commons.lang3.time.StopWatch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите строку: ");
            String inputText = scanner.nextLine();

            if(inputText.equals("!quit")) break;

            long start = System.currentTimeMillis();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("./airports.csv"));
                String probablyString;
                int counter = 0;
                while ((probablyString = bufferedReader.readLine()) != null) {
                    String[] splitArray = probablyString.split(",");
                    if (splitArray[Integer.parseInt(args[0]) - 1].toLowerCase(Locale.ROOT).contains(inputText.toLowerCase())) {//Integer.parseInt(args[0])){
                        System.out.println(splitArray[Integer.parseInt(args[0]) - 1] + "[" + probablyString + "]");
                        counter++;
                    }
                }
                bufferedReader.close();
                long finish = System.currentTimeMillis();

                long elapsed = finish - start;
                System.out.println("Прошло времени, мc: " + elapsed);
                System.out.println("Количество найденных строк: " + counter);

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
