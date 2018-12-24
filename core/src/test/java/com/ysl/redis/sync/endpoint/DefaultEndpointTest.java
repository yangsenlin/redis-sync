package com.ysl.redis.sync.endpoint;

import com.ysl.redis.sync.api.endpoint.Endpoint;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Auther: senlinyang
 * @Date: 18-12-24 17:10
 * @Description:
 */
public class DefaultEndpointTest {

    @Test
    public void testEndPoint(){
        String url="redis://:password@127.0.0.1:6379";
        Endpoint endpoint = new DefaultEndpoint(url);
        Assert.assertEquals("redis",endpoint.getSchema());
        Assert.assertEquals("127.0.0.1",endpoint.getHost());
        Assert.assertEquals(6379,endpoint.getPort());
    }
}
