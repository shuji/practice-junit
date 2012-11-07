package ch03;

public class Timeout {

    public int doLongTask() throws InterruptedException {
        // テストを失敗させるにはsleep時間を100L以上に修正してください
        Thread.sleep(50L);
        return 100;
    }

}
