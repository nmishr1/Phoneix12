package com.taobao.nacos.testcase.opensource.nacosdiscovery;

import com.alibaba.fastjson.JSONArray;
import com.taobao.nacos.testcase.BaseTestCase;
import com.taobao.nacos.unit.ServiceName;
import com.taobao.nacos.unit.QueryServiceUnit;
import com.taobao.nacos.unit.EndPointUrl;
import com.taobao.nacos.utils.HttpUtils;
import com.taobao.test.bolt.json.FastjsonUtils;
import com.taobao.test.common.dtaf.junit.annotation.TestSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QueryServiceTest extends BaseTestCase {

    @Before
    public void before() {

    }

    @After
    public void after() {

    }

    @TestSet("opensource")
    @Test
    public void getServicesSB1() {
        String getServiceUrl = "http://%s:%s%s";
        String queryUrl = String.format(getServiceUrl, testMachineIp, consumerSpringBootOnePort, EndPointUrl.getServiceUrl);
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        List<String> result = FastjsonUtils.jsonToStringList(httpResult);
        List<String> valuesList = new ArrayList<>(ServiceName.map.values());
        for (String serviceName : valuesList) {
            Assert.assertTrue(String.format("验证服务%s 在返回的服务列表中", serviceName), result.contains(serviceName));
        }
    }

    @TestSet("opensource")
    @Test
    public void getServicesSB2() {
        String getServiceUrl = "http://%s:%s%s";
        String queryUrl = String.format(getServiceUrl, testMachineIp, consumerSpringBootTwoPort, EndPointUrl.getServiceUrl);
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        List<String> result = FastjsonUtils.jsonToStringList(httpResult);
        List<String> valuesList = new ArrayList<>(ServiceName.map.values());
        for (String serviceName : valuesList) {
            Assert.assertTrue(String.format("验证服务%s 在返回的服务列表中", serviceName), result.contains(serviceName));
        }
    }

    @TestSet("opensource")
    @Test
    public void getConsumerServiceSB1() {
        String getServiceUrl = "http://%s:%s/services/%s";
        String queryUrl = String.format(getServiceUrl, testMachineIp, consumerSpringBootOnePort, ServiceName.map.get("OpensourceServiceConsumer"));
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        List<QueryServiceUnit> result = strToList(httpResult, QueryServiceUnit.class);
        List<Integer> ports = new ArrayList<>();
        for (QueryServiceUnit unit : result) {
            if (testMachineIp.equals(unit.getHost())) {
                ports.add(unit.getPort());
            }
        }
        Assert.assertTrue("", ports.size() >= 2);
    }

    @TestSet("opensource")
    @Test
    public void getProviderServiceSB1() {
        String getServiceUrl = "http://%s:%s/services/%s";
        String queryUrl = String.format(getServiceUrl, testMachineIp, consumerSpringBootOnePort, ServiceName.map.get("OpensourceServiceProvider"));
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        List<QueryServiceUnit> result = strToList(httpResult, QueryServiceUnit.class);
        List<Integer> ports = new ArrayList<>();
        for (QueryServiceUnit unit : result) {
            if (testMachineIp.equals(unit.getHost())) {
                ports.add(unit.getPort());
            }
        }
        Assert.assertTrue("", ports.size() >= 2);
    }

    @TestSet("opensource")
    @Test
    public void getConsumerServiceSB2() {
        String getServiceUrl = "http://%s:%s/services/%s";
        String queryUrl = String.format(getServiceUrl, testMachineIp, consumerSpringBootTwoPort, ServiceName.map.get("OpensourceServiceConsumer"));
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        List<QueryServiceUnit> result = strToList(httpResult, QueryServiceUnit.class);
        List<Integer> ports = new ArrayList<>();
        for (QueryServiceUnit unit : result) {
            if (testMachineIp.equals(unit.getHost())) {
                ports.add(unit.getPort());
            }
        }
        Assert.assertTrue("", ports.size() >= 2);
    }

    @TestSet("opensource")
    @Test
    public void getProviderServiceSB2() {
        String getServiceUrl = "http://%s:%s/services/%s";
        String queryUrl = String.format(getServiceUrl, testMachineIp, consumerSpringBootTwoPort, ServiceName.map.get("OpensourceServiceProvider"));
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        List<QueryServiceUnit> result = strToList(httpResult, QueryServiceUnit.class);
        List<Integer> ports = new ArrayList<>();
        for (QueryServiceUnit unit : result) {
            if (testMachineIp.equals(unit.getHost())) {
                ports.add(unit.getPort());
            }
        }
        Assert.assertTrue("", ports.size() >= 2);
    }

    private static <T> List<T> strToList(String str, Class<T> clazz) {
        JSONArray json = FastjsonUtils.jsonString2JsonArray(str);
        T t = null;
        List<T> list = new ArrayList<>();
        for (int i = 0; i < json.size(); i++) {
            t = (T) FastjsonUtils.jsonString2Entity(json.get(i).toString(), clazz);
            list.add(t);
        }
        return list;
    }
}
