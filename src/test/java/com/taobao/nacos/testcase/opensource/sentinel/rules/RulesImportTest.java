package com.taobao.nacos.testcase.opensource.sentinel.rules;

import com.taobao.nacos.testcase.BaseTestCase;
import com.taobao.nacos.unit.SentinelParamRuleUnit;
import com.taobao.nacos.unit.SentinelRuleUnit;
import com.taobao.nacos.utils.HttpUtils;
import com.taobao.test.bolt.json.FastjsonUtils;
import com.taobao.test.common.dtaf.junit.annotation.TestSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RulesImportTest extends BaseTestCase {
    @Before
    public void before() {

    }

    @After
    public void after() {

    }

    @Test
    @TestSet("opensource")
    public void addFlowRuleByFile() {
        String getPortUrl = String.format("http://%s:%s/app/opensource-sentinel/machines.json", sentinelDashboardIp, sentinelDashboardPort);
        String content = HttpUtils.get(getPortUrl, new ArrayList<>());
        SentinelRuleUnit result = (SentinelRuleUnit) FastjsonUtils.jsonString2Entity(content, SentinelRuleUnit.class);
        List<SentinelRuleUnit.Rule> machines = result.getData();
        int port = 0;
        for (SentinelRuleUnit.Rule machine : machines) {
            if ("opensource-sentinel".equals(machine.getApp()) && testMachineIp.equals(machine.getIp())) {
                port = machine.getPort();
                break;
            }
        }
        String url = String.format("http://%s:%s/v1/flow/rules?app=opensource-sentinel&ip=%s&port=%s",
                sentinelDashboardIp, sentinelDashboardPort, testMachineIp, port);
        String httpResult = HttpUtils.get(url, new ArrayList<>());
        SentinelRuleUnit sentinelRuleUnit = (SentinelRuleUnit) FastjsonUtils.jsonString2Entity(httpResult, SentinelRuleUnit.class);
        List<SentinelRuleUnit.Rule> data = sentinelRuleUnit.getData();
        for (SentinelRuleUnit.Rule rule : data) {
            switch (rule.getResource()) {
                case "/bad":
                    Assert.assertEquals("check /bad error ", 1, rule.getGrade());
                    Assert.assertTrue("check /bad error ", 0 == rule.getCount());
                    Assert.assertEquals("check /bad error ", "default", rule.getLimitApp());
                    Assert.assertEquals("check /bad error ", 0, rule.getStrategy());
                    break;
                case "hi":
                    Assert.assertEquals("check hi error ", 1, rule.getGrade());
                    Assert.assertTrue("check hi error ", 0 == rule.getCount());
                    Assert.assertEquals("check hi error ", "default", rule.getLimitApp());
                    Assert.assertEquals("check hi error ", 0, rule.getStrategy());
                    break;
                case "/good":
                    Assert.assertEquals("check /good error ", 1, rule.getGrade());
                    Assert.assertTrue("check /good error ", 10 == rule.getCount());
                    Assert.assertEquals("check /good error ", "default", rule.getLimitApp());
                    Assert.assertEquals("check /good error ", 0, rule.getStrategy());
                    break;
                case "hello":
                    Assert.assertEquals("check hello error ", 1, rule.getGrade());
                    Assert.assertTrue("check hello error ", 1 == rule.getCount());
                    Assert.assertEquals("check hello error ", "default", rule.getLimitApp());
                    Assert.assertEquals("check hello error ", 0, rule.getStrategy());
                    break;
                default:
                    Assert.assertTrue("there are not expected rules ", false);
            }
        }
    }

    @Test
    @TestSet("opensource")
    public void addDegradeRuleByNacos() {
        String getPortUrl = String.format("http://%s:%s/app/opensource-sentinel/machines.json", sentinelDashboardIp, sentinelDashboardPort);
        String content = HttpUtils.get(getPortUrl, new ArrayList<>());
        SentinelRuleUnit result = (SentinelRuleUnit) FastjsonUtils.jsonString2Entity(content, SentinelRuleUnit.class);
        List<SentinelRuleUnit.Rule> machines = result.getData();
        int port = 0;
        for (SentinelRuleUnit.Rule machine : machines) {
            if ("opensource-sentinel".equals(machine.getApp()) && testMachineIp.equals(machine.getIp())) {
                port = machine.getPort();
                break;
            }
        }
        String url = String.format("http://%s:%s/degrade/rules.json?app=opensource-sentinel&ip=%s&port=%s",
                sentinelDashboardIp, sentinelDashboardPort, testMachineIp, port);
        String httpResult = HttpUtils.get(url, new ArrayList<>());
        SentinelRuleUnit sentinelRuleUnit = (SentinelRuleUnit) FastjsonUtils.jsonString2Entity(httpResult, SentinelRuleUnit.class);
        List<SentinelRuleUnit.Rule> data = sentinelRuleUnit.getData();
        for (SentinelRuleUnit.Rule rule : data)
            switch (rule.getResource()) {
                case "/exceptionRatio":
                    Assert.assertEquals("check /exceptionRatio error ", 1, rule.getGrade());
                    Assert.assertTrue("check /exceptionRatio error ", 0.1 == rule.getCount());
                    Assert.assertEquals("check /exceptionRatio error ", "default", rule.getLimitApp());
                    break;
                case "/exceptionCount":
                    Assert.assertEquals("check /exceptionCount error ", 2, rule.getGrade());
                    Assert.assertTrue("check /exceptionCount error ", 5 == rule.getCount());
                    Assert.assertEquals("check /exceptionCount error ", "default", rule.getLimitApp());
                    break;
                case "abc0":
                    Assert.assertEquals("check abc0 error ", 0, rule.getGrade());
                    Assert.assertTrue("check abc0 error ", 20 == rule.getCount());
                    Assert.assertEquals("check abc0 error ", "default", rule.getLimitApp());
                    break;
                default:
                    Assert.assertTrue("there are not expected rules ", false);
            }
    }

    @Test
    @TestSet("opensource")
    public void addParamRuleByFile() {
        String getPortUrl = String.format("http://%s:%s/app/opensource-sentinel/machines.json", sentinelDashboardIp, sentinelDashboardPort);
        String content = HttpUtils.get(getPortUrl, new ArrayList<>());
        SentinelRuleUnit result = (SentinelRuleUnit) FastjsonUtils.jsonString2Entity(content, SentinelRuleUnit.class);
        List<SentinelRuleUnit.Rule> machines = result.getData();
        int port = 0;
        for (SentinelRuleUnit.Rule machine : machines) {
            if ("opensource-sentinel".equals(machine.getApp()) && testMachineIp.equals(machine.getIp())) {
                port = machine.getPort();
                break;
            }
        }
        String url = String.format("http://%s:%s/paramFlow/rules?app=opensource-sentinel&ip=%s&port=%s",
                sentinelDashboardIp, sentinelDashboardPort, testMachineIp, port);
        String httpResult = HttpUtils.get(url, new ArrayList<>());
        SentinelParamRuleUnit sentinelRuleUnit = (SentinelParamRuleUnit) FastjsonUtils.jsonString2Entity(httpResult, SentinelParamRuleUnit.class);
        Map<String, String> ruleMap = FastjsonUtils.jsonString2Map(sentinelRuleUnit.getData().get(0).getRule().toString());
        if ("hotResource".equals(ruleMap.get("resource"))) {
            List<Map<String, String>> list = FastjsonUtils.jsonToMapList(ruleMap.get("paramFlowItemList"));
            Assert.assertEquals("1", list.get(0).get("count"));
            Assert.assertEquals("2", list.get(0).get("object"));
            Assert.assertEquals("int", list.get(0).get("classType"));
        }else {
            Assert.assertTrue("there are not expected rules ", false);
        }
    }

}
