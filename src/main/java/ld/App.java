package ld;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Env.e.setenv("AVAR", "AVAL", 1);
    }
}
