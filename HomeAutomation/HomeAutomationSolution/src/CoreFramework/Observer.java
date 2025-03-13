package CoreFramework;

import CoreFramework.EnvironmentState;

public interface Observer {
    void update(EnvironmentState state);
}
