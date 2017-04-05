package com.apps.code.mobile.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.apps.code.mobile.rest.ClaimService;
import com.apps.code.mobile.rest.MessageRestService;
import com.apps.code.mobile.rest.ReclamacaoService;
import com.apps.code.mobile.rest.SubjectService;

public class MessageApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public MessageApplication() {
		singletons.add(new MessageRestService());
		singletons.add(new ReclamacaoService());
		singletons.add(new SubjectService());
		singletons.add(new ClaimService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}