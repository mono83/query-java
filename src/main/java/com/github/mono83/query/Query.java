package com.github.mono83.query;

import java.util.Collection;

public interface Query {
    Schema getSchema();

    Collection<Column> getColumns();

    Collection<Order> getOrder();

    Condition getCondition();

    int getLimit();

    long getOffset();
}
