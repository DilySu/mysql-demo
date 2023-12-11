package com.dily.mybatisFlex;

import com.dily.mybatisFlex.entity.Student;
import com.dily.mybatisFlex.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ReaderAndWriterTest
 * Date: 2023-12-11 星期一
 * Time: 11:14
 * Author: Dily_Su
 * Remark:
 */
@SpringBootTest
public class ReaderAndWriterTest {

    @Autowired
    private StudentMapper studentMapper;
    @Test
    public void save (){
        Student student = new Student();
        studentMapper.insert(student);
    }
}
