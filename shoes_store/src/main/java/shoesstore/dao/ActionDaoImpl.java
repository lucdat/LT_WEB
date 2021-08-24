package shoesstore.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import shoesstore.entities.Action;

@Repository
@Transactional(rollbackOn = Exception.class)
public class ActionDaoImpl extends BaseDaoImpl<Action, Integer> implements ActionDao<Action, Integer>{

}
