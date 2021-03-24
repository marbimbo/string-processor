package org.misio.model;

public class StringIntegerPair implements PairResponse {

    private String s;

    private Integer value;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "StringIntegerPair{" +
                "s='" + s + '\'' +
                ", value=" + value +
                '}';
    }
}
