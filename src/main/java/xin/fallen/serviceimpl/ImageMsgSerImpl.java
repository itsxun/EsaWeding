package xin.fallen.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.fallen.bean.ImageMsg;
import xin.fallen.dao.ImageMsgMapper;
import xin.fallen.service.ImageMsgSer;

/**
 * Created by itsxun on 16/12/25.
 */
@Service
public class ImageMsgSerImpl implements ImageMsgSer {
    @Autowired
    private ImageMsgMapper imageMsgMapper;

    public ImageMsg findRecord(String msgId) {
        return null;
    }

    public int addRecord(ImageMsg msg) {
        return imageMsgMapper.insert(msg);
    }

}