package pl.dms.dms.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User{
    private final User user;

    public CurrentUser(String name, String password, Collection<? extends GrantedAuthority> authorities,
                       User user) {
        super(name,password,authorities);
        this.user = user;
    }
    public User getUser(){
        return user;
    }
}
