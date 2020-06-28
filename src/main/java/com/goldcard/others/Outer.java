package com.goldcard.others;
public class Outer {
    private String name;
    private int age;

    public static class Builder {
        private String name;
        private int age;
        
        public int getAge() {
        	return age;
        }

        public Builder(int age) {
            this.age = age;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Outer build() {
            return new Outer(this);
        }
    }

    private Outer(Builder b) {
        this.age = b.age;
        this.name = b.name;
    }
}