package com.taobao.nacos.testcase.alibabacloud;

import com.taobao.nacos.testcase.BaseTestCase;
import com.taobao.nacos.unit.AnsEndpointUnit;
import com.taobao.nacos.unit.EndPointUrl;
import com.taobao.nacos.unit.NacosDiscoveryEndpointTest;
import com.taobao.nacos.unit.ServiceName;
import com.taobao.nacos.utils.HttpUtils;
import com.taobao.test.bolt.json.FastjsonUtils;
import com.taobao.test.common.dtaf.junit.annotation.TestSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.cloud.alibaba.nacos.NacosDiscoveryProperties;
import org.springframework.cloud.alicloud.context.ans.AnsProperties;

import java.util.ArrayList;

public class EndPointTest extends BaseTestCase {
    @Before
    public void before() {

    }

    @After
    public void after() {

    }

    @TestSet("alibabacloud")
    @Test
    public void ansSB2(){
        String url = String.format("http://%s:%s%s",testMachineIp,consumerSpringBootTwoManagementPort, EndPointUrl.ansEndPointsb2);
        String httpResult = HttpUtils.get(url, new ArrayList<>());
        AnsEndpointUnit result = (AnsEndpointUnit) FastjsonUtils.jsonString2Entity(httpResult, AnsEndpointUnit.class);
        AnsProperties ansProperties = result.getAnsProperties();
        Assert.assertTrue("",testMachineIp.contains(ansProperties.getClientIp()));
        Assert.assertEquals("", ServiceName.map.get("alicloudServiceConsumer2"),ansProperties.getClientDomains());
        Assert.assertTrue("",ansProperties.isRegisterEnabled());
    }

    @TestSet("alibabacloud")
    @Test
    public void ansSB1(){
        String url = String.format("http://%s:%s%s",testMachineIp,consumerSpringBootOneManagementPort,EndPointUrl.ansEndPointsb1);
        String httpResult = HttpUtils.get(url, new ArrayList<>());
        AnsEndpointUnit result = (AnsEndpointUnit) FastjsonUtils.jsonString2Entity(httpResult, AnsEndpointUnit.class);
        AnsProperties ansProperties = result.getAnsProperties();
        Assert.assertTrue("",testMachineIp.contains(ansProperties.getClientIp()));
        Assert.assertEquals("", ServiceName.map.get("alicloudServiceConsumer"),ansProperties.getClientDomains());
        Assert.assertTrue("",ansProperties.isRegisterEnabled());
    }
}