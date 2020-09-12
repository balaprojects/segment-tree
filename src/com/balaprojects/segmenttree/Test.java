package com.balaprojects.segmenttree;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] input = new int[] {-1, 3, 4, 0, 2, 1};
        SegmentTree segmentTree = new SegmentTree();
        int[] segmentTree1 = segmentTree.constructSegmentTree(input);
        System.out.println(segmentTree.query(segmentTree1, 1, 2, input.length - 1));
        System.out.println("---Update Index");
        segmentTree.update(input, segmentTree1, 1, -5);
        Arrays.stream(input).forEach(e -> System.out.print(e+ ", "));
        System.out.println("");
        System.out.println(segmentTree.query(segmentTree1, 0, input.length - 1, input.length - 1));
        System.out.println(segmentTree.query(segmentTree1, 2, input.length - 1, input.length - 1));
        System.out.println(segmentTree.query(segmentTree1, 4, input.length - 1, input.length - 1));
        System.out.println("---Update Range Index");
        segmentTree.updateRange(input, segmentTree1, 2, 4, -2);
        Arrays.stream(input).forEach(e -> System.out.print(e+ ", "));
        System.out.println("");
        System.out.println(segmentTree.query(segmentTree1, 0, input.length - 1, input.length - 1));
        System.out.println(segmentTree.query(segmentTree1, 0, 1, input.length - 1));
        System.out.println(segmentTree.query(segmentTree1, 4, input.length - 1, input.length - 1));
    }

}
