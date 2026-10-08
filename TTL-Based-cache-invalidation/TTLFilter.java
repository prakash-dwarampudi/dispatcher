package com.usa.cities.core.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.engine.EngineConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.osgi.service.component.propertytypes.ServiceRanking;
import org.osgi.service.component.propertytypes.ServiceVendor;

@Component(service = Filter.class,
property = {
        EngineConstants.SLING_FILTER_SCOPE + "=" + EngineConstants.FILTER_SCOPE_REQUEST,
})
@ServiceDescription("Filter to set Cache control")
@ServiceRanking(-700)
@ServiceVendor("Adobe")
public class TTLFilter implements Filter{
	
	 private static final long TTL_IN_SECONDS = 180;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		SlingHttpServletResponse slingResponse = (SlingHttpServletResponse) response;
		 // Set the Cache-Control header for browsers and standard CDNs
        slingResponse.setHeader("Cache-Control", "public, max-age=" + TTL_IN_SECONDS);
        
		chain.doFilter(request, slingResponse);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
