
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        int goodNodes = 0;
    
        public int goodNodes(TreeNode root) {
            dfs(root, Integer.MIN_VALUE);
            return goodNodes;
        }
    
        private void dfs(TreeNode node, int maxSoFar) {
    
            if (node == null) return;
    
            // A node is good if its value >= maximum
            // value encountered on the path from root.
            if (node.val >= maxSoFar) {
                goodNodes++;
            }
    
            // Update maximum before visiting children.
            maxSoFar = Math.max(maxSoFar, node.val);
    
            dfs(node.left, maxSoFar);
            dfs(node.right, maxSoFar);
        }
    }
  
    

/*

- Q
    
    # **1448. Count Good Nodes in Binary Tree**
    
    **Apple**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAEiklEQVRYha2XW2wUVRzGf7OX2SVt2d1ut11cMrVkt4XAA0oLiURC4UHI8iDpi4oJobXFRjCRRAJKTBDpW8VwEVGIwcjFd0OCSRHKMxEoCbSYmm7YsL1QdrdAZ/Yy40OnWNqZ7QzyPc75zv/79uw5/4tw+/ZdbOI14E0gBpTr354A94G/gKSdYC6LvAjQCrzvdruWeb1ePB4Rh8MBgKqqKEoOWZbJ5wv3gAvAGStmhHlOwA98DXRUV1d5/P6FeDxiyYCKkiOdzjIyMqYAPwJfAemXMbABOBcKBcM1NVUIglBSeDY0TWN4eIzR0Ucp4EOgx4jnMNnfAfwhSZFwOByyLQ4gCALhcAhJioSBy8BOqwY6Kyv9p2Kx150+X4UlMVVVOX/+At3d385Z8/kqiMXqnJWV/h+AzvkMbASOBYMBvF6vJXFZlmltbWPfvv309fUZcrxeD8FgAOCYrmFowA+ck6SI0+v1WBIHOHr0GFeu/AnA9u3bTXlerwdJijiBX3WtOQYOhULBGqvHDlO//vTpMwDs2vUJzc3rS/J9vgpCoWCYqZcF/PcKJOD+ihUN4nwXbnDwH1S1SF1dHU6nkyNHvqOpqZFoNMrDhykqKwPU1taa7tc0jTt3+nPAEiA5nYh2VFdXlRTv7b1Od3c3fX13UFWVhoZ64vE4tbUSZ8/+Qm/vdSYnJxFFkbVr3+LAgS+JxWJz4giCQHV1lTgyMvYRcHD6BO7W1y9ZapZkrl69xo4drRSLxZKnMxOxWIxLl37H45l7nxQlx8DAYD+w1AEsdrtdpuJPnz5l//4vbImXlZXR1XUYUTSO6fGIuN2uBmCxA1hZ6sldu9ZLMmmrvtDR0c6aNatLJjBdc6UDiJXK7zdu3LAlDrB586Z5ObpmvQOomK5qRpiYmLAlLgiCpSSma5abK+sIBAK2DGiaRn//gGW+A5hQVdWUsHz5clsGAI4fP0GhUCjJ0TWfOID7ipIzJTY1NVquC9O4desW7e07SSQSphxdc8AB3JRl2ZS4aNEi1q1725YBgJ6enuc1wgi65k0H8CCfL9wrdQqdnR/bNhAIBNi69V3DNUXJkc8XBoAH05fwYjqdNQ22atUqWlpabBnYu/dzfD6f4Vomk4WpvvF5Nfx5ZGQsr2maacBDhw4SjUYticfjcbZt+8BwTW/VcsBPAM7Ozl0AGaBG01hdXl5muFEURTZu3MDg4CAAzc3r2bPnM9ra2mhsbESWZVwuF1u2xOnqOozLZdxwDw+P8ezZ5EngN3ixKfUD9yQpYqsnsINMZoJEIpkClqF3yjMTURrYlkgki7KsvHJxWVZIJJJFpjrk52367EzYA+x+9Ogxr9KELCuMjz8G2M2s9tzojzo5Pp5Wx8fTJyQpYrkzNkM2O8HQULIIfAqcnL1uVgtOAe8kEslUKjVKqddhBk3TSKVGGRpKpoBNwPdGPCuj2TdAe01NlejzWRvNMpnszKd2gJcczWYiArQD77ndroYFC7yI4ovDaS6XY3JSJp8v9AMXdfH/PZwaYTHwBhAFFurfssDfTI3nD+wE+xfxCKNpO+N8NAAAAABJRU5ErkJggg==)
    
    **Uber**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAMAAABEpIrGAAAAVFBMVEVHcEwAAAAAAAD09PQAAAAAAAAAAAAAAAAAAAAAAADKyspTU1ORkZFdXV3o6OhLS0svLy/t7e06OjrW1tajo6McHBwRERHd3d2Dg4N7e3v///+3t7dIZjuNAAAACnRSTlMAAf//WTKz9uHQX/4MSwAAAOdJREFUOI2lk9tuwyAMholJQ8rBnBJI2vd/zzlM2rpK4ErzDQZ//rEsWwghpnlZlYI/ptS6zJNodrtDx+63Fl97cYCViKmb3zQmMY/iALNYxsAiBhW0KoQaA4oHxnGAj4DdXJ7ZfegATl6eNNrywP79WjqArjGSyoEYHWgt/TsgXTF4GjT0FHJO5R3Y6LB6q9Ye8szHzxf+cXkP34o88zNbMp/P3z5ISt0IkAECWhcTCcGLAhiMqKN/6lojsRYrbqBfFKhVHlIJJbh0XZOhI+yft3oM/H8e2JFjh5Yde3Zx2NXjl5dZ/y9JphAjxeVImQAAAABJRU5ErkJggg==)
    
    **Groww**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAE7ElEQVRYhbWXXWxURRTHf2fu3bu73W1LqRAMlGAtgpGYlAcf/YAS0caqWeEBDSbGWD4SMEYeiL4SjRpDYmKUBB/RWKOIEj+QhgQRNXxUPkQJLRQIGKBN2717d/fuvTM+3FJaStsF2vM4c+b//8+ZmXPOCGXaqrWmphjSYmC5CI3AHCA1OO0BF0F3GK1+sDS72rZLbzm4MpFDptXMN+jNglphO6QxoDUYDcYMggiIAqUixMDHxfClsnmn7WM5c4cCjGTW6K22rTbEHPCLoMMbpGMCCigLnDiUfAhLbP3qU94AueXKWwp4bo2ZZxn2piqpL+QhDMYnHcssGxJJyGXpDIWmnZ/IuQkFPL/GLFKGjkQFVsEDwIwltAwzgCRSUMgRBMZf/O22+PExBTy7ztTZIV3xJHYxf1fEo4TEk0gxT6gM9W3b5Pz1CTXcyw5oT6YmnRxAinlMMoWlhXYwQ9hDAjKt5r1UNQ35XLRgEsmHRORzkKri/hde5f2hQYAVr5m5yqHbGAiDSd/9MAkYW5BYCbTHvB07pFsBaOGtmDN026eKHBUgzjU4lfFp277nbQBpecVUxmLmkmVL+k6fWznklg9xF45mznJiZScUtIsXzrYdhxY7JumgNHXkdhFiefhj9WlON/8LfhISlWl87xnbGJqNmTjD3TF5HqwS/Np6knOPd0E+AaGAo1HKNNvAYq2nhjwWJTL2bezg0iMXwEuAFsCAH6CRxTZQZ8oUYPlROLUNQWL4ax5N7rgQxGHf64e4uugy5G5aEASAqVNARTnhj2ehmArpeuIy1+pd4lmwC2P4DkAxbdiz+SBXF/0HueRotdqASIU9LquAhJDsg8sPuRxYd5j8jH4IHer3zeXhbxaSvqYopqOoACQGIDszYO+mg+Rm94ObGJ8i02pcEVKjojB4e50c/P3kJQ6/fAyUAS8GloaET2wgyaKdC1jQPge7AFYAVxoKtG86SLHWAzc+NrMSCE1eMq3mlLJYqMOR804OjII/V5+ia2kn+DEoWiPTVDyEWInqM/fw4E/1lJIBf2X+IaguQNYZP6U5MSiWTtsIR5QaJsBAcgCyM0P2rz9E7wNXoqcTyGjAogW+Rf99ffy+/lA05lsTkwM4NqoQHLGNZrcIq1CgSpDshwuN/RxYexh/Wh7c5NCR3NIMkLej4zFEl20i8sHeTaN320HAd6LIJgIqJQvHWi7Q8eKJCGy8M7zZ9G2UkIQDrucSBLvUrs8kG/P4wqqA/etO0PFSB/gKcrHyAW/XVBpl1OfUPj2gAFIuW75/8yTdj14GL2EoWVNVEw3JOOChQ7bAYEOy/Wvp7q07+yHcC1pNDTWAIFg1qKz3ATVLu6OhIW1GyP5yhsraetyeqWhKDOlaIdvTSdWyhuuDN3pCEUPoLyHbo0lPG6wYk0k+TXB7QgKWDJ8Y0ZRS09xNII24fSHpWhmMwd0IMQiQrhXcvhBxGpm+7PxwBzVqyfSmY9h2A9meLlKzIOHc+VEkHCE1C9zeLkI9n/Rjx292GRvcGFEDe7bqqtQGqADtQsGPPobjmVLRO1dpwEMNeB/pqqaNyG18zUZY/8/zlchmDSuprEhdbyYIgqikQlRYbBscO4J0PVcJbTov7zKj6fR48OWHt/+36Ui+RQlPaaOj77mSKE8b42G4qIwc1Vr/iNK7qF5e1vf8fw30Ay+dTvE1AAAAAElFTkSuQmCC)
    
    **Paytm**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAADqklEQVRYhb2XMWwbZRTHf98lbuvBqe0BCZ/cnLARbdMqtpRkIKpqWaKQLXQoDCDSpYIitUlgQQKsRB2QGkRcCXc0JRtLmoVALKgTiaUeeoOreoilK5GTzXZsqEsb+xgO7By203Nw8pdO373vu/f+//fefffpBADLFQWhxxG1ALpwctAQ4i41McWYXRMsVxSk6oNDITaJoEhNCkoI/ZtDJwfQcSL0uOCnP3WrPiGXxHl3DyF3D4pdoNgFAMUdHbWko5Zr3MntoJZr1gIKipYEhFwSEf8RQm7JUtxkvsbM+jOShRcL2VOA0yaI+GxM9vdaIv4v5h8/Zya7Q/F5+xzbClDsgsXgUQIOa1m3g1qu8faDv9AqrUW0jO60dYccIOCQWAwexWkT1gVEfLaukO8WEfG1bmMTS8gl7bvne2Gy39byJW6aifiPdJ28Httn21tAwCFZ3mr7Qcjd0xTfZE3I+y99cce4XijC1WOyTYyDu168UrlCOrMFgFd2ctxhJ53ZMt2fOfky6cwWz3yvMJWBiB+UY4a/9hQCDtAqEHI3OM67Jci2ERDoa2yVH395yPXPf6Cv7xijQ37Gwqe5GUuwsVngyvvnWP41zacfvcHc7QRn5z5DLUFUM3zVklENZ68x3htpiFDse7TA2Wveq17ZxZX3zrFdfsL2HxVGR3z16gBsbBYAiJ81no/4jXFSMQjnT4Fih8eVRsx/z496BcT0Fw3r4demxY1cgblYgnfGh7gZSzAWPgPAW+EBfktlmYsl8MouOsVuTlMLtFweRW40zCu7WIx/iNfj4tXX0/X54w47o8M+fvfk2S4/7Yi8WK6YbFMLtH9KCnBCdjEWHsDrMTK8deMSAnh3fKie9QnZza0blwCYkI1yj78Eg33G2G835vvtDQ71Uc4kQIjT0/VTInL1ApGP3+woo04RXVhj6qulum2qwGoq2+TQbdxZSplsk4BkKkvyAEUk76+jPtpsLwBg9tufD0zAbGylaa5JQDKVJfr9WtfJowtrLavb8uSZia2gZjZbLe0LaibHTIvs2woolitcvBbvigg1k+Pite8oliot19uevVouT3gi9r/aEV1YI3z5Nlou3/YZ03egHULDPr68eoHQiN8ScfL+OrOxFUs7SoiB6QI6lv6MAic9fDA+zOBrHgKnZJwO4xOn5fJouTyrqSyrHW5lIQY+uYeuhyx7dBX6kqRXq5cRFA+dW1DUa/qkRGZe06u1IHD3sIgRIqlXa0Ey89rfAkNGhhJTtQMAAAAASUVORK5CYII=)
    
    **Flipkart**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAMAAABEpIrGAAAAw1BMVEVHcEzbrSn35EPd1X7o0FP010XDlyHv3l7xvDDftDDcrS2OezjvyjPzwTAAAD0jbqr15k/15UmUch/U07tFNhL31zkAbr4Hb7v64TH55DD82TL45y/63zD63TEAg+TjsSf91DITid8PhNn1yi/9yTL9zTHqty/wxi782zDxwS8Fgdnqxi0FfdTovy35xTEIecz/3B3wxBD55S+PoZUAdtK1qmtxlqb450F8qLTrwR5NkMDVvVT/4iCsupLlz1Xu2UVHcEw4vXyjAAAAQXRSTlMA/O4cPnlJS/5vlBKy6QphtsskEhfggoH/////////////////////////////////////////////////////AEKm9AEAAAG/SURBVDiNdZOLcqowFEWjRRGttY/7sBRDJKQoIoq8odb//6t7ToKCervGGcZZm32OEAnp8qbpuvZGfkB7zj8k+bP+H633Pzrkg1v/0rGHw+H9vf/Q1Q951yly7ca3SjGft5vkdw6x5ucpL7eqCVj9Zv87Z30BFqB+S//KAV+nY1EUpwUgC6yOQxYFpXRJs71pmljx2Dq8Z3Fa0qWEQ+A3BBYXhaz20kNHFWGCkMlFruC7uTrK+9MoijYbZpoa0S5OIgtoXW43gMeYQfRWIt/oq2iLAc/jbED0K78/UsehcYkB8FwMiHZWioIuHZriAhvwnBtkopqPBW5Oqe8AcK1lAXfhlTKTIeK7kFJBU08FJvCgpDdZHfsAWrhQ28aAO4UHZTDG6zSO4wyoMFRlWWrb2xACY3wZnDFvW5bwKaM48B0/toHPzzUPcQJWCEhIoioIgiTtoR+NQvdRHYipEGItiXwIBL1zIGxO1KsrhCsDdQJ+pyaM1uHwfCaHLhACabLb7TK7KTDaY90k3BgCSdwUdDxMGWFEVBhIVcGQXDMOIRDAhESuOH66+3M+GdMaV4Ade+Nfd1plZrO/f2bDK/sPkkNkoehHrzwAAAAASUVORK5CYII=)
    
    **Zomato**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAMAAABEpIrGAAAAQlBMVEXMIC7vxcfMEiTabXTJAA/MGyrSPEfMIC7MIC7////lmp/UR1HprbD66uvPKzjYXmb44ePfhYr01tjceH7+9vf1E3coc6mSAAAAFnRSTlP4////////Xv/////////////////4qNSRRwAAAK5JREFUOI3tk90OwyAIhQXBefxpq+37P+uYLtmdvdrVhkgg54uiCe7h4sLcwy11I250I/7AGtAVYKJk/QBixsNniFkETURlAnLg6ifg6SB4lARQB0JFlQFoIGSc3eRkq3CjekKo7vA8TkjYMvigWhrEEE89QSp5WCMusgew2w5IdAVLy0UF5qBxhQazjdumOVqS5VWqD+L3d5NqFiOrvU5nmCXrl7/614Db4b0b/ycQAx+FSTe2PwAAAABJRU5ErkJggg==)
    
    **⚡32**
    
    Solved
    
    Medium
    
    Topics
    
    !premium lock icon
    
    Companies
    
    Hint
    
    Given a binary tree `root`, a node *X* in the tree is named **good** if in the path from root to *X* there are no nodes with a value *greater than* X.
    
    Return the number of **good** nodes in the binary tree.
    
    **Example 1:**
    
    ![](https://assets.leetcode.com/uploads/2020/04/02/test_sample_1.png)
    
    ```
    Input: root = [3,1,4,3,null,1,5]
    Output: 4
    Explanation: Nodes in blue are good.
    Root Node (3) is always a good node.
    Node 4 -> (3,4) is the maximum value in the path starting from the root.
    Node 5 -> (3,4,5) is the maximum value in the path
    Node 3 -> (3,1,3) is the maximum value in the path.
    ```
    
    **Example 2:**
    
    ![](https://assets.leetcode.com/uploads/2020/04/02/test_sample_2.png)
    
    ```
    Input: root = [3,3,null,4,2]
    Output: 3
    Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
    ```
    
    **Example 3:**
    
    ```
    Input: root = [1]
    Output: 1
    Explanation: Root is considered as good.
    ```
    
    **Constraints:**
    
    - The number of nodes in the binary tree is in the range `[1, 10^5]`.
    - Each node's value is between `[-10^4, 10^4]`.

*/