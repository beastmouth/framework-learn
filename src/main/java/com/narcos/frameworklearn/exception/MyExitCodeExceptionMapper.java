package com.narcos.frameworklearn.exception;

import org.springframework.boot.ExitCodeExceptionMapper;
import org.springframework.boot.web.server.PortInUseException;
import org.springframework.stereotype.Component;

/**
 * @author hbj
 * @date 2020/4/16 2:52 下午
 */
@Component
public class MyExitCodeExceptionMapper implements ExitCodeExceptionMapper {
    @Override
    public int getExitCode(Throwable exception) {
        if (exception instanceof PortInUseException) {
            // 需要返回大于0的整数，才会发布事件
            return 10;
        }
        return 0;
    }
}
