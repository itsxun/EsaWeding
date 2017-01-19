package xin.fallen.controller;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by itsxun on 16/12/25.
 */
@Controller
public class MsgDispatcher {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/dispatcher")
    public String dispatcher(HttpServletRequest req, HttpServletResponse resp) {
        log.info("收到新消息...");
        String type = null;
        String xmlDetail = null;
        try {
            xmlDetail = IOUtils.toString(req.getInputStream());
            System.out.println(xmlDetail);
            type = xmlDetail.substring(xmlDetail.indexOf("<MsgType><![CDATA[") + 18, xmlDetail.indexOf("]]></MsgType>"));
            req.setAttribute("xmlDetail", xmlDetail);
        } catch (IOException e) {
            log.error("消息分发异常，原因是:{}", e.getMessage());
        }
        if ("text".equals(type)) {
            return "forward:/msgDurableHandle/textMsg";
        }
        if ("image".equals(type)) {
            return "forward:/msgDurableHandle/imageMsg";
        }
//        if ("event".equals(type)) {
//            String eventType = xmlDetail.substring(xmlDetail.indexOf
//                            ("<Event><![CDATA[")+16,
//                    xmlDetail.indexOf("]]></Event>"));
//            if (eventType.equals("subscribe")) {
//                return "forward:/msgDurableHandle/FollowMsg";
//            }
//            if (eventType.equals("unsubscribe")) {
//                return "forward:/msgDurableHandle/UnFollowMsg";
//            }
//        }
        else {
            log.error("不支持的消息格式");
            return null;
        }
    }
}