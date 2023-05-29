import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {
	public static void main(String[] a) {
		String sample[] = {"sample1","sample2"};
		System.out.println(sample.length);
		ArrayList<String> samplelist = new ArrayList<String>();
		Collections.addAll(samplelist, sample);
		samplelist.add("sample3");
		sample = (String[]) samplelist.toArray();
		System.out.println(sample.length);
	}
}
