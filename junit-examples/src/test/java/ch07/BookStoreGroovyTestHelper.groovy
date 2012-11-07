package ch07

/**
 * Groovyによる宣言的なセットアッフ
 * @author shuji.w6e
 */
class BookStoreGroovyTestHelper {

    static Book Bookオブジェクトの作成_KentBeckのTestDrivenDevelopment() {
        new Book(
                title: "Test Driven Development",
                price: 4500,
                author: new Author(
                    firstName: "Beck",
                    lastName: "Kent",
                ),
        )
    }
}
