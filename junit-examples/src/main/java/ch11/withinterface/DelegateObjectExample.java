package ch11.withinterface;

import java.util.Date;

/**
 * リスト11.9 インタフェースを使ってシステム時間の処理を委譲
 * @author shuji.w6e
 */
public class DelegateObjectExample {

    DateFactory dateFactory = new DateFactoryImpl();
    Date date = new Date();
    
    public void doSomething() {
        this.date = dateFactory.newDate();
        // なんらかの処理（省略）
    }
}
