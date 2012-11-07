package cucumber.poker;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import cucumber.poker.Card;
import cucumber.poker.Card.Suit;

@RunWith(Enclosed.class)
public class CardTest {

    @RunWith(Theories.class)
    public static class インスタンス化テスト {
        @DataPoints
        public static Suit[] SUITES = Suit.values();
        @DataPoints
        public static int[] NOS = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

        @Theory
        public void コンストラクタでスートと数字が保持される(Suit suit, int no) {
            String desc = suit + " of " + no;
            Card instance = new Card(suit, no);
            assertThat(desc, instance.suit, is(sameInstance(suit)));
            assertThat(desc, instance.no, is(no));
        }
    }

    @RunWith(Theories.class)
    public static class ファクトリメソッドのテスト {
        @DataPoints
        public static char[] SUITES = { 'D', 'S', 'H', 'C' };
        @DataPoints
        public static int[] NOS = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

        @Theory
        public void getメソッドでインスタンスを生成できる(char suit, int no) {
            String desc = suit + " of " + no;
            Card instance = Card.get(suit, no);
            switch (suit) {
            case 'D':
                assertThat(desc, instance, is(new Card(Suit.DIAMONDS, no)));
                break;
            case 'S':
                assertThat(desc, instance, is(new Card(Suit.SPADES, no)));
                break;
            case 'H':
                assertThat(desc, instance, is(new Card(Suit.HEARTS, no)));
                break;
            case 'C':
                assertThat(desc, instance, is(new Card(Suit.CLUBS, no)));
                break;
            }
        }

    }

}
