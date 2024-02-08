package com.vince.cicafacebook.configuration.jwt;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.List;

public class CustomJwtConverter implements Converter<Jwt, CustomJwt> {
    @Override
    public CustomJwt convert(Jwt source) {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        var customJwt = new CustomJwt(source, grantedAuthorityList);
        customJwt.setFirstName(source.getClaimAsString("given_name"));
        customJwt.setLastName(source.getClaimAsString("family_name"));
        customJwt.setAuthName(source.getClaimAsString("sub"));
        return customJwt;
    }
}
