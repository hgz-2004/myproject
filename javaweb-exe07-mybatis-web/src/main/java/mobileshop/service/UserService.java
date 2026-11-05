package mobileshop.service;

import mobileshop.entity.UserEntity;

public interface UserService {
    boolean validUserPwd(UserEntity ue);

    UserEntity getUserByUsername(String username);
}
