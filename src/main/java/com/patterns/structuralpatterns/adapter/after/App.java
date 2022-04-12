package com.patterns.structuralpatterns.adapter.after;

import com.patterns.structuralpatterns.adapter.after.security.LoginHandler;
import com.patterns.structuralpatterns.adapter.after.security.UserDetailsService;

public class App {
	
	public static void main(String[] args) {
		AccountService accountService = new AccountService();
		UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
		LoginHandler loginHandler = new LoginHandler(userDetailsService);
		String login = loginHandler.login("hyeonse", "hyeonse");
		System.out.println(login);
	}
}
