package com.maviron.spring.springdemo.design.visitor;

interface Element {
    <T> T accept(Visitor<T> visitor);
}