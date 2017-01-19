package xin.fallen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xin.fallen.bean.*;
import xin.fallen.service.ImageMsgSer;
import xin.fallen.service.TextMsgSer;
import xin.fallen.util.PicDownloader;
import xin.fallen.util.PicDurable;
import xin.fallen.util.TokenSupplier;
import xin.fallen.util.Xml2Bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by itsxun on 16/12/25.
 */

@Controller
@RequestMapping("/msgDurableHandle")
public class MsgDurable {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private TextMsgSer textMsgSerImpl;

    @Autowired
    private ImageMsgSer imageMsgSerImpl;

//    @Autowired
//    private FollowEveSer followEveSerImpl;
//
//    @Autowired
//    private WechatUserSer wechatUserSerImpl;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/textMsg")
    public void textMsgDurableHandle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write("");
        String xmlDetail = (String) req.getAttribute("xmlDetail");
        Xml2Bean xml2Bean = new Xml2Bean(xmlDetail);
        TextMsg msg = (TextMsg) xml2Bean.getBean(TextMsg.class);
        msg.setCreateTime(sdf.format(new Date(Long.parseLong(msg
                .getCreateTime()) * 1000)));
        int status = textMsgSerImpl.addRecord(msg);
        if (status == 0) {
            log.error("{}消息插入失败", msg.getMsgId());
        }
    }

    @RequestMapping("/imageMsg")
    public void imageMsgDurableHandle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write("");
        String xmlDetail = (String) req.getAttribute("xmlDetail");
        Xml2Bean xml2Bean = new Xml2Bean(xmlDetail);
        ImageMsg msg = (ImageMsg) xml2Bean.getBean(ImageMsg.class);
        msg.setPicPath(System.currentTimeMillis()+".jpg");
        int status = imageMsgSerImpl.addRecord(msg);
        if (status == 0) {
            log.error("{}消息插入失败", msg.getMsgId());
        }
        String APPID = (String) redisTemplate.opsForValue().get("APPID");
        String APPSECRET = (String) redisTemplate.opsForValue().get("APPSECRET");
        Token token = TokenSupplier.getToken(APPID, APPSECRET);
        byte[] pic=PicDownloader.download(msg.getPicUrl());
        PicDurable.save(pic,msg.getPicPath());
    }

//    @RequestMapping("/FollowMsg")
//    public void FollowMsgDurableHandle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        resp.getWriter().write("");
//        String xmlDetail = (String) req.getAttribute("xmlDetail");
//        Xml2Bean xml2Bean = new Xml2Bean(xmlDetail);
//        FollowEve msg = (FollowEve) xml2Bean.getBean(FollowEve.class);
//        Integer status = followEveSerImpl.addRecord(msg);
//        if (status == 0) {
//            log.error("消息插入失败");
//        }
//    }
//
//    @RequestMapping("/UnFollowMsg")
//    public void UnFollowMsgDurableHandle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        resp.getWriter().write("");
//        String xmlDetail = (String) req.getAttribute("xmlDetail");
//        Xml2Bean xml2Bean = new Xml2Bean(xmlDetail);
//        FollowEve msg = (FollowEve) xml2Bean.getBean(FollowEve.class);
//        int status = wechatUserSerImpl.setStatus(msg.getFromUserName(), "0");
//        if (status == 0) {
//            log.error("用户{}取消关注失败", msg.getFromUserName());
//        }
//    }
}