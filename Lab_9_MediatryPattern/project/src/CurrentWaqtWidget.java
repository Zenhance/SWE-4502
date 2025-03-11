public class CurrentWaqtWidget extends WidgetComponent
{
    private String currentWaqt;

    public CurrentWaqtWidget(Mediator mediator) {
        super(mediator);
    }

    public void updateCurrentWaqt(String waqt) {
        this.currentWaqt = waqt;
        System.out.println("Current Waqt Updated: " + currentWaqt);
    }

}
