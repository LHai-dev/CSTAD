package co.jdbc;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class Jdbcimpl {
    public DataSource dataSource(){
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUser("postgres");
        dataSource.setPassword("Hai172212");
        dataSource.setDatabaseName("elearning");
        return dataSource;
    }
}
