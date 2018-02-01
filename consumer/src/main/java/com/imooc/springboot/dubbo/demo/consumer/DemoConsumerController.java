package com.imooc.springboot.dubbo.demo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.imooc.springboot.dubbo.demo.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoConsumerController {

    @Reference
    private DemoService demoService;

    /***
     * 先启动 provider  再启动consumer然后访问地址可以看效果
     */
    // TODO: 2018/2/1 http://localhost:8080/sayHello?name=111
    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String name) {
        System.out.println("api收到参数：" + name);
        return demoService.sayHello(name);
    }

}