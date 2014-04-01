//'use strict';
describe('Controller: personFormController' ,function(){

  var personFormController,
      scope;

  // load the controller's module
  beforeEach(module('hyttebookingApp'));

  // define the mock people service
  beforeEach(function() {
    personService = {
        getPerson: function(personId) {
          if(personId){
            return {
              id : 1,
              firstName : "Kalle",
              surName : "Karlsson",  
              gender : 'M' 
            };
          } else {
            return {
              gender : 'M'  
            };
          }
          
        }
    };
  });

  it('Existing id in routeParams', inject(function($controller, $rootScope) {
    routeParams = {}; 
    routeParams.personId = 5;
    scope = $rootScope.$new();
    personFormController = $controller('personFormController', {
      $scope: scope,
      $routeParams : routeParams,
      personService: personService
    });        
    expect(scope.person.id).toBe(1);
  }));


  it('No id in routeParams', inject(function($controller, $rootScope) {
    routeParams = {}; 
    scope = $rootScope.$new();
    personFormController = $controller('personFormController', {
      $scope: scope,
      $routeParams : routeParams,
      personService: personService
    });        
    expect(scope.person.id).toBe(undefined);
  }));

});
