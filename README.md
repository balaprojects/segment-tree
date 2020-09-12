# segment-tree

>What is a segment tree?
   - It is a binary tree that has input array elements as leaf nodes.
   - Provides two operations
      - update
      - query

>Use cases of segment tree
   1. It is mainly useful for range queries where it guarantees **log(n)** performance.
   2. Examples: Minimum value in a given range, Maximum value in a given range, Sum of values in a given range.

>Logical Representation of Segment Tree<br>
  ![](https://github.com/balaprojects/images/blob/master/SegmentTree_LogicalRepresentation.PNG)

>Number of nodes in a tree<br>
   - 1 + 2 + 2^2 + 2^3 + .. + 2^h = 2^(h + 1) - 1
   - 2^h =N
   - 2.2^h - 1 = 2N - 1
   Hence total number of nodes in a tree is **2N - 1**.

>Range Query Logic
  - There are 3 possibilities when we compare a query range with a node's range
      - Full Overlap
      - Partial Overlap
      - No Overlap
