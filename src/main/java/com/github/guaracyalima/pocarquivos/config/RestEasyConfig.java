package com.github.guaracyalima.pocarquivos.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.github.guaracyalima.pocarquivos.resources.DocumentResource;

@ApplicationPath("/api")
public class RestEasyConfig extends Application{

	private Set<Object> singletons = new HashSet<Object>();

	public RestEasyConfig() {
        singletons.add(new DocumentResource());
    }

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
