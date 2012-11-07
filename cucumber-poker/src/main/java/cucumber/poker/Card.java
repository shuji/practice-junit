package cucumber.poker;

/**
 * リスト17.7 Cardクラス
 * @author shuji.w6e
 */
public class Card {
    public enum Suit {
        DIAMONDS, SPADES, HEARTS, CLUBS;
    }

    public final int no;
    public final Suit suit;

    Card(Suit suit, int no) {
        this.suit = suit;
        this.no = no;
    }

    public static Card get(char suit, int no) {
        if (no < 1 || 13 < no)
            throw new IllegalArgumentException();
        switch (suit) {
        case 'D':
            return new Card(Suit.DIAMONDS, no);
        case 'S':
            return new Card(Suit.SPADES, no);
        case 'H':
            return new Card(Suit.HEARTS, no);
        case 'C':
            return new Card(Suit.CLUBS, no);
        default:
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + no;
        result = prime * result + ((suit == null) ? 0 : suit.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Card other = (Card) obj;
        if (no != other.no) return false;
        if (suit != other.suit) return false;
        return true;
    }
    
}
