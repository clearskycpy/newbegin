package random;


public class NumArray {

    class Node {
        // 左右孩子节点
        public Node left, right;
        public int start,end;
        // 当前节点值
        public int val;
        public Node(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    Node root = null;
        public NumArray(int[] nums) {
            root = buildTree(nums,0,nums.length-1);
        }



    public void update(int index, int val) {
            updateTree(index,root,val);
        }



    public int sumRange(int left, int right) {
            return  query(root,left,right);
        }

    private int query(Node root, int left, int right) {
            if (root.start == left && root.end == right)
                return root.val;
            else {
                int mid = root.start + ((root.end-root.start)>>1);
                if (right <= mid){
                    return query(root.left,left,right);
                }else if (left > mid){
                    return query(root.right,left,right);
                }else {
                    return query(root.left,left,mid) + query(root.right, mid+1, right);
                }
            }
    }

    private void updateTree(int index, Node root, int val) {
        if (root.start == root.end){
            root.val = val;
            return;
        }else {
            int mid = root.start + ((root.end-root.start) >> 1);
            if (index > mid){
                updateTree(index,root.right,val);
            }else {
                updateTree(index,root.left,val);
            }
            root.val = root.left.val + root.right.val;
        }
    }
    private Node buildTree(int[] nums, int start, int end) {
        if(start > end){
            return null;
        }
        if (start == end){
//                说明到了叶子结点
            Node node = new Node(start,end);
            node.val = nums[start];
            return node;
        }else {
            Node node = new Node(start,end);
            int mid = start + ((end - start) >> 1);

            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid + 1, end);

            node.val = node.left.val + node.right.val;
            return node;
        }
    }

}

