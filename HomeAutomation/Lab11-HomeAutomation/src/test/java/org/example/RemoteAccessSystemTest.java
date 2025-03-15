package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import smarthome.core.*;
import smarthome.components.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoteAccessSystemTest {

    @Mock
    private HomeSystem mockHomeSystem;

    @Mock
    private EnvironmentalState mockState;

    private RemoteAccessSystem remoteSystem;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Set up the mock environmental state
        Map<String, Object> stateValues = new HashMap<>();
        stateValues.put("temperature", 22.0);
        stateValues.put("motion", false);
        Mockito.when(mockState.getAllValues()).thenReturn(stateValues);

        // Set up the mock home system
        Mockito.when(mockHomeSystem.getFullState()).thenReturn(mockState);

        remoteSystem = new RemoteAccessSystem(mockHomeSystem);

        // Verify observer registration
        Mockito.verify(mockHomeSystem).registerObserver("all", remoteSystem);
    }

    @Test
    public void testNotificationCreation() {
        // Create a notification
        remoteSystem.createNotification("Test notification");

        // Verify notification was created
        List<String> notifications = remoteSystem.getNotifications();
        assertEquals(1, notifications.size());
        assertEquals("Test notification", notifications.get(0));
    }

    @Test
    public void testNotificationClearing() {
        // Create some notifications
        remoteSystem.createNotification("Test notification 1");
        remoteSystem.createNotification("Test notification 2");

        // Clear notifications
        remoteSystem.clearNotifications();
    }
}