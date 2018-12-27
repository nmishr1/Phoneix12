package com.taobao.nacos.testcase.opensource.nacosdiscovery;

import com.taobao.nacos.testcase.BaseTestCase;
import com.taobao.nacos.unit.IpAddress;
import com.taobao.nacos.unit.NamingOpenApiResult;
import com.taobao.nacos.utils.HttpUtils;
import com.taobao.test.bolt.common.annotation.TestDescription;
import com.taobao.test.bolt.json.FastjsonUtils;
import com.taobao.nacos.unit.ServiceName;
import com.taobao.test.common.dtaf.junit.annotation.TestSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ServiceRegisterTest extends BaseTestCase {

    @Before
    public void before() {

    }

    @After
    public void after() {

    }
    @TestSet("opensource")
    @Test
    @TestDescription("验证spring boot 1.x 版本的应用服务注册成功")
    public void registerSuccessSB1OpensourceServiceConsumer() {
        String serviceName = ServiceName.map.get("OpensourceServiceConsumer");
        logger.info(String.format("this is %s service in spring boot 1.x register test",serviceName));
        String queryUrl = String.format(nacosServerIp, serviceName);
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        NamingOpenApiResult result = (NamingOpenApiResult) FastjsonUtils.jsonString2Entity(httpResult, NamingOpenApiResult.class);
        List<IpAddress> ipAddresses = result.getHosts();
        List<IpAddress> hosts = new ArrayList<>();
        for (IpAddress ip : ipAddresses) {
            if (testMachineIp.equals(ip.getIp()) && consumerSpringBootOnePort == ip.getPort()) {
                hosts.add(ip);
            }
        }
        Assert.assertTrue("验证spring boot 1.x 版本的应用服务注册成功",hosts.size() > 0);
    }

    @TestSet("opensource")
    @Test
    @TestDescription("验证spring boot 2.x 版本的应用服务注册成功")
    public void registerSuccessSB2OpensourceServiceConsumer() {
        String serviceName = ServiceName.map.get("OpensourceServiceConsumer");
        logger.info(String.format("this is %s service in spring boot 2.x register test",serviceName));
        String queryUrl = String.format(nacosServerIp, serviceName);
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        NamingOpenApiResult result = (NamingOpenApiResult) FastjsonUtils.jsonString2Entity(httpResult, NamingOpenApiResult.class);
        List<IpAddress> ipAddresses = result.getHosts();
        List<IpAddress> hosts = new ArrayList<>();
        for (IpAddress ip : ipAddresses) {
            if (testMachineIp.equals(ip.getIp()) && consumerSpringBootTwoPort == ip.getPort()) {
                hosts.add(ip);
            }
        }
        Assert.assertTrue("验证spring boot 2.x 版本的应用服务注册成功",hosts.size() > 0);
    }

    @TestSet("opensource")
    @Test
    @TestDescription("验证spring boot 1.x 版本的应用服务注册成功")
    public void registerSuccessSB1OpensourceServiceProvider() {
        String serviceName = ServiceName.map.get("OpensourceServiceProvider");
        logger.info(String.format("this is %s service in spring boot 1.x register test",serviceName));
        String queryUrl = String.format(nacosServerIp, serviceName);
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        NamingOpenApiResult result = (NamingOpenApiResult) FastjsonUtils.jsonString2Entity(httpResult, NamingOpenApiResult.class);
        List<IpAddress> ipAddresses = result.getHosts();
        List<IpAddress> hosts = new ArrayList<>();
        for (IpAddress ip : ipAddresses) {
            if (testMachineIp.equals(ip.getIp()) && providerSpringBootOnePort == ip.getPort()) {
                hosts.add(ip);
            }
        }
        Assert.assertTrue("验证spring boot 1.x 版本的应用服务注册成功",hosts.size() > 0);
    }

    @TestSet("opensource")
    @Test
    @TestDescription("验证spring boot 2.x 版本的应用服务注册成功")
    public void registerSuccessSB2OpensourceServiceProvider() {
        String serviceName = ServiceName.map.get("OpensourceServiceProvider");
        logger.info(String.format("this is %s service in spring boot 1.x register test",serviceName));
        String queryUrl = String.format(nacosServerIp, serviceName);
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        NamingOpenApiResult result = (NamingOpenApiResult) FastjsonUtils.jsonString2Entity(httpResult, NamingOpenApiResult.class);
        List<IpAddress> ipAddresses = result.getHosts();
        List<IpAddress> hosts = new ArrayList<>();
        for (IpAddress ip : ipAddresses) {
            if (testMachineIp.equals(ip.getIp()) && providerSpringBootTwoPort == ip.getPort()) {
                hosts.add(ip);
            }
        }
        Assert.assertTrue("验证spring boot 2.x 版本的应用服务注册成功",hosts.size() > 0);
    }

    @TestSet("opensource")
    @Test
    @TestDescription("验证spring boot 2.x 版本的应用服务注册成功")
    public void registerSuccessSB2OpensourceZuul() {
        String serviceName = ServiceName.map.get("OpensourceZuul");
        logger.info(String.format("this is %s service in spring boot 2.x register test",serviceName));
        String queryUrl = String.format(nacosServerIp, serviceName);
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        NamingOpenApiResult result = (NamingOpenApiResult) FastjsonUtils.jsonString2Entity(httpResult, NamingOpenApiResult.class);
        List<IpAddress> ipAddresses = result.getHosts();
        List<IpAddress> hosts = new ArrayList<>();
        for (IpAddress ip : ipAddresses) {
            if (testMachineIp.equals(ip.getIp()) && zuulSpringBootTwoPort == ip.getPort()) {
                hosts.add(ip);
            }
        }
        Assert.assertTrue("验证spring boot 2.x 版本的应用服务注册成功",hosts.size() > 0);
    }

    @TestSet("opensource")
    @Test
    @TestDescription("验证spring boot 2.x 版本的应用服务注册成功")
    public void registerSuccessSB2OpensourceServiceProvider3() {
        String serviceName = ServiceName.map.get("OpensourceServiceProvider3");
        logger.info(String.format("this is %s service in spring boot 2.x register test",serviceName));
        String queryUrl = String.format(nacosServerIp, serviceName);
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        NamingOpenApiResult result = (NamingOpenApiResult) FastjsonUtils.jsonString2Entity(httpResult, NamingOpenApiResult.class);
        List<IpAddress> ipAddresses = result.getHosts();
        List<IpAddress> hosts = new ArrayList<>();
        for (IpAddress ip : ipAddresses) {
            if (testMachineIp.equals(ip.getIp()) && provider3SpringBootTwoPort == ip.getPort()) {
                hosts.add(ip);
            }
        }
        Assert.assertTrue("验证spring boot 2.x 版本的应用服务注册成功",hosts.size() > 0);
    }
}
