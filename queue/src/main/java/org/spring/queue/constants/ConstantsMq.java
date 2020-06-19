package org.spring.queue.constants;

public final class ConstantsMq {

    public static final String EMPTY = "";
    public static final String XDLE = "x-dead-letter-exchange";
    public static final String XDLRK = "x-dead-letter-routing-key";

    // OMS Topic
    public static final String EXCHANGE = "spring-boot-exchange";

    // Routes where payment is a producer
    public static final String ROUTING_KEY = "spring-boot-queue";
    public static final String ROUTING_KEY_DEAD = ROUTING_KEY + "-dead";

}
