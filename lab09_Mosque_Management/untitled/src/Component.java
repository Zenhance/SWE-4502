abstract class Component {
    protected DisplayMediator mediator;

    public void setMediator(DisplayMediator mediator) {
        this.mediator = mediator;
    }

    public abstract void update();
}
