package aop.aspectj.demo;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
	
	new SomeManager().doTheStaff();
	
	new WebService().service();
//	new WebService().proceed("p2");
    }
}
