/*
 * This file is generated by jOOQ.
*/
package com.jooq.my_schema.tables.records;


import com.jooq.my_schema.tables.Items;
import com.jooq.my_schema.tables.interfaces.IItems;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


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
public class ItemsRecord extends UpdatableRecordImpl<ItemsRecord> implements Record4<Integer, String, String, String>, IItems {

    private static final long serialVersionUID = -1207960120;

    /**
     * Setter for <code>MY_SCHEMA.ITEMS.ID</code>.
     */
    @Override
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>MY_SCHEMA.ITEMS.ID</code>.
     */
    @Override
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>MY_SCHEMA.ITEMS.CODE</code>.
     */
    @Override
    public void setCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>MY_SCHEMA.ITEMS.CODE</code>.
     */
    @Override
    public String getCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>MY_SCHEMA.ITEMS.ITEM_NAME</code>.
     */
    @Override
    public void setItemName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>MY_SCHEMA.ITEMS.ITEM_NAME</code>.
     */
    @Override
    public String getItemName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>MY_SCHEMA.ITEMS.DESCRIPTION</code>.
     */
    @Override
    public void setDescription(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>MY_SCHEMA.ITEMS.DESCRIPTION</code>.
     */
    @Override
    public String getDescription() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Items.ITEMS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Items.ITEMS.CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Items.ITEMS.ITEM_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Items.ITEMS.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getItemName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getItemName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemsRecord value2(String value) {
        setCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemsRecord value3(String value) {
        setItemName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemsRecord value4(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemsRecord values(Integer value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public void from(IItems from) {
        setId(from.getId());
        setCode(from.getCode());
        setItemName(from.getItemName());
        setDescription(from.getDescription());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends IItems> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ItemsRecord
     */
    public ItemsRecord() {
        super(Items.ITEMS);
    }

    /**
     * Create a detached, initialised ItemsRecord
     */
    public ItemsRecord(Integer id, String code, String itemName, String description) {
        super(Items.ITEMS);

        set(0, id);
        set(1, code);
        set(2, itemName);
        set(3, description);
    }
}
