package ch09;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import ch09.RunOn.OS;

/**
 * リスト9.19
 * @author shuji.w6e
 */
public class OSDependent implements TestRule {

    @Override
    public Statement apply(final Statement base, final Description desc) {
        return new Statement() {

            @Override
            public void evaluate() throws Throwable {
                RunOn env = desc.getAnnotation(RunOn.class);
                if (env == null || canEvaluate(env.value())) {
                    base.evaluate();
                } else {
                    // don't evaluate
                }
            }

            private boolean canEvaluate(OS os) {
                String osName = System.getProperty("os.name");
                if (osName == null) return false;
                if (os == OS.WINDOWS && osName.startsWith("Windows")) return true;
                if (os == OS.MAC && osName.startsWith("Mac OS X")) return true;
                if (os == OS.LINUX && osName.startsWith("Linux")) return true;
                return false;
            }
        };
    }
}
