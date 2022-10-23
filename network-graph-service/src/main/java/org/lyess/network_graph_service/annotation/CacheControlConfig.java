package org.lyess.network_graph_service.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-10-23 11:27 a.m.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface CacheControlConfig {
    public boolean isPrivate() default true;
    public boolean noCache() default false;
    public boolean noStore() default false;
    public boolean noTransform() default true;
    public boolean mustRevalidate() default true;
    public boolean proxyRevalidate() default false;
    public int maxAge() default 0;
    public int sMaxAge() default 0;
}
