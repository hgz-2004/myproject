package mobileshop.service;

import mobileshop.entity.UserEntity;

public interface UserService {
    boolean validUserPwd(UserEntity ue);

    UserEntity getUserByUsername(String username);

    boolean save(UserEntity ue);

    boolean existUserNameOrEmail(String username, String email);

    // Kept as a compatibility alias for the earlier registration implementation.
    boolean register(UserEntity ue);
}
