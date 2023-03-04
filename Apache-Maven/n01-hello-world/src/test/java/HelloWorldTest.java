// simple POJO test
public class HelloWorldTest {
     public void test1() {
         System.out.println("Test #1");
     }

     public void test2() {
         System.out.println("Test #2");
     }

    // this one will not run with Surefire
    public void helloTest1() {
         System.out.println("helloTest1()");
     }

    // this one will not run with Surefire
    public void myTest() {
         System.out.println("My Test");
     }
}
