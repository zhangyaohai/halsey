package com.halsey.netty.demo1;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

/**
 * Created by zhangyaohai on 2017/6/22.
 */
public class HalseyEcode extends MessageToByteEncoder {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        byte[] b;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oo = null;

        try {
            oo = new ObjectOutputStream(byteArrayOutputStream);
            oo.writeObject(o);
            b = byteArrayOutputStream.toByteArray();
            byteBuf.writeBytes(b);
            channelHandlerContext.flush();
        }finally {
            byteArrayOutputStream.close();
            oo.close();
        }
    }
}
