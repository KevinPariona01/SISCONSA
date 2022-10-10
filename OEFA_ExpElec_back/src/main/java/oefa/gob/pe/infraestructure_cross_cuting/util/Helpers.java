package oefa.gob.pe.infraestructure_cross_cuting.util;

import lombok.experimental.UtilityClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@UtilityClass
public class Helpers {

	public boolean isBlank(String string) {
		return string == null || string.isEmpty();
	}

	public String getAlfrescoFolderName() {
		// DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		Date date = new Date();

		return dateFormat.format(date);
	}

	@SuppressWarnings("UseOfObsoleteDateTimeApi")
	public Date localDateToDate(LocalDate localDate) {
		if (localDate == null) {
			return null;
		} else {
			return java.sql.Date.valueOf(localDate);
		}
	}

}