package mobileshop.dao;

import mobileshop.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /**
     * 查找所有用户
     * @return
     */
    List<UserEntity> findAll();

    /**
     * 按用户名查找用户
     * @return
     */
    UserEntity findByUserName(String username);

    /**
     * 按用户名更新用户密码
     * @return
     */
    int updatePassword(@Param("username") String username,@Param("password") String password);

    /**
     * 新增用户
     * @param ue
     * @return
     */
    int save(UserEntity ue);

    /**
     * 根据传入的用户名删除用户
     * @param username
     * @return
     */
    int deleteByUsername(String username);
}