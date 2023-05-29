import java.text.Collator;
import java.util.Arrays;
public class Demo {
   public static void main(String args[]) {
      String[] arr = new String[] { "Abcd", "defr", "zxwd", "rdfvlk", "abc", "abcder", "abccc", "oinadskal", "ksnfls", "abccccdd" };
      System.out.print("The unsorted array is: ");
      System.out.println(Arrays.toString(arr));
      Arrays.sort(arr, Collator.getInstance());
      System.out.print("The sorted array in case-insensitive order is: ");
      System.out.println(Arrays.toString(arr));
   }
}