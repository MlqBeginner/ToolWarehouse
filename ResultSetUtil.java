package uitl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过反射自动匹配
 */
public class ResultSetUtil {

    /**
     * 通过反射给单个属性赋值
     */
    public static <T>T eachNoe(ResultSet set,Class<T> cla)
    {
        T obj=null;
        try {
            if(set.next())
            {
                //创建该类型的实例对象
                obj=cla.newInstance();
                //获取到所有属性
                Field[] declaredFields = cla.getDeclaredFields();
                //遍历每一项赋值
                for (Field item : declaredFields)
                {
                    //打开访问私有属性的开关
                    item.setAccessible(true);
                    item.set(obj,set.getObject(item.getName()));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 通过反射给集合对象属性赋值
     */
    public static <T>List<T> eachList(ResultSet set, Class<T> cla)
    {
        List<T> list=new ArrayList<T>();
        T obj=null;
        try {
            while (set.next())
            {
                //创建该类型的实例对象
                obj=cla.newInstance();
                //获取到所有属性
                Field[] declaredFields = cla.getDeclaredFields();
                //遍历每一项赋值
                for (Field item : declaredFields)
                {
                    //打开访问私有属性的开关
                    item.setAccessible(true);
                    item.set(obj,set.getObject(item.getName()));
                }
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return list;

    }

}
