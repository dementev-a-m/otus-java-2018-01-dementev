package ru.otus.homework9.executor;

import ru.otus.homework9.logger.LoggerController;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.sql.Connection;

/**
 * Created by Антон Дементьев on 23.04.2018.
 */
public class ExecutorFactory{
    private ExecutorFactory(){}
    private static LoggerController loggerController = new LoggerController();
    static {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        try {
            platformMBeanServer.registerMBean(loggerController, new ObjectName("logger", "name", "controller"));
        } catch (InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException | MalformedObjectNameException e) {
            e.printStackTrace();
        }
    }
    public static Executor createExecutor(){
        if (loggerController.isEnabled()){
            return new LoggerExecutor();
        }
        else{
            return new ExecutorImpl();
        }

    }
}
