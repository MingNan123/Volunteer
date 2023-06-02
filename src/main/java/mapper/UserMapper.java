package mapper;

import model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 22541
 */
public interface UserMapper {

    @Select("select * from volunteer_database.user where user_name = #{username} and password = #{password}")
    @ResultMap("userResultMap")
    User selectByusername (@Param("username") String username, @Param("password")String password);
    @Insert("insert into volunteer_database.user values (null,#{username},#{password})")
    void add(User user);
    @Select("select * from volunteer_database.user where user_name = #{username}")
    User selectByUsername (@Param("username") String username);
}
