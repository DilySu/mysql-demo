package com.dily.mybatisFlex;

import com.dily.mybatisFlex.entity.Role;
import com.dily.mybatisFlex.entity.Student;
import com.dily.mybatisFlex.entity.User;
import com.dily.mybatisFlex.mapper.GroupMapper;
import com.dily.mybatisFlex.mapper.RoleMapper;
import com.dily.mybatisFlex.mapper.StudentMapper;
import com.dily.mybatisFlex.mapper.UserMapper;
import com.dily.mybatisFlex.service.StudentService;
import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.util.UpdateEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static com.dily.mybatisFlex.entity.table.RoleTableDef.ROLE;
import static com.dily.mybatisFlex.entity.table.UserTableDef.USER;
import static com.mybatisflex.core.query.QueryMethods.avg;
import static com.mybatisflex.core.query.QueryMethods.max;

/**
 * StudentTest
 * Date: 2023-08-28 星期一
 * Time: 15:25
 * Author: Dily_Su
 * Remark:
 */
@SpringBootTest
public class StudentTest {

    @Autowired
    StudentService studentService;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    GroupMapper groupMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;

    /**
     * 增、删、改
     */
    @Test
    public void saveOrUpdateOrRemove() {
        Student student = new Student();
        student.setName("test");
        // 新增
//        studentService.save(student);
//        System.out.println(student);

        // 删除
//        studentService.removeById(student.getId());
//
        // 修改
        // id 存在则更新，忽略null；id 不存在则新增
//        student.setId(14);
//        student.setAge(14);
//        studentService.saveOrUpdate(student);
        // 根据 id 更新，不忽略 null
//        student.setId(13);
//        studentService.updateById(student,false);
        // 根据 QueryWrapper 更新，忽略 null
//        student.setId(11);
//        student.setAge(11);
//        studentService.update(student,new QueryWrapper().where(Student::getId).eq(student.getId()));
        // 更新 id = 1 的对象，修改 name 和 sex
        Student student1 = UpdateEntity.of(Student.class, 12);
//        student1.setName("id12");
//        student1.setSex("男");
//        student1.setAge(11);
//        studentService.updateById(student1);
        // 更新 id = 1 的对象，修改年龄
//        UpdateWrapper<Student> updateWrapper = UpdateWrapper.of(student1);
//        updateWrapper.setRaw("age","age + 1");
//        studentService.updateById(student1);
    }

    /**
     * 查询
     */
    @Test
    public void get() {
        Student student = new Student();
//        student.setId(13);
        // entity 转 queryWrapper
        QueryWrapper queryWrapper = QueryWrapper.create(new Student());
        // 查询指定字段，并转化为指定类型
//        Integer ids = studentService.getOneAs(queryWrapper.select("id").where(Student::getId).eq(student.getId()),Integer.class);
//        Map map = studentService.getOneAs(queryWrapper.select("id","name").where(Student::getId).eq(student.getId()),Map.class);

//        List list = studentService.list(new QueryWrapper().where(Student::getId).eq(student.getId()));
//        System.out.println(list);

        // 表关联查询
        // 多对一、一对一
//        Student students= studentMapper.selectOneWithRelationsById(14);
        // 一对多
//        Group group = groupMapper.selectOneWithRelationsById(1);
        // 多对多
        List<Role> roles = userMapper.selectOneWithRelationsById(2).getRoles();
        System.out.println(roles.size());
    }


    @Test
    public void method() {
        Map map= QueryChain.of(studentMapper)
                .select(
                        max(Student::getAge).as(Student::getMaxAge),
                        avg(Student::getAge).as(Student::getAvgAge)
                )
//                .where(Student::getId).eq(1)
//                .groupBy(Student::getAge)
                .oneAs(Map.class);

        List<Map> users = QueryChain.of(userMapper)
                .from(User.class)
                .leftJoin(Role.class).on(USER.ID.eq(ROLE.ID))
                .listAs(Map.class);
    }
}


