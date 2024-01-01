package microservices.project.target.mapper;

import microservices.project.target.entity.FinancialGoal;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FinancialGoalMapper {

    @Insert("INSERT INTO FinancialGoals(userId, description, targetAmount, currentAmount, startDate, endDate, status) " +
            "VALUES(#{userId}, #{description}, #{targetAmount}, #{currentAmount}, #{startDate}, #{endDate}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "goalId")
    int insert(FinancialGoal financialGoal);

    @Select("SELECT * FROM FinancialGoals WHERE goalId = #{goalId}")
    FinancialGoal selectById(@Param("goalId") Integer goalId);

    @Update("UPDATE FinancialGoals SET description = #{description}, targetAmount = #{targetAmount}, currentAmount = #{currentAmount}, " +
            "startDate = #{startDate}, endDate = #{endDate}, status = #{status} WHERE goalId = #{goalId}")
    int updateById(FinancialGoal financialGoal);

    @Delete("DELETE FROM FinancialGoals WHERE goalId = #{goalId}")
    int deleteById(@Param("goalId") Integer goalId);

    @Select("SELECT * FROM FinancialGoals")
    List<FinancialGoal> selectAll();
}
