package shoesstore.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import shoesstore.entities.Import;

@Repository
@Transactional(rollbackOn = Exception.class)
public class ImportDaoImpl extends BaseDaoImpl<Import, Integer> implements ImportDao<Import, Integer> {

}
