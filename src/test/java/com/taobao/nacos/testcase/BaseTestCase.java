package com.taobao.nacos.testcase;

import com.taobao.nacos.unit.NacosOpenApiConstants;

import java.util.Map;

public class BaseTestCase {

    public Map<String, String> params;
    public String nacosServerIp;
    public String testMachineIp;
    public int consumerSpringBootOnePort;
    public int consumerSpringBootTwoPort;
    public int consumerSpringBootOneManagementPort;
    public int consumerSpringBootTwoManagementPort;
    public int providerSpringBootOnePort;
    public int providerSpringBootTwoPort;
    public int zuulSpringBootTwoPort;
    public int gatewaySpringBootTwoPort;
    public int provider3SpringBootTwoPort;
    public int sentinelSpringBootTwoPort;
    public String sentinelDashboardIp;
    public int sentinelDashboardPort;

    public BaseTestCase() {
        nacosServerIp = System.getProperty("nacosServerIp", params.get("nacosServerIp")) + NacosOpenApiConstants.QUERY_INSTANCS_LIST_BY_SERVICENAME;
        testMachineIp = System.getProperty("testAppAddr", params.get("testAppAddr"));
        consumerSpringBootOnePort = Integer.valueOf(System.getProperty("consumer.springBootOne.port", params.get("consumer.springBootOne.port")));
        consumerSpringBootTwoPort = Integer.valueOf(System.getProperty("consumer.springBootTwo.port", params.get("consumer.springBootTwo.port")));
        consumerSpringBootOneManagementPort = Integer.valueOf(System.getProperty("consumer.springBootOne.management.port",params.get("consumer.springBootOne.management.port")));
        consumerSpringBootTwoManagementPort = Integer.valueOf(System.getProperty("consumer.springBootTwo.management.port",params.get("consumer.springBootTwo.management.port")));
        providerSpringBootOnePort = Integer.valueOf(System.getProperty("provider.springBootOne.port", params.get("provider.springBootOne.port")));
        providerSpringBootTwoPort = Integer.valueOf(System.getProperty("provider.springBootTwo.port", params.get("provider.springBootTwo.port")));
        zuulSpringBootTwoPort = Integer.valueOf(System.getProperty("zuul.springBootTwo.port", params.get("zuul.springBootTwo.port")));
        gatewaySpringBootTwoPort = Integer.valueOf(System.getProperty("gateway.springBootTwo.port",params.get("gateway.springBootTwo.port")));
        provider3SpringBootTwoPort = Integer.valueOf(System.getProperty("provider3.springBootTwo.port", params.get("provider3.springBootTwo.port")));
        sentinelSpringBootTwoPort = Integer.valueOf(System.getProperty("sentinel.springBootTwo.port",params.get("sentinel.springBootTwo.port")));
        sentinelDashboardIp = System.getProperty("sentinel.dashboard.ip",params.get("sentinel.dashboard.ip"));
        sentinelDashboardPort = Integer.valueOf(System.getProperty("sentinel.dashboard.port",params.get("sentinel.dashboard.port")));
    }
}
