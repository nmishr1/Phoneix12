package com.taobao.nacos.testcase.opensource.nacosconfig;

import com.taobao.nacos.testcase.BaseTestCase;
import com.taobao.nacos.utils.HttpUtils;
import com.taobao.test.bolt.json.FastjsonUtils;
import com.taobao.test.common.dtaf.junit.annotation.TestSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

public class QueryConfigTest extends BaseTestCase {
    @Before
    public void before() {

    }

    @After
    public void after() {

    }

    /*
    * queryNacosConfig
    * 1.set the configure in to nacos server settings
    * 2.start spring boot 1.x version with key info in controller
    * 3.check config info by controller interface
    * */
    @TestSet("opensource")
    @Test
    public void queryNacosConfigSB1() {
        String restUrl = "http://%s:%s/nacos-config";
        String queryUrl = String.format(restUrl, testMachineIp, providerSpringBootOnePort);
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        Map<String, String> result = FastjsonUtils.jsonString2Map(httpResult);
        Assert.assertEquals("check nacos config error key:ext.key","ext-config-common01.properties",result.get("ext.key"));
        Assert.assertEquals("check nacos config error key:ext.key02","ext-config-common02.properties",result.get("ext.key02"));
        Assert.assertEquals("check nacos config error key:ext.key03","ext-config-common03.properties",result.get("ext.key03"));
        Assert.assertEquals("check nacos config error key:bootstrap","bootstrap-common.properties",result.get("bootstrap"));
        Assert.assertEquals("check nacos config error key:all-common","all-common.properties",result.get("all-common"));
    }


    /*
     * queryNacosConfig
     * 1.set the configure in to nacos server settings
     * 2.start spring boot 2.x version with key info in controller
     * 3.check config info by controller interface
     * */
    @TestSet("opensource")
    @Test
    public void queryNacosConfigSB2() {
        String restUrl = "http://%s:%s/nacos-config";
        String queryUrl = String.format(restUrl, testMachineIp, providerSpringBootTwoPort);
        String httpResult = HttpUtils.get(queryUrl, new ArrayList<>());
        Map<String, String> result = FastjsonUtils.jsonString2Map(httpResult);
        Assert.assertEquals("check nacos config error key:ext.key","ext-config-common01.properties",result.get("ext.key"));
        Assert.assertEquals("check nacos config error key:ext.key02","ext-config-common02.properties",result.get("ext.key02"));
        Assert.assertEquals("check nacos config error key:ext.key03","ext-config-common03.properties",result.get("ext.key03"));
        Assert.assertEquals("check nacos config error key:bootstrap","bootstrap-common.properties",result.get("bootstrap"));
        Assert.assertEquals("check nacos config error key:all-common","all-common.properties",result.get("all-common"));
    }
}
