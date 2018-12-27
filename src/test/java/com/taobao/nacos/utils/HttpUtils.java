package com.taobao.nacos.utils;

import com.taobao.test.bolt.http.LoginUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class HttpUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    public static String get(String url,List<Cookie> cookieList) {
        logger.info("url is " + url);
        String result = "";
        HttpClient httpclient = new DefaultHttpClient();
        httpclient = LoginUtil.getHttpsClient(httpclient);
        HttpGet httpget = new HttpGet(url);
        String cookiesstr="";
        for (Cookie cookie : cookieList) {
            String oneCookie = cookie.getName() + "=" + cookie.getValue() + "; ";
            cookiesstr = cookiesstr + oneCookie;
            httpget.setHeader(cookie.getName(), cookie.getValue());
        }
        httpget.setHeader("Cookie", cookiesstr);
        HttpResponse httpResponse;
        try {
            httpResponse = httpclient.execute(httpget);
            logger.info("HttpUtils result code is " + httpResponse.getStatusLine().getStatusCode());
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity);
            logger.info("HttpUtils result is " + result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpget.releaseConnection();
        }
        return result;
    }
}
