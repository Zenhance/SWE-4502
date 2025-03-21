package Lab_final_210042166.Task_Management_System.Statistics;

public class StatisticsCollector {
    private int createCount;
    private int updateCount;
    private int deleteCount;

    public void incrementCreateCount()
    {
        createCount++;
    }
    public void incrementUpdateCount()
    {
        updateCount++;
    }
    public void incrementDeleteCount()
    {
        deleteCount++;
    }

    public int getCreateCount()
    {
        return createCount;
    }
    public int getUpdateCount()
    {
        return updateCount;
    }
    public int getDeleteCount()
    {
        return deleteCount;
    }

}
