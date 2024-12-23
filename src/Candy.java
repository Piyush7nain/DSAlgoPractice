import java.util.Arrays;

public class Candy {
    /**
     * There are n children standing in a line. Each child is assigned a rating value given in
     * the integer array ratings.
     *
     * You are giving candies to these children subjected to the following requirements:
     *
     * Each child must have at least one candy.
     * Children with a higher rating get more candies than their neighbors.
     * Return the minimum number of candies you need to have to distribute the candies to the children.
     *
     * Example 1:
     * Input: ratings = [1,0,2]
     * Output: 5
     * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
     *
     * Example 2:
     * Input: ratings = [1,2,2]
     * Output: 4
     * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
     * The third child gets 1 candy because it satisfies the above two conditions.
     *
     * Constraints:
     * n == ratings.length
     * 1 <= n <= 2 * 104
     * 0 <= ratings[i] <= 2 * 104
     * */

    public int candy(int[] ratings) {
        if(ratings.length == 0) return 0;
        if(ratings.length == 1) return 1;
        int candy = 0;
        int[] candies = new int[ratings.length];
        if(ratings[0] > ratings[1]) {
            candies[0] = 1;
        }
        if(ratings[ratings.length - 1] > ratings[ratings.length - 2]) {
            candies[candies.length - 1] = 1;
        }
        candy+=candies[0];
        candy+=candies[candies.length - 1];
        for(int i = 1; i < ratings.length; i++) {
            int back = ratings.length-i-1;
            System.out.println(candy);
            candy-=candies[i];
            if(ratings[i] > ratings[i -1]) {
                candies[i] = Math.max(candies[i -1] + 1, candies[i]);
            }
            candy+=candies[i];
            System.out.println(candy);
            candy-=candies[back];
            if(ratings[back] > ratings[back+1]) {
                candies[back] = Math.max(candies[back+1] + 1, candies[back]);
            }
            candy+=candies[back];
            System.out.println(candy);
            System.out.println("------");
            System.out.println("------");
        }

        System.out.println(Arrays.toString(candies));
//        for(int c: candies){
//            candy+=c;
//        }
        return candy + ratings.length;
    }

    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        Candy candy = new Candy();
        System.out.println(candy.candy(ratings));
    }
}
