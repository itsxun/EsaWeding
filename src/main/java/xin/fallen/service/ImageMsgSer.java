package xin.fallen.service;


import xin.fallen.bean.ImageMsg;

/**
 * Created by itsxun on 16/12/25.
 */
public interface ImageMsgSer {
    int addRecord(ImageMsg msg);

    ImageMsg findRecord(String msgId);
}