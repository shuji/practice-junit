package ch08;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.yaml.snakeyaml.Yaml;

/**
 * リスト8.15 外部リソースを使ったパラメータ化テスト
 * @author shuji.w6e
 */
@RunWith(Theories.class)
public class CalculatorDataPointsYamlTest {

    @SuppressWarnings("unchecked")
    @DataPoints
    public static Fixture[] getParams() {
        InputStream in = CalculatorDataPointsYamlTest.class.getResourceAsStream("params.yaml");
        return ((List<Fixture>) new Yaml().load(in)).toArray(new Fixture[0]);
    }

    @Theory
    public void add(Fixture p) throws Exception {
        Calculator sut = new Calculator();
        assertThat(sut.add(p.x, p.y), is(p.expected));
    }

    public static class Fixture {
        public int x;
        public int y;
        public int expected;
    }
}
