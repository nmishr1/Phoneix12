package com.taobao.nacos.testcase.opensource.nacosdiscovery;

import com.taobao.nacos.testcase.BaseTestCase;
import com.taobao.nacos.utils.HttpUtils;
import com.taobao.test.common.dtaf.junit.annotation.TestSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ServiceInvokeTest extends BaseTestCase {
    @Before
    public void before() {

    }

    @After
    public void after() {

    }

    @TestSet("opensource")
    @Test
    public void userSB1restTest(){
        String restUrl = "http://%s:%s/user/rest";
        String queryUrl = String.format(restUrl, testMachineIp, consumerSpringBootOnePort);
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        Assert.assertTrue("",httpResult.contains("123"));
        Assert.assertTrue("",httpResult.contains("opensource-service-provider3"));
    }

    @TestSet("opensource")
    @Test
    public void userSB1feignTest(){
        String restUrl = "http://%s:%s/user/feign";
        String queryUrl = String.format(restUrl, testMachineIp, consumerSpringBootOnePort);
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        Assert.assertTrue("",httpResult.contains("123"));
        Assert.assertTrue("",httpResult.contains("opensource-service-provider3"));
    }

    @TestSet("opensource")
    @Test
    public void userSB2restTest(){
        String restUrl = "http://%s:%s/user/rest";
        String queryUrl = String.format(restUrl, testMachineIp, consumerSpringBootTwoPort);
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        Assert.assertTrue("",httpResult.contains("123"));
        Assert.assertTrue("",httpResult.contains("opensource-service-provider3"));
    }

    @TestSet("opensource")
    @Test
    public void userSB2feignTest(){
        String restUrl = "http://%s:%s/user/feign";
        String queryUrl = String.format(restUrl, testMachineIp, consumerSpringBootTwoPort);
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        Assert.assertTrue("",httpResult.contains("123"));
        Assert.assertTrue("",httpResult.contains("opensource-service-provider3"));
    }

    @TestSet("opensource")
    @Test
    public void zuulProvider1Test(){
        String zuulUrl = "http://%s:%s/provider1/user";
        String queryUrl = String.format(zuulUrl, testMachineIp, zuulSpringBootTwoPort);
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        Assert.assertTrue("",httpResult.contains("123"));
    }

    @TestSet("opensource")
    @Test
    public void zuulProvider3Test(){
        String zuulUrl = "http://%s:%s/provider3/user";
        String queryUrl = String.format(zuulUrl, testMachineIp, zuulSpringBootTwoPort);
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        Assert.assertTrue("",httpResult.contains("opensource-service-provider3"));
    }

    @TestSet("opensource")
    @Test
    public void gatewayProvider1Test(){
        String zuulUrl = "http://%s:%s/provider1/user";
        String queryUrl = String.format(zuulUrl, testMachineIp, gatewaySpringBootTwoPort);
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        Assert.assertTrue("",httpResult.contains("123"));
    }

    @TestSet("opensource")
    @Test
    public void gatewayProvider3Test(){
        String zuulUrl = "http://%s:%s/provider3/user";
        String queryUrl = String.format(zuulUrl, testMachineIp, gatewaySpringBootTwoPort);
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        Assert.assertTrue("",httpResult.contains("opensource-service-provider3"));
    }

}
