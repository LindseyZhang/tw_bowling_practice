import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class BowlingCalculatorTest {

    @Test
    public void testCalcTotal() {
        //given
        int[] scores = new int []{1,2,3,4,5,6,7,8,9,10};
        int expectResult = 55;

        //when
        int result = new BowlingCalculator().calcTotal(scores);

        //then
        assertThat(result).isEqualTo(expectResult);
    }

   @Test
    public void testCalcScoreForEveryBlock() {
       //given
       String input = "X|X|X|X|X|X|X|X|X|X||XX";
       int[] expectResult = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30};

       //when
       int[] actualResult = new BowlingCalculator().calcScoreForEveryBlock(input);

       //then
       assertThat(actualResult).isEqualTo(expectResult);

   }

    @Test
    public void testProcessStrike () {
        //given
        String input = "X|X|X|X|X|X|X|X|X|X||XX";
        int expectResult = 300;

        //when
        int actualResult = new BowlingCalculator().calcScore(input);

        //then
        assertThat(actualResult).isEqualTo(expectResult);

    }

   @Test
   public void testProcessNoExtraScore () {
     //given
       String input = "9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||";

       int score = 9;
       int[] expectResult = new int[]{score, score, score, score, score, score, score, score, score, score};

       //when
       int[] actualResult = new BowlingCalculator().calcScoreForEveryBlock(input);

       //then
       assertThat(actualResult).isEqualTo(expectResult);

   }

    @Test
    public void testProcessNormal () {
        //given
        String input = "9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||";
        int expectResult = 90;

        //when
        int actualResult = new BowlingCalculator().calcScore(input);

        //then
        assertThat(actualResult).isEqualTo(expectResult);

    }

    @Test
    public void testProcessSpare () {
        //given
        String input = "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5";

        int score = 15;
        int[] expectResult = new int[]{score, score, score, score, score, score, score, score, score, score};

        //when
        int[] actualResult = new BowlingCalculator().calcScoreForEveryBlock(input);

        //then
        assertThat(actualResult).isEqualTo(expectResult);

    }

    @Test
    public void testCalcScoreForSpare () {
        //given
        String input = "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5";
        int expectResult = 150;

        //when
        int result = new BowlingCalculator().calcScore(input);

        //then
        assertThat(result).isEqualTo(expectResult);

    }

    @Test
    public void testProcessMixSituation () {
        //given
        String input = "X|7/|9-|X|-8|8/|-6|X|X|X||81";
        int[] expectResult = new int[]{20, 19, 9, 18, 8, 10, 6, 30, 28, 19};

        //when
        int[] actualResult = new BowlingCalculator().calcScoreForEveryBlock(input);

        //then
        assertThat(actualResult).isEqualTo(expectResult);

    }

    @Test
    public void testCalcScoreWithMixSituation () {
        //given
        String input = "X|7/|9-|X|-8|8/|-6|X|X|X||81";
        int expectResult = 167;

        //when
        int result = new BowlingCalculator().calcScore(input);

        //then
        assertThat(result).isEqualTo(expectResult);

    }
}
