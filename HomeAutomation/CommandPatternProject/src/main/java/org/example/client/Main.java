// Main.java (Client)
package org.example.client;

import org.example.command.TurnOnLightCommand;
import org.example.command.TurnOffLightCommand;
import org.example.invoker.RemoteControl;
import org.example.receiver.Light;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();

        // Create Command objects
        TurnOnLightCommand turnOn = new TurnOnLightCommand(light);
        TurnOffLightCommand turnOff = new TurnOffLightCommand(light);

        // Create Invoker
        RemoteControl remote = new RemoteControl();

        // Execute Commands
        remote.setCommand(turnOn);
        remote.pressButton();  // Output: Light is ON

        remote.setCommand(turnOff);
        remote.pressButton();  // Output: Light is OFF
    }
}
