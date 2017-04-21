'use strict';

[1, 2, 3].map(function (n) {
    return n + 1;
});

$(function () {
    $(document).ready(function () {
        var statistics = document.getElementById('statistics-array').getAttribute('value');
        console.log(statistics);
        var statisticsArr = JSON.parse(statistics);
        var data = {
            labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri'],
            series: [statisticsArr]
        };
        new Chartist.Line('.ct-chart', data);
    });

    $(document).on("click", "#href-update-statistics", function (event) {
        event.preventDefault();
        $.get("/updatestatistics", function (responseText) {
            console.log(responseText);
            var statisticsArr = JSON.parse(responseText);
            var data = {
                labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri'],
                series: [statisticsArr]
            };
            new Chartist.Line('.ct-chart', data);
        });
    });
});