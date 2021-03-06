(function() {

    var ractive = new Ractive({
        el: '#applicationForm',
        template: '#template',
        data: {
            applicant : {
                firstName : '',
                lastName : '',
                dateOfBirth:'',
                contactNumber : '',
                emailAddress :'',
                educationLevel : '',
                major : '',
                yearOfExperience : '',
                interestedJobPosition :'',
                certificatesOne : '',
                certificatesTwo : '',
                certificatesThree : '',
                certificatesFour : '',
                latestSalary : '',
                availability : '',
                introduceMessage : ''
            },

            educationLevel : '',
            jobPositions : ''
        }
    });

    $.getJSON( "/api/majoingun/v1/educationlevels", function( data ) {
        ractive.set('educationLevelList', data);
    });

    $.getJSON( "/api/majoingun/v1/jobpositions", function( data ) {
        ractive.set('jobPositions', data);
    });
    
    ractive.on('submit', function (event) {
        event.original.preventDefault();
        var applicant = ractive.get('applicant');

        alert(applicant.dateOfBirth);
        $.ajax({
            type: "POST",
            url: "/api/majoingun/v1/applicants",
            data: JSON.stringify(applicant),
            contentType: "application/json; charset=utf-8",
            dataType: "text",
            success: function(){
                swal("Saved!", "Your information was saved successfully!", "success");
                //location.reload();
                ractive.reset();
            },
            error: function(){
                swal({
                    title: "Error!",
                    text: "All fields are required.",
                    type: "error"
                });
            }
        });

        $.getJSON( "/api/majoingun/v1/educationlevels", function( data ) {
            ractive.set('educationLevelList', data);
        });

        $.getJSON( "/api/majoingun/v1/jobpositions", function( data ) {
            ractive.set('jobPositions', data);
        });
    });
}());