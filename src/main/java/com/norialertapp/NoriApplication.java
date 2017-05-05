package com.norialertapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NoriApplication {


    public static void main(String[] args) {
        SpringApplication.run(NoriApplication.class, args);
    }

//    @Value("${spring.datasource.driverClassName}")
//    private String databaseDriverClassName;
//
//    @Value("${spring.datasource.url}")
//    private String datasourceUrl;
//
//    @Value("${spring.datasource.username}")
//    private String databaseUsername;
//
//    @Value("${spring.datasource.password}")
//    private String databasePassword;
//
//    @Value("@{spring.datasource.firstname")
//    private String databaseFirstname;
//
//    @Value("@{spring.datasource.lastname")
//    private String databaseLastname;
//
//    @Value("@{spring.datasource.role")
//    private String databaseRole;
//
//    @Bean
//    public DataSource datasource() {
//        org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
//        ds.setDriverClassName(databaseDriverClassName);
//        ds.setUrl(datasourceUrl);
//        ds.setUsername(databaseUsername);
//        ds.setPassword(databasePassword);
//
//        return ds;
//    }
}