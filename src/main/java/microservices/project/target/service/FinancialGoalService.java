package microservices.project.target.service;

import microservices.project.target.entity.FinancialGoal;
import microservices.project.target.mapper.FinancialGoalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FinancialGoalService implements FinancialGoalService {

    private final FinancialGoalMapper financialGoalMapper;

    @Autowired
    public FinancialGoalService(FinancialGoalMapper financialGoalMapper) {
        this.financialGoalMapper = financialGoalMapper;
    }

    @Override
    public FinancialGoal createFinancialGoal(FinancialGoal financialGoal) {
        financialGoalMapper.insert(financialGoal);
        return financialGoal; // The financialGoal object will now contain the generated ID
    }

    @Override
    public FinancialGoal getFinancialGoalById(Integer goalId) {
        return financialGoalMapper.selectById(goalId);
    }

    @Override
    public List<FinancialGoal> getAllFinancialGoals() {
        return financialGoalMapper.selectAll();
    }

    @Override
    public void updateFinancialGoal(FinancialGoal financialGoal) {
        financialGoalMapper.updateById(financialGoal);
    }

    @Override
    public void deleteFinancialGoal(Integer goalId) {
        financialGoalMapper.deleteById(goalId);
    }
}
