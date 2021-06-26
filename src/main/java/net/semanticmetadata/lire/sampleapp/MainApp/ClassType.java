package net.semanticmetadata.lire.sampleapp.MainApp;

import net.semanticmetadata.lire.imageanalysis.features.GlobalFeature;
import net.semanticmetadata.lire.imageanalysis.features.LireFeature;

public class ClassType {
    private String classType;
    private Class<? extends GlobalFeature> globalFeature;
    public ClassType(String classType,Class<? extends GlobalFeature> globalFeature) {
        this.classType = classType;
        this.globalFeature=globalFeature;
    }

    public String toString() {
        return this.classType;
    }
    public Class returnClass()
    {
        return globalFeature;
    }
}
