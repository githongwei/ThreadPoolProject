package com.pack.util.dbcp.datasource;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DynDatasource {

    String sourceName() default "masterDataSource";

}
