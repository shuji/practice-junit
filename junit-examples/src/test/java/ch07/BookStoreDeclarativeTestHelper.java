package ch07;

/**
 * リスト7.A Javaによる宣言的なセットアップ
 * @author shuji.w6e
 */
public class BookStoreDeclarativeTestHelper {

    public static Book Bookオブジェクトの作成_MartinFowlerのRefactoring() {
        return new Book() {
            {
                title = "Refactoring";
                price = 4500;
                author = new Author() {
                    {
                        firstName = "Martin";
                        lastName = "Fowler";
                    }
                };
            }
        };
    }

}
