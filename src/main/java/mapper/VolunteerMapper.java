package mapper;
import model.Volunteer;
import org.apache.ibatis.annotations.*;
import java.util.List;
/**
 * @author 22541
 */
public interface VolunteerMapper {
     //1、查询所有
     @Select("select * from volunteer_database.volunteer")
     @ResultMap("volunteerResultMap")
     List<Volunteer> selectAll();

     //2、新增志愿者信息
     @Insert("insert into volunteer_database.volunteer " +
             "values (#{vtId}, #{vtSno},#{vtName},#{vtRegion},#{vtStartTime},#{vtDuration},#{vtStatus})")
     @ResultMap("volunteerResultMap")
     void insert(Volunteer volunteer);

     //3、修改志愿者信息
     @Update("update volunteer_database.volunteer " +
             "set vt_name = #{vtName},vt_sno = #{vtSno},vt_region = #{vtRegion}," +
             "vt_duration=#{vtDuration},vt_startTime = #{vtStartTime} ,vt_status=#{vtStatus} " +
             "where vt_id = #{vtId}")
     @ResultMap("volunteerResultMap")
     void update(Volunteer volunteer);/*返回影响的行数*/

     //4、删除一条志愿者信息
     @Delete("DELETE FROM volunteer_database.volunteer WHERE vt_id=#{vtId}")
     @ResultMap("volunteerResultMap")
     void deleteById(int id);
     //5、得到一条志愿者信息
    @Select("select * from volunteer_database.volunteer where vt_id = #{vtId}")
    @ResultMap("volunteerResultMap")
    Volunteer getById(Integer id);
}
