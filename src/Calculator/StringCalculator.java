package Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    
    public static int add(String number){
        String [] array;
        int ans=0;
        
        if("".equals(number))return 0;
        
        List<Integer> neg = new ArrayList<>();
        
        if(number.startsWith("//")){
            Matcher a = Pattern.compile("//(.)\n(.*)").matcher(number);
            a.matches();
            String b = a.group(1);
            String c = a.group(2);
            array = c.split(Pattern.quote(b));
            for(int i = 0 ; i < array.length ; i++)if(Integer.parseInt(array[i])<0)neg.add(Integer.parseInt(array[i]));
            String mess = "negatives not allowed: ";
            for(int i = 0 ; i < neg.size(); i++)mess += neg.get(i)+" ";
            if(!neg.isEmpty())throw new RuntimeException(mess);
            for(int i = 0 ; i < array.length ; i++)if(Integer.parseInt(array[i])<=1000)ans+=Integer.parseInt(array[i]);
            return ans;
        }
        else{
            array = number.split(",|\n");
            for(int i = 0 ; i < array.length ; i++)if(Integer.parseInt(array[i])<0)neg.add(Integer.parseInt(array[i]));
            String mess = "negatives not allowed: ";
            for(int i = 0 ; i < neg.size(); i++)mess += neg.get(i)+" ";
            if(!neg.isEmpty())throw new RuntimeException(mess);
            for(int i = 0 ; i < array.length ; i++)if(Integer.parseInt(array[i])<=1000)ans+=Integer.parseInt(array[i]);
            return ans;
        }
    }
}
