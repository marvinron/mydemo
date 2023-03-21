package com.maviron.spring.springdemo.propertychange;

import org.springframework.stereotype.Service;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName PropertyChangeSupportMaterialTag.java
 * @Description 当某个属性发生变化的时候触发
 * @createTime 2023年03月20日 11:09:00
 */
public class PropertyChangeSupportMaterialTag {
    transient   protected PropertyChangeSupport listeners  =   new PropertyChangeSupport( this );

    public   void  addPropertyChangeListener(PropertyChangeListener listener) {
        listeners.addPropertyChangeListener(listener);
    }

    protected   void  firePropertyChange(String prop, Object old, Object newValue) {
        listeners.firePropertyChange(prop, old, newValue);
    }

    public   void  removePropertyChangeListener(PropertyChangeListener l) {
        listeners.removePropertyChangeListener(l);
    }

}
