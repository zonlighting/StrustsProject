package com.ssv.actions;

import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport {
	private String a = "acc";

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	@Override
	public String execute() throws Exception {
			
		return super.execute();
	}

}
