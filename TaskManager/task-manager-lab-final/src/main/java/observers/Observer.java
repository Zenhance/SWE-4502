package observers;

import commands.Command;

public interface Observer {
    void update(Command command);
}
