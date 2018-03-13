package com.test.templates;

import com.test.metadata.ClassMetadata;
import com.test.metadata.MethodMetadata;
import com.test.metadata.PackageMetadata;

import java.util.List;

public abstract class ComponentTemplate {
    private PackageMetadata packageMetadata;
    private ClassMetadata classMetadata;
    private List<MethodMetadata> methodMetadataList;

    public abstract ComponentTemplate buildMetadata();
} 
