package com.taobao.test;

import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias("SpringCloudAlibabaApplication")

public class SpringCloudAlibabaApplication {


    protected boolean isDeploySuccessfully() {

        return true;
    }


    // stop app
    public String keyWordForKillCommand() {
        return null;
    }

}
