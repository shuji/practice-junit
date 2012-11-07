package ch11;

import java.util.logging.Logger;

/**
 * リスト11.20
 * リスト11.31 ロガーを扱うクラス
 * @author shuji.w6e
 */
public class SpyExample {
    
    Logger logger = Logger.getLogger(SpyExample.class.getName());
    
    public void doSomething() {
        logger.info("doSomething");
    }
}
