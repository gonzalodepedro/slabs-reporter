package ar.com.gonzalodepedro.memcached.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents the result of calling a 'stats slabs' command on memcached.
 * @author gonzalo
 *
 */
public class StatsSlabs {

	int activeSlabs;
	int totalMalloced;
		
	private Map<Integer, SlabClass> slabClasses = new HashMap<Integer,SlabClass>();
	
	public StatsSlabs(List<SlabClass> slabClasses, int activeSlabs, int totalMalloced){
		addSlabClasses(slabClasses);
		this.activeSlabs = activeSlabs;
		this.totalMalloced = totalMalloced;
	}
	
	public void setSlabClasses(List<SlabClass> slabClasses, int activeSlabs, int totalMalloced){
		addSlabClasses(slabClasses);
		this.activeSlabs = activeSlabs;
		this.totalMalloced = totalMalloced;
	}
	
	/**
	 * Given a List of SlabClasses it stores them into the Map
	 * @param slabClasses
	 */
	private void addSlabClasses(List<SlabClass> slabClasses){
		for(SlabClass sc : slabClasses){
			this.slabClasses.put(sc.getClassId(), sc);
		}
	}
	
}
