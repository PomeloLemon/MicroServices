package com.sdxb.springbootexample.service;

import com.sdxb.springbootexample.dao.FinancialGoalDao;
import com.sdxb.springbootexample.entity.FinancialGoal;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("financialgoalService")
public class FinancialGoalServiceImpl implements FinancialGoalService {
    @Resource
    private FinancialGoalDao financialgoalDao;

    @Resource
    private AccountService accountService; // 注入AccountService

    @Override
    public FinancialGoal get(Integer id) {
        // 通过DAO的方法根据ID获取特定财务目标
        return financialgoalDao.findById(id);
    }

    @Override
    public List<FinancialGoal> getAllGoals(Integer id) {
        // 通过DAO的方法获取所有财务目标
        return financialgoalDao.findAll(id);
    }

    @Override
    public void save(FinancialGoal financialGoal) {
        // 在保存之前设置userId
        Integer userId = accountService.getUserIdForLoggedInUser();
        financialGoal.setUserId(userId);
        financialgoalDao.insert(financialGoal);
    }

    @Override
    public void update(FinancialGoal financialGoal) {
        // 更新前确保userId是正确的
        Integer userId = accountService.getUserIdForLoggedInUser();
        financialGoal.setUserId(userId);
        financialgoalDao.update(financialGoal);
    }

    @Override
    public void delete(Integer id) {
        // 通过DAO的方法删除财务目标
        financialgoalDao.delete(id);
    }
}
