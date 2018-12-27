package com.taobao.nacos.testcase.opensource.sentinel.flowlimit;

import com.taobao.nacos.testcase.BaseTestCase;
import com.taobao.nacos.utils.HttpUtils;
import com.taobao.test.common.dtaf.junit.annotation.TestSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class FlowLimitByFeignTest extends BaseTestCase {
    @Before
    public void before() {

    }

    @After
    public void after() {

    }

    @TestSet("opensource")
    @Test
    public void FlowLimitByFeignTestFail() {
        String url = String.format("http://%s:%s/sentinel/feign/fail", testMachineIp, consumerSpringBootTwoPort);
        String httpResult = HttpUtils.get(url, new ArrayList<>());
        Assert.assertEquals("fallback userSentinel", httpResult);
    }

    @TestSet("opensource")
    @Test
    public void FlowLimitByFeignTestSuccess() {
        String url = String.format("http://%s:%s/sentinel/feign/success", testMachineIp, consumerSpringBootTwoPort);
        String httpResult = HttpUtils.get(url, new ArrayList<>());
        Assert.assertTrue("check sentinel success",httpResult.contains("Sentinel: opensource-service-provider"));
    }
}
