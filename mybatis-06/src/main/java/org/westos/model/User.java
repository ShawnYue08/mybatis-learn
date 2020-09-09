package org.westos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lwj
 * @date 2020/9/9 13:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -5970028623059313270L;
    private Integer uid;
    private String uname;
    private String upassword;
    private String unickname;
}
