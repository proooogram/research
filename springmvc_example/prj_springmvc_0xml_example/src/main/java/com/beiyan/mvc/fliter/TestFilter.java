package com.beiyan.mvc.fliter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("test Filter 初始化");

	}

	public void destroy() {
		System.out.println("test Filter 销毁");

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		int port = request.getLocalPort();
		System.out.println("TestFilter 记录的请求端口号是：" + port);
		chain.doFilter(request, response);

	}

	public boolean equals(Object obj) {

		return true;
	}

}
