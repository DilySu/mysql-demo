package com.dily.jpa.repository;

import com.dily.jpa.entity.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * GroupRepo
 * Date: 2023-11-29 星期三
 * Time: 14:25
 * Author: Dily_Su
 * Remark:
 */
@Repository
public interface GroupRepo extends CrudRepository<Group,Integer> {
}
