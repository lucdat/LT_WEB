package shoesstore.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import shoesstore.entities.Role;

@Repository
@Transactional(rollbackOn = Exception.class)
public class RoleDaoImpl extends BaseDaoImpl<Role, Integer> implements RoleDao<Role, Integer>{

}
