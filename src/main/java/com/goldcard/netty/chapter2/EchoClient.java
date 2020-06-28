/**  

* <p>Title: EchoClient.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年6月10日  

* @version 1.0  

*/  
package com.goldcard.netty.chapter2;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**  

* <p>Title: EchoClient</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年6月10日  

*/
public class EchoClient {
	private final String host;
	private final int port;
	
	public EchoClient(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	public void start() throws Exception{
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(group)
			.channel(NioSocketChannel.class)
			.option(ChannelOption.SO_KEEPALIVE,true)
			.remoteAddress(new InetSocketAddress(host, port))
			.handler(new ChannelInitializer<SocketChannel>() {
				@Override
                public void initChannel(SocketChannel channel) throws Exception{
					channel.pipeline().addLast(new EchoClientHandler());
				}
			});
			ChannelFuture channelFuture = bootstrap.connect().sync();
			channelFuture.channel().closeFuture().sync();
		} finally {
			group.shutdownGracefully().sync();
		}
	}
	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) throws Exception{
		/*if (args.length != 2) {
			System.err.println("Usage: " + EchoClient.class.getSimpleName() +
					"<host> <port>");
			return;
		}
		String host = args[0];
		int port = Integer.parseInt(args[1]);*/
		String host = "localhost";
		int port = 4507;
		new EchoClient(host, port).start();
		ByteBuf byteBuf =  PooledByteBufAllocator.DEFAULT.buffer();
		System.out.println(byteBuf.hasArray());
		EmbeddedChannel channel = new EmbeddedChannel();
		channel.writeOutbound(byteBuf);
	}

}
