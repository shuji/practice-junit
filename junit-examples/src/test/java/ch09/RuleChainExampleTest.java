package ch09;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.rules.RuleChain;

/**
 * リスト9.20 RuleChainによるルールの連鎖
 * @author shuji.w6e
 */
public class RuleChainExampleTest {

    @Rule
    public RuleChain ruleChain = RuleChain
                                     .outerRule(new DBServer())
                                     .around(new AppServer());

    @Test
    public void テスト() throws Exception {
    }
}

class AppServer extends ExternalResource {
    @Override
    protected void before() throws Throwable {
        System.out.println("start AP");
    }

    @Override
    protected void after() {
        System.out.println("shutdown AP.");
    }
}

class DBServer extends ExternalResource {
    @Override
    protected void before() throws Throwable {
        System.out.println("start DB");
    }

    @Override
    protected void after() {
        System.out.println("shutdown DB.");
    }
}