package ar.com.gonzalodepedro.memcached.visualization.html;

import java.util.Map.Entry;

import ar.com.gonzalodepedro.memcached.model.SlabClass;
import ar.com.gonzalodepedro.memcached.model.StatsSlabs;

public class SlabClassSizeDistributionGraph implements IComponent {

	@Override
	public String getHtml(StatsSlabs stats) {
		StringBuffer toReturn = new StringBuffer();
		toReturn.append(
		"    <script type=\"text/javascript\">" +
		"      google.load(\"visualization\", \"1\", {packages:[\"corechart\"]}); " +
		"      google.setOnLoadCallback(drawChart);" +
		"      function drawChart() { " +
		"        var data = new google.visualization.DataTable(); " +
		"        data.addColumn('string', 'Slab Class'); " +
		"        data.addColumn('number', 'Bytes allocated'); " +

		"        data.addRows(" + stats.getActiveSlabs()  + ");   "
		);

		int i = 0;
		for(Entry<Integer, SlabClass> scEntry : stats.getSlabClasses().entrySet()){
			toReturn.append(	"        data.setValue(" + i + ", 0, '" + scEntry.getKey() +"');   "  						);
			toReturn.append(	"        data.setValue(" + i + ", 1, '" + scEntry.getValue().getMemRequested() +"');   "	);
			
		}

		toReturn.append(
		"        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));   " +
		"        chart.draw(data, {width: 450, height: 300, title: 'My Daily Activities'});   " +
		"      }   " +
		"    </script>   " +
		"    <div id=\"chart_div\"></div>   "
		);
		
		return toReturn.toString();
	}

}
