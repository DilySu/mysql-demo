package com.dily.mysql.repository;

import com.dily.mysql.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * RoleRepo
 * Date: 2023-11-29 星期三
 * Time: 14:57
 * Author: Dily_Su
 * Remark:
 */
@Repository
public interface RoleRepo extends CrudRepository<Role,Integer> {
}
