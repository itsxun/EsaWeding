package xin.fallen.util;


import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xin.fallen.bean.Token;

import java.io.IOException;

/**
 * Created by FallenXun
 * Date: 16-12-9
 * Time: 下午3:44
 * Usage:
 */
public class TokenSupplier {
    private static Logger log = LoggerFactory.getLogger("log");

    private static final String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={APPID}&secret={APPSECRET}";

    public static Token getToken(String APPID, String APPSECRET) {
        Token token = null;
        String address = url.replace("{APPID}", APPID).replace("{APPSECRET}", APPSECRET);
        System.out.println(address);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(address);
            CloseableHttpResponse response = httpclient.execute(httpGet);
            try {
                if (response.getStatusLine().getStatusCode() != 200) {
                    return null;
                }
                HttpEntity entity = response.getEntity();
                Gson gson = new Gson();
                token = gson.fromJson(EntityUtils.toString(entity, "utf-8"),
                        Token.class);
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } catch (Exception e) {
            log.error("请求access_token失败,原因是：{}", e.getMessage());
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                log.error("httpclient关闭异常，原因是：{}", e.getMessage());
            }
        }
        return token;
    }
}
