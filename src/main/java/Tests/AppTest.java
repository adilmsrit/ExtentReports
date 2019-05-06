package Tests;

public class AppTest {

    public static void main(String[] args) {
        Stack theStack = new Stack(3);
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while (!theStack.isEmpty()){
            long value = theStack.pop();
            System.out.println(value);
        }

        System.out.println(reverseString("ADIL"));

    }

    public static String reverseString(String str){

        int length = str.length();
        String reversedString ="";

        for (int i=length-1;i>=0;i--) {
            reversedString += str.substring(length - 1, length);
            length--;
        }
        return reversedString;

    }




}
