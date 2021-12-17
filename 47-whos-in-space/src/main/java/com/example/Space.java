package com.example;

import java.util.List;

public record Space(String message, Integer number, List<Person> people) {
}
