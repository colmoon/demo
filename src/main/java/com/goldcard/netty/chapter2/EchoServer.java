/**  

* <p>Title: EchoServer.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年6月10日  

* @version 1.0  

*/  
package com.goldcard.netty.chapter2;

import java.net.InetSocketAddress;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**  

* <p>Title: EchoServer</p>  

* <p>Description: 测试</p>

* @author wu.xiao.jian 2119  

* @date 2018年6月10日  

*/
public class EchoServer {
	private final int port;
	
	public EchoServer(int port) {
		this.port = port;
	}
	
	public static void main(String[] args) throws Exception{
/*		if(args.length != 1) {
			System.err.println("Usage: " + EchoServer.class.getName() + 
					" <port>");
		}
		int port = Integer.parseInt(args[0]);*/
		int port = 4507;
		new EchoServer(port).start();
	}
	
	public void start() throws Exception{
		final EchoServerHandler serverHandler = new EchoServerHandler();
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(group)
			.channel(NioServerSocketChannel.class)
			.localAddress(new InetSocketAddress(port))
			.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
                public void initChannel(SocketChannel channel) throws Exception{
					System.out.println("test");
					channel.pipeline().addLast(serverHandler);
				}
			});
			ChannelFuture channelFuture = bootstrap.bind().sync();
			channelFuture.channel().closeFuture().sync();
		} finally {
			group.shutdownGracefully().sync();
		}
	}
}
