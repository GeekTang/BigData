package tools.thrift_echo;

import java.util.Date;

import org.apache.thrift.TException;

public class EchoServiceServer implements EchoService.Iface {

    public String echo(String welcome) throws TException {
        System.out.println("Greets: " + welcome);
        return (new Date()).toString() + ": " + welcome;
    }

}
