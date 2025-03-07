package Application;

public class DemoSleep {

    public static void sleep(long seconds){
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
