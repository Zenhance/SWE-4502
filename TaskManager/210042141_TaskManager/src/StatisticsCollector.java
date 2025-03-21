public class StatisticsCollector {
    public int createCount;
    public int updateCount;
    public int deleteCount;

    public StatisticsCollector(int createCount, int updateCount, int deleteCount){
        this.createCount = createCount;
        this.updateCount = updateCount;
        this.deleteCount = deleteCount;
    }

    public void increaseCreateCommand(){
        createCount++;
    }

    public void increaseUpdateCommand(){
        updateCount++;
    }

    public void increaseDeleteCommand(){
        deleteCount++;
    }

    public int  getCreateCount(){
        return createCount;
    }

    public int getUpdateCount(){
        return updateCount;
    }

    public int getDeleteCount(){
            return deleteCount;
    }
    
}