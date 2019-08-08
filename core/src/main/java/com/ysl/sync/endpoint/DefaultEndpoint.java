package com.ysl.sync.endpoint;

import com.ysl.sync.api.endpoint.Endpoint;

import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Auther: senlinyang
 * @Date: 18-12-24 17:01
 * @Description:
 */
public class DefaultEndpoint implements Endpoint {

    private String url;
    private URI uri;

    public DefaultEndpoint(String url){
        try {
            this.url = url;
            this.uri = new URI(url);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("url is error",e);
        }
    }

    public String getSchema() {
        return uri.getScheme();
    }

    public String getHost() {
        return uri.getHost();
    }

    public int getPort() {
        return uri.getPort();
    }

    public String getUserName() {
        String[] userInfos = getUserInfo();
        if(userInfos == null || userInfos.length != 2){
            return null;
        }
        return userInfos[0];
    }

    public String getPassword() {
        String[] userInfos = getUserInfo();
        if(userInfos == null || userInfos.length != 2){
            return null;
        }
        return userInfos[1];
    }

    public InetSocketAddress getSocketAddress() {
        return new InetSocketAddress(getHost(), getPort());
    }

    public String[] getUserInfo(){
        String userInfo = uri.getUserInfo();
        if(userInfo != null){
            return userInfo.split("\\\\s*:\\\\s*");
        }
        return null;
    }

    @Override
    public String toString() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DefaultEndpoint that = (DefaultEndpoint) o;

        return uri != null ? uri.equals(that.uri) : that.uri == null;
    }

    @Override
    public int hashCode() {
        return uri != null ? uri.hashCode() : 0;
    }
}
