package ch07

// リスト7.B
class BookStoreGroovyTestHelper {

    static Book Bookオブジェクトの作成_MartinFowlerのRefactoring() {
        new Book(
                title: "Refactoring",
                price: 4500,
                author: new Author(
                    firstName: "Martin",
                    lastName: "Fowler",
                ),
        )
    }
}
