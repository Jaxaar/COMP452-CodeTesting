import java.util.Random;

public class RandomMockHGG extends Random {

    public int outputValue;

    public RandomMockHGG(int val){
        outputValue = val;
    }

    @Override
    public int nextInt(int UpperBound){
        return outputValue-1;
    }


}
