package ch18.ex06;

import java.util.concurrent.Executors;

/**
 * リスト18.13 BackgroundTaskクラス
 * @author shuji.w6e
 */
public class BackgroundTask {

    private final Runnable task;

    public BackgroundTask(Runnable task) {
        this.task = task;
    }

    public void invoke() {
        Executors.newSingleThreadExecutor().execute(task);
    }
}
