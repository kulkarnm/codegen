package com.test.templates;

import com.test.keywords.AccessModifier;
import com.test.metadata.ClassMetadata;
import com.test.metadata.FieldMetaData;
import com.test.metadata.MethodMetadata;
import com.test.metadata.PackageMetadata;

import java.util.List;

public class RestControllerTemplate extends ComponentTemplate {

    public ComponentTemplate buildMetadata(){
        PackageMetadata pkgMetadata = new PackageMetadata("com.barclaycard.digital.directdebit.web");
        FieldMetaData fieldMetaData = new FieldMetaData("createDebitCommandService",AccessModifier.PRIVATE,null,"com.barclaycard.digital.directdebit.service.CreateDirectDebitCommandService",null);
        ClassMetadata classMetadata = new ClassMetadata("CreateDirectDebitCommandController",null, AccessModifier.PUBLIC,null,null,fieldMetaData)
    }

} 
