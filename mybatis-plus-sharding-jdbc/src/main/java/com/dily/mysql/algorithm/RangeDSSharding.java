package com.dily.mysql.algorithm;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Date: 2022-09-20 星期二
 * Time: 16:57
 * Author: Dily_Su
 * Remark: 区间查询数据库选择算法
 */
public class RangeDSSharding implements RangeShardingAlgorithm<Long> {

    /**
     * @param collection 库名集合
     * @param rangeShardingValue sql参数
     * @return 表名集合
     *
     * select * from user where id between 100 and 200
     */
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {
        // m$->{id%2+1} => m1, m2
        Collection<String> res = new ArrayList<>();
        collection.forEach(e -> {
            if (e.startsWith("m"))
                res.add(e);
        });
        return res;
    } // 这个类型只适用于 Long 的范围查询
}
