import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CompetitorsData {
    public static void main(String[] args) {
        List<Competitor> competitors = readCompetitorsInfo();
        sortCompetitors(competitors);
        saveToFile(competitors);
    }

    static void sortCompetitors(List<Competitor> competitors) {
        Collections.sort(competitors);
    }

    public static List<Competitor> readCompetitorsInfo() {
        Scanner scanner = new Scanner(System.in);
        List<Competitor> competitors = new ArrayList<>();
        System.out.println("Podaj wynik kolejnego gracza (lub stop)");

        for (String userInput = scanner.nextLine(); !userInput.equals("stop"); userInput = scanner.nextLine()) {
            System.out.println("Podaj wynik kolejnego gracza (lub stop):");
            String[] userArray = userInput.split(" ");
            competitors.add(new Competitor(userArray[0], userArray[1], Integer.parseInt(userArray[2])));
        }
        printCompetitors(competitors);
        scanner.close();
        return competitors;
    }

    static void printCompetitors(List<Competitor> competitors) {
        for (Competitor competitor : competitors) {
            System.out.println(competitor);
        }
    }

    static void saveToFile(List<Competitor> competitors) {
        PrintWriter save = null;
        try {
            save = new PrintWriter("stats.csv");
            for (Competitor competitor : competitors) {
                save.println(competitor);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        save.close();
    }

}

