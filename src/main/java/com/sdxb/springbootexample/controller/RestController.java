package com.sdxb.springbootexample.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sdxb.springbootexample.entity.FinancialGoal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.sql.DataSource;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    public RestController() {

    }

    @PostMapping("/insertGoal")
    public ResponseEntity<String> createGoals(@RequestBody String goal) {
        try {
            FinancialGoal fgoal = new Gson().fromJson(goal, FinancialGoal.class);
            Connection connection = FinancialGoalsDB().getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("INSERT INTO FinancialGoals (UserID, Description, TargetAmount, CurrentAmount, StartDate, EndDate)"
                    + "VALUES("
                    + "'" + fgoal.getUserId() + "',"
                    + "'" + fgoal.getDescription() + "',"
                    + "" + fgoal.getTargetAmount() + ","
                    + "" + fgoal.getCurrentAmount() + ","
                    + "'" + fgoal.getStartDate() + "',"
                    + "'" + fgoal.getEndDate() + "',"
                    + ");");
            return new ResponseEntity<>("Created", HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>("Database Error, please try later", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getGoals/{userId}")
    public ResponseEntity<String> getGoals(@PathVariable String userId) {
        try {
            Connection connection = FinancialGoalsDB().getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(
                    "SELECT GoalID, UserID, Description, TargetAmount, CurrentAmount, StartDate, EndDate FROM FinancialGoals" +
                            " WHERE UserId = '" + userId + "';");
            List<FinancialGoal> list = new LinkedList<>();
            while (result.next()) {
                FinancialGoal fgoal = new FinancialGoal(
                        result.getInt("GoalID"),
                        result.getString("UserID"),
                        result.getString("Description"),
                        result.getBigDecimal("TargetAmount"),
                        result.getBigDecimal("CurrentAmount"),
                        result.getDate("StartDate"),
                        result.getDate("EndDate")
                );
                list.add(fgoal);
            }
            return new ResponseEntity<>(new Gson().toJson(list), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>("Database Error, please try later", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/editGoal")
    public ResponseEntity<String> updateGoal(@RequestBody String goal) {
        try {
            FinancialGoal fgoal = new Gson().fromJson(goal, FinancialGoal.class);
            Connection connection = FinancialGoalsDB().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE FinancialGoals SET"
                    + " Description = '" + fgoal.getDescription() + "',"
                    + "TargetAmount = " + fgoal.getTargetAmount() + ","
                    + "CurrentAmount = " + fgoal.getCurrentAmount() + ","
                    + "StartDate = '" + fgoal.getStartDate() + "',"
                    + "EndDate = '" + fgoal.getEndDate() + "',"
                    + "WHERE GoalID = " + fgoal.getGoalId() + ","
                    + "AND UserID = '" + fgoal.getUserId() + "';");
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>("Database Error, please try later", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/deleteGoal")
    public ResponseEntity<String> deleteGoal(@RequestBody String Ids) {
        try {
            Type StringList = new TypeToken<ArrayList<String>>() {
            }.getType();
            List<String> IdList = new Gson().fromJson(Ids, StringList);
            Connection connection = FinancialGoalsDB().getConnection();
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM FinancialGoals WHERE " +
                    "GoalID = " + Integer.parseInt(IdList.get(0)) + ", " +
                    "AND UserID = '" + IdList.get(1) + "';");
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>("Database Error, please try later", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/deleteAll")
    public ResponseEntity<String> deleteAllGoals(@RequestBody String Id) {
        try {
            Connection connection = FinancialGoalsDB().getConnection();
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM FinancialGoals WHERE " +
                    "UserID = '" + Id + "';");
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>("Database Error, please try later", HttpStatus.BAD_REQUEST);
        }
    }

    // ----------------- SUPPORT FUNCTIONS ----------------- //

    private DataSource FinancialGoalsDB() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://southeast-asia-s3rv3r.database.windows.net:1433;database=Pfm_System_FinancialGoals");
        dataSource.setUsername("TongjiStudent");
        dataSource.setPassword("Tongji_Root");
        return dataSource;
    }

}
