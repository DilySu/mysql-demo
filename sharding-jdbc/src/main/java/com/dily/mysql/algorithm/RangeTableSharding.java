package com.dily.mysql.algorithm;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Date: 2022-09-20 星期二
 * Time: 16:57
 * Author: Dily_Su
 * Remark: 区间查询表选择算法
 */
public class RangeTableSharding implements RangeShardingAlgorithm<Long> {

    /**
     * @param collection 表名集合
     * @param rangeShardingValue sql参数
     * @return 表名集合
     *
     * 只适用于 Long 的范围查询
     * select * from user where id between 100 and 200
     */
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {
        // user_$->{id%2+1} => user_1, user_2
        String logicTableName = rangeShardingValue.getLogicTableName();
        Collection<String> res = new ArrayList<>();
        collection.forEach(e -> {
            if (e.startsWith(logicTableName))
                res.add(e);
        });
        return res;
    }
}
