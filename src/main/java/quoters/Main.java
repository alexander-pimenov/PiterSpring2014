package quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * "Spring под капотом"
 * https://medium.com/@kirill.sereda/spring-%D0%BF%D0%BE%D0%B4-%D0%BA%D0%B0%D0%BF%D0%BE%D1%82%D0%BE%D0%BC-9d92f2bf1a04
 * */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        //вытащим из контекста бин и запустим его метод
        //Нужно вытаскивать по интерфейсу
        context.getBean(Quoter.class).sayQuote();
        //по классу вытаскивать это не верно !!!
//        context.getBean(TerminatorQuoter.class);


    }
}
