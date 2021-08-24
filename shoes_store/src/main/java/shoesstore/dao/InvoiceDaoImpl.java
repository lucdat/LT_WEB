package shoesstore.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import shoesstore.entities.Invoice;

@Repository
@Transactional(rollbackOn = Exception.class)
public class InvoiceDaoImpl extends BaseDaoImpl<Invoice, Integer> implements InvoiceDao<Invoice, Integer> {

}
