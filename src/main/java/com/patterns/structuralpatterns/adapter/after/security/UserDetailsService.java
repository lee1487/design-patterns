package com.patterns.structuralpatterns.adapter.after.security;

public interface UserDetailsService {

	UserDetails loadUser(String username);
}
