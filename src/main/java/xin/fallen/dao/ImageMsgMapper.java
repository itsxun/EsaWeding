package xin.fallen.dao;


import xin.fallen.bean.ImageMsg;

/**
 * Created by itsxun on 16/12/25.
 */
public interface ImageMsgMapper {
    int insert(ImageMsg msg);

    ImageMsg selectByPrimarykey(String msgId);
}
