package com.github.mono83.query;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public interface Condition {
    enum Type {
        AND, OR
    }

    /**
     * @return Condition type (AND or OR)
     */
    Type getType();

    /**
     * @return Collection of rules inside condition. Can be empty but must not be null.
     */
    Collection<Rule> getRules();

    /**
     * @return Collection of sub-conditions inside condition. Can be empty but must not be null.
     */
    Collection<Condition> getConditions();

    /**
     * General implementation of Condition interface.
     */
    class Impl implements Condition {
        private final Type type;
        private final Collection<Rule> rules;
        private final Collection<Condition> conditions;

        public Impl(final Type type, final Collection<Rule> rules, final Collection<Condition> conditions) {
            if (type == null) {
                throw new NullPointerException("type");
            }
            this.type = type;
            this.rules = rules == null ? Collections.emptyList() : rules;
            this.conditions = conditions == null ? Collections.emptyList() : conditions;
        }

        @Override
        public Type getType() {
            return type;
        }

        @Override
        public Collection<Rule> getRules() {
            return rules;
        }

        @Override
        public Collection<Condition> getConditions() {
            return conditions;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Condition)) return false;
            Condition impl = (Condition) o;
            return getType() == impl.getType() &&
                    Objects.equals(getRules(), impl.getRules()) &&
                    Objects.equals(getConditions(), impl.getConditions());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getType(), getRules(), getConditions());
        }
    }
}
