package com.github.mono83.query;

import java.util.Objects;
import java.util.Optional;

public interface Schema {
    String getName();

    Optional<String> getAlias();

    /**
     * General schema implementation.
     */
    class Impl implements Schema {
        private final String name;
        private final String alias;

        /**
         * Main constructor.
         *
         * @param name  Schema table name
         * @param alias Schema alias
         */
        public Impl(final String name, final String alias) {
            this.name = name;
            this.alias = alias;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public Optional<String> getAlias() {
            return Optional.ofNullable(alias);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Schema)) return false;
            Schema impl = (Schema) o;
            return Objects.equals(getName(), impl.getName()) &&
                    Objects.equals(getAlias(), impl.getAlias());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getAlias());
        }
    }
}
