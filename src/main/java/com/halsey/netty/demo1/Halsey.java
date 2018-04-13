package com.halsey.netty.demo1;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by zhangyaohai on 2017/6/22.
 */
@Data
public  class Halsey implements Serializable{

    private int id;
    private String name;
    private String mark;

    enum Status {

        STATUS_OK("可用正常", 1);

        private @Setter @Getter String msg;
        private @Setter @Getter int value;

        Status(String msg, int value){
                this.msg = msg;
                this.value = value;
        }
    }

}
