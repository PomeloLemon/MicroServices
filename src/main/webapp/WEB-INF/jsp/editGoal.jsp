<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Financial Goal</title>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2>Edit Financial Goal</h2>
    <form action="UpdateGoalServlet" method="post">
        <!-- Hidden field to pass the goal ID -->
        <input type="hidden" name="goalId" value="${financialGoal.goalId}">

        <div class="form-group">
            <label for="userId">UserID:</label>
            <input type="text" class="form-control" id="userId" name="userId" value="${financialGoal.userId}">
        </div>

        <div class="form-group">
            <label for="description">Description:</label>
            <input type="text" class="form-control" id="description" name="description" value="${financialGoal.description}">
        </div>

        <div class="form-group">
            <label for="targetAmount">Target Amount:</label>
            <input type="number" class="form-control" id="targetAmount" name="targetAmount" value="${financialGoal.targetAmount}" step="0.01">
        </div>

        <div class="form-group">
            <label for="currentAmount">Current Amount:</label>
            <input type="number" class="form-control" id="currentAmount" name="currentAmount" value="${financialGoal.currentAmount}" step="0.01">
        </div>

        <div class="form-group">
            <label for="startDate">Start Date:</label>
            <input type="date" class="form-control" id="startDate" name="startDate" value="${financialGoal.startDate}">
        </div>

        <div class="form-group">
            <label for="endDate">End Date:</label>
            <input type="date" class="form-control" id="endDate" name="endDate" value="${financialGoal.endDate}">
        </div>

        <button type="submit" class="btn btn-primary">Update Goal</button>
    </form>
</div>
</body>
</html>
