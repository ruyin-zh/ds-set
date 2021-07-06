package org.code.ruyin.ds.hash.collision;

/**
 * @author hjxz
 * @date 2021/7/7
 * @title 测试类
 * @description
 */
public class Employee {

    private String name;
    private double salary;
    private int seniority;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        return o instanceof Employee && name.equals(((Employee) o).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
