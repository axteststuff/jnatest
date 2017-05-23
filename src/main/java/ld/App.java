package ld;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
                System.out.println( "Hello World!" );
                Env.e.setenv("AVAR", "AVAL", 1);
                System.out.println(Env.e.getpid());
                System.out.println(Env.e.getppid());
                long[] timenul = new long[1];
                System.out.println(Env.e.time(timenul));
            } catch (UnsatisfiedLinkError e) {
                System.out.println("Exception" + e);
            }
    }
}
