package com.maviron.spring.springdemo.importdesc;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ServiceImportSelector.java
 * @Description TODO
 * @createTime 2022年08月11日 10:17:00
 */
public class ServiceImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.test.ConfigB"};
    }
}
