package xin.fallen.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.fallen.bean.FollowEve;
import xin.fallen.dao.FollowEveMapper;
import xin.fallen.service.FollowEveSer;

/**
 * Created by itsxun on 17/1/19.
 */
@Service
public class FollowEveSerImpl implements FollowEveSer {

    @Autowired
    private FollowEveMapper followEveMapper;

    public int addRecord(FollowEve msg) {
        return followEveMapper.insert(msg);
    }
}
