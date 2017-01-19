package xin.fallen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by itsxun on 17/1/19.
 */
@Controller
public class Test {
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/test")
    public void test(HttpServletRequest req, HttpServletResponse resp) {
//        redisTemplate.opsForValue().set("APPID", "wx0802b7199eb4ed8a");
//        redisTemplate.opsForValue().set("APPSECRET", "b2b9777938f3ab56b6b43965719876d1");

//        String APPID = (String) redisTemplate.opsForValue().get("APPID");
//        System.out.println(APPID);
    }
}