function goToSchedule() {
    window.location.href = "/schedule";
}

function goToRegisterPage() {
    window.location.href = "/register";
}

function tryToRegUser() {
    var hiddenBlock = document.getElementById("createMessage");
    hiddenBlock.style.display = "inline";
}

function goToPurchasePage() {
    window.location.href = "/purchase";
}

function buttonsIdIncrement() {
    var buttons = document.getElementsByTagName("button");

    var i = 0;

    for (var button in buttons) {
        buttons.id = i;
        i++;
    }
}