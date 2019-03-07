package practice.io.netty;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * netty Handler
 */
public class NettyServerHandler extends SimpleChannelHandler {

  @Override
  public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    super.channelClosed(ctx, e);
    System.out.println("channelClosed");
  }

  @Override
  public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    super.channelDisconnected(ctx, e);
    System.out.println("channelDisconnected");
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
    super.exceptionCaught(ctx, e);
    System.out.println("exceptionCaught");
  }

  @Override
  public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
    super.messageReceived(ctx, e);
    System.out.println("服务器端收到客户端消息:"+e.getMessage());
    ctx.getChannel().write(e.getMessage() + "!");
  }
}
