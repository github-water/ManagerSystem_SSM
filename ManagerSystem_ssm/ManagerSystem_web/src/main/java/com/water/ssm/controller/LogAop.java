package com.water.ssm.controller;


import com.water.ssm.domain.SysLog;
import com.water.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime;//开始访问时间
    private Class clazz;    //访问的类
    private Method method;  //访问的方法


    //前置通知
    //获取开始时间；执行的类；执行方法
    @Before("execution(* com.water.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();
        clazz = jp.getTarget().getClass();//具体访问的类
        String methodName = jp.getSignature().getName();//获取方法名称
        Object[] args = jp.getArgs();
        if(args == null || args.length == 0){
            method = clazz.getMethod(methodName);//只能获取无参方法
        }else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName,classArgs);
        }

    }

    //后置通知
    @After("execution(* com.water.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        long time = new Date().getTime() - visitTime.getTime();

        String url = null;
        //获取url
        //先判断访问类和方法不为空
        if(clazz!=null&&method!=null&&clazz!= LogAop.class){
            //1.获取Controller的类注解值
            //1.1获取RequestMapping对象
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            //1.2获取RequestMapping的value
            if(classAnnotation!=null){
                String[] classValue = classAnnotation.value();

                //2.获取方法上的注解值
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if(methodAnnotation!=null){
                    String[] methodValue = methodAnnotation.value();

                    url = classValue[0]+methodValue[0];

                    //获取IP对象
                    String ip = request.getRemoteAddr();

                    //获取操作用户
                    SecurityContext context = SecurityContextHolder.getContext();//从上下文中获取当前对象
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();


                    //将日志信息封装到SysLog对象中
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名]"+clazz.getName()+"[方法名]"+method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);

                    //调用Service完成数据库添加
                    sysLogService.save(sysLog);


                }
            }

        }



    }
}
