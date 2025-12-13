//            TC --> O(n^2)
// class Solution {
//      public int max(int a , int b, int c){
//         return Math.max(a, Math.max(b,c));
//        }  
//      public int levels(TreeNode root) {
//         if(root==null) return 0;
//         return 1 + Math.max(levels(root.left),levels(root.right));
//      } 
//     public int diameterOfBinaryTree(TreeNode root) {
//        if(root==null) return 0;
//        int myDia = levels(root.left) + levels(root.right);
//        int leftDia = diameterOfBinaryTree(root.left);
//        int rightDia = diameterOfBinaryTree(root.right);
//        return max(myDia,leftDia,rightDia);
//     }
// }


//  Method -->2

// class Solution{
//     static int maxDia;
//     public int levels(TreeNode root){
//         if(root==null) return 0;
//         int leftLevels = levels(root.left);
//         int rightLevels = levels(root.right);
//         int dia = leftLevels + rightLevels;
//         maxDia= Math.max(dia,maxDia);
//         return 1 + Math.max(leftLevels,rightLevels);
//     }
//     public int diameterOfBinaryTree(TreeNode root){
//         maxDia = 0;
//         levels(root);
//         return maxDia;
//     }
// }

// static hatane ke liye
// int pass by value hote h , isliye class banana parega ya array ka ek element banake pass by reference kar sakte ho.

class Solution{
   
   public class Int{
    int val;
    Int(int val){
        this.val = val;
    }
   }
    public int levels(TreeNode root, Int dia){
        if(root==null) return 0;
        int leftLevels = levels(root.left,dia);
        int rightLevels = levels(root.right,dia);
        int path = leftLevels + rightLevels; // extra
        dia.val= Math.max(dia.val,path); // extra
        return 1 + Math.max(leftLevels,rightLevels);
    }
    public int diameterOfBinaryTree(TreeNode root){
        Int dia = new Int(0);
        levels(root,dia);
        return dia.val;
    }
}
