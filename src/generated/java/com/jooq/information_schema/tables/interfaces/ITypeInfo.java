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
public interface ITypeInfo extends Serializable {

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.TYPE_NAME</code>.
     */
    public void setTypeName(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.TYPE_NAME</code>.
     */
    public String getTypeName();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.DATA_TYPE</code>.
     */
    public void setDataType(Integer value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.DATA_TYPE</code>.
     */
    public Integer getDataType();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.PRECISION</code>.
     */
    public void setPrecision(Integer value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.PRECISION</code>.
     */
    public Integer getPrecision();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.PREFIX</code>.
     */
    public void setPrefix(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.PREFIX</code>.
     */
    public String getPrefix();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.SUFFIX</code>.
     */
    public void setSuffix(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.SUFFIX</code>.
     */
    public String getSuffix();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.PARAMS</code>.
     */
    public void setParams(String value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.PARAMS</code>.
     */
    public String getParams();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.AUTO_INCREMENT</code>.
     */
    public void setAutoIncrement(Boolean value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.AUTO_INCREMENT</code>.
     */
    public Boolean getAutoIncrement();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.MINIMUM_SCALE</code>.
     */
    public void setMinimumScale(Short value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.MINIMUM_SCALE</code>.
     */
    public Short getMinimumScale();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.MAXIMUM_SCALE</code>.
     */
    public void setMaximumScale(Short value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.MAXIMUM_SCALE</code>.
     */
    public Short getMaximumScale();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.RADIX</code>.
     */
    public void setRadix(Integer value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.RADIX</code>.
     */
    public Integer getRadix();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.POS</code>.
     */
    public void setPos(Integer value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.POS</code>.
     */
    public Integer getPos();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.CASE_SENSITIVE</code>.
     */
    public void setCaseSensitive(Boolean value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.CASE_SENSITIVE</code>.
     */
    public Boolean getCaseSensitive();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.NULLABLE</code>.
     */
    public void setNullable(Short value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.NULLABLE</code>.
     */
    public Short getNullable();

    /**
     * Setter for <code>INFORMATION_SCHEMA.TYPE_INFO.SEARCHABLE</code>.
     */
    public void setSearchable(Short value);

    /**
     * Getter for <code>INFORMATION_SCHEMA.TYPE_INFO.SEARCHABLE</code>.
     */
    public Short getSearchable();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface ITypeInfo
     */
    public void from(com.jooq.information_schema.tables.interfaces.ITypeInfo from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface ITypeInfo
     */
    public <E extends com.jooq.information_schema.tables.interfaces.ITypeInfo> E into(E into);
}
