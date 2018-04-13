package com.halsey.netty.demo1;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by zhangyaohai on 2017/6/22.
 */
public class NettyClient {

    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup boss = new NioEventLoopGroup();
        try {
            Bootstrap client = new Bootstrap();
            client.group(boss).channel(NioSocketChannel.class).option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new HalseyEcode()).addLast(new ClientHandler());
                        }
                    });
            ChannelFuture channelFuture = client.connect("localhost", 8000).sync();
            channelFuture.channel().eventLoop().scheduleAtFixedRate(
                    ()-> {
                        Channel channel =  channelFuture.channel();
                        ByteBuf byteBuf = Unpooled.buffer(1024);
                        byteBuf.writeInt(10001);
                        byteBuf.writeInt(6);
                        byteBuf.writeInt(999999);
                        byteBuf.writeDouble(37.324432);
                        byteBuf.writeDouble(29.47446654);
                        byteBuf.writeBytes(Unpooled.copiedBuffer("465654".getBytes(Charset.defaultCharset())));
                        channel.writeAndFlush(byteBuf.array());
                    },
                    0,5, TimeUnit.SECONDS);
            channelFuture.channel().closeFuture().sync();
        }finally {
            boss.shutdownGracefully();
         }

    }
}
