'use strict';

angular.module('dish', [
  'dish.services',
  'dish.controllers',
  'ngRoute'
  ])
.config(function ($routeProvider, $httpProvider) {
  $routeProvider.when('/dish-list', {templateUrl: 'views/dish-list.html', controller: 'DishListCtrl'});
  $routeProvider.when('/dish-detail/:id', {templateUrl: 'views/dish-detail.html', controller: 'DishDetailCtrl'});
  $routeProvider.when('/dish-creation', {templateUrl: 'views/dish-creation.html', controller: 'DishCreationCtrl'});

  $httpProvider.defaults.useXDomain = true;
  delete $httpProvider.defaults.headers.common['X-Requested-With'];
  
});
