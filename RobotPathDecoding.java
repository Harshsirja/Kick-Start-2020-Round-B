import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class RobotPathDecoding{

    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        try {
            int T = sc.nextInt();
            for (int i = 0; i < T; i++) {
                long w = 1;
                long h = 1;
                long max = (long) Math.pow(10, 9);
                char tempArray[] = sc.next().toCharArray();

                ArrayList<Character> array = recursive(tempArray, 0, tempArray.length);
                String finalProgram = array.toString();
                for (int j = 0; j < finalProgram.length(); j++) {
                    switch (finalProgram.charAt(j)) {
                        case 'S':
                            if (h == max) {
                                h = 1;
                            } else {
                                h++;
                            }
                            break;
                        case 'N':
                            if (h == 1) {
                                h = max;
                            } else {
                                h--;
                            }
                            break;
                        case 'E':
                            if (w == max) {
                                w = 1;
                            } else {
                                w++;
                            }
                            break;
                        case 'W':
                            if (w == 1) {
                                w = max;
                            } else {
                                w--;
                            }
                            break;
                        default:
                            break;
                    }
                }
                System.out.println("Case #" + (i + 1) + ": " + (w) + " " + (h));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Character> recursive(char[] tempArray, int postion, int end) throws Exception{
        ArrayList<Character> array = new ArrayList<Character>();

        while (postion < end) {
            if (tempArray[postion] == 'E' || tempArray[postion] == 'S' || tempArray[postion] == 'W' || tempArray[postion] == 'N') {
                array.add(tempArray[postion]);
                postion++;
            } else {
                int times = Character.getNumericValue(tempArray[postion]);
                int start = postion + 2; // next number/ letter
                int last = postion + 3;

                int bracketsClosed = 1;
                while (true) {
                    if (tempArray[last] == ')') {
                        bracketsClosed--;
                        if (bracketsClosed == 0) {
                            break;
                        }
                    }
                    if (tempArray[last] == '(') {
                        bracketsClosed++;
                    }
                    last++;
                }

                for (int i = 0; i < times; i++) {
                    array.addAll(recursive(tempArray, start, last));
                }
                postion = last + 1;
            }
        }

        return array;
    }
}
