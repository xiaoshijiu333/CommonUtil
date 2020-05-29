package com.fei.common.server.iputil;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/12/20
 * @Description: 服务器的一些常量
 */
public class AgentServerConstant {

    private AgentServerConstant() {
    }

    static final String UNKNOWN = "unknown";
    /**
     * X-Real-IP：nginx：服务代理
     * HTTP_CLIENT_IP：有些代理服务器
     * WL-Proxy-Client-IP：weblogic 服务代理
     * Proxy-Client-IP：apache 服务代理
     * X-Forwarded-For：Squid 服务代理
     */
    static final String AGENT_SQUID = "X-Forwarded-For";
    static final String AGENT_APACHE = "Proxy-Client-IP";
    static final String AGENT_WEBLOGIC = "WL-Proxy-Client-IP";
    static final String AGENT_SOMEOTHER = "HTTP_CLIENT_IP";
    static final String AGENT_NGINX = "X-Real-IP";

}
