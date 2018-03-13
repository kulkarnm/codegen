package com.test.codegen;

import com.sun.codemodel.*;
import com.test.keywords.AccessModifier;
import com.test.keywords.OtherModifier;
import com.test.metadata.AnnotationMetadata;
import com.test.metadata.MethodMetadata;

import java.util.List;

public class MethodGenerator extends SegementGenerator<MethodMetadata> {

    private JCodeModel cm;
    public MethodGenerator(JCodeModel cm){
        this.cm=cm;
    }

    public JDefinedClass generateSegment(MethodMetadata methodMetadata, JDefinedClass dc) {
        AccessModifier accessModifier =methodMetadata.getAccessModifier();
        List<OtherModifier> otherModifiers = methodMetadata.getOtherModifiers();
        int finalMod = resolveAccessModifier(0,accessModifier);
        for(OtherModifier modifier:otherModifiers){
            finalMod = resolveOtherModifier(finalMod,modifier);
        }
        String returnType = methodMetadata.getReturnType();
        String name = methodMetadata.getMethodName();
        JMethod m = dc.method(finalMod, cm.ref(returnType), name);
        List<AnnotationMetadata> annotations = methodMetadata.getAnnotations();
        for(AnnotationMetadata annotation: annotations){
            String annotationTypeName = annotation.getName();
            m.annotate(cm.ref(annotationTypeName));
        }

        JBlock jblock = m.body();
        JClass webIntegrationClass = cm.ref("com.badion.util.WebIntegrationTemplate");
        jblock.decl(webIntegrationClass, "template").init(webIntegrationClass.staticInvoke("newInstance").arg(dc.dotclass()));
        m.body()._return(webIntegrationClass.staticInvoke("build"));
        return dc;
    }

} 
