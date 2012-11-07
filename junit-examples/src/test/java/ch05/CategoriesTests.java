package ch05;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * リスト5.9 カテゴリ化テストを実行するテストスイートクラス
 * @author shuji.w6e
 */
@RunWith(Categories.class)
@ExcludeCategory(SlowTests.class)
@SuiteClasses(SlowAndFastTest.class)
public class CategoriesTests {
}
