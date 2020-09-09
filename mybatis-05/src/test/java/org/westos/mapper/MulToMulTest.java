package org.westos.mapper;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.westos.model.Course;
import org.westos.model.Student;
import org.westos.util.SqlSessionFactoryUtil;

import java.io.IOException;
import java.util.List;

/**
 * @author lwj
 * @date 2020/9/9 12:22
 */
public class MulToMulTest {
    @Test
    public void testStudentMapper() {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            /*Student student = mapper.selectBySid(1);
            System.out.println(JSON.toJSONString(student, true));*/
            List<Student> students = mapper.selectAll();
            System.out.println(JSON.toJSONString(students, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCourseMapper() {
        try (SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession()) {
            CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
            /*Course course = mapper.selectByCid(1);
            System.out.println(JSON.toJSONString(course, true));*/
            List<Course> courses = mapper.selectAll();
            System.out.println(JSON.toJSONString(courses, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
