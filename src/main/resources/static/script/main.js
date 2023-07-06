function generateNewRandomUser(theUrl) {
    const xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", theUrl, true);
    xmlHttp.send(null);

    xmlHttp.onload = function () {
        document.getElementById("responseP").innerHTML = (xmlHttp.response);
    };

    xmlHttp.onerror = function () {
        document.getElementById("responseP").innerHTML = (xmlHttp.status);
    };
}
