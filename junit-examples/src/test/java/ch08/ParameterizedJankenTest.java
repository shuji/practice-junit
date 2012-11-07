package ch08;

import static ch08.Janken.Hand.*;
import static ch08.Janken.Result.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import ch08.Janken.Hand;
import ch08.Janken.Result;

@RunWith(Theories.class)
public class ParameterizedJankenTest {

    @DataPoints
    public static Fixture[] FIXTURES = new Fixture[] {
          new Fixture(GU, GU, DRAW),
          new Fixture(GU, PA, LOSE),
          new Fixture(GU, TYOKI, WIN),
          new Fixture(PA, GU, WIN),
          new Fixture(PA, PA, DRAW),
          new Fixture(PA, TYOKI, LOSE),
          new Fixture(TYOKI, GU, LOSE),
          new Fixture(TYOKI, PA, WIN),
          new Fixture(TYOKI, TYOKI, DRAW),
    };
    
    @Theory
    public void judge(Fixture fx) throws Exception {
        Janken sut = new Janken();
        Result actual = sut.judge(fx.h1, fx.h2);
        assertThat(fx.toString(), actual, is(fx.expected));
    }
    
    static class Fixture {
        final Hand h1;
        final Hand h2;
        final Result expected;

        public Fixture(Hand h1, Hand h2, Result expected) {
            this.h1 = h1;
            this.h2 = h2;
            this.expected = expected;
        }

        @Override
        public String toString() {
            return String.format("%s vs %s expected %s.", h1, h2, expected);
        }
    }
}
