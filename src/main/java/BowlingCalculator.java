import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingCalculator {
    public int calcTotal(int[] scores) {
        return Arrays.stream(scores).sum();
    }

    public int[] calcScoreForEveryBlock(String input) {

        List<String> liststr = splitString(input);

        int[] result = new int[10];
        for (int j = 0; j < 10; j++) {
            List<String> scoreUnit = liststr.subList(j, lastPosOrNextThree(j, liststr));
            result[j] = calcFirstBlock(scoreUnit.get(0)) + addExtraScore(
                    scoreUnit.subList(1, scoreUnit.size()), getExtraTime(scoreUnit.get(0)));
        }

        return result;
    }

    private int lastPosOrNextThree(int j, List<String> split) {
        return j+4 < split.size()? j+4 : split.size();
    }

    private int getExtraTime(String s) {
        if ("X".equals(s)) return 2;
        if (s.contains("/")) return 1;
        return 0;
    }

    private int addExtraScore(List<String> s, int time) {
        if (s.isEmpty()) return 0;
        if (0 == time) return 0;

        String str = concatedListString(s);
        if (str.length() > 1 && str.charAt(1) == '/') return 10;
        int total = 0;
        for (int i = 0; i < time; ++i) {
            total += getSingleTryScore(str.charAt(i));
        }
        return total;
    }

    private String concatedListString(List<String> str) {
        StringBuilder builder = new StringBuilder();
        for (String s : str) {
            builder.append(s);
        }
        return builder.toString();
    }

    private int getSingleTryScore(char c) {
        if ('X' == c) return 10;
        if ('-' == c) return 0;
        if ('/' == c) return 11;
        if (Character.isDigit(c)) return Character.getNumericValue(c);
        return 0;
    }

    private int calcFirstBlock(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            total += getSingleTryScore(s.charAt(i));
        }
        return total > 10 ? 10 : total;
    }

    private List<String> splitString(String input) {
        String[] split = input.split("\\|");
        return Arrays.stream(split).collect(Collectors.toList());
    }

    public int calcScore(String input) {
        return calcTotal(calcScoreForEveryBlock(input));
    }
}
