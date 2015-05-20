var biddingServices = angular.module('biddingServices');

//SERVICE USAGE
//
//INVOCATION: Item.query();
//     ROUTE: /items/
//    METHOD: GET
//
//INVOCATION: Item.save({id: 1}, {post data});
//     ROUTE: /items/1
//    METHOD: POST
//	
//INVOCATION: Item.delete({id: 1});
//     ROUTE: /items/1
//    METHOD: DELETE
//
//INVOCATION: Item.update({id: 1}, {post data});
//     ROUTE: /items/1
//    METHOD: PUT
//
//INVOCATION: Item.query({name: 'ItemName'});
//     ROUTE: /items?name=ItemName
//    METHOD: GET

biddingServices.factory('Item', ['$resource', 
    function($resource) {
		$resource('/items/:id', { id: '@id' }, {
			update: {
				method: 'PUT', 
				url: '/items/:id' 
			},
			action: {
				method: 'PUT', 
				url: '/items/:id/action' 
			}
		})
	}]);
