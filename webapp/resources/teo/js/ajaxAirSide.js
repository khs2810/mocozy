let itemArr = "";
let place = "강남구";


$(document).ready(function(){
    aJaxApiCall(place, function(res){
        drawAirSide(res)
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
            callback(itemArr[0]);
        },
        error: function() {
            console.log("대기정보 api요청 실패")
        }
    })
}

function drawAirSide(i){
    console.log(i)
    let str = `<tr>
                <td>KHAI지수</td>
                <td>${i.khaiValue}</td>
               </tr>
               <tr>
                <td>아황산가스</td>
                <td style="color: ${getColorByGrade(i.so2Grade)}">${i.so2Value} ppm</td>
               </tr>

               <tr>
                <td>일산화탄소</td>
                <td style="color: ${getColorByGrade(i.coGrade)}">${i.coValue} ppm</td>
               </tr>
               <tr>
                <td>오존</td>
                <td style="color: ${getColorByGrade(i.o3Grade)}">${i.o3Value} ppm</td>
               </tr>
               <tr>
                <td>이산화질소</td>
                <td style="color: ${getColorByGrade(i.no2Grade)}">${i.no2Value} ppm</td>
               </tr>
               <tr>
                <td>미세먼지</td>
                <td style="color: ${getColorByGrade(i.pm10Grade)}">${i.pm10Value} ㎍/㎥</td>
               </tr>`
    str += `<tr>
                <td colspan='2'>
                    <a href='airApi.co'>자세히 보기></a>
                </td>
            </tr>`
    document.querySelector('#air_info_side').innerHTML = str;
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