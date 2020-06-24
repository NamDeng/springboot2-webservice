package com.nwh.springboot.web.dto;

public class HelloResponseDto {
    private final String name;
    private final int age;

    public HelloResponseDto(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
