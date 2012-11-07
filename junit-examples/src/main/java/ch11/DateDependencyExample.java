package ch11;

import java.util.Date;

/**
 * リスト11.1 システム時間に依存する処理を含むメソッド
 * @author shuji.w6e
 */
public class DateDependencyExample {

    Date date = new Date();

    public void doSomething() {
        this.date = new Date();
        // なんらかの処理（省略）
    }

}
