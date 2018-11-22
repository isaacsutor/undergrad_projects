import java.util.ArrayList;
import java.util.Scanner;

/**
 * HTMLStrings parses an HTML string with the relevant tags so as to return the
 * requested section and tags which affect it
 * 
 * @author IsaacSutor
 * @version 20170912
 * 
 *          Followed the open hand policy and spoke to Bashir Davis about
 *          understanding the assignment and general problem solving techniques
 *          and data structures
 *
 */
public class HTMLStrings {
    public static void main(String[] args) {
        ArrayList<String> htmlArray = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        String fullText = scan.nextLine();
        String temp[] = fullText.split("\\s+");
        int start = Integer.parseInt(temp[0]);
        int last = Integer.parseInt(temp[1]) - 1;
        int whereZero = temp[0].length() + temp[1].length() + 2;
        String htmlText = fullText.substring(whereZero, fullText.length());
        String middle = "";
        for (int i = 0; i < start; i++) {
            if (htmlText.charAt(i) == '<') {
                int j = htmlText.indexOf(">", i);
                String small = htmlText.substring(i, j + 1);

                if (small.charAt(1) == '/') {
                    small = small.substring(0, 1)
                            + small.substring(2, small.length());
                }

                if (htmlArray.size() > 1) {
                    if (htmlArray.get(htmlArray.size() - 1).equals(small)) {
                        htmlArray.remove(htmlArray.size() - 1);
                    }
                }

                else {
                    htmlArray.add(small);
                }
                i = j;
            }
        }
        middle = htmlText.substring(start, last + 1);
        String firstHalf = "";
        String total = "";
        for (int i = 0; i < htmlArray.size(); i++) {
            firstHalf += htmlArray.get(i);
        }
        ArrayList<String> dontUse = new ArrayList<String>();
        ArrayList<String> addToEnd = new ArrayList<String>();
        for (int i = 0; i < middle.length() - 2; i++) {
            if (middle.charAt(i) == '<') {
                if (i < middle.length()) {
                    if (middle.charAt(i + 1) == '/') {
                        int b = middle.indexOf(">", i);
                        String small = middle.substring(i, b + 1);
                        dontUse.add(small);
                    }
                }
            }
            if (middle.charAt(i) == '<') {
                if (middle.charAt(i + 1) != '/') {
                    int b = middle.indexOf(">", i);
                    String small = middle.substring(i, b + 1);
                    addToEnd.add(small);
                }
            }
        }
        total += firstHalf;
        if (dontUse.size() > 0) {
            if (htmlArray.size() > 0) {
                if (htmlArray.get(htmlArray.size() - 1) == dontUse.get(0)) {
                    htmlArray.remove(htmlArray.size() - 1);
                }
            }
        }
        total += middle;
        for (int i = 0; i < addToEnd.size(); i++) {
            htmlArray.add(addToEnd.get(i));
        }
        String endHalf = "";
        if (last == htmlText.length() - 1) {
            System.out.println(total);
        }
        else {
            for (int i = htmlArray.size() - 1; i >= 0; i--) {
                endHalf += htmlArray.get(i);
            }
            String endHalfDash = "";
            for (int i = 0; i < endHalf.length(); i++) {
                if (endHalf.charAt(i) == '<') {
                    endHalfDash += "</";
                }
                else {
                    endHalfDash += endHalf.charAt(i);
                }

            }
            total += endHalfDash;
            System.out.println(total);
        }
    }
}
