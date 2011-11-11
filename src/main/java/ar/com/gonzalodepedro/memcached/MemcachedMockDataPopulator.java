package ar.com.gonzalodepedro.memcached;

import java.io.IOException;
import java.util.Arrays;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

public class MemcachedMockDataPopulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer[] sizes = new Integer[] {1, 1024, 2048};
		
		MemcachedClient mcc = null;
		try {
			mcc = new MemcachedClient(AddrUtil.getAddresses("127.0.0.1:11211"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(int size: sizes){
			mcc.add(Integer.toString(size), 0, new Object[size] );
		}
		
	}

}
