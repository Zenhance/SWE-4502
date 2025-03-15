package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import smarthome.core.*;

import static org.junit.jupiter.api.Assertions.*;

class HomeSystemTest {

    private HomeSystem homeSystem;

    @Mock
    private StateChangeObserver mockObserver;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        homeSystem = new HomeSystem();
    }

//    @org.junit.jupiter.api.Test
//    void registerObserver() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void updateState() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void getStateValue() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void getFullState() {
//    }
@Test
public void testStateUpdate() {
    homeSystem.updateState("temperature", 22.5);
    assertEquals(22.5, homeSystem.getStateValue("temperature"));
}

    @Test
    public void testObserverNotification() {
        // Register mock observer for specific property
        homeSystem.registerObserver("temperature", mockObserver);

        // Update the monitored state
        homeSystem.updateState("temperature", 22.5);

        // Verify observer was notified with correct parameters
        Mockito.verify(mockObserver).onStateChange("temperature", null, 22.5);
    }

    @Test
    public void testMultipleObservers() {
        // Create a second mock observer
        StateChangeObserver mockObserver2 = Mockito.mock(StateChangeObserver.class);

        // Register both observers for same property
        homeSystem.registerObserver("temperature", mockObserver);
        homeSystem.registerObserver("temperature", mockObserver2);

        // Update the monitored state
        homeSystem.updateState("temperature", 22.5);

        // Verify both observers were notified
        Mockito.verify(mockObserver).onStateChange("temperature", null, 22.5);
        Mockito.verify(mockObserver2).onStateChange("temperature", null, 22.5);
    }

    @Test
    public void testUniversalObserver() {
        // Register observer for all properties
        homeSystem.registerObserver("all", mockObserver);

        // Update various states
        homeSystem.updateState("temperature", 22.5);
        homeSystem.updateState("motion", true);

        // Verify observer was notified for both changes
        Mockito.verify(mockObserver).onStateChange("temperature", null, 22.5);
        Mockito.verify(mockObserver).onStateChange("motion", null, true);
    }

    @Test
    public void testEnvironmentalStateGetAllValues() {
        homeSystem.updateState("temperature", 22.5);
        homeSystem.updateState("humidity", 45.0);

        EnvironmentalState state = homeSystem.getFullState();
        assertNotNull(state.getAllValues());
        assertEquals(2, state.getAllValues().size());
        assertEquals(22.5, state.getValue("temperature"));
        assertEquals(45.0, state.getValue("humidity"));
    }
}