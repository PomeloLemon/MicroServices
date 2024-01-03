package com.sdxb.springbootexample.dao;
import com.sdxb.springbootexample.entity.FinancialGoal;
import java.util.List;

public interface FinancialGoalDao {
    FinancialGoal findById(Integer id);
    List<FinancialGoal> findAll(Integer id);
    void insert(FinancialGoal financialGoal);
    void update(FinancialGoal financialGoal);
    void delete(Integer id);
}
