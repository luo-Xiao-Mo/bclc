package com.tool.monitor.exception;


import com.tool.monitor.core.result.Result;
import com.tool.monitor.core.result.ResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.PrintWriter;
import java.io.StringWriter;


@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

//    private static final String DEFAULT_VALIDATED_MSG_SEPARATOR = ";";

//    @Value(value = "${validated.msg.separator}")
//    private String validatedMsgSeparator;

    /**
     * HttpMessageNotReadableException处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(value = HttpStatus.OK)
    public Result handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String msg = "参数解析异常";
        logger.error(msg, e.getMessage());
        StringBuilder sb = new StringBuilder(msg);
        return ResultBuilder.genFailResult(sb.toString());
    }

//    /**
//     * 数据校验ConstraintViolationException处理
//     *
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseStatus(value = HttpStatus.OK)
//    public Result handleConstraintViolationException(ConstraintViolationException e) {
//        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//        List<String> msgs = new ArrayList<String>();
//        if (violations != null && !violations.isEmpty()) {
//            for (ConstraintViolation<?> violation : violations) {
//                msgs.add(violation.getMessage());
//            }
//        }
//        Collections.reverse(msgs);
//        String msg = StringUtils.join(msgs,
//                StringUtils.isNotBlank(validatedMsgSeparator) ? validatedMsgSeparator : DEFAULT_VALIDATED_MSG_SEPARATOR);
//        logger.info("ConstraintViolationException : {}", msg);
//        return ResultBuilder.genFailResult(msg);
//    }

    /**
     * ServiceException处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = ServiceException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Result handleServiceException(ServiceException e) {
        String msg = e.getMessage();
        logger.info("ServiceException : {}", msg);
        if (StringUtils.isEmpty(msg)) {
            msg = "服务器出错，请联系管理员";
        }
        return ResultBuilder.genFailResult(msg);
    }


    /**
     * 其他异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Result handleException(Exception e) {
        // 记录错误信息
        logger.error(new ExceptionHelper().getStrace(e));
        String msg = "服务器出错，请联系管理员";
        StringBuilder sb = new StringBuilder(msg).append("，错误信息：").append(e.getMessage());
        return ResultBuilder.genServerErrorResult(sb.toString());
    }

    private class ExceptionHelper {

        private String getStrace(Throwable t) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter writer = new PrintWriter(stringWriter);
            t.printStackTrace(writer);
            StringBuffer buffer = stringWriter.getBuffer();
            return buffer.toString();
        }
    }
}