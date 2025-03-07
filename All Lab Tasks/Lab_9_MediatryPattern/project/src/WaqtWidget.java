public class WaqtWidget extends WidgetComponent
{
    private  String waqtName;
    private  String waqtTime;

    public WaqtWidget(Mediator mediator)
    {
        super(mediator);
    }
     public void setWaqt(String waqtName,String waqtTime)
     {
         this.waqtName=waqtName;
         this.waqtTime=waqtTime;
         System.out.println("Waqt: " + waqtName + " -> " + waqtTime);

         mediator.notify("WaqtUpdated");
     }

    public String getWaqtTime() {
        return waqtTime;
    }

    public String getWaqtName() {
        return waqtName;
    }
}
