package ch11;

import java.util.Date;

/**
 * リスト11.3 システム時刻に依存する処理をnewDateメソッドに抽出
 * @author shuji.w6e
 */
public class MethodExtractExample {

    Date date = newDate();

    public void doSomething() {
        this.date = newDate();
        // なんらかの処理（省略）
    }

    Date newDate() {
        return new Date();
    }
}
