package com.kruger.reto.inventario_vacuna.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.kruger.reto.inventario_vacuna.domain")
@EnableJpaRepositories("com.kruger.reto.inventario_vacuna.repos")
@EnableTransactionManagement
public class DomainConfig {
}
