var stompClient = null;

function setConnected(connected) {
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#advertisements_grid").show();
    }
    else {
        $("#advertisements_grid").hide();
    }
    $("#advertisements").html("");
}

function connect() {
    var socket = new SockJS('/notification-system/advertisement-notifications');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        var queue = '/queue/advertisement-notifications/users/'+$("#userId").val();
        console.log('Connected to the queue: ' + queue);
        stompClient.subscribe(queue, function (response) {
            var notification = JSON.parse(response.body);
            var message = notification.userId +' => '+notification.description;
            showAdvertisements(message);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}


function showAdvertisements(message) {
    $("#advertisements").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#disconnect").click(function() { disconnect(); });
    $("#send").click(function() { sendName(); });
    $('#userId').blur(function(){
        disconnect();
        connect();
    })
});