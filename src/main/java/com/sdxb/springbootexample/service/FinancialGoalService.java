package com.sdxb.springbootexample.service;

import com.sdxb.springbootexample.entity.FinancialGoal;
import java.util.List;

public interface FinancialGoalService {
    // 获取特定的财务目标
    FinancialGoal get(Integer id);

    // 获取所有财务目标列表
    List<FinancialGoal> getAllGoals(Integer id);

    // 保存新的财务目标
    void save(FinancialGoal financialGoal);

    // 更新现有的财务目标
    void update(FinancialGoal financialGoal);

    // 删除财务目标
    void delete(Integer id);
}

