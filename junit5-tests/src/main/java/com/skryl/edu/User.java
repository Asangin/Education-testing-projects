package com.skryl.edu;

import java.util.Objects;

/**
 * @author Skryl D.V. on 2022-05-27
 */
public class User {
    public enum State {
        ENABLE, DISABLE
    }

    private String name;
    private Integer age;

    private State state;

    public State getState() {
        return state;
    }

    public User setState(State state) {
        this.state = state;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }
}
