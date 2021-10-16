package tr.com.getir.book.util;

import java.util.Locale;

public class RequestContext {
    private static final ThreadLocal<String> userMachineTl = new ThreadLocal<>();
    private static final ThreadLocal<Long> transactionIdTl = new ThreadLocal<>();

    private RequestContext() {
    }

    public static String getUserMachine() {
        return userMachineTl.get();
    }

    public static void setUserMachine(String userMachine) {
        userMachineTl.set(userMachine);
    }

    public static void removeUserMachine() {
        userMachineTl.remove();
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
