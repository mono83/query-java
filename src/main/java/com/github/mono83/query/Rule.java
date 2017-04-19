package com.github.mono83.query;

public interface Rule {
    Operator getOperator();

    Object getLeft();

    Object getRight();
}
