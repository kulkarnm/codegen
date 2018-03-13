package com.test.metadata;

import com.sun.codemodel.JBlock;
import com.test.keywords.AccessModifier;
import com.test.keywords.OtherModifier;

import java.util.List;
import java.util.Map;

public class MethodMetadata  implements TypeMetadata {
    private AccessModifier accessModifier;
    private List<OtherModifier> otherModifiers;
    private String methodName;
    private String returnType;
    private Map<Class,String> paramTypesVsNames;
    private List<AnnotationMetadata> annotations;
    private JBlock bodyImplementation;

    public MethodMetadata(AccessModifier accessModifier, List<OtherModifier> otherModifiers, String methodName,String returnType, Map<Class, String> paramTypesVsNames, List<AnnotationMetadata> annotations,JBlock bodyImplementation) {
        this.accessModifier = accessModifier;
        this.otherModifiers = otherModifiers;
        this.methodName = methodName;
        this.returnType =returnType;
        this.paramTypesVsNames = paramTypesVsNames;
        this.annotations=annotations;
        this.bodyImplementation = bodyImplementation;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public List<OtherModifier> getOtherModifiers() {
        return otherModifiers;
    }

    public String getMethodName() {
        return methodName;
    }

    public Map<Class, String> getParamTypesVsNames() {
        return paramTypesVsNames;
    }

    public List<AnnotationMetadata> getAnnotations() {
        return annotations;
    }

    public String getReturnType() {
        return returnType;
    }

    public JBlock getBodyImplementation() {
        return bodyImplementation;
    }
}
