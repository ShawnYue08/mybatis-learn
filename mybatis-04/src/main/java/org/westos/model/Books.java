package org.westos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lwj
 * @date 2020/9/7 14:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books implements Serializable {
    private static final long serialVersionUID = 3301442300858007177L;
    private Integer bookid;
    private String bookname;
    private Float bookprice;
    private Account account;
}
