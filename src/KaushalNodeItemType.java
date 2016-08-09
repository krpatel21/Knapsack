import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KaushalNodeItemType
{
    static final int W = 16;
    static int maxprofit = 0;
    static int numbest;
    static int n = 4;
    static String[] include = new String[100];
    static BestSet[] bestSet = new BestSet[100];

    static int[] w = {2, 5, 10, 5};
    static int[] p = {40, 30, 50, 10};
    //    Integer[] pw = createPwArray(w, p);
    static int[] pw = {20, 6, 5, 2};

    public static void knapsack(int i, int profit, int weight)
    {
        if (weight <= W && profit > maxprofit)
        {
            maxprofit = profit;
            numbest = i;
            bestSet[i] = new BestSet(include[i], maxprofit);
        }

        if (promising(i, weight, profit))
        {
            include[i + 1] = "yes";
            knapsack(i + 1, profit + p[i + 1], weight + w[i + 1]);
//        }else{
            include[i + 1] = "no";
            knapsack(i + 1, profit, weight);
        }
    }

    static boolean promising(int i, int weight, int profit)
    {
        int j, k;
        int totweight;
        float bound;
        if (weight >= W)
        {
            return false;
        } else
        {
            j = i + 1;
            bound = profit;
            totweight = weight;
            while (j < n && totweight + w[j] <= W)
            {
                totweight = totweight + w[j];
                bound = bound + p[j];
                j++;
            }
        }
        k = j;
        if (k < n)
        {
            bound = bound + (W - totweight) * p[k] / w[k];
        }
        return bound > maxprofit;
    }

    public static void main(String[] args)
    {
        include[0] = "yes";
        knapsack(0, 0, 0);
        System.out.println(Arrays.toString(bestSet));
    }
}
