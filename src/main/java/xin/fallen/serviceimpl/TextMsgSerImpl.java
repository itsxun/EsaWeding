package xin.fallen.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.fallen.bean.TextMsg;
import xin.fallen.dao.TextMsgMapper;
import xin.fallen.service.TextMsgSer;

/**
 * Created by itsxun on 16/12/25.
 */
@Service
public class TextMsgSerImpl implements TextMsgSer {
    @Autowired
    private TextMsgMapper textMsgMapper;

    public int addRecord(TextMsg textMsg) {
       return textMsgMapper.insert(textMsg);
    }

    public TextMsg findRecord(String msgId) {
        return textMsgMapper.selectByPrimarykey(msgId);
    }
}