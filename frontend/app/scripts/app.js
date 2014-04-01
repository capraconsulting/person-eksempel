'use strict';

var application = angular.module('hyttebookingApp', ['ngRoute', 'mm.foundation']);

application.config(function ($routeProvider) {
  $routeProvider
    .when('/', {
      templateUrl: 'views/list_persons.html',
      controller: 'topBarController',
      activetab: 'list_persons'
    })
    .when('/list_persons', {
      templateUrl: 'views/list_persons.html',
      controller: 'topBarController',
      activetab: 'list_persons'
    })
    .when('/register_person', {
      templateUrl: 'views/register_person.html',
      controller: 'topBarController',
      activetab: 'register_person'
    })
    .when('/register_person/:personId', {
      templateUrl: 'views/register_person.html',
      controller: 'topBarController',
      activetab: 'register_person'
    })
    .otherwise({
      redirectTo: '/'
    });
});

