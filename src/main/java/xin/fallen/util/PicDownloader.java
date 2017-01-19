package xin.fallen.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by itsxun on 16/12/2.
 */
public class PicDownloader {
    private static Logger logger = LoggerFactory.getLogger("logger");

    private static final String url = "https://api.weixin.qq.com/cgi-bin/media/get?access_token={ACCESS_TOKEN}&amp;media_id={MEDIA_ID}";

    public static byte[] download(String mediaId, String acc_token) {
        byte[] pic = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet get = new HttpGet(url.replace("{ACCESS_TOKEN}",acc_token)
                    .replace("{MEDIA_ID}",mediaId));
            CloseableHttpResponse response = httpclient.execute(get);
            try {
                if (response.getStatusLine().getStatusCode() == 200) {
                    HttpEntity entity = response.getEntity();
                    pic = EntityUtils.toByteArray(entity);
                    EntityUtils.consume(entity);
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            logger.error("图片下载请求发起失败，原因是：{}", e.getMessage());
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                logger.error("HttpClient关闭失败");
            }
        }
        return pic;
    }

    public static byte[] download(String picUrl) {
        byte[] pic = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet get = new HttpGet(picUrl);
            CloseableHttpResponse response = httpclient.execute(get);
            try {
                if (response.getStatusLine().getStatusCode() == 200) {
                    HttpEntity entity = response.getEntity();
                    pic = EntityUtils.toByteArray(entity);
                    EntityUtils.consume(entity);
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            logger.error("图片下载请求发起失败，原因是：{}", e.getMessage());
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                logger.error("HttpClient关闭失败");
            }
        }
        return pic;
    }
}
