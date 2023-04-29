package com.videostore.infraestructure.configuration;



import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class CustomHeaderFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException,
            ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        res.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
//        res.setHeader("Content-Security-Policy", "default-src 'self'; img-src 'self'; script-src 'self'; style-src 'self' 'unsafe-inline';");
//        res.setHeader("X-Content-Type-Options", "nosniff");
//        res.setHeader("X-Frame-Options", "SAMEORIGIN");
//        res.setHeader("X-XSS-Protection", "1; mode=block");
//        res.setHeader("Referrer-Policy", "strict-origin-when-cross-origin");
//        res.setHeader("Permissions-Policy", "geolocation=(self); microphone=(); camera=()");
//        res.setHeader("Content-Disposition", "attachment; filename=example.txt"); // Úsalo solo cuando envíes archivos para descargar
//        res.setHeader("Expect-CT", "max-age=86400, enforce, report-uri=\"https://example.com/report-uri\"");
//        res.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, private");
//        res.setHeader("X-Download-Options", "noopen");
//        res.setHeader("X-DNS-Prefetch-Control", "off");
//        res.setHeader("X-Permitted-Cross-Domain-Policies", "none");
//        res.setHeader("X-Robots-Tag", "noindex, nofollow");
        String customHeader = req.getHeader("X-Auth-VideoStore-Header");

        if (customHeader != null && customHeader.equals("yes")) {
            filterChain.doFilter(request, res);
        } else {
            res.sendError(HttpServletResponse.SC_FORBIDDEN, "Unauthorized access");
        }
    }
}


