package shoesstore.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import shoesstore.entities.FeedBack;

@Repository
@Transactional(rollbackOn = Exception.class)
public class ManagerFeedBackDaoImp extends BaseDaoImpl<FeedBack, Integer> implements ManagerFeedBackDao<FeedBack, Integer>{

}
