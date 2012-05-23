/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

import org.junit.*;
import static org.junit.Assert.*;


public class StringCalculatorTest {
    @Test
    public void empty_string(){
        int ans=0;
        String cad = "";
        assertEquals(ans,StringCalculator.add(cad));
    }
    @Test
    public void one_number(){
        int ans=78;
        String cad = "78";
        assertEquals(ans,StringCalculator.add(cad));
    }
    @Test
    public void two_number(){
        int ans=96;
        String cad = "24,72";
        assertEquals(ans,StringCalculator.add(cad));
    }
    @Test
    public void un_known_amount_of_numbers(){
        int ans=196;
        String cad = "24,72,100";
        assertEquals(ans,StringCalculator.add(cad));
    }
    @Test
    public void new_lines_between_numbers (){
        int ans=60;
        String cad = "10\n20,30";
        assertEquals(ans,StringCalculator.add(cad));
    }
    @Test
    public void support_different_delimiters (){
        int ans=30;
        String cad = "//;\n10;20";
        assertEquals(ans,StringCalculator.add(cad));
    }
    @Test
    public void negatives_not_allowed (){
        String ans = "negatives not allowed: -20 -41 -899 ";
        String cad = "78,8,9,-20,-41,-899,89";
        try{
            StringCalculator.add(cad);
        }catch(RuntimeException ex){
            assertEquals(ans,ex.getMessage());
        }
    }
    @Test
    public void no_more_than_1000 (){
        int ans=1200;
        String cad = "//;\n100;500;600;1200;2400";
        assertEquals(ans,StringCalculator.add(cad));
    }
  
}
