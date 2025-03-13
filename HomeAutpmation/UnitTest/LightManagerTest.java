import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LightManagerTest {

    private LightManager lightManager;
    private SystemState systemState;

    @BeforeEach
    public void setUp() {
        lightManager = new LightManager();
        systemState = new SystemState();
    }



}
