package ch11.withclass;

import java.util.Date;

/**
 * リスト11.5 newDateを定義した新しいクラス
 * @author shuji.w6e
 */
public class DateFactory {

    Date newDate() {
        return new Date();
    }
}
