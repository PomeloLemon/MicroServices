package com.sdxb.springbootexample.controller;


import com.sdxb.springbootexample.entity.FinancialGoal;
import com.sdxb.springbootexample.service.FinancialGoalService;
import com.sdxb.springbootexample.service.AccountService; // 假设你的AccountService已经存在
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FinancialGoalController {

    @Resource
    private FinancialGoalService financialGoalService;

    @Resource
    private AccountService accountService; // 添加账户服务


    @GetMapping("/")
    public String defaultHTML() {
        return "default";
    }

    // 显示目标列表
    @GetMapping("/target")
    public String target(Model model) {
        List<FinancialGoal> goalsList = financialGoalService.getAllGoals(accountService.getUserIdForLoggedInUser());
        model.addAttribute("goalsList", goalsList);
        model.addAttribute("userId", accountService.getUserIdForLoggedInUser()); // 添加userId到模型
        return "target";
    }

    // 处理添加新目标的表单提交
    @PostMapping("/InsertGoalServlet")
    public String addGoal(FinancialGoal financialGoal, Model model) {
        Integer userId = accountService.getUserIdForLoggedInUser(); // 获取当前用户ID
        financialGoal.setUserId(userId); // 设置用户ID
        financialGoalService.save(financialGoal);
        return "redirect:/target";
    }

    // 处理通过编辑链接发送的GET请求
    @GetMapping("/EditGoalServlet")
    public String editGoalForm(@RequestParam("goalId") Integer goalId, Model model) {
        FinancialGoal financialGoal = financialGoalService.get(goalId);
        model.addAttribute("financialGoal", financialGoal);
        return "editGoal"; // 返回编辑目标的视图名称
    }

    // 处理编辑目标的表单提交
    @PostMapping("/UpdateGoalServlet")
    public String updateGoal(@ModelAttribute FinancialGoal financialGoal) {
        financialGoalService.update(financialGoal);
        return "redirect:/target";
    }

    // 处理删除目标的链接
    @GetMapping("/DeleteGoalServlet")
    public String deleteGoal(@RequestParam("goalId") Integer goalId) {
        financialGoalService.delete(goalId);
        return "redirect:/target";
    }
}
