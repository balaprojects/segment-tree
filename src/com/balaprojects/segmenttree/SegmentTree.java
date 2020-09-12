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
        return query(segmentTree, low, high, 0, length, 0);
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

    public void update(int[] input, int[] segmentTree, int index, int delta) {
        input[index] += delta;
        update(segmentTree, index, delta, 0, input.length - 1, 0);
    }

    public void update(int[] segmentTree, int index, int delta, int low, int high, int pos) {
        if(index < low || index > high) {
            return;
        }

        if(low == high) {
            segmentTree[pos] += delta;
            return;
        }

        int mid = (low + high) / 2;
        update(segmentTree, index, delta, low, mid, ((2*pos) + 1));
        update(segmentTree, index, delta, mid + 1, high, ((2*pos) + 2));
        segmentTree[pos] = Math.min(segmentTree[((2*pos) + 1)], segmentTree[((2*pos) + 2)]);
    }

    public void updateRange(int[] input, int[] segmentTree, int startIndex, int endIndex, int delta) {
        for (int i = startIndex; i <= endIndex; i++) {
            input[i] += delta;
        }
        updateRange(segmentTree, startIndex, endIndex, delta, 0, input.length - 1, 0);
    }

    public void updateRange(int[] segmentTree, int startIndex, int endIndex, int delta, int low, int high, int pos) {
        if(startIndex > high || endIndex < low) {
            return;
        }

        if(low == high) {
            segmentTree[pos] += delta;
            return;
        }

        int mid = (low + high) / 2;
        updateRange(segmentTree, startIndex, endIndex, delta, low, mid, ((2*pos) + 1));
        updateRange(segmentTree, startIndex, endIndex, delta, mid + 1, high, ((2*pos) + 2));
        segmentTree[pos] = Math.min(segmentTree[((2*pos) + 1)], segmentTree[((2*pos) + 2)]);
    }

}