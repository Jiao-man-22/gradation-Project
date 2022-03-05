package chatonlineserver.configs;

import com.jiao.chatonlineserver.domain.UserInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
* 定义一个LoginAOP切面类，必须先登录才能使用用户操作功能

切面类需要明白的：什么时候给什么方法增加什么功能

切面 （Aspect） 理解为一个增强的功能

切入点 （Pointcut） 理解为需要增强功能的目标方法的一组集合

通知 （Advice） 理解为切面的执行时间

环绕增强方法实际是拦截了目标方法的执行，在执行目标方法之前，必须执行环绕方法
* */
@Aspect
@Component
public class LoginAop {
   /* @Value("${token.header}")
    String token;
    private static Logger logger = LoggerFactory.getLogger(LoginAop.class);

    //执行用户功能先进入登录切入点
    @Pointcut("execution(* com.jiao.chatonlineserver.controller.*(..))")
    public void loginPoint() {
    }

    @Around("loginPoint()")
    public Object doBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.debug("登录环绕通知");
        //1.拿到request请求
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //2.获取session
        HttpSession session = request.getSession();
        //3.获取userInfo信息
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        //4.判断是否登录
        if (userInfo == null){
            //如果 requestedWith 为 XMLHttpRequest 则为 Ajax 请求
            String requestType = request.getHeader("X-Requested-With");
            if ("XMLHttpRequest".equals(requestType)){
                logger.debug("ajax请求");
                //返回ajax数据
                String loginResult = "{\"loginResult\":\"false\"}";
                return loginResult;
            }else {
                logger.debug("非ajax请求");
                return "redirect:/login";
            }
        }else {
            //已登录 可执行目标方法
            Object proceed = joinPoint.proceed();
            return proceed;
        }
    }


*/


}

