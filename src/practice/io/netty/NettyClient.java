package practice.io.netty;

import java.net.InetSocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

/**
 * netty 客户端
 */
public class NettyClient {

  public static void main(String[] args) {
    System.out.println("netty client启动...");
    ClientBootstrap clientBootstrap = new ClientBootstrap();
    // 线程池
    ExecutorService boot = Executors.newCachedThreadPool();
    ExecutorService worker = Executors.newCachedThreadPool();
    clientBootstrap.setFactory(new NioClientSocketChannelFactory(boot, worker));
    clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
      @Override
      public ChannelPipeline getPipeline() throws Exception {
        ChannelPipeline pipeline = Channels.pipeline();
        //将数据转换为string类型
        pipeline.addLast("decoder", new StringDecoder());
        pipeline.addLast("encoder", new StringEncoder());
        pipeline.addLast("clientHandler", new NettyClientHandler());
        return pipeline;
      }
    });
    //连接服务端
    ChannelFuture connect = clientBootstrap.connect(new InetSocketAddress("127.0.0.1", 9090));
    Channel channel = connect.getChannel();
    System.out.println("client start");
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      channel.write(scanner.next());
    }
  }
}
