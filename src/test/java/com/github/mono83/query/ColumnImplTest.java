package com.github.mono83.query;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColumnImplTest {
    @Test
    public void testNullSchemaAndAliasAllowed() {
        Column column = new Column.Impl(null, "foo", null);

        assertFalse(column.getSchema().isPresent());
        assertFalse(column.getAlias().isPresent());
        assertEquals("foo", column.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testNullNameForbidden() {
        new Column.Impl("foo", null, "foo");
    }

    @Test
    public void testFullData() {
        Column column = new Column.Impl("main", "username", "u");

        assertTrue(column.getSchema().isPresent());
        assertTrue(column.getAlias().isPresent());
        assertEquals("main", column.getSchema().get());
        assertEquals("username", column.getName());
        assertEquals("u", column.getAlias().get());
    }

    @Test
    public void testEqAndHashCode() {
        Column c1 = new Column.Impl("foo");
        Column c2 = new Column.Impl("foo");
        Column c3 = new Column.Impl("bar");

        assertEquals(c1, c2);
        assertEquals(c2, c1);
        assertNotEquals(c1, c3);
        assertNotEquals(c2, c3);
        assertEquals(c1.hashCode(), c2.hashCode());
        assertNotEquals(c1.hashCode(), c3.hashCode());
    }
}