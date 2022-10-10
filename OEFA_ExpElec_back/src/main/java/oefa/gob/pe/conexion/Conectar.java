package oefa.gob.pe.conexion;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.p6spy.engine.spy.P6DataSource;
import lombok.extern.log4j.Log4j2;
import oefa.gob.pe.infraestructure_cross_cuting.config_properties.DatabaseSiia;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Log4j2
@Component
public class Conectar {

	private final String url;

	private final String usuario;

	private final String password;

	public Conectar(final DatabaseSiia database) {
		url = database.getUrl();
		usuario = database.getUser();
		password = database.getPass();
	}

	public DataSource getDataSource() {
		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setURL(url);
		ds.setUser(usuario);
		ds.setPassword(password);
		ds.setApplicationName("ima-backend");
		return new P6DataSource(ds);
	}
}
