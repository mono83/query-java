package com.github.mono83.query;

public enum Operator {
    // Equality
    EQ, NOT_EQ,

    // NULLs
    IS_NULL, NOT_IS_NULL;

    /**
     * Returns inverted operator.
     *
     * @param operator Operator to invert
     * @return Inverted operator
     */
    Operator not(final Operator operator) {
        if (operator == null) {
            throw new NullPointerException("operator");
        }

        switch (operator) {
            case EQ:
                return NOT_EQ;
            case NOT_EQ:
                return EQ;
            case IS_NULL:
                return NOT_IS_NULL;
            case NOT_IS_NULL:
                return IS_NULL;
            default:
                throw new IllegalArgumentException("Operator " + operator + " does not support inversion");
        }
    }
}
