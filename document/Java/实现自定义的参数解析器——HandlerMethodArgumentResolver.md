**1.为什么需要自己实现参数解析器**

我们都知道在有注解的接口方法中加上@RequestBody等注解，springMVC会自动的将消息体等地方的里面参数解析映射到请求的方法参数中。

如果我们想要的信息不完全是来自消息体等地方，比如说一部分是消息体，一部分是消息头，甚至一部分从配置中获取。这个时候我们又希望在方法入参进来就将这些信息组装好。或者说是需要从消息头里面去进行token解析认证的时候。

**2. HandlerMethodArgumentResolver接口**

实现HandlerMethodArgumentResolver来扩展自己的参数解析器。该接口有两个方法supportsParameter和resolveArgument我们需要重写这两个方法。

![img](https://img2018.cnblogs.com/i-beta/1216484/201911/1216484-20191130223903358-1083946672.png)

 

 

 

supportsParameter是条件，只有这个方法返回true的时候。才会在调用resolveArgument方法进行参数解析。

Spring源码中对这两个方法的调用：

![img](https://img2018.cnblogs.com/i-beta/1216484/201911/1216484-20191130224058584-254153768.png)

 

 

 

**3.实现自己的参数解析器：**

 ```java
（1）自定义注解，被注解标记的类，我们才对它使用解析器。（我现在只要找大象这个动物）

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Documented
public @interface UserId {
}
 ```

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```java
package com.nijunyang.springboot.argsresolver;

import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: create by nijunyang
 * @date:2019/11/30
 */
public class DefArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        //方法参数是User 则使用此解析器
        //可以类型，也可以注解 
        //return methodParameter.hasParameterAnnotation(UserId.class);
        return User.class.isAssignableFrom(methodParameter.getParameterType());
    }

    @Nullable
    @Override
    public Object resolveArgument(
            MethodParameter methodParameter,
            @Nullable ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest,
            @Nullable WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest servletRequest = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String info = (String) nativeWebRequest.getAttribute("params", NativeWebRequest.SCOPE_REQUEST);
        //获取消息头认证信息，没有后续操作了，根据业务实际来解析校验该token
        String token = servletRequest.getHeader("Authorization");
        //自己塞数据进去，也可以从配置文件获取数据
        return new User("zhangsan",18);


    }
}
```

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

 

**4.将自己的解析器加入到容器的解析器集合中**

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```java
package com.nijunyang.springboot.argsresolver;

import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author: create by nijunyang
 * @date:2019/11/30
 */
@Component
//一定要将自己的扩展类加到容器中
public class DefWebMvcConfigurer implements WebMvcConfigurer {

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new DefArgumentResolver());
    }
}
```

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

当然也可以用注解的形式注入到DefWebMvcConfigurer 中在添加到集合中，同时还可以在DefArgumentResolver 中获取配置的信息。

**5.Test**

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```java
package com.nijunyang.springboot.argsresolver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: create by nijunyang
 * @date:2019/11/30
 */
@RestController
public class Controller {

    @GetMapping("/test")
    public String test(User user){
        return user.toString();
    }
}
```

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

**6.效果：**

![img](https://img2018.cnblogs.com/i-beta/1216484/201911/1216484-20191130224849215-697273957.png)

 

直接可以获取到我们自定返回的对象。