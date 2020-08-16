import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BusRoutes{

    public static void main(String[] args) {
        Scanner scan;
        scan= new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        try {
            int testCases = scan.nextInt();

            for (int i = 0; i < testCases; i++) {
                int n = scan.nextInt();
                long d = scan.nextLong();
                long dayStart = d;
                long array[] = new long[n];

                for (int j = 0; j < n; j++) {
                    array[j] = scan.nextLong();
                }

                int index = n - 1;
                while (true) {
                    if (index == -1) {
                        break;
                    }

                    long days = dayStart % array[index];
                    if (days == 0) {
                        index--;
                    } else {
                        dayStart -= days;
                    }
                }

                System.out.print("\nCase #" + (i + 1) + ": " + dayStart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
