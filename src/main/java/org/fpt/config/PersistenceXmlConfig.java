package org.fpt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "org.fpt.persistence.dao", "org.fpt.persistence.service" })
public class PersistenceXmlConfig {

    public PersistenceXmlConfig() {
        super();
    }

}