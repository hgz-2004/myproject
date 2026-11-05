package mobileshop.dao;

import mobileshop.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    UserEntity findByUserName(String username);

    int save(UserEntity user);

    boolean existUserNameOrEmail(@Param("username") String username,
                                @Param("email") String email);
}
