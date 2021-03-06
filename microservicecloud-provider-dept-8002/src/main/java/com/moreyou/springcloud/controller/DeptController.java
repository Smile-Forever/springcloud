package com.moreyou.springcloud.controller;

import com.moreyou.springcloud.entities.Dept;
import com.moreyou.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;


    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }
    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        return deptService.get(id);
    }
    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return deptService.list();
    }

    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = client.getServices();
        List<ServiceInstance> instances = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId() + "\t"
                    + element.getHost() + "\t"
                    + element.getPort() + "\t"
            + element.getUri());

        }
        return this.client;
    }
}
