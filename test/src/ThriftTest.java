//import com.verizon.cloud.service.ThriftServiceDefinition;
//import com.verizon.cloud.service.api.metering.rollup.MeteringRollupService;
//import org.apache.thrift.protocol.TBinaryProtocol;
//import org.apache.thrift.protocol.TProtocol;
//import org.apache.thrift.transport.TSocket;
//import org.apache.thrift.transport.TTransport;
//
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.ServiceLoader;
//
//public class ThriftTest {
//    public static void main(String args[]) throws Exception {
//        Iterator<ThriftServiceDefinition> thriftServices =
//                ServiceLoader.load(ThriftServiceDefinition.class).iterator();
//        while (thriftServices.hasNext()) {
//            System.out.println(thriftServices.next().getName());
//        }
//
//        MeteringRollupService.Client client = createThriftClient("localhost", 9502);
//        client.configure(new HashSet<String>());
//    }
//
//    public static MeteringRollupService.Client createThriftClient(String ip, int port) throws Exception {
//        TTransport t = new TSocket(ip, port);
//        t.open();
//        TProtocol p = new TBinaryProtocol(t);
//        return new MeteringRollupService.Client(p);
//    }
//}
