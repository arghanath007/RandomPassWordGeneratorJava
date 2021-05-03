import java.util.*;
public class PasswordGenerator
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the password: ");
        int length= sc.nextInt();
        for(int i=0;i< length;i++)
        {
            //127-32=95
            int password=(int)(Math.random()*95 + 32);
            char character=(char)password;
            System.out.print(character);
        }
    }
}