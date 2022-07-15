package com.maviron.spring.springdemo.function.functionmode;

public class File {
      
    public enum Type { TEXT, AUDIO, VIDEO }
     
    private final Type type;
    private final String content;
     
    public File( Type type, String content ) {
        this.type = type;
        this.content = content;
    }
     
    public Type getType() {
        return type;
    }
     
    public String getContent() {
        return content;
    }
     
    @Override
    public String toString() {
        return type + ": " + content;
    }
}