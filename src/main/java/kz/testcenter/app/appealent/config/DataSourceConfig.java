package kz.testcenter.app.appealent.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://192.168.200.19:5432/online_test_appeal");
        dataSourceBuilder.username("m.sadykov");
        dataSourceBuilder.password("Sadykov-2023");
        return dataSourceBuilder.build();
    }
}