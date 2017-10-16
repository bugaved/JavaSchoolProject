// window.onload = function () {
//
//     var buttons = document.getElementsByTagName('button');
//
//     var counter = 0;
//
//     for (var i = 0; i < buttons.length; i++) {
//
//         var button = buttons[i];
//
//         button.setAttribute("id", "" + counter);
//         counter++;
//
//         button.addEventListener("click", function () {
//             button.setAttribute("id", "clickedId");
//         });
//     }
//
// };
//
//
// function iterate() {
//
//     var table = document.getElementById("trainsTable");
//
//
//     for (var i = 0, row; row = table.rows[i]; i++) {
//
//         var cellWithButton = (row.cells[6]);
//
//         var button = cellWithButton.getElementsByTagName("button");
//
//         console.log(button[1]);
//
//         //iterate through rows
//         //rows would be accessed using the "row" variable assigned in the for loop
//         for (var j = 0, col; col = row.cells[j]; j++) {
//             //iterate through columns
//             //columns would be accessed using the "col" variable assigned in the for loop
//         }
//     }
//
// }