package org.misio.model;

import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StringIntegerPair {

    @Id
    private String s;

    private Integer value;

    public StringIntegerPair() {
    }

    private StringIntegerPair(String s, Integer value) {
        Assert.notNull(s, "s must not be null!");
        Assert.notNull(value, "value must not be null!");
        this.s = s;
        this.value = value;
    }

    public static StringIntegerPair of(String s, Integer value) {
        return new StringIntegerPair(s, value);
    }

    public void setS(String s) {
        this.s = s;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getS() {
        return s;
    }

    public Integer getValue() {
        return value;
    }
}
