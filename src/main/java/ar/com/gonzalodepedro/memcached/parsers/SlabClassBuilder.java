package ar.com.gonzalodepedro.memcached.parsers;

import ar.com.gonzalodepedro.memcached.model.SlabClass;

public class SlabClassBuilder {

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

	public SlabClassBuilder(int classId) {
		this.classId = classId;
	}
	
	public void setChunkSize(int chunkSize) {
		this.chunkSize = chunkSize;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setTotalChunks(int totalChunks) {
		this.totalChunks = totalChunks;
	}
	
	public void setUsedChunks(int usedChunks) {
		this.usedChunks = usedChunks;
	}

	public void setFreeChunks(int freeChunks) {
		this.freeChunks = freeChunks;
	}

	public void setFreeChunksEnd(int freeChunksEnd) {
		this.freeChunksEnd = freeChunksEnd;
	}

	public void setMemRequested(int memRequested) {
		this.memRequested = memRequested;
	}

	public void setGetHits(int getHits) {
		this.getHits = getHits;
	}

	public void setCmdSet(int cmdSet) {
		this.cmdSet = cmdSet;
	}

	public void setDeleteHits(int deleteHits) {
		this.deleteHits = deleteHits;
	}

	public void setIncrHits(int incrHits) {
		this.incrHits = incrHits;
	}

	public void setDecrHits(int decrHits) {
		this.decrHits = decrHits;
	}

	public void setCasHits(int casHits) {
		this.casHits = casHits;
	}

	public void setCasBadval(int casBadval) {
		this.casBadval = casBadval;
	}

	public void setChunksPerPage(int chunksPerPage) {
		this.chunksPerPage = chunksPerPage;
	}

	public SlabClass build() {
		return new SlabClass(this.classId, this.chunkSize, this.chunksPerPage, this.totalPages, this.totalChunks,
				this.usedChunks, this.freeChunks, this.freeChunksEnd,
				this.memRequested, this.getHits, this.cmdSet, this.deleteHits,
				this.incrHits, this.decrHits, this.casHits, this.casBadval);
	}

}
