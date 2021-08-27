package shoesstore.dao;


import java.util.List;

import shoesstore.entities.Invoice;
public interface InvoiceDao<E,ID> extends BaseDao<E, ID> {	
	public List<Invoice> statistical(String a , String b);
}