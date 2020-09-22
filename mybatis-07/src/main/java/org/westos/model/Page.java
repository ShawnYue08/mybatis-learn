package org.westos.model;

import java.io.Serializable;
import lombok.Data;

/**
 * page
 * @author 
 */
@Data
public class Page implements Serializable {
    private Integer pid;

    private String pname;

    private Integer pcount;

    private Double pprice;

    private static final long serialVersionUID = 1L;
}