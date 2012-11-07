package ch05;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * リスト5.6 ￼ Theoriesによるパラメータ化テスト
 * @author shuji.w6e
 */
@RunWith(Theories.class)
public class CalcTheoriesTest {
    
    @DataPoints public static int[][] VALUES = {
            {0, 0, 0},
            {0, 1, 1},
            {1, 0, 1},
            {3, 4, 7},
    };

    @Theory
    public void add(int[] values) throws Exception {
        Calc sut = new Calc();
        assertThat(sut.add(values[0], values[1]), is(values[2]));
    }
}

