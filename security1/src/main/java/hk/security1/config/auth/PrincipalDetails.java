package hk.security1.config.auth;

import hk.security1.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

//시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행한다.
//로그인 진행이 완료가 되면 session을 만들어준다. (Security ContextHolder)
//시큐리티가 가지고 세션에 들어갈 수 있는 세션은 정해져있다.
//오브젝트 => Authentication 타입 객체
//Authentication 안에 User 정보가 있어야 됨
//User오브젝트타입 => UserDetails 타입 객체이어야 함
public class PrincipalDetails implements UserDetails {

    private User user; //콤포지션을 넣어준다.

    public PrincipalDetails(User user) {
        this.user = user;
    }

    //해당 User의 건한을 리턴하는 곳
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    //니 계정 너무 오래 사용한거 아니니?
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        //우리 사이트 1년동안 회원이 로그인을 안하면 휴면 계정으로 하기로 함
        //현재시간 - 로그인 시간 => 1녀을 초가하면 return false하면 됨
        return true;
    }
}
