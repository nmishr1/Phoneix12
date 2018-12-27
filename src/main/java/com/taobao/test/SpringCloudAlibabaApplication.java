package com.taobao.test;

import com.taobao.test.common.dtaf.ex.element.application.MiddleWareApplication;
import com.taobao.test.common.dtaf.ex.exception.deploy.DeployApplicationFailedException;
import com.taobao.test.common.dtaf.ex.script.ServerHubScript;
import com.taobao.test.common.sshtester.unit.SSHCommand;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;


@XStreamAlias("SpringCloudAlibabaApplication")

public class SpringCloudAlibabaApplication extends MiddleWareApplication {

    protected List<ServerHubScript> getDeployScripts() {
        return null;
    }

    protected boolean isDeploySuccessfully() {
//        Boolean isDeploy = Boolean.valueOf(properties.get("deploy.skip"));
//        String ip_addr;
//        if (isDeploy) {
//            ip_addr = IpUtils.getInternetIp();
//        } else {
//            ip_addr = properties.get("testAppAddr");
//        }
//        String sbaApplications = properties.get("sbaApplications");
//        String sbaPort = properties.get("sbaPort");
//        String url = "http://" + ip_addr + ":" + sbaPort + sbaApplications;
//        System.out.println("url is " + url);
//        String result = HttpUtils.doGet(url, 10);
//        System.out.println("-------------------");
//        System.out.println(result);
        return true;
    }

    @Override
    public void deploy() {
        String homePath = properties.get("homePath");
        String shellPath = properties.get("shellPath");
        String stopShell = properties.get("stopShell");
        String gitRepo = properties.get("gitRepo");
        String gitBranch = properties.get("gitBranch");
        String testAppAddr = properties.get("testAppAddr");
        SSHCommand command = new SSHCommand();
        command.addCommand("cd " + shellPath);
        command.addCommand("sh " + stopShell);
        command.addCommand("cd " + homePath);
        command.addCommand("rm -rf sca-examples");
        command.addCommand("git clone -b " + gitBranch + " " + gitRepo);
        command.addCommand("cd " + shellPath);
        command.addCommand("sh " + properties.get("startShell"));
        sSHClient.setIp(testAppAddr);
        sSHClient.executeCommandWithPTY(command);
        Long time = Long.valueOf(properties.get("deploy.time"));
        Long deployTime = time > 0 ? time : 50000;
        if (!isDeploySuccessfully()) {
            String errorInfo = "APP deploy failed!";
            System.out.println(errorInfo);
            throw new DeployApplicationFailedException(errorInfo);
        }
        try {
            Thread.sleep(deployTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // stop app
    public String keyWordForKillCommand() {
        return null;
    }

    // start
    public String startScriptPathForStartCommand() {
        return "sca-examples/" + properties.get("startShell");
    }
}
