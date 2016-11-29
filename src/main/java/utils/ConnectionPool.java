package utils;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by vic on 28.11.16.
 */
public class ConnectionPool {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "123";

    private static volatile ConnectionPool instance = null;
    private PoolProperties poolProperties;
    private DataSource datasource;

    private ConnectionPool() {
        poolProperties = new PoolProperties();
        poolProperties.setUrl(DB_URL);
        poolProperties.setDriverClassName("org.postgresql.Driver");
        poolProperties.setUsername(DB_USER);
        poolProperties.setPassword(DB_PASSWORD);
        poolProperties.setJmxEnabled(true);
        poolProperties.setTestWhileIdle(false);
        poolProperties.setTestOnBorrow(true);
        poolProperties.setValidationQuery("SELECT 1");
        poolProperties.setTestOnReturn(false);
        poolProperties.setValidationInterval(30000);
        poolProperties.setTimeBetweenEvictionRunsMillis(30000);
        poolProperties.setMaxActive(100);
        poolProperties.setInitialSize(10);
        poolProperties.setMaxWait(10000);
        poolProperties.setRemoveAbandonedTimeout(60);
        poolProperties.setMinEvictableIdleTimeMillis(30000);
        poolProperties.setMinIdle(10);
        poolProperties.setLogAbandoned(true);
        poolProperties.setRemoveAbandoned(true);
        poolProperties.setJdbcInterceptors(
                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
                        "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");

        datasource = new DataSource();
        datasource.setPoolProperties(poolProperties);
    }

    public static ConnectionPool getInstance() {
        if(instance == null) {
            synchronized(ConnectionPool.class) {
                if(instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            return datasource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}