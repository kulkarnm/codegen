package com.test.codegen;

import com.sun.codemodel.JAnnotationUse;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.test.metadata.AnnotationMetadata;
import com.test.metadata.ClassMetadata;

import java.util.List;
import java.util.Map;

public class ClassGenerator extends SegementGenerator<ClassMetadata> {
    private JCodeModel cm;
    public ClassGenerator(JCodeModel cm){
        this.cm=cm;
    }
    public JDefinedClass generateSegment(List<ClassMetadata> classMetadatas,JDefinedClass jDefinedClass) {
        JDefinedClass dc = null;
        ClassMetadata classMetadata = classMetadatas.get(0);
        try {
            dc = cm._class(classMetadata.getClassName());
            List<AnnotationMetadata> annotations = classMetadata.getAnnotations();
            for (AnnotationMetadata annotation : annotations) {
                JAnnotationUse annotationUse = dc.annotate(cm.ref(annotation.getName()));
                Map<String, String> params = annotation.getParams();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    annotationUse.param(entry.getKey(), entry.getValue());
                }
            }
        } catch (JClassAlreadyExistsException e) {
            e.printStackTrace();
        }
        return dc;
    }

} 
