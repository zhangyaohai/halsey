package com.halsey.netty.demo1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Created by zhangyaohai on 2017/6/22.
 */
public class HalseyDecode extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

        ByteArrayInputStream bi = null;
        ObjectInputStream objectInputStream = null;
        byte [] bs = new byte[byteBuf.readableBytes()];
        try {
            byteBuf.readBytes(bs);
            bi = new ByteArrayInputStream(bs);
            objectInputStream = new ObjectInputStream(bi);
            list.add(objectInputStream.readObject());

        }finally {

            if(bi != null)
                bi.close();
            if(objectInputStream != null)
                objectInputStream.close();
        }


    }
}
