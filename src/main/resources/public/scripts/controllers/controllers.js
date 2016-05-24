'use strict';

/* Controllers */

var app = angular.module('dish.controllers', []);


app.run(function ($rootScope, $templateCache) {
  $rootScope.$on('$viewContentLoaded', function () {
    $templateCache.removeAll();
  });
});

app.controller('DishListCtrl', ['$scope', 'UsersFactory', 'UserFactory', '$location',
  function ($scope, UsersFactory, UserFactory, $location) {

    $scope.openDish = function (dishId) {
      $location.path('/dish-detail/' + dishId);
    };

    $scope.deleteDish = function (userId) {
      UserFactory.delete({ id: userId });
      $scope.dishes = UsersFactory.query();
    };

    $scope.createNewDish = function () {
      $location.path('/dish-creation');
    };
    var q = UsersFactory.query(function(response){
    	$scope.dishes = response;
    }, function(error){
	    	console.log(error);
	    }
	);    
    
  }]);

app.controller('DishDetailCtrl', ['$scope', '$routeParams', 'UserFactory', 'UsersFactory', 'CommentsFactory','$location',
  function ($scope, $routeParams, UserFactory, UsersFactory, CommentsFactory, $location) {
	$scope.addComment = function (dishId){
		$scope.comment.dishId = dishId;
		CommentsFactory.add($scope.comment, function(response){
			UserFactory.show({id: $routeParams.id}, function(response){
		    	$scope.dish = response;
		    }, function(error){
			    	console.log(error);
			    });
	    });
	};
	
    $scope.updateUser = function () {
      UsersFactory.update($scope.user);
      $location.path('/dish-list');
    };

    $scope.cancel = function () {
      $location.path('/dish-list');
    };
    UserFactory.show({id: $routeParams.id}, function(response){
    	$scope.dish = response;
    }, function(error){
	    	console.log(error);
	    });
    
  }]);

app.controller('DishCreationCtrl', ['$scope', 'UsersFactory', '$location',
  function ($scope, UsersFactory, $location) {

    $scope.createNewDish = function () {
      UsersFactory.create($scope.dish, function(response){
    	  $location.path('/dish-list');
      });
    }
  }]);
