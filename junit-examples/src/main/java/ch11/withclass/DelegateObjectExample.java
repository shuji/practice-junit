package ch11.withclass;

import java.util.Date;

/**
 * リスト11.6 DateFactoryクラスの利用
 * @author shuji.w6e
 */
public class DelegateObjectExample {

    DateFactory dateFactory = new DateFactory();
    Date date = new Date();
    
    public void doSomething() {
        this.date = dateFactory.newDate();
        // なんらかの処理（省略）
    }
}
