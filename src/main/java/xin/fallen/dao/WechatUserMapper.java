package xin.fallen.dao;

import org.apache.ibatis.annotations.Param;
import xin.fallen.bean.WechatUser;

/**
 * Created by itsxun on 17/1/19.
 */
public interface WechatUserMapper {
    int insert(WechatUser user);

    int updateStatusByPrimaryKey(@Param("openId") String openId, @Param("status") String status);

    Integer IsOpenIdExist(String openId);

    int deleteByPrimaryKey(String openId);
}