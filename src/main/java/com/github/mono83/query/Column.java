package com.github.mono83.query;

import java.util.Objects;
import java.util.Optional;

public interface Column {
    String getName();

    Optional<String> getSchema();

    Optional<String> getAlias();

    /**
     * General implementation of Column interface
     */
    class Impl implements Column {
        private final String schema;
        private final String name;
        private final String alias;

        /**
         * Main constructor
         *
         * @param schema Table name
         * @param name   Column name
         * @param alias  Alias
         */
        public Impl(final String schema, final String name, final String alias) {
            if (name == null) {
                throw new NullPointerException("name");
            }
            this.schema = schema;
            this.name = name;
            this.alias = alias;
        }

        /**
         * Short constructor with name only.
         *
         * @param name Column name
         */
        public Impl(final String name) {
            this(null, name, null);
        }

        @Override
        public Optional<String> getSchema() {
            return Optional.ofNullable(schema);
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
            if (!(o instanceof Column)) return false;
            Column impl = (Column) o;
            return Objects.equals(getSchema(), impl.getSchema()) &&
                    Objects.equals(getName(), impl.getName()) &&
                    Objects.equals(getAlias(), impl.getAlias());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getSchema(), getName(), getAlias());
        }
    }
}
