package com.test.metadata;

import com.test.keywords.AccessModifier;
import com.test.keywords.OtherModifier;

import java.util.List;

public class FieldMetaData  implements TypeMetadata {
    private String name;
    private AccessModifier accessModifier;
    private List<OtherModifier> otherModifiers;
    private String compositeType;
    private List<AnnotationMetadata> annotations;

    public FieldMetaData(String name, AccessModifier accessModifier, List<OtherModifier> otherModifiers, String compositeType, List<AnnotationMetadata> annotations) {
        this.name = name;
        this.accessModifier = accessModifier;
        this.otherModifiers = otherModifiers;
        this.compositeType = compositeType;
        this.annotations=annotations;
    }

    public String getName() {
        return name;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public List<OtherModifier> getOtherModifiers() {
        return otherModifiers;
    }

    public String getCompositeType() {
        return compositeType;
    }

    public List<AnnotationMetadata> getAnnotations() {
        return annotations;
    }
}
