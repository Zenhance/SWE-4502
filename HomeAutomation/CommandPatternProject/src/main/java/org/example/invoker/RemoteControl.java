// RemoteControl.java (Invoker)
package org.example.invoker;

import org.example.command.Command;

public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
