package com.moon.demo.service.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
 
public class Test6 {
 
    public static void filter(List<String> languages, Predicate<String> condition) {
        languages.stream().filter(condition).forEach(x -> System.out.println(x + " "));
    }
 
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Python", "scala", "Shell", "R");
        System.out.println("Language starts with J: ");
        filter(languages, x -> x.startsWith("J"));
        System.out.println("\nLanguage ends with a: ");
        filter(languages, x -> x.endsWith("a"));
        System.out.println("\nAll languages: ");
        filter(languages, x -> true);
        System.out.println("\nNo languages: ");
        filter(languages, x -> false);
        System.out.println("\nLanguage length bigger three: ");
        filter(languages, x -> x.length() > 4);
    }
 
}