package nd4j_test;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import java.util.concurrent.TimeUnit;

/**
 * Created by hwang on 8/21/15.
 */
public class test1 {
    public static void main(String[] args) throws Exception {
        INDArray nd = Nd4j.create(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        long begintime = System.currentTimeMillis();
        long beginTimeSeconds = TimeUnit.MILLISECONDS.toMillis(begintime);

        nd = nd.broadcast(new int[]{5000, 10});
        System.out.println("transporse (5000,10)->(10,5000)+broadcast (10,5000)->(5000,5000)");
        nd = nd.transpose().broadcast(new int[]{5000, 5000});

        long endtime = System.currentTimeMillis();
        long endTimeSeconds = TimeUnit.MILLISECONDS.toMillis(endtime);
        System.out.println("time:" + String.valueOf(endTimeSeconds - beginTimeSeconds)+"ms");

        System.out.println("transporse (5000,5000)->(5000,5000)");
        INDArray nd2 = nd.transpose();
        long endtime2 = System.currentTimeMillis();
        long endTimeSeconds2 = TimeUnit.MILLISECONDS.toMillis(endtime2);
        System.out.println("time:" + String.valueOf(endTimeSeconds2 - endTimeSeconds)+"ms");

        System.out.println("muliplication (5000,5000)*(5000,5000)");
        INDArray nd4 = nd2.mmul(nd);

        long endtime3 = System.currentTimeMillis();
        long endTimeSeconds3 = TimeUnit.MILLISECONDS.toMillis(endtime3);
        System.out.println("time:" + String.valueOf(endTimeSeconds3 - endTimeSeconds2)+"ms");

        //System.out.println(nd4);
    }
}
