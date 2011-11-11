package ar.com.gonzalodepedro.memcached.visualization.html;

import ar.com.gonzalodepedro.memcached.model.StatsSlabs;

public interface IComponent {

	public String getHtml(StatsSlabs stats);
	
	
}
