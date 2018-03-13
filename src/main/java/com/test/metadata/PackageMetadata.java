package com.test.metadata;


public class PackageMetadata implements TypeMetadata {
    private String packageName;

    public PackageMetadata(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageName() {
        return packageName;
    }
}
