package com.linkstec.mybatis.controller;

import com.linkstec.mybatis.service.impl.MyHystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by sh on 2017/4/25.
 */
@RestController
@RequestMapping("/mot/hystrix")
public class HystrixController {

    @RequestMapping("/future")
    public String getFuture() throws InterruptedException {
        Future<String> productSyncCall = new MyHystrixCommand
                ("http://www.baidu.com").queue();
        try {
            String product = productSyncCall.get();
            System.out.println("sync get product" + product);
            Future<String> orderSyncCall = new MyHystrixCommand("http://google.co.id/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8").queue();
            Future<String> cartSyncCall = new MyHystrixCommand("http://www.baidu.com").queue();
            System.out.println("sync get order" + orderSyncCall.get());
            System.out.println("sync get cart" + cartSyncCall.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return "123";
    }
}
