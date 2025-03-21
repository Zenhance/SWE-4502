public class StatisticsCollector {
    public int createCommandCount;
    public int updateCommandCount;
    public int deleteCommandCount;

    public StatisticsCollector(int createCommandCount, int updateCommandCount, int deleteCommandCount){
        this.createCommandCount = createCommandCount;
        this.updateCommandCount = updateCommandCount;
        this.deleteCommandCount = deleteCommandCount;
    }

    public void increaseCreateCommand(){
        createCommandCount++;
    }

    public void increaseUpdateCommand(){
        updateCommandCount++;
    }

    public void increaseDeleteCommand(){
        deleteCommandCount++;
    }

    public int  getCreateCount(){
        return createCommandCount;
    }

    public int getUpdateCount(){
        return updateCommandCount;
    }

    public int getDeleteCount(){
            return deleteCommandCount;
    }



}