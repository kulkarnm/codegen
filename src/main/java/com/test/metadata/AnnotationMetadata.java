package com.test.metadata;

import java.util.Map;

public class AnnotationMetadata implements TypeMetadata {
    private String name;
    private Map<String,String> params;

    public AnnotationMetadata(String name, Map<String, String> params) {
        this.name = name;
        this.params = params;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getParams() {
        return params;
    }
}
