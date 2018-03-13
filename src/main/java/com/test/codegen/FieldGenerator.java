package com.test.codegen;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import com.test.keywords.AccessModifier;
import com.test.keywords.OtherModifier;
import com.test.metadata.AnnotationMetadata;
import com.test.metadata.FieldMetaData;

import java.util.List;

public class FieldGenerator extends SegementGenerator<FieldMetaData> {

    private JCodeModel cm;

    public FieldGenerator(JCodeModel cm) {
        this.cm = cm;
    }

    public JDefinedClass generateSegment(FieldMetaData field, JDefinedClass dc) {
        String name = field.getName();
        String type = field.getCompositeType();

        AccessModifier accessModifier = field.getAccessModifier();
        List<OtherModifier> otherModifiers = field.getOtherModifiers();
        int finalMod = resolveAccessModifier(0, accessModifier);
        for (OtherModifier modifier : otherModifiers) {
            finalMod = resolveOtherModifier(finalMod, modifier);
        }
        JFieldVar fieldForInject = dc.field(finalMod, type, name);
        List<AnnotationMetadata> annotations = field.getAnnotations();
        for (AnnotationMetadata annotation : annotations) {
            String annotationTypeName = annotation.getName();
            fieldForInject.annotate(cm.ref(annotationTypeName));
        }
        return dc;
    }

} 
