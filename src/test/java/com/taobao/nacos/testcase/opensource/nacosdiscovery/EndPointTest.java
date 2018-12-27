package com.taobao.nacos.testcase.opensource.nacosdiscovery;

import com.taobao.nacos.testcase.BaseTestCase;
import com.taobao.nacos.unit.NacosDiscoveryEndpointTest;
import com.taobao.nacos.unit.ServiceName;
import com.taobao.nacos.unit.EndPointUrl;
import com.taobao.nacos.utils.HttpUtils;
import com.taobao.test.bolt.json.FastjsonUtils;
import com.taobao.test.common.dtaf.junit.annotation.TestSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.cloud.alibaba.nacos.NacosDiscoveryProperties;

import java.util.ArrayList;

public class EndPointTest extends BaseTestCase {
    @Before
    public void before() {

    }

    @After
    public void after() {

    }

    @TestSet("opensource")
    @Test
    public void nacosDiscoverySB2(){
    String nacosDiscoveryUrl = String.format("http://%s:%s%s",testMachineIp,consumerSpringBootTwoManagementPort, EndPointUrl.nacosEndPointUrl);
        String httpResult = HttpUtils.get(nacosDiscoveryUrl, new ArrayList<>());
        NacosDiscoveryEndpointTest result = (NacosDiscoveryEndpointTest) FastjsonUtils.jsonString2Entity(httpResult, NacosDiscoveryEndpointTest.class);
        NacosDiscoveryProperties nacosDiscoveryProperties = result.nacosDiscoveryProperties;
        Assert.assertTrue("",nacosServerIp.contains(nacosDiscoveryProperties.getServerAddr()));
        Assert.assertEquals("", ServiceName.map.get("OpensourceServiceConsumer2"),nacosDiscoveryProperties.getService());
        Assert.assertTrue("",nacosDiscoveryProperties.isRegisterEnabled());
    }

    @TestSet("opensource")
    @Test
    public void nacosDiscoverySB1(){
        String nacosDiscoveryUrl = String.format("http://%s:%s%s",testMachineIp,consumerSpringBootOneManagementPort, EndPointUrl.nacosEndPointUrlsb1);
        String httpResult = HttpUtils.get(nacosDiscoveryUrl, new ArrayList<>());
        NacosDiscoveryEndpointTest result = (NacosDiscoveryEndpointTest) FastjsonUtils.jsonString2Entity(httpResult, NacosDiscoveryEndpointTest.class);
        NacosDiscoveryProperties nacosDiscoveryProperties = result.nacosDiscoveryProperties;
        Assert.assertTrue("",nacosServerIp.contains(nacosDiscoveryProperties.getServerAddr()));
        Assert.assertEquals("", ServiceName.map.get("OpensourceServiceConsumer"),nacosDiscoveryProperties.getService());
        Assert.assertTrue("",nacosDiscoveryProperties.isRegisterEnabled());
    }
}