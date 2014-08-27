describe('Controller: listPersonController', function () {


    beforeEach(module('hyttebookingApp'));

    var listPersonController,
        scope,
        q,
        deferred,
        personService;


    function getPersonMap() {
        var kalle = {
                id: 1,
                firstName: "Karl",
                surName: "Svensson",
                gender: 'M'
            },
            bo = {
                id: 2,
                firstName: "Bosse",
                surName: "Karlsson",
                gender: 'M'
            },
            anna = {
                id: 3,
                firstName: "Anna",
                surName: "Gunnarsson",
                gender: 'F'
            },
            personMap = {};

        personMap[1] = kalle;
        personMap[2] = bo;
        personMap[3] = anna;
        return personMap;
    }

    //Prepare the fake factory
    beforeEach(function () {
        personService = {
            getPersons: function () {
                deferred = q.defer();
                // Place the fake return object here
                deferred.resolve(getPersonMap());
                return deferred.promise;
            }
        };
        spyOn(personService, 'getPersons').andCallThrough();
    });


    //Inject fake factory into controller
    beforeEach(inject(function ($rootScope, $controller, $q) {
        scope = $rootScope.$new();
        q = $q;
        listPersonController = $controller('listPersonController', { $scope: scope, personService: personService });
    }));


    it('Only three persons in scope', function () {
        scope.$apply();
        expect(scope.persons[4]).toBe(undefined);
    });


    it('Persons are in scope', function () {
        scope.$apply();
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


});
