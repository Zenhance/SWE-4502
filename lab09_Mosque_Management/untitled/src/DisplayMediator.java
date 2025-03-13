import java.awt.*;

public interface DisplayMediator {
    void notify(Component sender, String event);
    void setComponent(Component component);

}
