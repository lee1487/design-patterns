package com.patterns.structuralpatterns.adapter.after;

import com.patterns.structuralpatterns.adapter.after.security.UserDetails;

public class AccountUserDetails implements UserDetails{
	
	private Account account;

	public AccountUserDetails(Account account) {
		this.account = account;
	}

	@Override
	public String getUsername() {
		return account.getName();
	}

	@Override
	public String getPassword() {
		return account.getPassword();
	}

}
