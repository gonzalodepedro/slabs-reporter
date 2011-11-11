package ar.com.gonzalodepedro.memcached.visualization.html;

import java.util.Map.Entry;

import ar.com.gonzalodepedro.memcached.model.SlabClass;
import ar.com.gonzalodepedro.memcached.model.StatsSlabs;

public class MemRequestedPerSlabClass implements IComponent{

	@Override
	public String getHtml(StatsSlabs stats) {
		StringBuffer toReturn = new StringBuffer();
		toReturn.append(
		"    <script type=\"text/javascript\"> \n" +
		"      google.load(\"visualization\", \"1\", {packages:[\"corechart\"]}); \n" +
		"      google.setOnLoadCallback(drawChart); \n" +
		"      function drawChart() { \n" +
		"        var data = new google.visualization.DataTable(); \n" +
		"        data.addColumn('string', 'Slab Class'); \n" +
		"        data.addColumn('number', 'Bytes allocated'); \n" +
		"        data.addRows(" + stats.getActiveSlabs()  + ");  \n "
		);

		int i = 0;
		for(Entry<Integer, SlabClass> scEntry : stats.getSlabClasses().entrySet()){
			toReturn.append(	"        data.setValue(" + i + ", 0, '" + scEntry.getKey() +"');   \n"  						);
			toReturn.append(	"        data.setValue(" + i + ", 1, " + scEntry.getValue().getMemRequested() +");   \n"	);
		i++;	
		}

		toReturn.append(
		"        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));    \n" +
		"        chart.draw(data, {width: 450, height: 300, title: 'My Daily Activities'});    \n" +
		"      }    \n" +
		"    </script>    \n" +
		"    <div id=\"chart_div\"></div>    \n"
		);
		
		return toReturn.toString();
	}



	
}
