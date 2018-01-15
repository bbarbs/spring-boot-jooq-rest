/*
 * This file is generated by jOOQ.
*/
package com.jooq.information_schema.tables.pojos;


import com.jooq.information_schema.tables.interfaces.ISessions;

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
public class Sessions implements ISessions {

    private static final long serialVersionUID = 1805629492;

    private Integer id;
    private String  userName;
    private String  sessionStart;
    private String  statement;
    private String  statementStart;
    private String  containsUncommitted;

    public Sessions() {}

    public Sessions(Sessions value) {
        this.id = value.id;
        this.userName = value.userName;
        this.sessionStart = value.sessionStart;
        this.statement = value.statement;
        this.statementStart = value.statementStart;
        this.containsUncommitted = value.containsUncommitted;
    }

    public Sessions(
        Integer id,
        String  userName,
        String  sessionStart,
        String  statement,
        String  statementStart,
        String  containsUncommitted
    ) {
        this.id = id;
        this.userName = userName;
        this.sessionStart = sessionStart;
        this.statement = statement;
        this.statementStart = statementStart;
        this.containsUncommitted = containsUncommitted;
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
    public String getUserName() {
        return this.userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getSessionStart() {
        return this.sessionStart;
    }

    @Override
    public void setSessionStart(String sessionStart) {
        this.sessionStart = sessionStart;
    }

    @Override
    public String getStatement() {
        return this.statement;
    }

    @Override
    public void setStatement(String statement) {
        this.statement = statement;
    }

    @Override
    public String getStatementStart() {
        return this.statementStart;
    }

    @Override
    public void setStatementStart(String statementStart) {
        this.statementStart = statementStart;
    }

    @Override
    public String getContainsUncommitted() {
        return this.containsUncommitted;
    }

    @Override
    public void setContainsUncommitted(String containsUncommitted) {
        this.containsUncommitted = containsUncommitted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Sessions (");

        sb.append(id);
        sb.append(", ").append(userName);
        sb.append(", ").append(sessionStart);
        sb.append(", ").append(statement);
        sb.append(", ").append(statementStart);
        sb.append(", ").append(containsUncommitted);

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
    public void from(ISessions from) {
        setId(from.getId());
        setUserName(from.getUserName());
        setSessionStart(from.getSessionStart());
        setStatement(from.getStatement());
        setStatementStart(from.getStatementStart());
        setContainsUncommitted(from.getContainsUncommitted());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends ISessions> E into(E into) {
        into.from(this);
        return into;
    }
}
