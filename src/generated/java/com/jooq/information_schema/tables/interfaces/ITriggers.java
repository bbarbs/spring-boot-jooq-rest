/*
 * This file is generated by jOOQ.
*/
package com.jooq.information_schema.tables.interfaces;


import java.io.Serializable;

import javax.annotation.Generated;


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
public interface ITriggers extends Serializable {

    /**
     * Setter for <code>INFORMATION_SCHEMA.TRIGGERS.TRIGGER_CATALOG</code>.
     */
    public void setTriggerCatalog(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TRIGGERS.TRIGGER_CATALOG</code>.
     */
    public String getTriggerCatalog();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TRIGGERS.TRIGGER_SCHEMA</code>.
     */
    public void setTriggerSchema(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TRIGGERS.TRIGGER_SCHEMA</code>.
     */
    public String getTriggerSchema();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TRIGGERS.TRIGGER_NAME</code>.
     */
    public void setTriggerName(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TRIGGERS.TRIGGER_NAME</code>.
     */
    public String getTriggerName();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TRIGGERS.TRIGGER_TYPE</code>.
     */
    public void setTriggerType(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TRIGGERS.TRIGGER_TYPE</code>.
     */
    public String getTriggerType();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TRIGGERS.TABLE_CATALOG</code>.
     */
    public void setTableCatalog(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TRIGGERS.TABLE_CATALOG</code>.
     */
    public String getTableCatalog();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TRIGGERS.TABLE_SCHEMA</code>.
     */
    public void setTableSchema(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TRIGGERS.TABLE_SCHEMA</code>.
     */
    public String getTableSchema();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TRIGGERS.TABLE_NAME</code>.
     */
    public void setTableName(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TRIGGERS.TABLE_NAME</code>.
     */
    public String getTableName();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TRIGGERS.BEFORE</code>.
     */
    public void setBefore(Boolean value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TRIGGERS.BEFORE</code>.
     */
    public Boolean getBefore();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TRIGGERS.JAVA_CLASS</code>.
     */
    public void setJavaClass(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TRIGGERS.JAVA_CLASS</code>.
     */
    public String getJavaClass();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TRIGGERS.QUEUE_SIZE</code>.
     */
    public void setQueueSize(Integer value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TRIGGERS.QUEUE_SIZE</code>.
     */
    public Integer getQueueSize();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TRIGGERS.NO_WAIT</code>.
     */
    public void setNoWait(Boolean value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TRIGGERS.NO_WAIT</code>.
     */
    public Boolean getNoWait();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TRIGGERS.REMARKS</code>.
     */
    public void setRemarks(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TRIGGERS.REMARKS</code>.
     */
    public String getRemarks();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TRIGGERS.SQL</code>.
     */
    public void setSql(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TRIGGERS.SQL</code>.
     */
    public String getSql();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TRIGGERS.ID</code>.
     */
    public void setId(Integer value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TRIGGERS.ID</code>.
     */
    public Integer getId();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface ITriggers
     */
    public void from(com.jooq.information_schema.tables.interfaces.ITriggers from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface ITriggers
     */
    public <E extends com.jooq.information_schema.tables.interfaces.ITriggers> E into(E into);
}
