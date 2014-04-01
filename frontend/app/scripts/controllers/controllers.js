'use strict';
//Person listing 

application.controller('listPersonController', function ($scope, $modal, personService, messageService) {

  personService.getPersons()
  .then(function(persons) {
      $scope.persons = persons;
      if(persons.length === 0){
        messageService.addSuccessMessage("No persons added yet.");
      }
  }, function(response) {
      // error handler
      messageService.addErrorMessage("Something went wrong : " + response);
  });

  //Launch the modal for deleting a person
  $scope.openDeleteModal = function (personId, firstname, lastname, index) {
    var modalInstance = $modal.open({
      templateUrl: 'deletePersonModal.html',
      controller: ModalInstanceCtrl,
      resolve: {
        personData : function () {
          return {
            id : personId,
            firstname : firstname,
            lastname : lastname,
            index : index
          };
        }
      }
    });

    //The person click ok on the delete person modal
    modalInstance.result.then(function (personData) {
      personService.deletePerson(personData.id)
      .then(function(data) {
        $scope.persons.splice(personData.index, 1);
        messageService.addSuccessMessage("Person : " + personData.firstname + " " + personData.lastname + " deleted");
      }, function(response) {
        // error handler
        messageService.addErrorMessage("Something went wrong : " + response);
      });
    });
  };
});

//Person Registration
application.controller('personFormController', function ($scope, $routeParams, $location, personService, messageService) {
    
    var personId = $routeParams.personId;
      
    personService.getPerson(personId)
    .then(function(person) {
        $scope.person = person;
    }, function(response) {
      // error handler
      messageService.addErrorMessage("Something went wrong : " + response);
    });

    //Create or update a person depending on the id
    $scope.savePerson = function(formValid, id, firstname, lastname){
    
      personService.savePerson(id, firstname, lastname)
      .then(function(person) {
        //It was an update. Redirect to person list
        if(id){
          messageService.addSuccessMessage("Persons updated");
          $location.path("/list_persons");
        } else {
          //Empty fields to register new person
          messageService.addSuccessMessage("Person : " + firstname + " " + lastname + " created");
          $scope.person = {};
        }       
      }, function(response) {
        // error handler
        messageService.addErrorMessage("Something went wrong : " + response);
      });
    }
});


//For the top bar  
application.controller('topBarController', function ($scope, $route, messageService) {
  //For setting the active tab
  $scope.$route = $route;

  //Alerts 
  $scope.alerts = messageService.getAlerts();
  $scope.closeAlert = function(index) {
      messageService.closeAlert(index);
  };

});


var ModalInstanceCtrl = function ($scope, $modalInstance, personData) {

  $scope.firstname = personData.firstname;
  $scope.lastname = personData.lastname;
  //Send the person data when clicking ok on the modal
  $scope.ok = function () {
    $modalInstance.close(personData); 
  };

  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
};





