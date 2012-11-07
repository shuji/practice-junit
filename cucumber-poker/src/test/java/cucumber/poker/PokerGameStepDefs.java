package cucumber.poker;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import cucumber.annotation.ja.ならば;
import cucumber.annotation.ja.もし;
import cucumber.annotation.ja.前提;
import cucumber.poker.Card;
import cucumber.poker.Pat;
import cucumber.poker.PokerGame;

/**
 * リスト17.12 ステップ定義の追加
 * @author shuji.w6e
 */
public class PokerGameStepDefs {
    
    PokerGame sut;

    @前提("^手札に([SHDC])(\\d+),([SHDC])(\\d+),([SHDC])(\\d+),([SHDC])(\\d+),([SHDC])(\\d+)が配られた$")
    public void 手札にカードが配られた(
            char suit1, int no1, 
            char suit2, int no2, 
            char suit3, int no3, 
            char suit4, int no4,
            char suit5, int no5) {
        sut = new PokerGame();
        sut.setUp(Card.get(suit1, no1), 
                  Card.get(suit2, no2), 
                  Card.get(suit3, no3), 
                  Card.get(suit4, no4), 
                  Card.get(suit5, no5));
    }

    @もし("^チェンジしない$")
    public void チェンジしない() {
        sut.noChange();
    }

    @ならば("^ノーペアであるべき$")
    public void ノーペアであるべき() {
        assertThat(sut.pat(), is(Pat.NO_PAIR));
    }

    @ならば("^(\\d+)のワンペアであるべき$")
    public void ワンペアであるべき(int no) {
        Pat expected = new Pat.OnePair(no);
        assertThat(sut.pat(), is(expected));
    }
}
