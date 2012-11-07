package ch10;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * リスト10.5 テストスイートクラスの作成
 * @author shuji.w6e
 */
@RunWith(Categories.class)
@IncludeCategory(FastTests.class)
@ExcludeCategory(SlowTests.class)
@SuiteClasses({ FooTest.class, BarTest.class })
public class CategorizedTest {
}
