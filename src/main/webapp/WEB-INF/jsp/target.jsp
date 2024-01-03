<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Financial Goals</title>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        .container {
            display: flex;
            justify-content: space-between;
        }
        .goals-list {
            width: 50%;
            margin-top: 50px;
            margin-right: 10%; /* 增加右边距离 */
        }
        .form-container {
            width: 38%;
            margin-top: 80px;
            margin-left: 20%; /* 增加左边距离 */
        }
    </style>

</head>
<body>
<h1>Financial Goals List</h1>
<div class="container">
    <!-- 左侧部分: 显示目标列表 -->
    <div class="goals-list">
        <table class="table">
            <thead>
            <tr>
                <th>GoalID</th>
                <th>UserID</th>
                <th>Description</th>
                <th>TargetAmount</th>
                <th>CurrentAmount</th>
                <th>StartDate</th>
                <th>EndDate</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${goalsList}" var="goal">
                <tr>
                    <td>${goal.goalId}</td>
                    <td>${goal.userId}</td>
                    <td>${goal.description}</td>
                    <td>${goal.targetAmount}</td>
                    <td>${goal.currentAmount}</td>
                    <td>${goal.startDate}</td>
                    <td>${goal.endDate}</td>
                    <td>
                        <!-- Edit link could be a button or link that triggers a modal or another page -->
                        <a href="EditGoalServlet?goalId=${goal.goalId}" class="btn btn-primary btn-sm">Edit</a>
                        <!-- Delete link sends a GET request to a URL which will handle the deletion on the server -->
                        <a href="DeleteGoalServlet?goalId=${goal.goalId}" class="btn btn-danger btn-sm">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- 右侧部分: 新目标的输入表单 -->
    <div class="form-container">
        <!-- The form to add a new goal -->
        <form action="InsertGoalServlet" method="post">
            <div class="form-group">
                <label for="description">Description:</label>
                <input type="text" class="form-control" id="description" name="description">
            </div>
            <div class="form-group">
                <label for="targetAmount">Target Amount:</label>
                <input type="number" class="form-control" id="targetAmount" name="targetAmount" step="0.01">
            </div>
            <div class="form-group">
                <label for="currentAmount">Current Amount:</label>
                <input type="number" class="form-control" id="currentAmount" name="currentAmount" step="0.01">
            </div>
            <div class="form-group">
                <label for="startDate">Start Date:</label>
                <input type="date" class="form-control" id="startDate" name="startDate">
            </div>
            <div class="form-group">
                <label for="endDate">End Date:</label>
                <input type="date" class="form-control" id="endDate" name="endDate">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>
</body>
</html>
