import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bigData {
    public static void main(String[] args) {
        System.out.println(function());
    }


    public static String function () {
        Scanner in = new Scanner(System.in);

        int sum1 = 0, sum2 = 0;
        int tmp;

        int sizeOne = in.nextInt();
        int sizeTwo = in.nextInt();

        List<Integer> arrayOne = new ArrayList<>();
        List<Integer> arrayTwo = new ArrayList<>();

        for (int i = 0; i < sizeOne; i++)
            arrayOne.add(in.nextInt());
        for (int i = 0; i < sizeTwo; i++)
            arrayTwo.add(in.nextInt());

        //частный случай
        if (sizeOne == 0 || sizeTwo == 0)
            return getAnswer(sum(arrayOne), sum(arrayTwo));


        List<Integer> maxOne = new ArrayList<>();
        List<Integer> maxTwo = new ArrayList<>();

        tmp = arrayOne.get(0);
        maxOne.add(0);
        for (int i = 1; i < sizeOne; i++) {
            int current = arrayOne.get(i);
            //if (tmp < )
        }

        return "";
    }

    public static int sum (List<Integer> array) {
        int sum = 0;
        for (Integer number : array)
            sum += number;
        return sum;
    }

    public static String getAnswer (int sum1, int sum2) {
        String answer = sum1 + "";
        for (int i = 0; i < 9-answer.length(); i++)
            answer = "0" + answer;
        answer = sum2 + answer;
        return answer;
    }
}
