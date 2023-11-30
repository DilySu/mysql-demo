package com.dily.mysql.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.math.BigInteger;
import java.util.Collection;

/**
 * Date: 2022-09-20 星期二
 * Time: 17:10
 * Author: Dily_Su
 * Remark: 简单查询表选择算法
 */
public class PreciseTableSharding implements PreciseShardingAlgorithm<Long> {

    /**
     *
     * @param collection 表名列表
     * @param preciseShardingValue sql参数
     * @return 表名
     * select * from user where id in (100,200)
     */
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        String logicTableName = preciseShardingValue.getLogicTableName();
        // 实现 user_$->{cid%2+1}
        BigInteger shardingValue = BigInteger.valueOf(preciseShardingValue.getValue());
        BigInteger res = shardingValue.mod(new BigInteger("2")).add(new BigInteger("1"));
        String key = logicTableName + "_" + res;
        if (collection.contains(key))
            return key;
        throw new UnsupportedOperationException("router" + key + "is not supported, please check your config");
    }
}
