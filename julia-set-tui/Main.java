/**********

ABOUT:
  This is an simple Terminal-based animated version of the Julia Set (https://en.wikipedia.org/wiki/Julia_set)
  It cycles through different versions of the Julia Set, and displays them in the terminal
  
USAGE:
  Increase your terminal height to >=130 or so (I designed this for Ubuntu 20.04, so this may vary by OS or
  shell used). Make sure this .java file is compiled before running. To run, enter "java Main". This will
  play the animation. Its speed will vary by computer.
  
  You can optionally increase the iteration depth by adding the iteration depth as an argument. For example,
  for the fractals to generate to 100 iterations, run "java Main 100". The default is 10 iterations, because
  I've found that for higher iterations, some of the finer details are not shown at all due to the lower
  resolution of the terminal.
  
Created by Gabriel Thompson

**********/

public class Main {
    static int maxDepth = 10; // default depth

    public static void main(String[] args) {
        if (args.length > 0)
            maxDepth = Integer.parseInt(args[0]);

        for (double a = 0.0; a < 20.0; a += 0.03) {
            juliaSet(Math.sin(a) * .5, Math.cos(a) * .5);
        }
    }

    public static void juliaSet(double real, double imag) {
        String out = "";
        for (double y = 2.0; y > -2.0; y -= .03) {
            for (double x = -2.0; x < 2.0; x += .012) {
                if (inSet(x, y, real, imag)) {
                    out += "X";
                } else {
                    out += " ";
                }
            }
            out += "\n";
        }
        System.out.println(out);
    }

    public static boolean inSet(double x, double y, double cX, double cY) {
        for (int i = 0; i < maxDepth; i++) {
            double tempX = x * x - y * y;
            y = 2 * x * y + cY;
            x = tempX + cX;

            if (x * x + y * y > 4)
                return false;
        }
        return true;
    }

}
