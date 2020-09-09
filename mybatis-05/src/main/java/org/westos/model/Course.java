package org.westos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;

/**
 * @author lwj
 * @date 2020/9/9 12:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable {
    private static final long serialVersionUID = -7418471653366978677L;
    private Integer cid;
    private String cname;
    private List<Student> students;
}
