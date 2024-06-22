let itemArr = "";
let place = "강남구";


$(document).ready(function(){
    aJaxApiCall(place, function(res){
        drawAirInfo(res, place)
    })
})

function aJaxApiCall(place, callback) {
    $.ajax({
        url: "airPlace",
        data: {
            place : place
        },
        success: function(data) {
            itemArr = data.response.body.items;
            callback(itemArr);
        },
        error: function() {
            console.log("대기정보 api요청 실패")
        }
    })
}

function getAirInfo(data) {

    place = data.target;
    aJaxApiCall(place, function(res){
        drawAirInfo(res, place)
    });
}

function drawAirInfo(items, place) {    
    let html = document.querySelector('#air_info_place').innerHTML;
    let str = "";
    str = `
        <tr>
            <th colspan="7"><h1 align="center" style="font-weight: 700;">${place}</h1></th>
        </tr>
        <tr>
            <th></th><th></th><th></th><th></th><th></th>
            <th colspan="2" id="span_right_po">
                <span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
                <span style="color: ${getColorByGrade('1')}; padding: 5px;">좋음</span>
                <span style="color: ${getColorByGrade('2')}; padding: 5px;">보통</span>
                <span style="color: ${getColorByGrade('3')}; padding: 5px;">나쁨</span>
                <span style="color: ${getColorByGrade('4')}; padding: 5px;">매우나쁨</span>
            </th>
        </tr>
        <tr>
            <td>측정시간</td>
            <td>KHAI지수</td>
            <td>아황산가스(SO2)</td>
            <td>일산화탄소(CO)</td>
            <td>오존(O3)</td>
            <td>이산화질소(NO2)</td>
            <td>미세먼지(PM10)</td>
        </tr>`
    for(let i of items) {
    str += `<tr>
            <td>${i.dataTime}</td>
            <td style="color: ${getColorByGrade(i.khaiGrade)}">${i.khaiValue}</td>
            <td style="color: ${getColorByGrade(i.so2Grade)}">${i.so2Value} ppm</td>
            <td style="color: ${getColorByGrade(i.coGrade)}">${i.coValue} ppm</td>
            <td style="color: ${getColorByGrade(i.o3Grade)}">${i.o3Value} ppm</td>
            <td style="color: ${getColorByGrade(i.no2Grade)}">${i.no2Value} ppm</td>
            <td style="color: ${getColorByGrade(i.pm10Grade)}">${i.pm10Value} ㎍/㎥</td>
        </tr>`;
    }
    document.querySelector('#air_info_place').innerHTML = str;
}

function getColorByGrade(grade) {
    switch (grade) {
        case '1':
            return 'green';   // 검은색
        case '2':
            return 'black';  // 노란색
        case '3':
            return 'rgb(255, 196, 0)';  // 주황색
        case '4':
            return 'red';     // 빨간색
    }
}