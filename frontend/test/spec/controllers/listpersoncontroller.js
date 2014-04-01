//'use strict';
describe('Controller: listPersonController' ,function(){

  var listPersonController,
      scope;

  // load the controller's module
  beforeEach(module('hyttebookingApp'));

   // define the mock people service
  beforeEach(function() {
    var kalle  = {
      id : 1,
      firstName : "Karl",
      surName : "Svensson",
      gender : 'M'
    };
    var bo  = {
      id : 2,
      firstName : "Bosse",
      surName : "Karlsson",
      gender : 'M'
    };
    var anna  = {
      id : 3,
      firstName : "Anna",
      surName : "Gunnarsson",
      gender : 'F'
    };  
    var persons = [kalle, bo, anna];
    var personMap = {};
    personMap[1] = kalle;
    personMap[2] = bo;
    personMap[3] = anna;

    personService = {
        getPersons: function() { 
          return personMap;
        },
        deletePerson : function(personId){
          delete personMap[personId];
        }
    };
  });

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    listPersonController = $controller('listPersonController', {
      $scope: scope,
      personService: personService
    });
  }));

  it('Persons are in scope', function () {
    expect(scope.persons[1].id).toBe(1);
    expect(scope.persons[1].firstName).toBe("Karl");
    expect(scope.persons[1].surName).toBe("Svensson");
    expect(scope.persons[1].gender).toBe("M");
    expect(scope.persons[2].id).toBe(2);
    expect(scope.persons[2].firstName).toBe("Bosse");
    expect(scope.persons[2].surName).toBe("Karlsson");
    expect(scope.persons[2].gender).toBe("M");
    expect(scope.persons[3].id).toBe(3);
    expect(scope.persons[3].firstName).toBe("Anna");
    expect(scope.persons[3].surName).toBe("Gunnarsson");
    expect(scope.persons[3].gender).toBe("F");
  });


  it('Only thre persons in scope', function () {
     expect(scope.persons[4]).toBe(undefined);
  });

  it('Delete person' , function(){
    personService.deletePerson(1);
    expect(scope.persons[1]).toBe(undefined);
    expect(scope.persons[2].id).toBe(2);
  });


});
