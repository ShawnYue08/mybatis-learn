package org.westos.model;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    private Integer uid;

    private String uname;

    private String upassword;

    private String uNickname;

    private static final long serialVersionUID = 1L;
}