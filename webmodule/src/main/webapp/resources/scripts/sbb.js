function goToSchedule() {
    window.location.href = "/schedule";
}

function goToRegisterPage() {
    window.location.href = "/register";
}

function buyTicket() {

    var name = document.getElementById("name").value;
    var lastName = document.getElementById("lastName").value;
    var birthDate = document.getElementById("birthDate").value;

    if (name === '' || lastName === '' || birthDate === '') {
        return;
    }

    var route = document.getElementById("route").value;
    var stationFrom = document.getElementById("stationFrom").value;
    var stationTo = document.getElementById("stationTo").value;
    var departureDate = document.getElementById("departureDate").value;
    var arrivalDate = document.getElementById("arrivalDate").value;


    window.location.href = "/buyTicket?name=" + name + "&lastName=" + lastName + "&birthDate=" + birthDate + "&route=" + route + "&stationFrom=" + stationFrom + "&stationTo=" + stationTo + "&departureDate=" + departureDate + "&arrivalDate=" + arrivalDate;
}

function goToAdminPage() {
    window.location.href = "/admin";
}

function goToMyTicketPage(id) {
    window.location.href = "/mytickets?id=" + id;
}
