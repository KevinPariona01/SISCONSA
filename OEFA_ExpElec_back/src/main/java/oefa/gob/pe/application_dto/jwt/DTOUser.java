package oefa.gob.pe.application_dto.jwt;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PUBLIC)
public class DTOUser {
	String jti;
	String sub;
	String[] authorities;
	long iat;
	long exp;
}
