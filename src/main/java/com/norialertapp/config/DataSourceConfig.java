//package com.norialertapp.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
///**
// * Created by andrewdmo on 4/28/17.
// */
//@Configuration
//public class DataSourceConfig {
//
//    @Bean(name = "dataSource")
//    public DriverManagerDataSource createDataSource() {
//
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
////        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
////        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/platafina");
//
//        return driverManagerDataSource;
//    }
//
////    DataSource dataSource = DataSourceBuilder.create()
////        .driverClassName("com.mysql.jdbc.Driver")
////        .url("jdbc:mysql://localhost:3306/gsrestdb").username("***").password("***").build();
////
////    clients.jdbc(dataSource);
//}