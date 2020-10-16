package converter;

import com.mysql.cj.util.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 日期转化器
*
* */
@Component
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        //创建日期对象
        Date date=null;
        try{
            //判断传入的值是否为空
            if(StringUtils.isNullOrEmpty(s)){
                return null;
            }
            //转换日期格式
            date =new SimpleDateFormat("yyyy-mm-dd").parse(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
}
