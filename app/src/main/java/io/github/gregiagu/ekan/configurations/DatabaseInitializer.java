package io.github.gregiagu.ekan.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseInitializer {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Bean
    CommandLineRunner loadDatabase() {
        return runner -> {
            jdbcTemplate.execute("DROP TABLE IF EXISTS beneficiarios");
            jdbcTemplate.execute("CREATE TABLE beneficiarios (id INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(50), telefone VARCHAR(50), data_nascimento DATE, data_inclusao DATE, data_atualizacao DATE)");
            jdbcTemplate.execute("INSERT INTO beneficiarios (nome, telefone, data_nascimento, data_inclusao, data_atualizacao) VALUES "
                    + "('Zé Pamonha', '+5511966580021', '1971-10-05', '1999-02-06', '2021-06-06'),"
                    + "('Roberval Pereira', '+5511964002232', '1982-01-19', '2015-05-09', '2020-08-13'),"
                    + "('Kleitu Robertson', '+5561977411235', '1988-11-12', '2016-06-09', '2019-04-11'),"
                    + "('Astrozilda Molecular', '+5582933657720', '1991-12-12', '2014-04-19', '2019-04-21')"
            );
        };
    }
}
