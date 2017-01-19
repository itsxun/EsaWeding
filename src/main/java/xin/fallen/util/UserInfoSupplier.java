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
import xin.fallen.bean.WechatUser;

import java.io.IOException;

/**
 * Created by itsxun on 17/1/19.
 */
public class UserInfoSupplier {
    private static Logger log = LoggerFactory.getLogger("log");
    private static final String url = "https://api.weixin.qq" +
            ".com/cgi-bin/user/info?access_token={ACCESS_TOKEN}&openid" +
            "={OPENID}";

    public static WechatUser getDetail(String token, String openId) {
        WechatUser user = null;
        String address = url.replace("{ACCESS_TOKEN}", token).replace("{OPENID}", openId);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(address);
            CloseableHttpResponse response = httpclient.execute(httpGet);
            try {
                if (response.getStatusLine().getStatusCode() != 200) {
                    return null;
                }
                HttpEntity entity = response.getEntity();
                String json = EntityUtils.toString(entity, "utf-8");
                System.out.println(json);
                Gson gson = new Gson();
                user = gson.fromJson(json, WechatUser.class);
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } catch (Exception e) {
            log.error("请求用户资料失败,原因是：{}", e.getMessage());
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                log.error("httpclient关闭异常，原因是：{}", e.getMessage());
            }
        }
        return user;
    }
}
