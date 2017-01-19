package xin.fallen.dao;


import xin.fallen.bean.TextMsg;

/**
 * Created by itsxun on 16/12/25.
 */
public interface TextMsgMapper {
    int insert(TextMsg msg);

    TextMsg selectByPrimarykey(String msgId);
}
