package com.jooq.setup;

import com.ibatis.common.jdbc.ScriptRunner;

import java.io.*;
import java.sql.SQLException;

/**
 * Generate schema from file.
 */
public class SchemaGenerator {

    public static void main(String[] args) {
        // Path of sql file.
        String sqlPath = "C:/Users/brainold.b.barbero/IdeaProjects/jooq/src/main/resources/schema.sql";
        // Set connection.
        ScriptRunner scriptRunner = new ScriptRunner(
                "org.h2.Driver", "jdbc:h2:~/test", "test", "test",
                true, true);
        // Read file.
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader(sqlPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Run script.
        try {
            scriptRunner.runScript(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
