import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class BowlingCalculatorTest {

    @Test
    public void CalcTotalTest() {
        //given
        int[] scores = new int []{1,2,3,4,5,6,7,8,9,10};
        int expectResult = 55;

        //when
        int result = new BowlingCalculator().calcTotal(scores);

        //then
        assertThat(result).isEqualTo(expectResult);
    }


}
