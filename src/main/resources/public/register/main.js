(function () {
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
                interestedFields: '',
                type: ''
            }
            //universitiesList: universities
        }
    });

    ractive.set('universitiesList', universities);

    ractive.on('submit', function (event) {
        var data = ractive.get('prospect');

        $.ajax({
            type: "POST",
            url: "/api/majoingun/v1/prospects",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "text",
            success: function () {
                swal({
                        title: "Saved!",
                        text: "Your information has been saved successfully.",
                        type: "success"
                    },
                    function () {
                        location.reload(true);
                    });
            },
            error: function () {
                swal({
                    title: "Error!",
                    text: "All fields are required",
                    type: "error"
                });
            },
            statusCode: {
                400: function (data) {
                    var errMsg = data.responseText;
                    swal({
                        title: "Error!",
                        text: "<p>Your information was not complete: </p> " + errMsg,
                        html: true,
                        type: "error"
                    });
                },
                500: function () {
                    var errMsg = data.responseText;
                    swal({
                        title: "Error!",
                        text: "<p>Your information was not complete: </p> " + errMsg,
                        html: true,
                        type: "error"
                    });
                }
            }
        });
        event.original.preventDefault();
        ractive.set('universitiesList', universities);
    });
}());