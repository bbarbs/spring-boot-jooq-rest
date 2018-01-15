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
public interface IRights extends Serializable {

    /**
     * Setter for <code>INFORMATION_SCHEMA.RIGHTS.GRANTEE</code>.
     */
    public void setGrantee(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.RIGHTS.GRANTEE</code>.
     */
    public String getGrantee();

    /**
     * Setter for <code>INFORMATION_SCHEMA.RIGHTS.GRANTEETYPE</code>.
     */
    public void setGranteetype(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.RIGHTS.GRANTEETYPE</code>.
     */
    public String getGranteetype();

    /**
     * Setter for <code>INFORMATION_SCHEMA.RIGHTS.GRANTEDROLE</code>.
     */
    public void setGrantedrole(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.RIGHTS.GRANTEDROLE</code>.
     */
    public String getGrantedrole();

    /**
     * Setter for <code>INFORMATION_SCHEMA.RIGHTS.RIGHTS</code>.
     */
    public void setRights(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.RIGHTS.RIGHTS</code>.
     */
    public String getRights();

    /**
     * Setter for <code>INFORMATION_SCHEMA.RIGHTS.TABLE_SCHEMA</code>.
     */
    public void setTableSchema(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.RIGHTS.TABLE_SCHEMA</code>.
     */
    public String getTableSchema();

    /**
     * Setter for <code>INFORMATION_SCHEMA.RIGHTS.TABLE_NAME</code>.
     */
    public void setTableName(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.RIGHTS.TABLE_NAME</code>.
     */
    public String getTableName();

    /**
     * Setter for <code>INFORMATION_SCHEMA.RIGHTS.ID</code>.
     */
    public void setId(Integer value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.RIGHTS.ID</code>.
     */
    public Integer getId();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IRights
     */
    public void from(com.jooq.information_schema.tables.interfaces.IRights from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IRights
     */
    public <E extends com.jooq.information_schema.tables.interfaces.IRights> E into(E into);
}
