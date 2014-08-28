describe("List Persons ", function (){

    var ptor;
    beforeEach(function() {
        ptor = protractor.getInstance();
        ptor.get('#/current_page');
    });


    it('Number of rows are correct ', function() {
        var tableRows = element.all(protractor.By.xpath("//tr"));
        expect(tableRows.count()).toEqual(1);
    });


    it("Number of table headers is correct", function(){
       var tableHeaders = element.all(protractor.By.xpath("//tr/th"));
       expect(tableHeaders.count()).toEqual(3);
    });

});
