'use strict';

var services = angular.module('dish.services', ['ngResource']);

var baseUrl = 'http://localhost:8080';

function resourceErrorHandler(response){
	console.log(response);
}

services.factory('CommentsFactory', function ($resource) {
    return $resource(baseUrl + '/dish/add-comment', {}, {
        add: { method: 'POST' }
    })
});

services.factory('UsersFactory', function ($resource) {
    return $resource(baseUrl + '/dish', {}, {
        query: { method: 'GET', isArray: true},
        update: { method: 'PUT' },
        create: { method: 'POST' }
    })
});

services.factory('UserFactory', function ($resource) {
    return $resource(baseUrl + '/dish/:id', {}, {
        show: { method: 'GET' },
        delete: { method: 'DELETE', params: {id: '@id'} }
    })
});
