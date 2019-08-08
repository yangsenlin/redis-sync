package com.ysl.sync.api.endpoint;

import java.net.InetSocketAddress;

/**
 * @Auther: senlinyang
 * @Date: 18-12-24 16:59
 * @Description:
 */
public interface Endpoint {

    String getSchema();

    String getHost();

    int getPort();

    String getUserName();

    String getPassword();

    InetSocketAddress getSocketAddress();
}
