
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Reportes</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  
  <!-- ACA VAN LOS GRAFICOS -->
  
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
		<script type="text/javascript">
		
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawMentionsChart);
        google.charts.setOnLoadCallback(drawRetweetsAndLikesChart);

        function drawMentionsChart() {

          var data = new google.visualization.DataTable();
          data.addColumn('date', 'Tiempo');
          data.addColumn('number', 'Menciones');

          data.addRows([
            [new Date(2018, 7, 1), 5],  [new Date(2018, 7, 2), 7],  [new Date(2018, 7, 3), 3],
            [new Date(2018, 7, 4), 1],  [new Date(2018, 7, 5), 3],  [new Date(2018, 7, 6), 4],
            [new Date(2018, 7, 7), 3],  [new Date(2018, 7, 8), 4],  [new Date(2018, 7, 9), 2],
            [new Date(2018, 7, 10), 5], [new Date(2018, 7, 11), 8], [new Date(2018, 7, 12), 6],
            [new Date(2018, 7, 13), 3], [new Date(2018, 7, 14), 3], [new Date(2018, 7, 15), 5],
            [new Date(2018, 7, 16), 7], [new Date(2018, 7, 17), 6], [new Date(2018, 7, 18), 6],
            [new Date(2018, 7, 19), 3], [new Date(2018, 7, 20), 1], [new Date(2018, 7, 21), 2],
            [new Date(2018, 7, 22), 4], [new Date(2018, 7, 23), 6], [new Date(2018, 7, 24), 5],
            [new Date(2018, 7, 25), 9], [new Date(2018, 7, 26), 4], [new Date(2018, 7, 27), 9],
            [new Date(2018, 7, 28), 8], [new Date(2018, 7, 29), 6], [new Date(2018, 7, 30), 4],
            [new Date(2018, 7, 31), 6], [new Date(2018, 8, 1), 7],  [new Date(2018, 8, 2), 9]
          ]);


          var options = {
            'width':700,
            'height':400,
            hAxis: {
              title: 'Tiempo',
              format: 'd/M/yy',
              gridlines: {count: 15}
            },
          	vAxis: {
            	title: 'Menciones'
          	},
          backgroundColor: '#f1f8e9'
          };

          var chart = new google.visualization.LineChart(document.getElementById('menciones_chart'));

          chart.draw(data, options);

          var button = document.getElementById('change');

          button.onclick = function () {

            // If the format option matches, change it to the new option,
            // if not, reset it to the original format.
            options.hAxis.format === 'd/M/yy' ?
            options.hAxis.format = 'dd MMM, yyyy' :
            options.hAxis.format = 'd/M/yy';

            chart.draw(data, options);
          };
        }
        
        function drawRetweetsAndLikesChart() {

            var data = google.visualization.arrayToDataTable([
              ['Campo', 'Cantidad',],
              ['Retweets', 25],
              ['Likes', 12]
            ]);

            var options = {
              'width':700,
              'height':400,
              chartArea: {width: '50%'},
              hAxis: {
                title: '',
                minValue: 0
              },
              vAxis: {
                title: ''
              }
            };

            var chart = new google.visualization.BarChart(document.getElementById('likes_chart'));

            chart.draw(data, options);
          }

        google.charts.load('current', {
            'packages':['geochart'],
            // Note: you will need to get a mapsApiKey for your project.
            // See: https://developers.google.com/chart/interactive/docs/basic_load_libs#load-settings
            'mapsApiKey': 'AIzaSyD-9tSrke72PouQMnMX-a7eZSW0jkFMBWY'
          });
          google.charts.setOnLoadCallback(drawRegionsMap);

          function drawRegionsMap() {
            var data = google.visualization.arrayToDataTable([
              ['Pais', 'Cantidad de Tweets'],
              ['Argentina', 200],
              ['Brazil', 400],
              ['Russia', 250],
              ['United States', 600]
            ]);

            var options = {};

            var chart = new google.visualization.GeoChart(document.getElementById('regions_div'));

            chart.draw(data, options);
          }
          
          google.charts.load('current', {'packages':['table']});
          google.charts.setOnLoadCallback(drawTable);

          function drawTable() {
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Usuario');
            data.addColumn('number', 'Tweets');
            data.addColumn('number', 'Cantidad de Seguidores');
            data.addColumn('number', 'Cantidad de Amigos');
            data.addRows([
              ['@btgomez',  10, 47, 23],
              ['@carlosponce', 8,  58, 36],
              ['@mchamorro', 5, 39, 46],
              ['@sofiapp',  3, 26, 27],
              ['@lrem',  2, 37, 76],
              ['@vulpulate',  2, 69, 127],
              ['@carocarp',  2, 23, 27],
              ['@melisapanyagua',  2, 86, 102],
              ['@carlosva',  2, 57, 91],
              ['@pinoso12',  1, 43, 49],
              ['@cfrhector',  1, 61, 103],
              ['@montaneses',  1, 22, 41],
              ['@marilaigu',  1, 76, 78],
              ['@emanuelpoletti',  1, 156, 163],
              ['@maxcope',  1, 94, 98],
              ['@sebastebulli',  1, 14, 12],
              ['@debora777',  1, 26, 27]
            ]);

            var table = new google.visualization.Table(document.getElementById('table_div'));

            table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
          }
          
		</script>
  
  
  
  <!-- ACA VAN LOS GRAFICOS -->
  
  
  
  <style>
  .card {
	max-width: 300px;
	margin: auto;
	text-align: center;
	font-family: arial;
}
button {
	border: none;
	outline: 0;
	display: inline-block;
	padding: 8px;
	color: white;
	background-color: #4caf50;
	text-align: center;
	cursor: pointer;
	width: 100%;
	font-size: 18px;
}

th, td {
    padding: 15px;
}

  table.center {
    margin-left:auto; 
    margin-right:auto;
  }
  
</style>
</head>
<body>
<table class="center">
      <tr>
        <td>
        <div><p><strong>Cantidad de Menciones</strong></p></div>
        <div id="menciones_chart" style="border: 1px solid #ccc"></div>
        </td>
        <td>
        <div><p><strong>Cantidad de Likes y Retweets</strong></p></div>
        <div id="likes_chart" style="border: 1px solid #ccc"></div>
        </td>
      </tr>
      <tr>
      	<td>
      	<div><p><strong>Tweets por País</strong></p></div>
      	<div id="regions_div" style="border: 1px solid #ccc"></div>
      	</td>
      	<td>
      	<div><p><strong>Usuarios con más menciones</strong></p></div>
      	<div id="table_div" style="border: 1px solid #ccc"></div>
      	</td>
      	
      </tr>
    </table>
    <br/>
<div class="card">
    <p>
			<button onclick="location.href='/admin'">Regresar al menu principal</button>
		</p>
		
		</div>
</body>
</html>