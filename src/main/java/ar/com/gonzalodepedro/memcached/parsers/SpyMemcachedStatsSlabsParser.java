package ar.com.gonzalodepedro.memcached.parsers;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ar.com.gonzalodepedro.memcached.model.StatsSlabs;
import ar.com.gonzalodepedro.memcached.model.SlabClass;

public class SpyMemcachedStatsSlabsParser {

	// StatsSlabs properties
	private static final String TOTAL_MALLOCED = "total_malloced";
	private static final String ACTIVE_SLABS = "active_slabs";

	// SlabClass properties
	private static final String DECR_HITS = "decr_hits";
	private static final String CAS_HITS = "cas_hits";
	private static final String USED_CHUNKS = "used_chunks";
	private static final String CMD_SET = "cmd_set";
	private static final String CHUNK_SIZE = "chunk_size";
	private static final String CHUNKS_PER_PAGE = "chunks_per_page";
	private static final String CAS_BADVAL = "cas_badval";
	private static final String TOTAL_PAGES = "total_pages";
	private static final String FREE_CHUNKS_END = "free_chunks_end";
	private static final String GET_HITS = "get_hits";
	private static final String DELETE_HITS = "delete_hits";
	private static final String MEM_REQUESTED = "mem_requested";
	private static final String FREE_CHUNKS = "free_chunks";
	private static final String TOTAL_CHUNKS = "total_chunks";
	private static final String INCR_HITS = "incr_hits";

	private Map<Integer, SlabClassBuilder> builders = new HashMap<Integer, SlabClassBuilder>();

	/**
	 * Gets a Map same kind the one returned by memcached when asked for a
	 * 'stats slabs' and returns a Map with the same information but in our
	 * format
	 * 
	 * @param spmcStatsSlabs
	 * @return Map<SocketAddress, StatsSlabs> parsed StatsSlabs
	 */
	public Map<SocketAddress, StatsSlabs> parseStatsSlabs(
			Map<SocketAddress, Map<String, String>> spmcStatsSlabs) {

		Map<SocketAddress, StatsSlabs> retMap = new HashMap<SocketAddress, StatsSlabs>();

		for (Entry<SocketAddress, Map<String, String>> aServer : spmcStatsSlabs
				.entrySet()) {
			retMap.put(aServer.getKey(), parseAStat(aServer.getValue()) );
		}

		return retMap;
	}

	/**
	 * Create a StatsSlabs object
	 * 
	 * @param aServer
	 * @return StatsSlabs
	 */

	private StatsSlabs parseAStat(Map<String, String> aServer) {

		int totalMalloced = 0, activeSlabs = 0;
		String key, value;
		String[] values;

		for (Entry<String, String> entry : aServer.entrySet()) {

			key = entry.getKey();
			value = entry.getValue();

			// values for the StatsSlabs object only
			if (key.equals(TOTAL_MALLOCED)) {
				totalMalloced = Integer.parseInt(value);
			} else if (key.equals(ACTIVE_SLABS)) {
				activeSlabs = Integer.parseInt(value);
			}

			// Get the id and the value and populate the proper builder
			values = key.split(":", 2);
			if (values.length == 2) {
				populateSlabBuilder(
						getSlabClassBuilder(Integer.parseInt(values[0])),
						values[1], value);
			}

		}

		// Transform the list of builders into a list of SlabClass
		List<SlabClass> classes = new ArrayList<SlabClass>();
		for (SlabClassBuilder scb : this.builders.values()) {
			classes.add(scb.build());
		}

		return new StatsSlabs(classes, activeSlabs, totalMalloced);
	}

	/**
	 * Populates a slabClassBuilder with the given value
	 * 
	 * @param slabClassBuilder
	 *            slabClassBuilder to populate
	 * @param string
	 *            name of the property
	 * @param value
	 *            value
	 */
	private void populateSlabBuilder(SlabClassBuilder slabClassBuilder,
			String string, String value) {

		if (string.equals(DECR_HITS)) {
			slabClassBuilder.setDecrHits(Integer.parseInt(value));
		} else if (string.equals(CAS_HITS)) {
			slabClassBuilder.setCasHits(Integer.parseInt(value));
		} else if (string.equals(USED_CHUNKS)) {
			slabClassBuilder.setUsedChunks(Integer.parseInt(value));
		} else if (string.equals(CMD_SET)) {
			slabClassBuilder.setCmdSet(Integer.parseInt(value));
		} else if (string.equals(CHUNK_SIZE)) {
			slabClassBuilder.setChunkSize(Integer.parseInt(value));
		} else if (string.equals(CHUNKS_PER_PAGE)) {
			slabClassBuilder.setChunksPerPage(Integer.parseInt(value));
		} else if (string.equals(CAS_BADVAL)) {
			slabClassBuilder.setCasBadval(Integer.parseInt(value));
		} else if (string.equals(TOTAL_PAGES)) {
			slabClassBuilder.setTotalPages(Integer.parseInt(value));
		} else if (string.equals(FREE_CHUNKS_END)) {
			slabClassBuilder.setFreeChunksEnd(Integer.parseInt(value));
		} else if (string.equals(GET_HITS)) {
			slabClassBuilder.setGetHits(Integer.parseInt(value));
		} else if (string.equals(DELETE_HITS)) {
			slabClassBuilder.setDeleteHits(Integer.parseInt(value));
		} else if (string.equals(MEM_REQUESTED)) {
			slabClassBuilder.setMemRequested(Integer.parseInt(value));
		} else if (string.equals(FREE_CHUNKS)) {
			slabClassBuilder.setFreeChunks(Integer.parseInt(value));
		} else if (string.equals(TOTAL_CHUNKS)) {
			slabClassBuilder.setTotalChunks(Integer.parseInt(value));
		} else if (string.equals(INCR_HITS)) {
			slabClassBuilder.setIncrHits(Integer.parseInt(value));
		};

	}

	/**
	 * Get or create one
	 * 
	 * @param id
	 * @return the SlabClassBuilder matching the id
	 */
	private SlabClassBuilder getSlabClassBuilder(int id) {

		SlabClassBuilder builder = this.builders.get(id);
		if (builder == null) {
			builder = new SlabClassBuilder(id);
			this.builders.put(id, builder);
		}

		return builder;
	}

}
