package org.lyess.network_graph_service.producer;

import org.lyess.network_graph_service.annotation.CacheControlConfig;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.ws.rs.core.CacheControl;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-10-23 11:26 a.m.
 */
public class CacheControlProducer {

    @Produces
    public CacheControl get(InjectionPoint injectionPoint) {
        CacheControlConfig ccConfig = injectionPoint.getAnnotated().getAnnotation(CacheControlConfig.class);
        CacheControl cc = null;
        if (ccConfig != null) {
            cc = new CacheControl();
            cc.setMaxAge(ccConfig.maxAge());
            cc.setMustRevalidate(ccConfig.mustRevalidate());
            cc.setNoCache(ccConfig.noCache());
            cc.setNoStore(ccConfig.noStore());
            cc.setNoTransform(ccConfig.noTransform());
            cc.setPrivate(ccConfig.isPrivate());
            cc.setProxyRevalidate(ccConfig.proxyRevalidate());
            cc.setSMaxAge(ccConfig.sMaxAge());
        }
        return cc;
    }
}
