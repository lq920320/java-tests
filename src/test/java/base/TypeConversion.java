package base;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * 类型转换
 *
 * @author zetu
 * @date 2022/6/8
 */
public class TypeConversion {

    @Test
    public void implicitCasting() {
        byte byteVar = 42;
        short shortVar = byteVar;
        int intVar = shortVar;
        long longVar = intVar;
        float floatVar = longVar;
        double doubleVar = floatVar;

        System.out.println(byteVar);
        System.out.println(shortVar);
        System.out.println(intVar);
        System.out.println(longVar);
        System.out.println(floatVar);
        System.out.println(doubleVar);
    }

    @Test
    public void explicitCasting() {
        // Explicit casting
        double doubleVar = 42.0d;
        float floatVar = (float) doubleVar;
        long longVar = (long) floatVar;
        int intVar = (int) longVar;
        short shortVar = (short) intVar;
        byte byteVar = (byte) shortVar;

        System.out.println(byteVar);
        System.out.println(shortVar);
        System.out.println(intVar);
        System.out.println(longVar);
        System.out.println(floatVar);
        System.out.println(doubleVar);
    }


    @Test
    public void testNumericPromotion() {
        char char1 = 1, char2 = 2;
        short short1 = 1, short2 = 2;
        int int1 = 1, int2 = 2;
        float float1 = 1.0f, float2 = 2.0f;
        // char1 = char1 + char2; // Error: Cannot convert from int to char;
        // short1 = short1 + short2; // Error: Cannot convert from int to short;
        int1 = char1 + char2; // char is promoted to int.
        int1 = short1 + short2; // short is promoted to int.
        int1 = char1 + short2; // both char and short promoted to int.
        float1 = short1 + float2; // short is promoted to float.
        int1 = int1 + int2; // int is unchanged.
    }

    @Test
    public void nonNumericCasting() {
//        int badInt = (int) true; // Compiler error: incompatible types
        char char1 = (char) 65; // A
        byte byte1 = (byte) 'A'; // 65
        short short1 = (short) 'A'; // 65
        int int1 = (int) 'A'; // 65
        char char2 = (char) 8253; // ‽
        byte byte2 = (byte) '‽'; // 61 (truncated code-point into the ASCII range)
        short short2 = (short) '‽'; // 8253
        int int2 = (int) '‽'; // 8253
        System.out.println(char1);
        System.out.println(byte1);
        System.out.println(short1);
        System.out.println(int1);
        System.out.println(char2);
        System.out.println(byte2);
        System.out.println(short2);
        System.out.println(int2);

    }

    @Test
    public void objectCasting() {
        Float floatVar = new Float(42.0f);
        System.out.println(floatVar);
        Number n = floatVar; //Implicit (Float implements Number)
        System.out.println(n.getClass());
        System.out.println(n);
        Float floatVar2 = (Float) n; //Explicit
        System.out.println(floatVar2);
        Double doubleVar = (Double) n; //Throws exception (the object is not Double)
        System.out.println(doubleVar);
    }

    @Test
    public void instanceofTest() {
        Object obj = Calendar.getInstance();
        long time = 0;
        if (obj instanceof Calendar) {
            time = ((Calendar) obj).getTime().getTime();
            System.out.println("time1:" + time);
        }
        if (obj instanceof Date) {
            time = ((Date) obj).getTime(); // This line will never be reached, obj is not a Date type.
            System.out.println("time2:" + time);
        }
    }
}
