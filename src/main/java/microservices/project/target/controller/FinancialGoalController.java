package microservices.project.target.controller;

import microservices.project.target.entity.FinancialGoal;
import microservices.project.target.service.FinancialGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goals")
public class FinancialGoalController {

    @Autowired
    private FinancialGoalService financialGoalService;

    @PostMapping
    public ResponseEntity<FinancialGoal> createGoal(@RequestBody FinancialGoal financialGoal) {
        FinancialGoal createdGoal = financialGoalService.createFinancialGoal(financialGoal);
        return ResponseEntity.ok(createdGoal);
    }

    @GetMapping("/{goalId}")
    public ResponseEntity<FinancialGoal> getGoalById(@PathVariable Integer goalId) {
        FinancialGoal goal = financialGoalService.getFinancialGoalById(goalId);
        return ResponseEntity.ok(goal);
    }

    // Add more endpoints as needed for updating, deleting, listing goals, etc.
}
