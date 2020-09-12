package com.balaprojects.segmenttree;

import java.util.Arrays;

public class SegmentTree {

    public int[] constructSegmentTree(int[] input) {
        int[] segmentTree = new int[100];
        constructSegmentTree(input, segmentTree, 0, input.length - 1, 0);
        return segmentTree;
    }

    public void constructSegmentTree(int[] input, int[] segmentTree, int low, int high, int pos) {
        if(low == high) {
            segmentTree[pos] = input[low];
            return;
        }
        int mid = (low + high) / 2;
        constructSegmentTree(input, segmentTree, low, mid, ((pos * 2) + 1));
        constructSegmentTree(input, segmentTree, mid + 1, high, ((pos * 2) + 2));
        segmentTree[pos] = Math.min(segmentTree[((pos * 2) + 1)], segmentTree[((pos * 2) + 2)]);
    }

    public int query(int[] segmentTree, int low, int high, int length) {
        return query(segmentTree, low, high, 0, length - 1, 0);
    }

    public int query(int[] segmentTree, int qlow, int qhigh, int low, int high, int pos) {
        if(qlow <= low && qhigh >= high) {
            return segmentTree[pos];
        } else if(qlow > high || qhigh < low) {
            return Integer.MAX_VALUE;
        }
        int mid = (low + high) / 2;
        return Math.min(query(segmentTree, qlow, qhigh, low, mid, ((pos * 2) + 1)),
                query(segmentTree, qlow, qhigh, (mid + 1), high, ((pos * 2) + 2)));
    }

}