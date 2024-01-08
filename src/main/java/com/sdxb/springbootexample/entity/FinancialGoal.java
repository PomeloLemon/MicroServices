package com.sdxb.springbootexample.entity;

import java.math.BigDecimal;
import java.util.Date;

public class FinancialGoal {
    private final Integer goalId; // 财务目标的唯一标识符
    private final String userId; // 用户ID，表示这个财务目标属于哪个用户
    private final String description; // 财务目标的描述
    private final BigDecimal targetAmount; // 目标金额
    private final BigDecimal currentAmount; // 当前达到的金额
    private final Date startDate; // 财务目标的开始日期
    private final Date endDate; // 财务目标的结束日期


    // All arguments constructor
    public FinancialGoal(Integer goalId, String userId, String description,
                         BigDecimal targetAmount, BigDecimal currentAmount,
                         Date startDate, Date endDate) {
        this.goalId = goalId;
        this.userId = userId;
        this.description = description;
        this.targetAmount = targetAmount;
        this.currentAmount = currentAmount;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    // Getter and setter
    public Integer getGoalId() {
        return goalId;
    }

    public String getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getTargetAmount() {
        return targetAmount;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

}