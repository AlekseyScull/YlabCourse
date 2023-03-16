package homework2.statsaccumulator;

public class StatsAccumulatorImpl implements StatsAccumulator{
    private int maxValue = Integer.MIN_VALUE;
    private int minValue = Integer.MAX_VALUE;
    private int sum;
    private int count;

    @Override
    public void add(int value) {
        count++;
        maxValue = Math.max(maxValue, value);
        minValue = Math.min(minValue,value);
        sum += value;
    }

    @Override
    public int getMin() {
        return minValue;
    }

    @Override
    public int getMax() {
        return maxValue;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Double getAvg() {
        return count == 0 ? 0 : sum / (count * 1.0);
    }
}
