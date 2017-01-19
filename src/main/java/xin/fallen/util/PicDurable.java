package xin.fallen.util;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by itsxun on 17/1/19.
 */
public class PicDurable {
    public static Logger log = LoggerFactory.getLogger("log");
//    private static final String savePath =
//            "/home/fallen/Server/tomcat_8080/war/EsaWeding/WEB-INF/images/";

    private static final String savePath =
            "/Users/itsxun/git/EsaWeding/src/main/webapp/WEB-INF/images/";

    public static void save(byte[] pic, String name) {
        System.out.println(pic.length);
        File file = new File(savePath + name);
        try {
            FileUtils.writeByteArrayToFile(file, pic);
        } catch (IOException e) {
            log.error("图片生成失败");
        }
    }
}
