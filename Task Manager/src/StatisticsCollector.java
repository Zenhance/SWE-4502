public class StatisticsCollector {
    private int createCount = 0;
    private int updateCount = 0;
    private int deleteCount = 0;

    public void incrementCreate() {
        createCount++;
    }

    public void incrementUpdate() {
        updateCount++;
    }

    public void incrementDelete() {
        deleteCount++;
    }

    public void printStats() {
        System.out.println("Creates: " + createCount);
        System.out.println("Updates: " + updateCount);
        System.out.println("Deletes: " + deleteCount);
    }
}