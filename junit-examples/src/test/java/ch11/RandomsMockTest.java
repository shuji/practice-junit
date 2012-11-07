package ch11;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Test;

/**
 * リスト11.19 RandomNumberGeneratorクラスのnextIntが呼び出されたかを検証するテスト
 * @author shuji.w6e
 */
public class RandomsMockTest {

    @Test
    public void choiceでAを返す() throws Exception {
        List<String> options = new ArrayList<String>();
        options.add("A");
        options.add("B");
        Randoms sut = new Randoms();
        // モックの設定
        final AtomicBoolean isCallNextIntMethod = new AtomicBoolean(false);
        sut.generator = new RandomNumberGenerator() {
            @Override
            public int nextInt() {
                isCallNextIntMethod.set(true);
                return 0;
            }
        };
        assertThat(sut.choice(options), is("A"));
        assertThat(isCallNextIntMethod.get(), is(true));
    }

}
