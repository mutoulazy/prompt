package practice.io.netty;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

/**
 * netty 服务端
 */
public class NettyServer {

  public static void main(String[] args) {
    // 创建服务类对象
    ServerBootstrap serverBootstrap = new ServerBootstrap();
    // 创建两个线程池 分别为监听监听端口 ，nio监听
    ExecutorService boot = Executors.newCachedThreadPool();
    ExecutorService worker = Executors.newCachedThreadPool();
    // 设置工厂 并把两个线程池加入中
    serverBootstrap.setFactory(new NioServerSocketChannelFactory(boot, worker));
    // 设置管道工厂
    serverBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
      @Override
      public ChannelPipeline getPipeline() throws Exception {
        ChannelPipeline pipeline = Channels.pipeline();
        //将数据转换为string类型
        pipeline.addLast("decoder", new StringDecoder());
        pipeline.addLast("encoder", new StringEncoder());
        pipeline.addLast("serverHandler", new NettyServerHandler());
        return pipeline;
      }
    });
    // 绑定端口号
    serverBootstrap.bind(new InetSocketAddress(9090));
    System.out.println("netty server启动....");
  }
}
