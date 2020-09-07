package org.westos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.io.Serializable;

/**
 * @author lwj
 * @date 2020/9/7 14:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = 6623184271851977540L;
    private Integer aid;
    private String aname;
    private String apassword;
    private String anickname;
    private List<Books> books;
}
