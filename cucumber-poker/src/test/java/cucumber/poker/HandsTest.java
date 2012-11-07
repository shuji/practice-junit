package cucumber.poker;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import cucumber.poker.Card;
import cucumber.poker.Hands;

@RunWith(Enclosed.class)
public class HandsTest {

    @RunWith(Theories.class)
    public static class _5枚のカードを手札にセットする正常系テスト {
        @DataPoints
        public static Card[][] CARDS = {
                { Card.get('C', 1), Card.get('C', 2), Card.get('C', 3), Card.get('C', 4), Card.get('C', 5) },
                { Card.get('C', 1), Card.get('D', 1), Card.get('H', 1), Card.get('S', 1), Card.get('C', 13) },
                { Card.get('C', 1), Card.get('C', 10), Card.get('H', 1), Card.get('H', 2), Card.get('H', 3) },
                { Card.get('S', 11), Card.get('S', 12), Card.get('S', 13), Card.get('D', 9), Card.get('D', 10) }, };

        @Theory
        public void コンストラクタでスートと数字が保持される(Card[] cards) {
            Hands instance = new Hands(cards);
            assertThat(instance.cards.size(), is(5));
            assertThat(instance.cards, is(hasItems(cards)));
        }

        @Theory
        public void Iterableであること(Card[] cards) {
            Hands instance = new Hands(cards);
            assertThat(instance.cards, is(instanceOf(Iterable.class)));
        }
    }

}
