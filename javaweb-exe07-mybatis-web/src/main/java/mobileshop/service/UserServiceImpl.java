package mobileshop.service;

import mobileshop.dao.UserDao;
import mobileshop.entity.UserEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean validUserPwd(UserEntity ue) {
        //请完善代码。
        if (ue == null || StringUtils.isBlank(ue.getUsername())) {
            return false;
        }
        UserEntity dbUser = getUserByUsername(ue.getUsername());
        if (dbUser == null) {
            return false;
        }
        return StringUtils.equals(dbUser.getPassword(), ue.getPassword());
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return userDao.findByUserName(username);
    }
}
