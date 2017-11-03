
function ajaxRequest() {
    var myInputValueOne = document.getElementById("name").value;
    var myInputValueTwo = document.getElementById("lastName").value;

    var url = '/rest/bgg?param1=' + myInputValueOne + '&param2=' + myInputValueTwo;
    var request = new XMLHttpRequest();

    request.open('GET', url);

    request.onreadystatechange = function () {

        if (request.status === 200 && request.readyState === 4) {

            var items = JSON.parse(request.responseText);

            drawTable(items);

            console.log(items)
        }
    };

    function drawTable(data) {
        for (var i = 0; i < data.length; i++) {
            drawRow(data[i]);
        }
    }

    function drawRow(rowData) {
        var row = $("<tr />")
        $("#personDataTable").append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
        row.append($("<td>" + rowData.name + "</td>"));
        row.append($("<td>" + rowData.lastName + "</td>"));
    }


    request.send();

}