<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html ng-app="biddingApp">
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    
    <!-- Vendor Scripts -->
	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="webjars/angularjs/1.3.15/angular.min.js"></script>
	<script type="text/javascript" src="webjars/angularjs/1.3.15/angular-resource.min.js"></script>

	<!-- App Scripts -->
	<script type="text/javascript" src="<c:url value="/resources/javascripts/app.js" />"></script>
</head>
<body ng-controller="UserRoleController">
    <h1>testing</h1>
	
	<div ng-repeat="roles in roles">{{roles.roleId}} {{roles.roleName}}</div>

</body>
</html>
