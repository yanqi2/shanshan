function get(url) {
    $.get(url, function (data) {
        return data;
    });
}

function post(url) {
    $.post(url, function (data) {
        return data;
    });
}

function post(url, param) {
    $.post(url, JSON.stringify(param), function (data) {
        return data;
    });
}