/*
 * This file is generated by jOOQ.
*/
package com.jooq.my_schema.tables;


import com.jooq.my_schema.MySchema;
import com.jooq.my_schema.tables.records.ItemsOrdersRecord;

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
public class ItemsOrders extends TableImpl<ItemsOrdersRecord> {

    private static final long serialVersionUID = -1554678402;

    /**
     * The reference instance of <code>MY_SCHEMA.ITEMS_ORDERS</code>
     */
    public static final ItemsOrders ITEMS_ORDERS = new ItemsOrders();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ItemsOrdersRecord> getRecordType() {
        return ItemsOrdersRecord.class;
    }

    /**
     * The column <code>MY_SCHEMA.ITEMS_ORDERS.ORDER_ID</code>.
     */
    public final TableField<ItemsOrdersRecord, Integer> ORDER_ID = createField("ORDER_ID", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>MY_SCHEMA.ITEMS_ORDERS.ITEM_ID</code>.
     */
    public final TableField<ItemsOrdersRecord, Integer> ITEM_ID = createField("ITEM_ID", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>MY_SCHEMA.ITEMS_ORDERS</code> table reference
     */
    public ItemsOrders() {
        this(DSL.name("ITEMS_ORDERS"), null);
    }

    /**
     * Create an aliased <code>MY_SCHEMA.ITEMS_ORDERS</code> table reference
     */
    public ItemsOrders(String alias) {
        this(DSL.name(alias), ITEMS_ORDERS);
    }

    /**
     * Create an aliased <code>MY_SCHEMA.ITEMS_ORDERS</code> table reference
     */
    public ItemsOrders(Name alias) {
        this(alias, ITEMS_ORDERS);
    }

    private ItemsOrders(Name alias, Table<ItemsOrdersRecord> aliased) {
        this(alias, aliased, null);
    }

    private ItemsOrders(Name alias, Table<ItemsOrdersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return MySchema.MY_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemsOrders as(String alias) {
        return new ItemsOrders(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemsOrders as(Name alias) {
        return new ItemsOrders(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ItemsOrders rename(String name) {
        return new ItemsOrders(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ItemsOrders rename(Name name) {
        return new ItemsOrders(name, null);
    }
}
