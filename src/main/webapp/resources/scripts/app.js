angular
	.module('biddingApp', ['ngRoute'])
	.config(function($routeProvider, $httpProvider) {
		$routeProvider.when('/', {
			templateUrl : 'resources/views/public/login.html',
			controller : 'AuthenticationCtrl'
		}).when('/login', {
			templateUrl : 'resources/views/public/login.html',
			controller : 'AuthenticationCtrl'
		}).when('/items', {
			templateUrl : 'resources/views/protected/items.html',
			controller : 'ItemsCtrl'
		}).when('/items/:id', {
			templateUrl : 'resources/views/protected/items.html',
			controller : 'ItemInstanceCtrl'
		})
		.otherwise('/');

		$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

	}).controller('AuthenticationCtrl',

		function($rootScope, $scope, $http, $location, $route) {
		
        	$scope.vm = {
        			submitted: false,
        			errorMessages: []
        	};

        	$scope.login = function (username, password) {
        		var postData = $.param({'username': username, 'password': password});
        		console.log(postData);
        		$http({
	                method: 'POST',
	                url: "\authenticate",
	                data: postData,
	                headers: {
	                    "Content-Type": "application/x-www-form-urlencoded",
	                    "X-Login-Ajax-call": 'true'
	                }
	            })
	            .then(function(response) {
	            	if (response.data != null || response.data != '') {
	            		$location.path('/items');
	                }
	                else {
	                    $scope.vm.errorMessages = [];
	                    $scope.vm.errorMessages.push({description: 'Access denied'});
	                }
	            });
	        }
        	
        	$scope.redirectLogin = function(){
        		$location.path('/login');
        	}
        	
		}).controller('LoginCtrl', function($scope, $http) {
			
			$scope.onLogin = function () {
	            console.log('Attempting login with username ' + $scope.vm.username + ' and password ' + $scope.vm.password);

	            $scope.vm.submitted = true;

	            // Add checking of inputted values

	            $scope.login($scope.vm.username, $scope.vm.password);

	        };
		}).controller('ItemsCtrl', function($scope, $http) {
			$http.get('user_roles').success(function(data) {
				$scope.items = data;
				console.log($scope.items);
			});
			console.log($scope.items);
				
		}).controller('ItemInstanceCtrl', function($scope, $http) {
			
			
		}).controller('MainCtrl', function($scope, $http, $location) {
			
});