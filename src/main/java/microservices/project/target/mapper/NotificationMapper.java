package microservices.project.target.mapper;

import microservices.project.target.entity.Notification;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NotificationMapper {

    @Insert("INSERT INTO Notifications(userId, message, type, status, sendTime) " +
            "VALUES(#{userId}, #{message}, #{type}, #{status}, #{sendTime})")
    @Options(useGeneratedKeys = true, keyProperty = "notificationId")
    int insert(Notification notification);

    @Select("SELECT * FROM Notifications WHERE notificationId = #{notificationId}")
    Notification selectById(@Param("notificationId") Integer notificationId);

    @Update("UPDATE Notifications SET message = #{message}, type = #{type}, status = #{status}, sendTime = #{sendTime} " +
            "WHERE notificationId = #{notificationId}")
    int updateById(Notification notification);

    @Delete("DELETE FROM Notifications WHERE notificationId = #{notificationId}")
    int deleteById(@Param("notificationId") Integer notificationId);

    @Select("SELECT * FROM Notifications")
    List<Notification> selectAll();
}
