package com.dily.mybatisFlex;

import cn.hutool.core.bean.BeanUtil;
import com.dily.mybatisFlex.entity.Group;
import com.dily.mybatisFlex.entity.Product;
import com.dily.mybatisFlex.entity.Student;
import com.dily.mybatisFlex.entity.User;
import com.dily.mybatisFlex.mapper.GroupMapper;
import com.dily.mybatisFlex.mapper.ProductMapper;
import com.dily.mybatisFlex.mapper.StudentMapper;
import com.dily.mybatisFlex.mapper.UserMapper;
import com.mybatisflex.core.datasource.DataSourceKey;
import com.mybatisflex.core.row.Db;
import com.mybatisflex.core.row.Row;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * MoreSourceTest
 * Date: 2023-12-11 星期一
 * Time: 9:31
 * Author: Dily_Su
 * Remark: 多数据源测试
 */
@SpringBootTest
public class MoreSourceTest {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private ProductMapper productMapper;

    /**
     * 使用 @Table(dataSource = "master")
     */
    @Test
    public void get() {
        List<Student> students = studentMapper.selectAll();
        System.out.println(students);
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }

    /**
     * 使用 @UseDataSource("master")
     */
    @Test
    public void get2 (){
        List<Group> groups = groupMapper.selectAll();
        System.out.println(groups);
    }

    /**
     * 使用 DataSourceKey.use("master")
     */
    @Test
    public void get3 (){
        List<Group> groups = groupMapper.selectAll();
        System.out.println(groups);
        try {
            DataSourceKey.use("master");
            List<Row> rows = Db.selectAll("t_Group");
            List<Group> groupList = rows.stream().map(e -> {
                Group group = new Group();
                Map<String, Object> map = e;
                BeanUtil.copyProperties(map, group);
                return group;
            }).toList();
            System.out.println(groupList);
        }finally {
            DataSourceKey.clear();
        }
    }

    @Test
    public void get4 (){
       List<Product> products = productMapper.findAll();
        System.out.println(products);
    }
}
