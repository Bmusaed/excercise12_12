import java.io.File;
import java.io.PrintWriter;
import java.util.*;
public class Exercise12_12 {
  /**Main method*/
  public static void main(String[] args) throws Exception {
    // Check command line parameter usage
    extracted(args);

    // Check if source file exists
    File sourceFile = extracted2(args);

    StringBuilder buffer = new StringBuilder();
    Scanner input = new Scanner(sourceFile);

    extracted3(buffer, input);

    input.close();

    // Write buffer into the file
    PrintWriter output = new PrintWriter(sourceFile);
    output.print(buffer.toString());
    output.close();
  }

private static void extracted3(StringBuilder buffer, Scanner input) {
	while (input.hasNext()) {
      String s = input.nextLine();
      String s1 = s.trim();
      if (s1.charAt(0) == '{') {
        buffer.append(" {");
        if (s1.length() > 1) buffer.append("\r\n" + s.replace('{', ' '));
      }
      else
        buffer.append("\r\n" + s);
    }
}

private static File extracted2(String[] args) {
	File sourceFile = new File(args[0]);
    if (!sourceFile.exists()) {
       System.out.println("Source file " + args[0] + " not exist");
       System.exit(2);
    }
	return sourceFile;
}

private static void extracted(String[] args) {
	if (args.length != 1) {
      System.out.println(
        "Usage: java Exercise12_12 filename");
      System.exit(1);
    }
}
}
