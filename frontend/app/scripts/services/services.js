'use strict';
application.factory('personService', function($http){
		
	var personService = {};
	
	//Get all persons
	personService.getPersons = function($scope){
        var promise = $http.get("rest/person").then(function (response) {
            return response.data;
        });
        return promise;
	};

	//Get a person
	personService.getPerson = function(personId) {
		var promise = $http.get("rest/person/" + personId).then(function (response) {
            return response.data;
        });
        return promise;
	};

	//Delete a person
	personService.deletePerson = function(personId){
		var promise = $http.delete("rest/person/" + personId).then(function(response) {        
            return response.data;
        }); 
		return promise;
	};
	//Create a new or update a person 
	personService.savePerson = function(id, firstname, lastname, gender){

		var person  = {
		  firstname : firstname,
		  lastname : lastname
		};

		var promise;
		//New person
		if(!id){
			promise = $http.post("rest/person", person).then(function (response) {        
            	return response.data;
        	});   	
		} else {
			//Update an existing person
			person.id = id;
			promise = $http.put("rest/person", person).then(function (response) {        
            	return response.data;
        	});  
		}
		
		return promise;
	};

	return personService;
});

//Service for handling messages to the user
application.factory('messageService', function(){

	var alerts = [];

	var messageService = {};
	messageService.getAlerts = function(){
		return alerts;
	};

	messageService.closeAlert = function(index) {
    	alerts.splice(index, 1);
    };

	messageService.addSuccessMessage = function(text){
		alerts.length = 0;
		alerts.push({type: 'success' ,msg: text});
	};

	messageService.addErrorMessage = function(text){
		alerts.length = 0;
		alerts.push({type: 'danger', msg: text});
	};

	return messageService;

});
