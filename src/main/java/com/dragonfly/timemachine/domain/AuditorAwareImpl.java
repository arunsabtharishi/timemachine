package com.dragonfly.timemachine.domain;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareImpl implements AuditorAware<String>{

	@Override
    public String getCurrentAuditor() {
        //return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		return "arun";
    }
}
