package tr.com.getir.book.api.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import tr.com.getir.book.util.RequestContext;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

@Component
@Slf4j
public class BookFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        try {
            Long transactionId = Math.abs(UUID.randomUUID().getMostSignificantBits());
            RequestContext.setTransactionId(transactionId);
            RequestContext.setUserMachine(request.getRemoteAddr());
            MDC.put("transactionId", String.valueOf(transactionId));
            chain.doFilter(request, response);
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            RequestContext.removeTransactionId();
            System.out.println(response);
        }
    }

    @Override
    public void destroy() {
    }
}
