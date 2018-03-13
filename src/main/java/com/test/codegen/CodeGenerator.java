package com.test.codegen;

import com.sun.codemodel.*;
import com.test.keywords.AccessModifier;
import com.test.keywords.OtherModifier;
import com.test.metadata.AnnotationMetadata;
import com.test.metadata.ClassMetadata;
import com.test.metadata.FieldMetaData;
import com.test.metadata.MethodMetadata;

import java.util.List;
import java.util.Map;

public class CodeGenerator {

    private static JCodeModel cm = new JCodeModel();

    private SegementGenerator<ClassMetadata> classGenerator;
    private SegementGenerator<FieldMetaData> fieldGenerator;
    private SegementGenerator<MethodMetadata> methodGenerator;

    public CodeGenerator() {
        this.classGenerator = new ClassGenerator(cm);
        this.fieldGenerator = new FieldGenerator(cm);
        this.methodGenerator = new MethodGenerator(cm);
    }

    private void generateCode() {
        classGenerator.generateSegment();

    }





/*
    private static void createGetAllMethod(JDefinedClass dc, JFieldVar fieldForInject) {
        JMethod addGetAllMethod = dc.method(JMod.PUBLIC, cm.VOID, "getAllTest");
        addGetAllMethod.annotate(cm.ref("org.junit.Test"));
        JExpression getAllMethod = fieldForInject.invoke("getAll");
        JInvocation assertNotNull = cm.directClass("org.junit.Assert").staticInvoke("assertNotNull").arg(getAllMethod);
        addGetAllMethod.body().add(assertNotNull);
    }

    private static void createFindByMethod(JDefinedClass dc, JFieldVar fieldForInject) {
        JMethod addFindByIdMethod = dc.method(JMod.PUBLIC, cm.VOID, "findById");
        addFindByIdMethod.annotate(cm.ref("org.junit.Test"));
        JExpression findByIdMethod = fieldForInject.invoke("findById").arg(JExpr.lit((long) 10000L)).invoke("getId");
        JInvocation assertEquals = cm.directClass("org.junit.Assert").staticInvoke("assertEquals").arg(JExpr.cast(longType, findByIdMethod))
                .arg(JExpr.cast(longType, JExpr.lit(10000L)));
        addFindByIdMethod.body().add(assertEquals);
    }
*/

}
