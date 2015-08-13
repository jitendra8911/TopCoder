import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Quipu {

	private static int prevstart=0;
	private static int currstart=0;
    private static final String REGEX =
        "-";
    private static final String INPUT =
        "-XXXXXXXXX--XXXXXXXXX-XXXXXXXXX-XXXXXXX-XXXXXXXXX-";

    public static void main(String[] args) {
       Pattern p = Pattern.compile(REGEX);
       //  get a matcher object
       Matcher m = p.matcher(INPUT);
       int count = 0;
       int diff=0;
       m.find();
       StringBuffer sb=new StringBuffer();
       while(m.find()) {
           count++;
           currstart=m.start();
           diff=currstart-prevstart-1;
           sb.append(diff+"");
           prevstart=currstart;
      }
       System.out.println(sb.toString());
   }
}
