(function() {
    var universities = ['Silpakorn University', 'Mahidol University', 'Thammasart University', 'KMUTT', 'Chulalongkorn University'];

    var ractive = new Ractive({
        el: '#registerform',
        template: '#template',
        data: {
            prospect: {
                firstName: '',
                lastName: '',
                gender: '',
                email: '',
                mobile: '',
                university: '',
                interestedFields: [],
                type: ''
            }
            //universitiesList: universities
        }
    });

    ractive.set('universitiesList', universities);

    ractive.on('submit', function (event) {
        var data = ractive.get('prospect');
        alert(data.firstName + " is saved");
        alert(data.gender + " is saved");
        alert(data.university + " is saved");
        alert(data.interestedFields + " is saved");
        event.original.preventDefault();
        ractive.reset();
        ractive.set('universitiesList', universities);
    });
}());