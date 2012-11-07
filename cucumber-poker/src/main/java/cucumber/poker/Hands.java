package cucumber.poker;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * リスト17.8 Handsクラス
 * @author shuji.w6e
 */
public class Hands implements Iterable<Card> {

    private static final int SIZE = 5;
    final Set<Card> cards = new HashSet<Card>(SIZE);

    public Hands(Card... cards) {
        if (cards.length != SIZE) throw new IllegalArgumentException();
        for (Card card : cards) {
            this.cards.add(card);
        }
    }

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }
}
