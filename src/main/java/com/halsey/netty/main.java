package com.halsey.netty;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.AbstractExecutorService;


/**
 * Created by zhangyaohai on 2017/6/22.
 */
public class main {
    static final Logger logger = LoggerFactory.getLogger(main.class);

    public static void main(String[] args) {
//        LocalDate date1 = LocalDate.parse("2018-1-21");
//        LocalDate date2 = LocalDate.parse("2018-5-1");
//
//
//        int days =  Days.daysBetween(date1, date2).getDays();
//
//        System.out.println(days);
//       double d =  Math.floor(3.5);
//        System.out.println(d);
        logger.info("run");
        logger.debug("debug");
        logger.debug("eworuwo");

        logger.trace("Hello World!");
        logger.debug("How are you today?");
        logger.info("I am fine.");
        logger.warn("I love programming.");
        logger.error("I am programming.");
    }

    @Test
    public void st(){
        logger.info("run");
        logger.debug("debug");
        logger.debug("eworuwo");

        logger.trace("Hello World!");
        logger.debug("How are you today?");
        logger.info("I am fine.");
        logger.warn("I love programming.");
        logger.error("I am programming.");
    }
}
