package xin.fallen.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.fallen.bean.WechatUser;
import xin.fallen.dao.WechatUserMapper;
import xin.fallen.service.WechatUserSer;

/**
 * Created by itsxun on 17/1/19.
 */
@Service
public class WechatUserSerImpl implements WechatUserSer {
    @Autowired
    private WechatUserMapper wechatUserMapper;

    public int addRecord(WechatUser user) {
        return wechatUserMapper.insert(user);
    }

    public int setStatus(String openId, String status) {
        return wechatUserMapper.updateStatusByPrimaryKey(openId, status);
    }

    public Integer IsUserExist(String openId) {
        return wechatUserMapper.IsOpenIdExist(openId);
    }

    public int delUser(String openId) {
        return wechatUserMapper.deleteByPrimaryKey(openId);
    }
}
