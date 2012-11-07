package ch08;

/**
 * リスト8.4 じゃんけんクラス
 * @author shuji.w6e
 */
public class Janken {

    public enum Hand {
        GU, TYOKI, PA
    }
    
    public enum Result {
        WIN, LOSE, DRAW
    }

    public Result judge(Hand h1, Hand h2) {
        if (h1 == h2) return Result.DRAW;
        switch (h1) {
        case GU:
            return h2 == Hand.TYOKI ? Result.WIN : Result.LOSE;
        case PA:
            return h2 == Hand.GU ? Result.WIN : Result.LOSE;
        default:
            return h2 == Hand.PA ? Result.WIN : Result.LOSE;
        }
    }

}
