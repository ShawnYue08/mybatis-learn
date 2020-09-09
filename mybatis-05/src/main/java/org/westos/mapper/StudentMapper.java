package org.westos.mapper;

import org.westos.model.Student;
import java.util.*;
/**
 * @author lwj
 * @date 2020/9/9 12:06
 */
public interface StudentMapper {
    Student selectBySid(Integer sid);

    List<Student> selectAll();
}
