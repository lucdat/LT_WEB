package shoesstore.entities;

public class Paging {
	private Long totalRows;
	private int totalPages;
	private int recordPerPage=2;
	private int indexPage;
	private int offset;
	
	
	public Paging(int indexPage) {
		this.indexPage = indexPage;
	}


	public Long getTotalRows() {
		return totalRows;
	}


	public void setTotalRows(Long totalRows) {
		this.totalRows = totalRows;
	}


	public int getTotalPages() {
		return totalPages;
	}


	public void setTotalPages(int totalPages) {
		if(this.totalRows>0) {
			totalPages = (int)Math.ceil(this.totalRows/(double)this.recordPerPage);
		}
		this.totalPages = totalPages;
	}


	public int getRecordPerPage() {
		return recordPerPage;
	}


	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}


	public int getIndexPage() {
		return indexPage;
	}


	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}


	public int getOffset() {
		return offset;
	}


	public void setOffset(int offset) {
		if(this.indexPage>0) {
			offset = this.indexPage*this.recordPerPage - this.recordPerPage;
		}
		this.offset = offset;
	}
}
