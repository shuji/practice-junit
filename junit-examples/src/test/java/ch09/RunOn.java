package ch09;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * リスト9.18 RunOnアノテーション
 * @author shuji.w6e
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface RunOn {

    public enum OS {
        WINDOWS, MAC, LINUX
    }

    public OS value();
}
