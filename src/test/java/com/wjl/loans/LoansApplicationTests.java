package com.wjl.loans;

import com.wjl.loans.utils.JavaSmsApi;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class LoansApplicationTests {

   @Test
    void contextLoads() {
//       String response = JavaSmsApi.sendSms("17614305969");
//       System.out.println(response);
       String response =  System.getProperty("user.dir") + "/imgs/";
       System.out.println(response);
   }

}
