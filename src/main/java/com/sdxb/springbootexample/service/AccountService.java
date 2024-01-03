package com.sdxb.springbootexample.service;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    //private final RestTemplate restTemplate;
    //private final String accountServiceUrl; // 这里应该是您账户管理微服务的URL

   // @Autowired
    //public accountService(RestTemplate restTemplate) {
      //  this.restTemplate = restTemplate;
      //  this.accountServiceUrl = "http://account-service/"; // 这里需要被替换为实际的服务URL
    //}

    public Integer getUserIdForLoggedInUser() {
        // 调用账户管理微服务获取userId，这个例子假设返回的是一个整数类型的用户ID
        // 实际的实现可能需要提供额外的信息，比如用户的认证token
        //return restTemplate.getForObject(accountServiceUrl + "api/userid", Integer.class);
        return 123;
    }
}
