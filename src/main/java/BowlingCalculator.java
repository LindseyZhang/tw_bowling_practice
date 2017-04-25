
public class BowlingCalculator {
    public int calcTotal(int[] scores) {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }
}
