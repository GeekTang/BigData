package tools.thrift_echo;

import org.apache.thrift.transport.TServerSocket;  
import org.apache.thrift.transport.TServerTransport;  
import org.apache.thrift.server.TServer;  
import org.apache.thrift.server.TServer.Args;  
import org.apache.thrift.server.TSimpleServer;  
  
public class MyServer {  
  
 public static void StartsimpleServer(EchoService.Processor<EchoServiceServer> processor) {  
  try {  
   TServerTransport serverTransport = new TServerSocket(9090);  
   TServer server = new TSimpleServer(  
     new Args(serverTransport).processor(processor));  
  
   // Use this for a multithreaded server  
   // TServer server = new TThreadPoolServer(new  
   // TThreadPoolServer.Args(serverTransport).processor(processor));  
  
   System.out.println("Starting the simple server...");  
   server.serve();  
  } catch (Exception e) {  
   e.printStackTrace();  
  }  
 }  
   
 public static void main(String[] args) {  
  StartsimpleServer(new EchoService.Processor<EchoServiceServer>(new EchoServiceServer()));  
 }  
  
}