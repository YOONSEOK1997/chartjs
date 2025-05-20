<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
</head>
<body>
	<h1>Chart.js 라이브러리 실습</h1>

	<div>
		<h1>나라별 평균 나이</h1>
		<canvas id="chart1" style="width: 100%; max-width: 600px"></canvas>
	</div>

	<div>
		<h1>성별 가입자수</h1>
		<div id="chart2"></div>
	</div>

	<div>
  <h1>년도별 나라별 가입자 수</h1>
  <canvas id="chart3" style="width: 100%; max-width: 600px;"></canvas>
</div>
	<div>
		<h1>연도별 누적 가입자 수</h1>
		<div id="chart4"></div>
	</div>
</body>

<script>
////1)
   $.ajax({
      url : '/rest/AvgAgeByCountry',
      type : 'post',
      success : function(data) {
         console.log(data);
         
         const xValues = []; // 나라
         const yValues = []; // 평균나이
         const barColors = ["green", "blue", "orange", "brown"];
         
         $(data).each(function(i, e) {
            console.log(e);
            xValues[i] = e.country;
            yValues[i] = e.age;
         });
         
         new Chart("chart1", {
           type: "bar",
           data: {
             labels: xValues,
             datasets: [{
               backgroundColor: barColors,
               data: yValues
             }]
           },
           options: {
             legend: {display: false},
             scales: {
               yAxes: [{
                 ticks: {
                   beginAtZero: true
                 }
               }]
             },
         
             title: {
               display: true,
               text: "나라별 평균 나이"
             }
           }
         });
      }
   });
   ////3)
 $.ajax({
   url: '/rest/CountByYearAndCountry',
   type : 'post',
   success: function(data){
      console.log(data);

      const xValues = [100,200,300,400,500,600,700,800,900,1000];

      new Chart("chart3", {
        type: "line",
        data: {
          labels: xValues,
          datasets: [
            {
              data: [860,1140,1060,1060,1070,1110,1330,2210,7830,2478],
              borderColor: "red",
              fill: false
            },
            {
              data: [1600,1700,1700,1900,2000,2700,4000,5000,6000,7000],
              borderColor: "green",
              fill: false
            },
            {
              data: [300,700,2000,5000,6000,4000,2000,1000,200,100],
              borderColor: "blue",
              fill: false
            }
          ]
        },
        options: {
          legend: {display: false}
        }
      }); // new Chart

   } // success function 끝
}); // $.ajax 끝

</script>
</html>