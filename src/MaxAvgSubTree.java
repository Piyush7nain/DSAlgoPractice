public class MaxAvgSubTree {

    double maxAvg;
    public double maximumAverageSubtree(TreeNode root) {

        maxAvg = 0;
        postOrder(root);
        return maxAvg;
    }

    double[] postOrder(TreeNode root){

        if(root ==null)
            return new double[]{0,0};

        double[] left = postOrder(root.left);
        double[] right = postOrder(root.right);

        double count = left[0] + right[0] + 1.0;
        double sum = left[1] + right[1] + (double)root.val;

        double avg = (sum)/count;
        maxAvg = Math.max(maxAvg, avg);
        return new double[]{count, sum};
    }
}
