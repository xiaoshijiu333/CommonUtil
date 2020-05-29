package com.fei.common.server.iputil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/12/20
 * @Description: 获取客户端的ip地址
 */
public class GetClientIp {

    private static final Logger LOG = LoggerFactory.getLogger(GetClientIp.class);

    public static String getIpAdrress(HttpServletRequest request) {
        String ip = null;

        String ipAddresses = request.getHeader(AgentServerConstant.AGENT_SQUID);

        if (ipAddresses == null || ipAddresses.length() == 0
                || AgentServerConstant.UNKNOWN.equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader(AgentServerConstant.AGENT_APACHE);
        }

        if (ipAddresses == null || ipAddresses.length() == 0
                || AgentServerConstant.UNKNOWN.equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader(AgentServerConstant.AGENT_WEBLOGIC);
        }

        if (ipAddresses == null || ipAddresses.length() == 0
                || AgentServerConstant.UNKNOWN.equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader(AgentServerConstant.AGENT_SOMEOTHER);
        }

        if (ipAddresses == null || ipAddresses.length() == 0
                || AgentServerConstant.UNKNOWN.equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader(AgentServerConstant.AGENT_NGINX);
        }

        // 有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }

        // 还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (ip == null || ip.length() == 0 || AgentServerConstant.UNKNOWN.equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
        LOG.info("ip地址为：{}", ip);
        return ip;
    }

}
