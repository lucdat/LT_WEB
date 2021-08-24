package shoesstore.entities;

public class Paging {
	private Long totalRows;
	private int totalPages;
	private int recordPerPage=10;
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
		if(totalRows>0) {
			totalPages =(int) Math.ceil(totalRows/(double)recordPerPage);
		}
		return totalPages;
	}


	public void setTotalPages(int totalPages) {
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
		if(indexPage>0) {
			offset = indexPage*recordPerPage - recordPerPage;
		}
		return offset;
	}


	public void setOffset(int offset) {
		this.offset = offset;
	}


	@Override
	public String toString() {
		return "Paging [totalRows=" + totalRows + ", totalPages=" + totalPages + ", recordPerPage=" + recordPerPage
				+ ", indexPage=" + indexPage + ", offset=" + offset + "]";
	}
	
	
}
