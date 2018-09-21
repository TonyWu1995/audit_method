package audit_method;

public class JavaTest3 {

    static int[] random = {9353, 84769, 46569, 127170, 93812, 10584, 64014, 93570, 16714, 87483};

    public static void main(String args[]) {
        int height = 7;
        int j = 0;

        while (j < 6) {
            FBHTree fBHTree = new FBHTree(height);
            long a = System.nanoTime();
            for (int i = 0; i < (1 << 17); i++) {
                fBHTree.put(i + "", i + "");
            }
            long b = System.nanoTime();
            System.out.println("build:" + (double) (b - a) / 1000000);
            long c = System.nanoTime();
            for (int i = 0; i < 10; i++) {
                fBHTree.audit(random[i] + "");
            }

            long d = System.nanoTime();
            System.out.println("audit10:" + (double) (d - c) / 1000000);
            long e = System.nanoTime();
            for (int i = 0; i < 10; i++) {
                fBHTree.remove(random[i] + "");
            }
            long f = System.nanoTime();

            System.out.println("delete10:" + (double) (f - e) / 1000000);
            j++;
        }
    }
}
