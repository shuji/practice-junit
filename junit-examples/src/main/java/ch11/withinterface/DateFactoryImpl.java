package ch11.withinterface;

import java.util.Date;

/**
 * リスト11.8 DateFactoryクラスのデフォルト実装
 * @author shuji.w6e
 */
public class DateFactoryImpl implements DateFactory {
    
    @Override
    public Date newDate() {
        return new Date();
    }
}
