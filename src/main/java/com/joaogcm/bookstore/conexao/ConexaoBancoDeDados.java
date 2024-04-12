package com.joaogcm.bookstore.conexao;

import java.sql.Connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConexaoBancoDeDados {

	private static final String URL = "jdbc:oracle:thin:@//localhost:1521/desenvolvimento";
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String USUARIO = "joaogcm";
	private static final String SENHA = "Joao1997";
	private static HikariDataSource hikariDataSource = null;

	private static void inicializarPoolConexao() {
		if (hikariDataSource == null) {
			HikariConfig hikariConfig = new HikariConfig();
			hikariConfig.setJdbcUrl(URL);
			hikariConfig.setDriverClassName(DRIVER);
			hikariConfig.setUsername(USUARIO);
			hikariConfig.setPassword(SENHA);

			hikariConfig.setMinimumIdle(10);
			hikariConfig.setMaximumPoolSize(40);
			hikariConfig.setIdleTimeout(10000);
			hikariConfig.setAutoCommit(true);

			hikariDataSource = new HikariDataSource(hikariConfig);
		}
	}

	public static Connection abrirConexao() throws Exception {
		inicializarPoolConexao();
		return hikariDataSource.getConnection();
	}
}