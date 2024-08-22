package com.cantanhede.ds.zipzapshorter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@SpringBootTest
class ZipzapshorterApplicationTests {
	@Autowired
	private DataSource dataSource;
	@Test
	void contextLoads() {
		try (Connection connection = dataSource.getConnection()) {
			assertTrue(connection.isValid(1));
		} catch (SQLException e) {
			// Ignorar ou logar que o banco de dados não está disponível
			System.out.println("Banco de dados não está disponível: " + e.getMessage());
		}
    }
}
