package org.westos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lwj
 * @date 2020/9/7 21:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Girl implements Serializable {
    private static final long serialVersionUID = 1611265720249960439L;
    private Integer gid;
    private String gname;
    private Integer bbid;
    private Boy boy;
}
