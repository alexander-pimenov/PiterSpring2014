package quoters;

import quoters.profiling.Profiling;
import quoters.phase3.PostProxy;
import quoters.phase2.InjectRandomInt;

import javax.annotation.PostConstruct;

/*Сеттеры обязательно нужны здесь, т.к. настраивается это через xml*/
@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    public TerminatorQuoter() {
        System.out.println("Phase 1");
    }

    @PostConstruct
    public void init() {
        System.out.println("Phase 2");
        System.out.println("repeat = " + repeat);
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("Phase 3");
        for (int i = 0; i < repeat; i++) {
            //печатаем нашу цитату
            System.out.println("message = " + message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }
}
