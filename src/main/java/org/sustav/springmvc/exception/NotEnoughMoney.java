package org.sustav.springmvc.exception;

/**
 * @author Anton Sustavov
 * @since 2020/02/27
 */
public class NotEnoughMoney extends Exception {
    public NotEnoughMoney(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughMoney(String message) {
        super(message);
    }
}
