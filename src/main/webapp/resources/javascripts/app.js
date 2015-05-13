angular
	.module('biddingApp', ['ngResource'])
    .factory('UserRoles', ['$resource', function($resource){
    	return $resource('user_roles', {}, {
    		query: {method:'GET', params:{}, isArray:true}
    	});
    }])
    .controller('UserRoleController', ['$scope', 'UserRoles', function($scope, UserRoles) {
    	$scope.roles = UserRoles.query();
    }]);