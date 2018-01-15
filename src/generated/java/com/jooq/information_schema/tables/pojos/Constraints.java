/*
 * This file is generated by jOOQ.
*/
package com.jooq.information_schema.tables.pojos;


import com.jooq.information_schema.tables.interfaces.IConstraints;

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
public class Constraints implements IConstraints {

    private static final long serialVersionUID = 1842836162;

    private String  constraintCatalog;
    private String  constraintSchema;
    private String  constraintName;
    private String  constraintType;
    private String  tableCatalog;
    private String  tableSchema;
    private String  tableName;
    private String  uniqueIndexName;
    private String  checkExpression;
    private String  columnList;
    private String  remarks;
    private String  sql;
    private Integer id;

    public Constraints() {}

    public Constraints(Constraints value) {
        this.constraintCatalog = value.constraintCatalog;
        this.constraintSchema = value.constraintSchema;
        this.constraintName = value.constraintName;
        this.constraintType = value.constraintType;
        this.tableCatalog = value.tableCatalog;
        this.tableSchema = value.tableSchema;
        this.tableName = value.tableName;
        this.uniqueIndexName = value.uniqueIndexName;
        this.checkExpression = value.checkExpression;
        this.columnList = value.columnList;
        this.remarks = value.remarks;
        this.sql = value.sql;
        this.id = value.id;
    }

    public Constraints(
        String  constraintCatalog,
        String  constraintSchema,
        String  constraintName,
        String  constraintType,
        String  tableCatalog,
        String  tableSchema,
        String  tableName,
        String  uniqueIndexName,
        String  checkExpression,
        String  columnList,
        String  remarks,
        String  sql,
        Integer id
    ) {
        this.constraintCatalog = constraintCatalog;
        this.constraintSchema = constraintSchema;
        this.constraintName = constraintName;
        this.constraintType = constraintType;
        this.tableCatalog = tableCatalog;
        this.tableSchema = tableSchema;
        this.tableName = tableName;
        this.uniqueIndexName = uniqueIndexName;
        this.checkExpression = checkExpression;
        this.columnList = columnList;
        this.remarks = remarks;
        this.sql = sql;
        this.id = id;
    }

    @Override
    public String getConstraintCatalog() {
        return this.constraintCatalog;
    }

    @Override
    public void setConstraintCatalog(String constraintCatalog) {
        this.constraintCatalog = constraintCatalog;
    }

    @Override
    public String getConstraintSchema() {
        return this.constraintSchema;
    }

    @Override
    public void setConstraintSchema(String constraintSchema) {
        this.constraintSchema = constraintSchema;
    }

    @Override
    public String getConstraintName() {
        return this.constraintName;
    }

    @Override
    public void setConstraintName(String constraintName) {
        this.constraintName = constraintName;
    }

    @Override
    public String getConstraintType() {
        return this.constraintType;
    }

    @Override
    public void setConstraintType(String constraintType) {
        this.constraintType = constraintType;
    }

    @Override
    public String getTableCatalog() {
        return this.tableCatalog;
    }

    @Override
    public void setTableCatalog(String tableCatalog) {
        this.tableCatalog = tableCatalog;
    }

    @Override
    public String getTableSchema() {
        return this.tableSchema;
    }

    @Override
    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    @Override
    public String getTableName() {
        return this.tableName;
    }

    @Override
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String getUniqueIndexName() {
        return this.uniqueIndexName;
    }

    @Override
    public void setUniqueIndexName(String uniqueIndexName) {
        this.uniqueIndexName = uniqueIndexName;
    }

    @Override
    public String getCheckExpression() {
        return this.checkExpression;
    }

    @Override
    public void setCheckExpression(String checkExpression) {
        this.checkExpression = checkExpression;
    }

    @Override
    public String getColumnList() {
        return this.columnList;
    }

    @Override
    public void setColumnList(String columnList) {
        this.columnList = columnList;
    }

    @Override
    public String getRemarks() {
        return this.remarks;
    }

    @Override
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String getSql() {
        return this.sql;
    }

    @Override
    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Constraints (");

        sb.append(constraintCatalog);
        sb.append(", ").append(constraintSchema);
        sb.append(", ").append(constraintName);
        sb.append(", ").append(constraintType);
        sb.append(", ").append(tableCatalog);
        sb.append(", ").append(tableSchema);
        sb.append(", ").append(tableName);
        sb.append(", ").append(uniqueIndexName);
        sb.append(", ").append(checkExpression);
        sb.append(", ").append(columnList);
        sb.append(", ").append(remarks);
        sb.append(", ").append(sql);
        sb.append(", ").append(id);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public void from(IConstraints from) {
        setConstraintCatalog(from.getConstraintCatalog());
        setConstraintSchema(from.getConstraintSchema());
        setConstraintName(from.getConstraintName());
        setConstraintType(from.getConstraintType());
        setTableCatalog(from.getTableCatalog());
        setTableSchema(from.getTableSchema());
        setTableName(from.getTableName());
        setUniqueIndexName(from.getUniqueIndexName());
        setCheckExpression(from.getCheckExpression());
        setColumnList(from.getColumnList());
        setRemarks(from.getRemarks());
        setSql(from.getSql());
        setId(from.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends IConstraints> E into(E into) {
        into.from(this);
        return into;
    }
}
