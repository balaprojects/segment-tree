package com.balaprojects.segmenttree;

public class Test {

    public static void main(String[] args) {
        int[] input = new int[] {-1, 3, 4, 0, 2, 1};
        SegmentTree segmentTree = new SegmentTree();
        int[] segmentTree1 = segmentTree.constructSegmentTree(input);
        System.out.println(segmentTree.query(segmentTree1, 1, 2, input.length));
    }

}
