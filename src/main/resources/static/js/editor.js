$(document).ready(function () {
    $('#load').click(function (loadButton) {
    console.log(loadButton)
    let sessionNumber=$("#session_id").val()
    $.ajax({
        url: "http://localhost:8080/admin/session/"+sessionNumber, data: {},
        type: "GET",
        dataType: "json"})
        .done(function (result) {
            console.log(result);
            let data = JSON.stringify(result);
            let one=new JSONedtr(data, '#output');


            $( '#save' ).click(function(){

                //console.log('FIRST BUTTON CLICKED');


                var result1 = one.getData();
                console.log('Output of getData(): ', result1);
              
                var result2 = one.getDataString();
                post(JSON.stringify(result1));
                //console.log('Output of getDataString(): ', result2);
            })
        })
        .fail(function (xhr, status, err) {
        })
        .always(function (xhr, status) {
        })
    })
    function post(dataToPost) {
        let sessionNumber1=$("#session_id").val()
        $.ajax ({
            url: "http://localhost:8080/admin/session/update/"+sessionNumber1,
            //url: "http://localhost:8080/admin/session/update/1",
            data: dataToPost,
            type: "PUT",
            contentType : 'application/json',
            dataType: "json"
        })
    }
    // var data = '{"first_key":"one","second_key":"two","third_key":{"one":"item 3-1","two":"item 3-2","three":"item 3-3"},"fourth_key":[1,2,3,4,5],"fifth_key":{"level_2":{"level_3":{"level_4":"item"}}}}';
})