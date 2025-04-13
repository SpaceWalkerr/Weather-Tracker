import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


class Result {

    /*
     * Complete the 'getLargestNumber' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING num as parameter.
     */

    public static String getLargestNumber(String num) {
    // Write your code here
    List<Character> evenDigits = new ArrayList<Character>();
    List<Character> oddDigits = new ArrayList<Character>();
        
        for (char digit : num.toCharArray()) {
            if ((digit - '0') % 2 == 0) {
                evenDigits.add(digit);
            } else {
                oddDigits.add(digit);
            }
        }
        
        Collections.sort(evenDigits);
        Collections.sort(oddDigits);
        
        Collections.reverse(evenDigits);
        Collections.reverse(oddDigits);
        
        StringBuilder result = new StringBuilder();
        int evenIndex = 0, oddIndex = 0;
        
        for (char digit : num.toCharArray()) {
            if ((digit - '0') % 2 == 0) {
                result.append(evenDigits.get(evenIndex));
                evenIndex++;
            } else {
                result.append(oddDigits.get(oddIndex));
                oddIndex++;
            }
        }
        
        return result.toString();
    
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String num = bufferedReader.readLine();

        String result = Result.getLargestNumber(num);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
