package com.auth2.azuread;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class TestSeven {



    @AllArgsConstructor
    class TestAraidee{
        private String name;

        public void setName(String name){
            this.name = name;
        }
    }




    @Test
    public void testsf() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TestAraidee testAraidee = new TestAraidee("test");
        log.info("{}" , testAraidee.name);
        var context = new StandardEvaluationContext();
        context.setVariable("newName" , "test2");
        var parser = new SpelExpressionParser();
        parser.parseExpression("name = #newName").getValue(context,testAraidee);
        log.info("{}" , testAraidee.name);


        var method = this.getClass().getMethod("helloWorld",String.class);
//        method.invoke(this, "eiei");

        context.setVariable("x",10);
        context.setVariable("y",15);
        context.registerFunction("hello" , method);
//        context.registerFunction("hello", TestSeven.class.getDeclaredMethod("helloWorld", String.class));
//        TestSeven instance = new TestSeven();
//        context.registerFunction("hello", instance.getClass().getMethod("helloWorld", String.class));



        parser.parseExpression("#hello((#x+#y).toString())").getValue(context);


    }


    public  static void helloWorld(String name){
        System.out.println("Hello " + name);
    }

}
