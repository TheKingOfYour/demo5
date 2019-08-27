package com.offcn.demo5.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @JsonIgnoreProperties 如果是代理类，由于无法标记在属性或方法上，
 *  所以，可以标记在类声明上；也作用于反序列化时的字段解析；
 */


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = true, length = 200)
    private String name;

    @Column(name = "age", nullable = true, length = 4)
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
