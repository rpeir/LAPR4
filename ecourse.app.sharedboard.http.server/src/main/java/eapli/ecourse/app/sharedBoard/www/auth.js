var currentBoard = 0;
var requestMade = false;
var stopRequests = false;

function viewBoard(option) {
    currentBoard = option;
    if (!requestMade) {
        makeRequest(); requestMade= true;
    }
    var vBoard = document.getElementById("board");
    vBoard.innerHTML = "<div style=\"font-family: Arial, sans-serif;\">Loading your Board ... Please wait.</div>";
}

function makeRequest(){
    if(stopRequests){
        return; //stop requests
    }
    var request = new XMLHttpRequest();
    var vBoard = document.getElementById("board");
    vBoard.innerHTML = vBoard.innerHTML + "<p style=\"font-family: Arial, sans-serif;\">Loading your Board ... Please wait.</p>";

    request.open("GET", "/board/" + currentBoard + "/" + sessionToken, true);
    request.send();
    request.onreadystatechange = function () {
        if (request.status === 200) {
            vBoard.innerHTML = "<div style=\"font-family: Arial, sans-serif;\">" + request.response + "</div>";
        }
    };

    request.onload = function () {
        vBoard.innerHTML = "<div style=\"font-family: Arial, sans-serif;\">" + request.response + "</div>";
        vBoard.style.color = "black";
        setTimeout(makeRequest, 2000);
    };

    request.ontimeout = function () {
        vBoard.innerHTML = "<div style=\"font-family: Arial, sans-serif;\">Server timeout, still trying ...</div>";
        vBoard.style.color = "red";
        setTimeout(makeRequest, 100);
    };

    request.onerror = function () {
        vBoard.innerHTML = "<div style=\"font-family: Arial, sans-serif;\">No server reply, still trying ...</div>";
        vBoard.style.color = "red";
        setTimeout(makeRequest, 5000);
    };
}

function disconnect() {
    var request = new XMLHttpRequest();
    var vBoard = document.getElementById("board");
    vBoard.innerHTML = "<div style=\"font-family: Arial, sans-serif;\">Disconnecting ... Please wait.</div>";
    stopAJAXRequests();
    request.open("POST", "/disconnect/"+sessionToken, true);
    request.send();

    request.onload = function() {
        document.body.innerHTML = request.response;
        document.body.style.color="black";
        document.body.style.fontFamily="Arial, sans-serif";
        stopRequests();
    };

    request.ontimeout = function() {
        document.body.innerHTML= "Server timeout, still trying ...";
        document.body.style.color="red";
        document.body.style.fontFamily="Arial, sans-serif";
    };

    request.onerror = function() {
        document.body.innerHTML= "No server reply, still trying ...";
        document.body.style.color="red";
        document.body.style.fontFamily="Arial, sans-serif";
    };
}
function stopAJAXRequests(){
    stopRequests = true;
}
