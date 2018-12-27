package com.taobao.nacos.testcase.opensource.sentinel.flowlimit;

import com.taobao.nacos.testcase.BaseTestCase;
import com.taobao.nacos.utils.HttpUtils;
import com.taobao.test.common.dtaf.junit.annotation.TestSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.function.Function;

public class flowLimitbyurltest extends BaseTestCase {
    @Before
    public void before() {

    }

    @After
    public void after() {

    }

    @TestSet("opensource")
    @Test
    public void FlowLimitAllWithAnnotation() {
        String url = String.format("http://%s:%s/hi", testMachineIp, sentinelSpringBootTwoPort);
        String httpResult = HttpUtils.get(url, new ArrayList<>());
        Assert.assertEquals("this is flow limit", httpResult);
    }


    @TestSet("opensource")
    @Test
    public void flowLimitAllWithoutAnnotation() {
        String url = String.format("http://%s:%s/bad", testMachineIp, sentinelSpringBootTwoPort);
        String httpResult = HttpUtils.get(url, new ArrayList<>());
        Assert.assertEquals("Blocked by Sentinel (flow limiting)", httpResult);
    }

//    @TestSet("opensource")
//    @Test
//    public void helloFlowLimitOneInPerSecond() {
//        String queryString="metric/queryTopResourceMetric.json?app=opensource-sentinel&desc=true&pageIndex=1&pageSize=6";
//        MyThread myThread = new MyThread();
//        myThread.setFunction(() -> this.action(100, this::hello));
//        myThread.run();
//        String url=String.format("http://%s:%s/" + queryString,sentinelDashboardIp,sentinelDashboardPort);
//        String httpResult = HttpUtils.get(url, new ArrayList<>());
//
//    }

    private void action(int times, Runnable func) {
        for (int i = 0; i < times; i++) {
        func.run();
        }
    }

    private void hello() {
        String url = String.format("http://%s:%s/good", testMachineIp, sentinelSpringBootTwoPort);
        String httpResult = HttpUtils.get(url, new ArrayList<>());
    }

    class MyThread implements Runnable {
        Runnable function;

        @Override
        public void run() {

            function.run();
        }

        public void setFunction(Runnable function) {
            this.function = function;
        }
    }
}
