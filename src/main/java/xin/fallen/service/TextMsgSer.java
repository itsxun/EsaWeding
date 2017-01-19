package xin.fallen.service;


import xin.fallen.bean.TextMsg;

/**
 * Created by itsxun on 16/12/25.
 */
public interface TextMsgSer {
    int addRecord(TextMsg textMsg);

    TextMsg findRecord(String msgId);
}