# Talk to a server via TCP sockets, using a binary protocol
from thrift.transport.TSocket import *
from thrift.protocol.TBinaryProtocol import *
from pylib.echo import *
transport = TSocket("localhost", 9090)
transport.open()
protocol = TBinaryProtocol(transport)

# Use the service we already defined
service = EchoService.Client(protocol)
returnValue = service.echo("Hello World!")
print returnValue
