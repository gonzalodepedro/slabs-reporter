package ar.com.gonzalodepedro.memcached.visualization.html;

import java.util.Arrays;
import java.util.List;

import ar.com.gonzalodepedro.memcached.model.StatsSlabs;

public class Page implements IComponent {
	
	private static String head = "<html> \n" +
	"  <head> \n" +
	"    <script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>  \n"+
	"  </head>    \n" +
    "   ";
	
	private static String bodyTop =  
	"  <body>     \n";

	private static String bodyDown = 
	"  </body>    \n" +
	"</html>    \n";
	
	
	public List<IComponent> components;
	
	public Page(IComponent ... components){
		this.components = Arrays.asList(components);
	}
	
	@Override
	public String getHtml(StatsSlabs stats) {
		StringBuffer sb = new StringBuffer();
		sb.append(head);
		sb.append(bodyTop);
		
		for(IComponent aComponent : this.components)
			sb.append(aComponent.getHtml(stats));
		
		sb.append(bodyDown);
		
		return sb.toString();
	}
		
	

}
