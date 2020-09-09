package org.westos.mapper;

import org.westos.model.Course;
import java.util.*;
/**
 * @author lwj
 * @date 2020/9/9 12:34
 */
public interface CourseMapper {
    Course selectByCid(Integer cid);

    List<Course> selectAll();
}
