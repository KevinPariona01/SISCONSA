package oefa.gob.pe.application_services.seguridad;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;

class XsAuthority implements GrantedAuthority {

    @Serial
    private static final long serialVersionUID = -5141424009539961017L;
    private String authority;

    public XsAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
