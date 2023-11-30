package com.dily.mysql.algorithm;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Date: 2022-09-20 星期二
 * Time: 17:10
 * Author: Dily_Su
 * Remark: 按多个字段进行分库，简化查询
 */
public class ComplexDSSharding implements ComplexKeysShardingAlgorithm<Long> {

    @Override
    public Collection<String> doSharding(Collection<String> collection, ComplexKeysShardingValue<Long> complexKeysShardingValue) {
        Collection<String> res = new ArrayList<>();
        // id between xxx and xxx
        Range<Long> idRange = complexKeysShardingValue.getColumnNameAndRangeValuesMap().get("id");
        // cid in (100,200)
        Collection<Long> cidC = complexKeysShardingValue.getColumnNameAndShardingValuesMap().get("cid");
        if (cidC != null)  // in 查询时进行表选择
            cidC.forEach(e -> {
                BigInteger cid = BigInteger.valueOf(e);
                BigInteger target = cid.mod(new BigInteger("2")).add(new BigInteger("1"));
                res.add("m" + target);
            });
        else {
            res.addAll(collection.stream().filter(e -> e.startsWith("m")).collect(Collectors.toList()));
        }
        return res;
    }
}
