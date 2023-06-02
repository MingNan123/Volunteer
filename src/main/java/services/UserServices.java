package services;
import mapper.UserMapper;
import model.User;
import util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author 22541
 */
public class UserServices {
    public SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public User login(String username, String password){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4. 调用方法
        User user = mapper.selectByusername(username,password);
        //释放资源
        sqlSession.close();
        return  user;
    }

    public boolean add(User user){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4. 判断用户名是否存在
        User user1 = mapper.selectByUsername(user.getUsername());
        /*User user1 = mapper.selectByusername(User.getUsername());*/
        if(user1 == null){
            // 用户名不存在，注册
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return user1 == null;
    }
}

