package tr.com.getir.book.util;

import java.util.Locale;

public class RequestContext {
    private static final ThreadLocal<String> usernameTl = new ThreadLocal<>();
    private static final ThreadLocal<Long> transactionIdTl = new ThreadLocal<>();

    private RequestContext() {
    }

    public static String getUsername() {
        return usernameTl.get();
    }

    public static void setUsername(String username) {
        usernameTl.set(username);
    }

    public static void removeUsername() {
        usernameTl.remove();
    }

    public static Long getTransactionId() {
        return transactionIdTl.get();
    }

    public static void setTransactionId(Long transactionId) {
        transactionIdTl.set(transactionId);
    }

    public static void removeTransactionId() {
        transactionIdTl.remove();
    }


}
