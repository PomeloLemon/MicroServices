package com.sdxb.springbootexample.entity;

import java.math.BigDecimal;
import java.util.Date;

public class FinancialGoal {
    private Integer goalId; // 财务目标的唯一标识符
    private Integer userId; // 用户ID，表示这个财务目标属于哪个用户
    private String description; // 财务目标的描述
    private BigDecimal targetAmount; // 目标金额
    private BigDecimal currentAmount; // 当前达到的金额
    private Date startDate; // 财务目标的开始日期
    private Date endDate; // 财务目标的结束日期

    // Default constructor
    public FinancialGoal() {
    }
    // All arguments constructor
    public FinancialGoal(Integer goalId, Integer userId,String description,
                         BigDecimal targetAmount,BigDecimal currentAmount,
                         Date startDate,Date endDate){
        this.goalId=goalId;
        this.userId=userId;
        this.description=description;
        this.targetAmount=targetAmount;
        this.currentAmount=currentAmount;
        this.startDate=startDate;
        this.endDate=endDate;

    }

    // Getter and setter
    public Integer getGoalId() {
        return goalId;
    }
    public void setGoalId(Integer goalId) {
        this.goalId = goalId;
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTargetAmount() {
        return targetAmount;
    }
    public void setTargetAmount(BigDecimal targetAmount) {
        this.targetAmount = targetAmount;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }
    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {this.startDate = startDate;}

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}