import java.util.ArrayList;
import java.util.List;

// IT NEEDS TO BE REFACTORED
class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> output = new ArrayList<>();

        if (nums.length == 0) return output;

        int first = nums[0]; 
        int previous = nums[0]; // to reduce # of method calls
        int current;

        for (int i = 1; i < nums.length; i++) {
            current = nums[i];

            if (current - previous == 1) {
                previous = current;
                continue;
            }

            rangeToString(output, first, previous);
            first = previous = current;
        }

        rangeToString(output, first, previous);

        return output;
    }

    private void rangeToString(List<String> output, int first, int previous) {
        if (previous == first) {
            output.add(String.valueOf(previous));
        } else {
            output.add(first + "->" + previous);
        }
    }

}
