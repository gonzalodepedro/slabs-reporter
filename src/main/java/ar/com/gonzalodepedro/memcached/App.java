package ar.com.gonzalodepedro.memcached;

import java.io.FileOutputStream;
// TODO Auto-generated catch block

import java.io.FileWriter;
import java.io.IOException;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import ar.com.gonzalodepedro.memcached.model.SlabClass;
import ar.com.gonzalodepedro.memcached.model.StatsSlabs;
import ar.com.gonzalodepedro.memcached.parsers.SpyMemcachedStatsSlabsParser;
import ar.com.gonzalodepedro.memcached.visualization.html.MemRequestedPerSlabClass;
import ar.com.gonzalodepedro.memcached.visualization.html.Page;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {

		MemcachedClient mcc = null;
		try {
			mcc = new MemcachedClient(AddrUtil.getAddresses("127.0.0.1:11211"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// DEBUG
		Map<SocketAddress, Map<String,String>> stats_slabs = mcc.getStats("slabs");
		for(Entry<SocketAddress, Map<String, String>> entry : stats_slabs.entrySet()){
			System.out.println("\n " + entry.getKey());
			for(Entry<String, String> entry2 : entry.getValue().entrySet()){
				System.out.println("\t" + entry2.getKey() + " => " + entry2.getValue());
			}
		}

		SpyMemcachedStatsSlabsParser smslp = new SpyMemcachedStatsSlabsParser();
		Map<SocketAddress, StatsSlabs> statsPerServer = smslp.parseStatsSlabs(stats_slabs);
		
		
		MemRequestedPerSlabClass mrpsl = new MemRequestedPerSlabClass();
		Page page = new Page(mrpsl);
		
		String salida = page.getHtml(statsPerServer.entrySet().iterator().next().getValue());
		
		System.out.println(salida);
		
		FileWriter fw;
		try {
			fw = new FileWriter("prueba.html");
			fw.write(salida);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
		
	}
}
