package thrift;

import org.apache.thrift.TException;

import java.util.logging.Logger;

public class GreetingServiceImpl implements GreetingService.Iface {

    private static final Logger logger = Logger.getLogger(GreetingServiceImpl.class.getName());

    public String sayHello(String name) throws TException {
        logger.info(String.format("调用sayHello方法的参数name = {%s}", name));

        return "Hello, " + name;
    }

}