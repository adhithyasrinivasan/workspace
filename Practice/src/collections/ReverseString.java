package collections;

import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {

        String input = new String("Amazon");
        int i,j;
        StringBuffer str=new StringBuffer();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        str.append(in.nextLine());

        for (i=0;i<str.length()-1;i++){
            for (j=i+1;j<str.length();j++){
                if (str.charAt(i)==str.charAt(j))
                    str.deleteCharAt(j);
            }
        }
        System.out.println("Removed non-unique symbols: " + str);
	} 

}
