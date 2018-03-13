package com.test.metadata;

import com.test.keywords.AccessModifier;

import java.util.List;
import java.util.Map;

public class ClassMetadata  implements TypeMetadata {
    private String className;
    private List<String> packagesToImport;
    private AccessModifier accessModifier;
    private String extendsFrom;
    private List<String> implementsFrom;
    private List<FieldMetaData> variables;
    private List<MethodMetadata> methods;
    private List<AnnotationMetadata> annotations;

    public ClassMetadata(String className, List<String> packagesToImport, AccessModifier accessModifier, String extendsFrom, List<String> implementsFrom, List<FieldMetaData> variables, List<MethodMetadata> methods,List<AnnotationMetadata> annotations) {
        this.className = className;
        this.packagesToImport = packagesToImport;
        this.accessModifier = accessModifier;
        this.extendsFrom = extendsFrom;
        this.implementsFrom = implementsFrom;
        this.variables = variables;
        this.methods = methods;
        this.annotations = annotations;
    }

    public String getClassName() {
        return className;
    }

    public List<String> getPackagesToImport() {
        return packagesToImport;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public String getExtendsFrom() {
        return extendsFrom;
    }

    public List<String> getImplementsFrom() {
        return implementsFrom;
    }

    public List<FieldMetaData> getVariables() {
        return variables;
    }

    public List<MethodMetadata> getMethods() {
        return methods;
    }

    public List<AnnotationMetadata> getAnnotations() {
        return annotations;
    }
}
