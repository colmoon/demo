/**  

* <p>Title: EchoClientHandler.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年6月10日  

* @version 1.0  

*/  
package com.moon.demo.service.chapter2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**  

* <p>Title: EchoClientHandler</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年6月10日  

*/
@Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf>{
	@Override
    public void channelActive(ChannelHandlerContext ctx) {
		ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks", CharsetUtil.UTF_8));
	}
	
	@Override
    public void channelRead0(ChannelHandlerContext ctx, ByteBuf in) {
		System.out.println("client received: " + in.toString(CharsetUtil.UTF_8));
	}
	
	@Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
