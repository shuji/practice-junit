package ch03;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * リスト3.19 コンストラクタを検証するテスト
 * @author shuji.w6e
 */
public class ConstructorTest {

    @Test
    public void インスタンス化テスト() {
        // Exercise
        Person instance = new Person("Duke");
        // Verify
        assertThat(instance.getName(), is("Duke"));
        assertThat(instance.getAge(), is(-1));
        assertThat(instance.getEmail(), is(nullValue()));
    }

}
