package ch05;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * リスト5.3 テストスイートクラス
 * @author shuji.w6e
 */
@RunWith(Suite.class)
@SuiteClasses({ FooTest.class, BarTest.class })
public class AllTests {
}