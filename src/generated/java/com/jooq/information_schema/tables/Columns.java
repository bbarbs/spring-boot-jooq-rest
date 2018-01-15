/*
 * This file is generated by jOOQ.
*/
package com.jooq.information_schema.tables;


import com.jooq.information_schema.InformationSchema;
import com.jooq.information_schema.tables.records.ColumnsRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Columns extends TableImpl<ColumnsRecord> {

    private static final long serialVersionUID = 2121781693;

    /**
     * The reference instance of <code>INFORMATION_SCHEMA.COLUMNS</code>
     */
    public static final Columns COLUMNS = new Columns();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ColumnsRecord> getRecordType() {
        return ColumnsRecord.class;
    }

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.TABLE_CATALOG</code>.
     */
    public final TableField<ColumnsRecord, String> TABLE_CATALOG = createField("TABLE_CATALOG", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.TABLE_SCHEMA</code>.
     */
    public final TableField<ColumnsRecord, String> TABLE_SCHEMA = createField("TABLE_SCHEMA", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.TABLE_NAME</code>.
     */
    public final TableField<ColumnsRecord, String> TABLE_NAME = createField("TABLE_NAME", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.COLUMN_NAME</code>.
     */
    public final TableField<ColumnsRecord, String> COLUMN_NAME = createField("COLUMN_NAME", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.ORDINAL_POSITION</code>.
     */
    public final TableField<ColumnsRecord, Integer> ORDINAL_POSITION = createField("ORDINAL_POSITION", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.COLUMN_DEFAULT</code>.
     */
    public final TableField<ColumnsRecord, String> COLUMN_DEFAULT = createField("COLUMN_DEFAULT", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.IS_NULLABLE</code>.
     */
    public final TableField<ColumnsRecord, String> IS_NULLABLE = createField("IS_NULLABLE", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.DATA_TYPE</code>.
     */
    public final TableField<ColumnsRecord, Integer> DATA_TYPE = createField("DATA_TYPE", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.CHARACTER_MAXIMUM_LENGTH</code>.
     */
    public final TableField<ColumnsRecord, Integer> CHARACTER_MAXIMUM_LENGTH = createField("CHARACTER_MAXIMUM_LENGTH", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.CHARACTER_OCTET_LENGTH</code>.
     */
    public final TableField<ColumnsRecord, Integer> CHARACTER_OCTET_LENGTH = createField("CHARACTER_OCTET_LENGTH", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.NUMERIC_PRECISION</code>.
     */
    public final TableField<ColumnsRecord, Integer> NUMERIC_PRECISION = createField("NUMERIC_PRECISION", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.NUMERIC_PRECISION_RADIX</code>.
     */
    public final TableField<ColumnsRecord, Integer> NUMERIC_PRECISION_RADIX = createField("NUMERIC_PRECISION_RADIX", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.NUMERIC_SCALE</code>.
     */
    public final TableField<ColumnsRecord, Integer> NUMERIC_SCALE = createField("NUMERIC_SCALE", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.CHARACTER_SET_NAME</code>.
     */
    public final TableField<ColumnsRecord, String> CHARACTER_SET_NAME = createField("CHARACTER_SET_NAME", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.COLLATION_NAME</code>.
     */
    public final TableField<ColumnsRecord, String> COLLATION_NAME = createField("COLLATION_NAME", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.TYPE_NAME</code>.
     */
    public final TableField<ColumnsRecord, String> TYPE_NAME = createField("TYPE_NAME", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.NULLABLE</code>.
     */
    public final TableField<ColumnsRecord, Integer> NULLABLE = createField("NULLABLE", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.IS_COMPUTED</code>.
     */
    public final TableField<ColumnsRecord, Boolean> IS_COMPUTED = createField("IS_COMPUTED", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.SELECTIVITY</code>.
     */
    public final TableField<ColumnsRecord, Integer> SELECTIVITY = createField("SELECTIVITY", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.CHECK_CONSTRAINT</code>.
     */
    public final TableField<ColumnsRecord, String> CHECK_CONSTRAINT = createField("CHECK_CONSTRAINT", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.SEQUENCE_NAME</code>.
     */
    public final TableField<ColumnsRecord, String> SEQUENCE_NAME = createField("SEQUENCE_NAME", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.REMARKS</code>.
     */
    public final TableField<ColumnsRecord, String> REMARKS = createField("REMARKS", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.COLUMNS.SOURCE_DATA_TYPE</code>.
     */
    public final TableField<ColumnsRecord, Short> SOURCE_DATA_TYPE = createField("SOURCE_DATA_TYPE", org.jooq.impl.SQLDataType.SMALLINT, this, "");

    /**
     * Create a <code>INFORMATION_SCHEMA.COLUMNS</code> table reference
     */
    public Columns() {
        this(DSL.name("COLUMNS"), null);
    }

    /**
     * Create an aliased <code>INFORMATION_SCHEMA.COLUMNS</code> table reference
     */
    public Columns(String alias) {
        this(DSL.name(alias), COLUMNS);
    }

    /**
     * Create an aliased <code>INFORMATION_SCHEMA.COLUMNS</code> table reference
     */
    public Columns(Name alias) {
        this(alias, COLUMNS);
    }

    private Columns(Name alias, Table<ColumnsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Columns(Name alias, Table<ColumnsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return InformationSchema.INFORMATION_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Columns as(String alias) {
        return new Columns(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Columns as(Name alias) {
        return new Columns(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Columns rename(String name) {
        return new Columns(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Columns rename(Name name) {
        return new Columns(name, null);
    }
}
