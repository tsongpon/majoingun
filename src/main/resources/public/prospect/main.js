(function() {

    var prospectMap = [];

    $.getJSON( "/api/majoingun/v1/prospects", function( data ) {
        for(var i = 0; i < data.length; i++) {
            var o = {};
            o['Name'] = data[i].firstName + '   ' + data[i].lastName;
            o['E-mail Address'] = data[i].email;
            o['Mobile'] = data[i].mobile;
            o['University'] = data[i].university;
            prospectMap.push(o);
        }
    });

    var ractive = new Ractive({
        el: '#registerform',
        template: '#template',
        data: {
            data : prospectMap,
            perpage : 3
        },
        components: {
            datatable:  RactiveDatatable
        }
    });
}());