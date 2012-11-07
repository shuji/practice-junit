package ch09;

import java.io.File;

import org.junit.rules.TemporaryFolder;

/**
 * リスト9.4 特定のサブフォルダを作成するルール
 * @author shuji.w6e
 */
public class SpecificTemporaryFolder extends TemporaryFolder {

    public File srcFolder;
    public File binFolder;

    @Override
    protected void before() throws Throwable {
        super.before();
        srcFolder = newFolder("src");
        binFolder = newFolder("bin");
    }
}
