package com.goldcard.rpc.example;
public class RpcConsumer {
      
    public static void main(String[] args) throws Exception {  
        HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);  
        for (int i = 0; i < Integer.MAX_VALUE; i ++) {  
            String hello = service.hello("World" + i);  
            System.out.println(hello);
            int result = service.sum(i, i);
            System.out.println(result);
            Thread.sleep(1000);  
        }  
    }  
      
}  