import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Generic erasure
//  BeanUtils: dont' use it, as it has type erasure
// using mapstruct instead, but it
public class Test {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException {
        OrderDQ  orderDQ = new OrderDQ();
        orderDQ.setTags(Arrays.asList("tag1","tag2"));

        OrderDTQ  orderDTQ = new OrderDTQ();
        BeanUtils.copyProperties(orderDQ,orderDTQ);
        System.out.println(orderDQ.getTags());
        System.out.println(orderDTQ.getTags());
//        System.out.println(orderDTQ.getTags().get(0));
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.add(111);
//        list.add(222);
//
//        Class<?> clazz = Class.forName("java.util.ArrayList");
//        Method method = clazz.getMethod("add", Object.class);
//        method.invoke(list, "abc");
//
//        System.out.println(list);

    }
}

class OrderDQ{

    private List<String> tags;
//    private
    public List<String> getTags(){
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}

class OrderDTQ{

    private List<Integer> tags;
    //    private
    public List<Integer> getTags(){
        return tags;
    }

    public void setTags(List<Integer> tags) {
        this.tags = tags;
    }
}