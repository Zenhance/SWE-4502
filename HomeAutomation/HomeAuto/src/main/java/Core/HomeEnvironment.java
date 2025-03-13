package Core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeEnvironment {

    private final Map<String, Object> state= new HashMap<>();
    private final Map<String, List<Observer>> observers= new HashMap<>();
}
