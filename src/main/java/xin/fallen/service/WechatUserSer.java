package xin.fallen.service;

import xin.fallen.bean.WechatUser;

/**
 * Created by itsxun on 17/1/19.
 */
public interface WechatUserSer {
    int addRecord(WechatUser user);

    int setStatus(String openId, String status);

    Integer IsUserExist(String openId);

    int delUser(String openId);
}