import java.util.HashMap;

public class DecTester {
    public static void continuityTest() {
        double[] testIndices = new double[] { -10.5, -10, -1.5, -1, -0.5, 0, 0.5, 1, 1.5, 10, 10.5 };
        for (int i = 0; i < testIndices.length; i++) {
            DecTree<Integer> ts = new DecTree<Integer>();
            ts.add(testIndices[i], i);
            if ((Integer.valueOf(ts.get(testIndices[i])) != i)) {
                System.err.println("continuityTest() failed");
                System.exit(1);
            }
        }
        System.err.println("continuityTest passed");
    }

    public static void floatingPointTest(){
        DecTree<Double> ts = new DecTree<Double>();
        double bound = 19;
        for(double i = 0; i < bound; i++){
            for(double j = 0; j < 10; j+=1d/i){
                ts.add(j, j);
            }
        }

        for(double i = 0; i < bound; i++){
            for(double j = 0; j < 10; j+=1d/i){
                if(Double.valueOf(ts.get(j))!=j){
                    System.err.println("conflict: "+j+"at i = "+ i);
                }
            }
        }
        System.err.println("passed.");
    }

    public static void retentionTest() {
        System.gc();
        for (double j = 10; j <= 1000000; j *= 10) {
            DecTree<Double> ts = new DecTree<Double>();
            HashMap<Double, Double> hm = new HashMap<Double, Double>();
            long origTime = System.nanoTime();
            for (int i = 0; i <= j; i++) {
                ts.add((double) i, (double) i);
            }
            long tsTime = System.nanoTime()-origTime;
            origTime = System.nanoTime();
            for (int i = 0; i <= j; i++) {
                hm.put((double) i, (double) i);
            }
            double ratio = tsTime/(System.nanoTime()-origTime);
            System.out.println(ratio);
            System.out.println(j);
        }
    }

    public static void tests() {
        continuityTest();
        floatingPointTest();
        retentionTest();
    }

    public static void main(String[] args) {
        tests();
    }
}
