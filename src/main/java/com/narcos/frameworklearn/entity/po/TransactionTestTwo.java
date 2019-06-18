package com.narcos.frameworklearn.entity.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/06/18 15:03
 **/
@Getter
@Setter
@ToString
@Entity
@Table(name = "transaction_test_two")
public class TransactionTestTwo {
    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true, columnDefinition = "int(8) COMMENT 'ID'")
    private Integer id;
    @Column(nullable = false,unique = true,columnDefinition = "varchar(10) COMMENT 'name'")
    private String name;
}
