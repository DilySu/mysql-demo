package com.study.mysql;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.study.mysql.entity.Dict;
import com.study.mysql.entity.User;
import com.study.mysql.mapper.DictMapper;
import com.study.mysql.mapper.UserMapper;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MysqlApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DictMapper dictMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void addUser() {
        for (int i = 10; i > 0; i--) {
            User user = new User();
//            user.setId(i);
            user.setName("nb");
            user.setStatus(String.valueOf(i % 2));
            user.setCid((long) (1000 + i));
            userMapper.insert(user);
        }

    }

    @Test
    void getUser() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .in("id", 779280410994544640L, 779280411472695297L)
                .eq("cid", 1002L)
                .orderByDesc("cid");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    void getUserByRange() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("id", 779033260545019904L, 779033261287411713L);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    void getUserByComplex() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("id", 779280410994544640L, 779280411472695297L);
        wrapper.eq("cid", 779280411237814272L);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    void getUserByHint() {

        // 查某个分片的所有数据
        // select * from m2.user_2
        HintManager manager = HintManager.getInstance();
        manager.addTableShardingValue("user", 2L);
        manager.addTableShardingValue("user", 1L);

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("count(cid) as sum");
        wrapper.groupBy("cid");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
        manager.close();
    }

    @Test
    void addDict() {
        Dict yes = new Dict();
        yes.setStatus("1");
        yes.setValue("正常");
        dictMapper.insert(yes);

        Dict no = new Dict();
        no.setStatus("0");
        no.setValue("不正常");
        dictMapper.insert(no);

        addUser();
    }

    @Test
    void getUserStatus(){
        userMapper.getUserStatus().forEach(System.out::println);
    }

    @Test
    void masterSlaveDict(){  // 主库写
        for (int i = 10; i > 0; i--) {
            Dict dict = new Dict();
            dict.setStatus(String.valueOf(i%2));
            dict.setValue("标准");
            dictMapper.insert(dict);
        }
    }

    @Test
    void getMasterSlaveDict(){  // 从库读
        dictMapper.selectList(null).forEach(System.out::println);
    }


    @Test
    void updateMasterSlaveDict(){
        Dict dict = new Dict();
        dict.setStatus("2");
        dict.setValue("你猜正不正常");

        UpdateWrapper<Dict> dictQueryWrapper = new UpdateWrapper<>();
        dictQueryWrapper.eq("id","005c5da5a2764dbcaa0f8077deeb91c1");
        dictMapper.update(dict,dictQueryWrapper);
    }
}
