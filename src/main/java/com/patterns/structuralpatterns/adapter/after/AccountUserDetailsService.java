package com.patterns.structuralpatterns.adapter.after;

import com.patterns.structuralpatterns.adapter.after.security.UserDetailsService;
import com.patterns.structuralpatterns.adapter.after.security.UserDetails;

public class AccountUserDetailsService implements UserDetailsService {
	
	AccountService accountService;
	
	public AccountUserDetailsService(AccountService accountService) {
		this.accountService = accountService;
	}



	@Override
	public UserDetails loadUser(String username) {
		Account account = accountService.findAccountByUsername(username);
		
		return new AccountUserDetails(account);
	}

}
