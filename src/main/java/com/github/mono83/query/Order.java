package com.github.mono83.query;

public interface Order {
    enum Type {
        ASC, DESC
    }

    Type getType();

    Column getColumn();
}
