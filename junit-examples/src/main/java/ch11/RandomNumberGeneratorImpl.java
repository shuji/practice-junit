package ch11;

import java.util.Random;

/**
 * リスト11.12 乱数生成のデフォルト実装
 * @author shuji.w6e
 */
public class RandomNumberGeneratorImpl implements RandomNumberGenerator {
    
    private final Random rand = new Random();
    
    @Override
    public int nextInt() {
        return rand.nextInt();
    }

}
