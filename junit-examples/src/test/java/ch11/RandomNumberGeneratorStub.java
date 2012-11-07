package ch11;

/**
 * リスト11.16 再利用可能なスタブ実装
 * @author shuji.w6e
 */
public class RandomNumberGeneratorStub implements RandomNumberGenerator {

    private final int num;

    public RandomNumberGeneratorStub(int num) {
        this.num = num;
    }

    @Override
    public int nextInt() {
        return num;
    }

}
