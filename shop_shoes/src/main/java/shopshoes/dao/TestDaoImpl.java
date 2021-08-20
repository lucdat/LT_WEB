package shopshoes.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import shopshoes.entities.Demo;

@Repository
@Transactional(rollbackOn = Exception.class)
public class TestDaoImpl extends BaseDaoImpl<Demo, Integer> implements TestDao<Demo, Integer> {

}
