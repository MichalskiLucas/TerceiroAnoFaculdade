package org.example.hamburguerAngus;

import java.util.Map;

public interface ViewEngine {
    String render(String viewName, Map<String, Object> context);
}
