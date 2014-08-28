describe("Person Service ", function(){

    var personService, $httpBackend;

    // load the relevant application module, with the service to be tested
    beforeEach( module('hyttebookingApp') );

    beforeEach( function() {
        // inject the mock for the http backend
        inject(function(_$httpBackend_) {
            $httpBackend = _$httpBackend_;
        });
        // mock the response to a particular get request
        $httpBackend.whenGET('rest/person').respond([
            {id: 1, firstname: 'Peter', lastname: 'Hellstrand'},
            {id: 2, firstname: 'Morten', lastname: 'Tangen'}
        ]);
        // inject the service to be tested
        inject(function(_personService_) {
            personService = _personService_;
        });

    });

    describe("Get Persons", function(){
        it("number of persons are correct" , function(){
           $httpBackend.expectGET('rest/person');
           var promise = personService.getPersons();
           promise.then(function(persons){
               expect(persons.length).toBe(2);
           });
           $httpBackend.flush();
        });


        it("first name and last name" , function(){
            $httpBackend.expectGET('rest/person');
            var promise = personService.getPersons();
            promise.then(function(persons){
                expect(persons[0].firstname).toBe("Peter");
                expect(persons[0].lastname).toBe("Hellstrand");
                expect(persons[1].firstname).toBe("Morten");
                expect(persons[1].lastname).toBe("Tangen");
            });
            $httpBackend.flush();
        });
    });

});