package com.example.springtutorial.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.springtutorial.entity.User;

public class UserDetailsImpl implements UserDetails {
	private final User user;
	private final Collection<GrantedAuthority> authorities;
	
	//コンストラクタ
	public UserDetailsImpl(User user,Collection<GrantedAuthority> authorities) {
		this.user = user;
		System.out.println("userImpl:" + user);
		this.authorities = authorities;
	}
	
		//ハッシュ化済みのパスワードを返す
	@Override
	public String getPassword() {
		System.out.println("Password:" + user.getPassword());
		return user.getPassword();
	}
	
	//ログイン時に利用するユーザー名を返す
		@Override
	public String getUsername() {
			System.out.println("userName:" + user.getUserName());
		return user.getUserName();
		
		
	}

	//ロールのコレクションを返す
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
				return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

}
