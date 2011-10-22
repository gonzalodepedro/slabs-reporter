package ar.com.gonzalodepedro.memcached.visualization;

public class MemRequestedPerSlabClass {

	public String getHTML(){
		return 
		"<html>" +
		"  <head>" +
		"    <script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script> "+
		"  </head>   " +
        "   " +
		"  <body>    " +
		"    <script type=\"text/javascript\">" +
		"      google.load(\"visualization\", \"1\", {packages:[\"corechart\"]}); " +
		"      google.setOnLoadCallback(drawChart);" +
		"      function drawChart() { " +
		"        var data = new google.visualization.DataTable(); " +
		"        data.addColumn('string', 'Slab Class'); " +
		"        data.addColumn('number', 'Bytes allocated'); " +

		"        data.addRows(5);   " +

		"        data.setValue(0, 0, 'Work');   " +
		"        data.setValue(0, 1, 11);   " +
		"        data.setValue(1, 0, 'Eat');   " +
		"        data.setValue(1, 1, 2);   " +
		"        data.setValue(2, 0, 'Commute'); "  +
		"        data.setValue(2, 1, 2);   " +
		"        data.setValue(3, 0, 'Watch TV');   " +
		"        data.setValue(3, 1, 2);   " +
		"        data.setValue(4, 0, 'Sleep');   " +
		"        data.setValue(4, 1, 7);   " +

		" " +
		"        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));   " +
		"        chart.draw(data, {width: 450, height: 300, title: 'My Daily Activities'});   " +
		"      }   " +
		"    </script>   " +
		"    <div id=\"chart_div\"></div>   " +
		"  </body>   " +
		"</html>   ";
	}
	
}
