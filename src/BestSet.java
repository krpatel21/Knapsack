public class BestSet
{
    private String include;
    private int maxprofit;

    public BestSet(String include, int maxprofit)
    {
        this.include = include;
        this.maxprofit = maxprofit;
    }

    public String getInclude()
    {
        return include;
    }

    public void setInclude(String include)
    {
        this.include = include;
    }

    public int getMaxprofit()
    {
        return maxprofit;
    }

    public void setMaxprofit(int maxprofit)
    {
        this.maxprofit = maxprofit;
    }

    @Override
    public String toString()
    {
        return "BestSet{" +
                "include='" + include + '\'' +
                ", maxprofit=" + maxprofit +
                '}';
    }
}
