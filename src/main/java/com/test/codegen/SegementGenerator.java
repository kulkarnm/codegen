package com.test.codegen;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMod;
import com.test.keywords.AccessModifier;
import com.test.keywords.OtherModifier;
import com.test.metadata.TypeMetadata;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class SegementGenerator<T extends TypeMetadata> {
    protected static int resolveAccessModifier(int defaultMod, AccessModifier accessModifier) {
        int finalMods = defaultMod;
        switch (accessModifier) {
            case DEFAULT:
                finalMods = finalMods | JMod.NONE;
                break;
            case PRIVATE:
                finalMods = finalMods | JMod.PRIVATE;
                break;
            case PROTECTED:
                finalMods = finalMods | JMod.PROTECTED;
            case PUBLIC:
                finalMods = finalMods | JMod.PUBLIC;

        }
        return finalMods;
    }

    protected static int resolveOtherModifier(int defaultMod, OtherModifier otherModifier) {
        int finalMods = defaultMod;
        switch (otherModifier) {
            case ABSTRACT:
                finalMods = finalMods | JMod.ABSTRACT;
                break;
            case FINAL:
                finalMods = finalMods | JMod.FINAL;
                break;
            case SYNCHRONIZED:
                finalMods = finalMods | JMod.SYNCHRONIZED;
                break;
            case STATIC:
                finalMods = finalMods | JMod.STATIC;
        }
        return finalMods;
    }

    public void generateCode(String path, JCodeModel cm) {
        File file = new File(path);
        file.mkdirs();
        try {
            cm.build(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract JDefinedClass generateSegment(T typeMetadataList, JDefinedClass jDefinedClass);

} 
