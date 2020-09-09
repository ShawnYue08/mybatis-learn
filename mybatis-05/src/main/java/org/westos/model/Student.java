package org.westos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;

/**
 * @author lwj
 * @date 2020/9/9 12:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private Integer sid;
    private String sname;
    private String sgender;
    private List<Course> courses;
}
