package com.patterns.structuralpatterns.adapter.before.security;

public interface UserDetailsService {

	UserDetails loadUser(String username);
}
