package services;

import mapper.VolunteerMapper;
import model.Volunteer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import util.SqlSessionFactoryUtils;
import java.util.List;

/**
 * @author 22541
 */
public class VolunteerServices {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    /**
     * 查询所有
     * @return
     */
    public List<Volunteer> selectAll(){

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取VolunteerMapper
        VolunteerMapper mapper = sqlSession.getMapper(VolunteerMapper.class);
        //4. 调用方法
        List<Volunteer> volunteers = mapper.selectAll();
        sqlSession.close();
        return volunteers;
    }

    public void update(Volunteer volunteer){
        SqlSession sqlSession = factory.openSession();
        VolunteerMapper mapper = sqlSession.getMapper(VolunteerMapper.class);
        mapper.update(volunteer);
        sqlSession.commit();
        sqlSession.close();
    }

    public void insert(Volunteer volunteer){
        SqlSession sqlSession = factory.openSession();
        VolunteerMapper mapper = sqlSession.getMapper(VolunteerMapper.class);
        mapper.insert(volunteer);
        sqlSession.commit();
        sqlSession.close();
    }

    public void  deleteById(Integer id){
        SqlSession sqlSession = factory.openSession();
        VolunteerMapper mapper = sqlSession.getMapper(VolunteerMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    public Volunteer getById(Integer id){
        SqlSession sqlSession = factory.openSession();
        VolunteerMapper mapper = sqlSession.getMapper(VolunteerMapper.class);
        Volunteer volunteers = mapper.getById(id);
        sqlSession.commit();
        sqlSession.close();
        return volunteers;
    }
}
