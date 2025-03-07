package observers;

import models.EnvironmentState;

public interface Observer {
    void update(EnvironmentState environmentState);
}
