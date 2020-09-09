package org.westos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lwj
 * @date 2020/9/7 21:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boy implements Serializable {
    private static final long serialVersionUID = 1589521560109475017L;
    private Integer bid;
    private String bname;
    private Girl girl;
}
