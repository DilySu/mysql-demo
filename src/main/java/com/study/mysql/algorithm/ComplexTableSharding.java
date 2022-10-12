package com.study.mysql.algorithm;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Date: 2022-09-20 星期二
 * Time: 17:10
 * Author: Dily_Su
 * Remark: 按多个字段进行分表，简化查询
 */
public class ComplexTableSharding implements ComplexKeysShardingAlgorithm<Long> {

    /**
     * @param collection               表名列表
     * @param complexKeysShardingValue sql参数
     * @return 表名列表
     * select * from user where id between xxx and xxx and cid = 1003 in (100,200)
     */
    @Override
    public Collection<String> doSharding(Collection<String> collection, ComplexKeysShardingValue<Long> complexKeysShardingValue) {
        String logicTableName = complexKeysShardingValue.getLogicTableName();
        Collection<String> res = new ArrayList<>();

        // id between xxx and xxx
        Range<Long> idRange = complexKeysShardingValue.getColumnNameAndRangeValuesMap().get("id");
        // cid in (100,200)
        Collection<Long> cidC = complexKeysShardingValue.getColumnNameAndShardingValuesMap().get("cid");
        if (cidC != null)  // in 查询时进行表选择
            cidC.forEach(e -> {
                BigInteger cid = BigInteger.valueOf(e);
                BigInteger target = cid.mod(new BigInteger("2")).add(new BigInteger("1"));
                res.add(logicTableName + "_" + target);
            });
        else {
            res.addAll(collection.stream().filter(e -> e.startsWith(logicTableName)).collect(Collectors.toList()));
        }
        return res;

    }
}
