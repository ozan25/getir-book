package tr.com.getir.book.commondomain;


import org.springframework.data.domain.AuditorAware;
import tr.com.getir.book.util.RequestContext;

import java.util.Optional;

public class Auditor implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(RequestContext.getUserMachine());
    }
}