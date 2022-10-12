package com.study.mysql.algorithm;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Date: 2022-09-20 星期二
 * Time: 17:10
 * Author: Dily_Su
 * Remark: 不依赖分表参数, 自定义操作
 */
public class HintTableSharding implements HintShardingAlgorithm<Long> {

    /**
     * @param collection        表名列表
     * @param hintShardingValue sql参数
     * @return 表名列表
     * select * from user
     */
    @Override
    public Collection<String> doSharding(Collection<String> collection, HintShardingValue<Long> hintShardingValue) {
        String logicTableName = hintShardingValue.getLogicTableName();
        List<String> res = new ArrayList<>();

        hintShardingValue.getValues().forEach(e -> {
            String key = logicTableName + "_" + e;
            if (collection.contains(key))
                res.add(key);
        });
        return res;
    }
}
