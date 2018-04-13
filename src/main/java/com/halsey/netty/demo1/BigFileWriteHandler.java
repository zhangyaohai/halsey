package com.halsey.netty.demo1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * Created by zhangyaohai on 2017/6/22.
 */
public class BigFileWriteHandler extends ChunkedWriteHandler {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        super.write(ctx, msg, promise);
    }


}
