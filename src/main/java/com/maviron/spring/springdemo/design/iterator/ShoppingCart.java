package com.maviron.spring.springdemo.design.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ShoppingCart.java
 * @Description 迭代对象类
 * @createTime 2023年05月10日 11:14:00
 */
public class ShoppingCart implements Aggregate<String> {

    private List<String> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    @Override
    public Iterator<String> createIterator() {
        return new ShoppingCartIterator(items);
    }

    private class ShoppingCartIterator implements Iterator<String> {

        private int currentIndex = 0;
        private final List<String> items;

        public ShoppingCartIterator(List<String> items) {
            this.items = items;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < items.size();
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more items to iterate");
            }

            return items.get(currentIndex++);
        }
    }
}
