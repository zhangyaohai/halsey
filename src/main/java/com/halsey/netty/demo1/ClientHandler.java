package com.halsey.netty.demo1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by zhangyaohai on 2017/6/22.
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("connection。。。。。。。。。");
        Halsey halsey = new Halsey();
        halsey.setId(2);
        halsey.setMark("uuuuu");
        halsey.setName("halsey");
        ctx.write(halsey);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
