package mobileshop.dao;

import mobileshop.entity.UserEntity;

public interface UserDao {
    UserEntity findByUserName(String username);
}
