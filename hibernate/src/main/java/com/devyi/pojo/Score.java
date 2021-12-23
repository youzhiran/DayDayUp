package com.devyi.pojo;

import java.io.Serializable;

public class Score implements Serializable {
    private Integer id;
    private String name;
    private String kecheng;
    private Integer fenshu;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKecheng() {
        return kecheng;
    }

    public void setKecheng(String kecheng) {
        this.kecheng = kecheng;
    }

    public Integer getFenshu() {
        return fenshu;
    }

    public void setFenshu(Integer fenshu) {
        this.fenshu = fenshu;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kecheng='" + kecheng + '\'' +
                ", fenshu=" + fenshu +
                '}';
    }
}
