import com.google.common.collect.Lists;

import java.util.List;

/**
 * create by zhangyaohai
 * 2018-01-03 19:10
 **/
public class StreamApi{
    public static void main(String[] args) {
        List<Entity> list = Lists.newArrayList();
        Entity e = new Entity();
        e.setId(1);
        e.setName("133");

        Entity e2 = new Entity();
        e2.setId(2);
        e2.setName("zyh");

        Entity e3 = new Entity();
        e3.setId(3);
        e3.setName("zzz");
        list.add(e);
        list.add(e2);
        list.add(e3);

     //   list.stream().map()
    }
}
