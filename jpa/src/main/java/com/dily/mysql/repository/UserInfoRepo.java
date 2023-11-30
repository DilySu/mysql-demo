package com.dily.mysql.repository;

import com.dily.mysql.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * StudentRepo
 * Date: 2023-11-29 星期三
 * Time: 11:16
 * Author: Dily_Su
 * Remark:
 */
@Repository
public interface UserInfoRepo extends CrudRepository<UserInfo, Integer> {
}
