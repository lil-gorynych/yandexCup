import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class shootingRange {

    public static void main (String[] args) {
        if (getCenters()) System.out.println("Yes");
        else System.out.println("No");
    }


    public static boolean getCenters () {
        List<List<Double>> result = new ArrayList<>();
        List<Double> coef;
        Scanner in = new Scanner(System.in);

        int numberOfTargets = in.nextInt();
        if (numberOfTargets < 3) return true;

        for (int i = 0; i < 2; i++) {
            if (in.nextInt() == 0) {
                int tmp = in.nextInt();
                int x = in.nextInt(); int y = in.nextInt();
                result.add(getCircCenters(x, y));
            } else {
                int tmp;
                int x1 = in.nextInt(); int y1 = in.nextInt();
                for (int j = 0; j < 2; j++) tmp = in.nextInt();
                int x2 = in.nextInt(); int y2 = in.nextInt();
                for (int j = 0; j < 2; j++) tmp = in.nextInt();
                result.add(getRectCenters(x1, y1, x2, y2));
            }
        }

        coef = getCoef(result);


        for (int i = 2; i < numberOfTargets; i++) {
            List<Double> newCenter;
            if (in.nextInt() == 0) {
                int tmp = in.nextInt();
                int x = in.nextInt(); int y = in.nextInt();
                newCenter = getCircCenters(x, y);

            } else {
                int tmp;
                int x1 = in.nextInt(); int y1 = in.nextInt();
                for (int j = 0; j < 2; j++) tmp = in.nextInt();
                int x2 = in.nextInt(); int y2 = in.nextInt();
                for (int j = 0; j < 2; j++) tmp = in.nextInt();
                newCenter = getRectCenters(x1, y1, x2, y2);
            }

            if (!checkCenter(newCenter, coef)) return false;

        }

        return true;
    }

    public static List<Double> getCircCenters (int x, int y) {
        List<Double> result = new ArrayList<>();
        result.add((double) x); result.add((double) y);
        return result;
    }

    public static List<Double> getRectCenters (int x1, int y1,
                                               int x2, int y2) {
        List<Double> result = new ArrayList<>();
        result.add((double) (x1 + x2) / 2);
        result.add((double) (y1 + y2) / 2);
        return result;
    }

    public static List<Double> getCoef (List<List<Double>> centers) {
        // y = kx + b
        List<Double> result = new ArrayList<>();

        double x0 = centers.get(0).get(0),
                x1 = centers.get(1).get(0);
        double y0 = centers.get(0).get(1),
                y1 = centers.get(1).get(1);

        double dx = x1 - x0;
        double dy = y1 - y0;

        if (dx == 0) {
            result.add(x0);
            return result;
        }

        result.add(dy / dx);
        result.add(y0 - dy*x0/dx);

        return result;

    }

    public static boolean checkCenter (List<Double> center,
                                       List<Double> coef) {

        double x = center.get(0);
        double y = center.get(1);

        if (coef.size() == 1) {
            if (coef.get(0) == x) return true;
            else return false;
        }

        return y == coef.get(0) * x + coef.get(1);
    }
}
