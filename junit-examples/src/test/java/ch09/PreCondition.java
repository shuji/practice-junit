package ch09;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * リスト9.16 事前条件をチェックするカスタムルール
 * @author shuji.w6e
 */
public abstract class PreCondition implements TestRule {

    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                verify();
                base.evaluate();
            }
        };
    }

    protected abstract void verify() throws Throwable;

}
