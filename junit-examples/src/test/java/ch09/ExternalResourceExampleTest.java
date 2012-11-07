package ch09;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

/**
 * リスト9.5 ExternalResourceの利用例
 * @author shuji.w6e
 */
public class ExternalResourceExampleTest {

    @Rule
    public ServerResource resource = new ServerResource();

    static class ServerResource extends ExternalResource {
        Server server;

        @Override
        protected void before() throws Throwable {
            server = new Server(8080);
            server.start();
        }

        @Override
        protected void after() {
            server.shutdown();
        }

    }

    @Test
    public void testCase() throws Exception {
    }

}
