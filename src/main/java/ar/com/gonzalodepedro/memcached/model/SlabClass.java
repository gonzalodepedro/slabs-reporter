package ar.com.gonzalodepedro.memcached.model;


public class SlabClass {

	private int classId;
	private int chunkSize;
	private int chunksPerPage;
	private int totalPages;
	private int totalChunks;
	private int usedChunks;
	private int freeChunks;
	private int freeChunksEnd;
	private int memRequested;
	private int getHits;
	private int cmdSet;
	private int deleteHits;
	private int incrHits;
	private int decrHits;
	private int casHits;
	private int casBadval;
	
	public SlabClass(int classId, int chunkSize, int chunksPerPage, int totalPages, int totalChunks, int usedChunks, int freeChunks, int freeChunksEnd, int memRequested, int getHits, int cmdSet, int deleteHits, int incrHits, int decrHits, int casHits, int casBadval){
		this.classId = classId;
		this.chunkSize = chunkSize;
		this.chunksPerPage = chunksPerPage;
		this.totalPages = totalPages;
		this.totalChunks = totalChunks;
		this.usedChunks = usedChunks;
		this.freeChunks = freeChunks;
		this.freeChunksEnd = freeChunksEnd;
		this.memRequested = memRequested;
		this.getHits = getHits;
		this.cmdSet = cmdSet;
		this.deleteHits = deleteHits;
		this.incrHits = incrHits;
		this.decrHits = decrHits;
		this.casHits = casHits;
		this.casBadval = casBadval;
	}

	public int getChunkSize() {
		return chunkSize;
	}

	public int getChunksPerPage() {
		return chunksPerPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getTotalChunks() {
		return totalChunks;
	}

	public int getUsedChunks() {
		return usedChunks;
	}

	public int getFreeChunks() {
		return freeChunks;
	}

	public int getFreeChunksEnd() {
		return freeChunksEnd;
	}

	public int getMemRequested() {
		return memRequested;
	}

	public int getGetHits() {
		return getHits;
	}

	public int getCmdSet() {
		return cmdSet;
	}

	public int getDeleteHits() {
		return deleteHits;
	}

	public int getIncrHits() {
		return incrHits;
	}

	public int getDecrHits() {
		return decrHits;
	}

	public int getCasHits() {
		return casHits;
	}

	public int getCasBadval() {
		return casBadval;
	}
	
	public int getClassId(){
		return classId;
	}
	
}
