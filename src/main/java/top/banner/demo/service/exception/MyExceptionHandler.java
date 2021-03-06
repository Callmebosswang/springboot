package top.banner.demo.service.exception;

import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;
import java.util.Locale;
import java.util.NoSuchElementException;

/**
 * @author: XGL
 */
@RestControllerAdvice
public class MyExceptionHandler {
    @Resource
    private ApplicationContext applicationContext;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public Result handleBaseException(ValidationException e) {
        String desc = applicationContext.getMessage(e.getCode(), e.getArgs(), e.getMsg(), Locale.getDefault());
        if (StringUtils.isEmpty(desc)) {
            desc = e.getCode();
        }
        return new Result(HttpStatus.BAD_REQUEST.value()+"", desc);
    }

    //    IllegalArgumentException
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public Result handleBaseException(IllegalArgumentException e) {
        String code = e.getMessage();
        String message = e.getMessage();
        if (StringUtils.isEmpty(message)) {
            message = "请求参数错误";
        }
        String desc = applicationContext.getMessage(message, null, null, Locale.getDefault());
        if (desc != null) {
            code = message;
            message = desc;
        }
        return new Result(HttpStatus.BAD_REQUEST.value()+"", message);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoSuchElementException.class)
    public Result xx(NoSuchElementException e) {
        return new Result(HttpStatus.BAD_REQUEST.value()+"", "对象不存在");
    }
}
