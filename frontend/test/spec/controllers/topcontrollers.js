'use strict';
describe('Controller: topBarController' ,function(){

  // load the controller's module
  beforeEach(module('hyttebookingApp'));

  var topBarController,
      scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    topBarController = $controller('topBarController', {
      $scope: scope
    });
  }));

  it('should attach an empty list of messages to the scope', function () {
    expect(scope.alerts.length).toBe(0);
  });


  it('should contain two messages', function () {
    scope.alerts.push({type: 'success' ,msg: "text"});
    scope.alerts.push({type: 'success' ,msg: "text2"});
    expect(scope.alerts.length).toBe(2);
  });

});

