import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please input total amount of words: ");
        int num = scan.nextInt();
        System.out.print("What is the name of the file (removing the .txt): ");
        String name = scan.nextLine();
        File file = new File(name+".txt");
        String[] arr = new String[num];

        try {
            Scanner sc = new Scanner(file);

            int i = 0;
            while (sc.hasNextLine()) {
                String word = sc.nextLine();
                arr[i] = word;
                i++;
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: The file '" + name + "' was not found.");
            e.printStackTrace();
        }

        System.out.println("The sorted words are: ");
        for (String w : arr) {
            System.out.println(w);
        }

        scan.close();

    }
}
