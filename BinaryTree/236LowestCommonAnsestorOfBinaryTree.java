
    


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    
    class Solution {
    
        public TreeNode lowestCommonAncestor(
                TreeNode root, TreeNode p, TreeNode q) {
    
            // Base case: nothing found
            if (root == null) {
                return null;
            }
    
            // If current node is p or q, return it
            if (root == p || root == q) {
                return root;
            }
    
            // Search both subtrees
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
    
            // Targets found in opposite subtrees
            if (left != null && right != null) {
                return root;
            }
    
            // Otherwise propagate whichever result was found
            return left != null ? left : right;
        }
    }
    /*
    import java.util.*;
    
    class Solution {
    
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    
            // Store the paths from root to p and root to q
            List<TreeNode> pAncestors = new ArrayList<>();
            List<TreeNode> qAncestors = new ArrayList<>();
    
            // Find the path from root to p
            findPath(root, p, new ArrayList<>(), pAncestors);
    
            // Find the path from root to q
            findPath(root, q, new ArrayList<>(), qAncestors);
    
            // Store all ancestors of p in a HashSet
            Set<TreeNode> pSet = new HashSet<>(pAncestors);
    
            // Traverse q's path backwards: q -> root
            for (int i = qAncestors.size() - 1; i >= 0; i--) {
    
                TreeNode current = qAncestors.get(i);
    
                // First common node is the lowest common ancestor
                if (pSet.contains(current)) {
                    return current;
                }
            }
    
            return null;
        }
    
        private boolean findPath(
                TreeNode root,
                TreeNode target,
                List<TreeNode> currentPath,
                List<TreeNode> resultPath) {
    
            if (root == null) {
                return false;
            }
    
            // Add current node to path
            currentPath.add(root);
    
            // Target found
            if (root == target) {
                resultPath.addAll(currentPath);
                return true;
            }
    
            // Search left or right subtree
            if (findPath(root.left, target, currentPath, resultPath) ||
                findPath(root.right, target, currentPath, resultPath)) {
                return true;
            }
    
            // Backtrack if target was not found here
            currentPath.remove(currentPath.size() - 1);
    
            return false;
        }
    }
    */
    ```
    

/*

- Q
    
    # **36. Lowest Common Ancestor of a Binary Tree**
    
    **Uber**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAMAAABEpIrGAAAAVFBMVEVHcEwAAAAAAAD09PQAAAAAAAAAAAAAAAAAAAAAAADKyspTU1ORkZFdXV3o6OhLS0svLy/t7e06OjrW1tajo6McHBwRERHd3d2Dg4N7e3v///+3t7dIZjuNAAAACnRSTlMAAf//WTKz9uHQX/4MSwAAAOdJREFUOI2lk9tuwyAMholJQ8rBnBJI2vd/zzlM2rpK4ErzDQZ//rEsWwghpnlZlYI/ptS6zJNodrtDx+63Fl97cYCViKmb3zQmMY/iALNYxsAiBhW0KoQaA4oHxnGAj4DdXJ7ZfegATl6eNNrywP79WjqArjGSyoEYHWgt/TsgXTF4GjT0FHJO5R3Y6LB6q9Ye8szHzxf+cXkP34o88zNbMp/P3z5ISt0IkAECWhcTCcGLAhiMqKN/6lojsRYrbqBfFKhVHlIJJbh0XZOhI+yft3oM/H8e2JFjh5Yde3Zx2NXjl5dZ/y9JphAjxeVImQAAAABJRU5ErkJggg==)
    
    **Bloomberg**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAEjUlEQVRYhbWXX0xTdxTHP7e0BS3eysgFY9Za2MgIPkjIFqeLPkhIfHBmT5KQPcynEeODCe97GiGThBeDLyabPhND9Mlggg+LREtcJIaJA6Rhe2kbGm+hBW7be/bwK5WW/rnV7ZuctPeXc885v3PO79zvT8MZGoEvgJPAhfzv58AnQANgAsvAAvAUeA6sAdsO7VdEE9AH3AKWgB1AaogFLAJ3gfPA4Q9xrAEBYAz4G8g4cFwqOSAK/AKcyNt0hIZ85DP53dTruFSywGPgTN52TeffAq/zO/hY5/uz8TpvuygIreT/18CvQPfeos/n49KlSxw/frxi1CJCIpFgfX2dV69ekUwmyWQy5VSXgB+B3/OBFeEEKlVFOzcMQ2ZmZmRnZ6eibG9vy9bWliQSCZmbm5Pr169LS0tLpUzMoPqrCIdRzZItfckwDHny5InUg83NTRkfHxe/31/plIyhThjufABfAj/goEnS6TSLi4ukUqnCWnNzM8FgkLa2tsLz8PAw4XCY+/fvY9v2fhMe4HtgCvgD4BDqzJZtutIMLC0tyblz58QwjIJ0dHTIwMCAPHr0SLLZbEH33r174vP5ymUhg5otjW6gA/gKcNXaPUAul2NjY4N4PF5Yi8fjRCIRTNOkt7eX9vZ2ADo7O/F4POXMuIEBoNsFnAa6nDivBhHh7du3mKZZFKzIgWbfQwjocQHfoOry0eju7sYwjMJzOBxmd3e3knojcMENnKrHSUNDA7quc/To0cKa1+vl7Nmz3LhxA13XERGWl5d58OBBtQAATrqpM/3BYJDbt2+TTqcLARmGQVtbG83NzViWxYsXLxgbG+PZs2fVSsCe76pjtJ45YNu2LCwsyODgoOi6LpqmOflOHBw+HxqAiIhlWRKLxeTOnTvS1dVVMwg3kADed04NrK6uMjExQSwWK6z5/X6CwSD9/f309fVhGAZXr17F5/Nx7do13r17V8mcCTBXTwbC4bCEQqEiHZfLJV6vV9rb22VyclJs2xYREdM0ZWhoqFoG5l0o9vJRsG0by7KIRqNMTU0RjUYBOHLkCBcvXsTtdld6dcEFzAJVz0o9ME2Tra0tADRNo7W1Fa/XW041Azx1AX8Ckf/CuaZpBAKBomGUTqexLKuc+jLw3I0iCY+Bz3j/dawbuq7T29vLyMgIuq4DsLu7y8uXL8lms6XqNjAPrLlR6f8N+A74tJajUCjE6OgoyWSysNbU1MSxY8fo6ekhEAigaYpoRSIRpqeny5nZQDGvAm1vQpGEAyS03BzI5XJFstf1+wfS2tqaXLlyRTweT7nhc5MydD2AoksHKNns7OwBp6WSyWQklUpJPB6X6elp6e/vL+c8hyr3iT2n+2v+D/BzPpACKU2n0zx8+JA3b95ULU0ymWR1dZX5+XlWVlZIpVKlTAjgL+AnYL2SnQbgMv8fLb+Mw7vBGVSqqn4nHIqFKu15J873oKHqdBOIfWA2Mqhr3RiqrI6vZvtxOB/5XdTIdnJV20HNlluoi21TrZ06wSEUeT2NonCnUGTCj8pOAljJBzmLmq5LOBjx/wI2h34g730GlwAAAABJRU5ErkJggg==)
    
    **Apple**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAEiklEQVRYha2XW2wUVRzGf7OX2SVt2d1ut11cMrVkt4XAA0oLiURC4UHI8iDpi4oJobXFRjCRRAJKTBDpW8VwEVGIwcjFd0OCSRHKMxEoCbSYmm7YsL1QdrdAZ/Yy40OnWNqZ7QzyPc75zv/79uw5/4tw+/ZdbOI14E0gBpTr354A94G/gKSdYC6LvAjQCrzvdruWeb1ePB4Rh8MBgKqqKEoOWZbJ5wv3gAvAGStmhHlOwA98DXRUV1d5/P6FeDxiyYCKkiOdzjIyMqYAPwJfAemXMbABOBcKBcM1NVUIglBSeDY0TWN4eIzR0Ucp4EOgx4jnMNnfAfwhSZFwOByyLQ4gCALhcAhJioSBy8BOqwY6Kyv9p2Kx150+X4UlMVVVOX/+At3d385Z8/kqiMXqnJWV/h+AzvkMbASOBYMBvF6vJXFZlmltbWPfvv309fUZcrxeD8FgAOCYrmFowA+ck6SI0+v1WBIHOHr0GFeu/AnA9u3bTXlerwdJijiBX3WtOQYOhULBGqvHDlO//vTpMwDs2vUJzc3rS/J9vgpCoWCYqZcF/PcKJOD+ihUN4nwXbnDwH1S1SF1dHU6nkyNHvqOpqZFoNMrDhykqKwPU1taa7tc0jTt3+nPAEiA5nYh2VFdXlRTv7b1Od3c3fX13UFWVhoZ64vE4tbUSZ8/+Qm/vdSYnJxFFkbVr3+LAgS+JxWJz4giCQHV1lTgyMvYRcHD6BO7W1y9ZapZkrl69xo4drRSLxZKnMxOxWIxLl37H45l7nxQlx8DAYD+w1AEsdrtdpuJPnz5l//4vbImXlZXR1XUYUTSO6fGIuN2uBmCxA1hZ6sldu9ZLMmmrvtDR0c6aNatLJjBdc6UDiJXK7zdu3LAlDrB586Z5ObpmvQOomK5qRpiYmLAlLgiCpSSma5abK+sIBAK2DGiaRn//gGW+A5hQVdWUsHz5clsGAI4fP0GhUCjJ0TWfOID7ipIzJTY1NVquC9O4desW7e07SSQSphxdc8AB3JRl2ZS4aNEi1q1725YBgJ6enuc1wgi65k0H8CCfL9wrdQqdnR/bNhAIBNi69V3DNUXJkc8XBoAH05fwYjqdNQ22atUqWlpabBnYu/dzfD6f4Vomk4WpvvF5Nfx5ZGQsr2maacBDhw4SjUYticfjcbZt+8BwTW/VcsBPAM7Ozl0AGaBG01hdXl5muFEURTZu3MDg4CAAzc3r2bPnM9ra2mhsbESWZVwuF1u2xOnqOozLZdxwDw+P8ezZ5EngN3ixKfUD9yQpYqsnsINMZoJEIpkClqF3yjMTURrYlkgki7KsvHJxWVZIJJJFpjrk52367EzYA+x+9Ogxr9KELCuMjz8G2M2s9tzojzo5Pp5Wx8fTJyQpYrkzNkM2O8HQULIIfAqcnL1uVgtOAe8kEslUKjVKqddhBk3TSKVGGRpKpoBNwPdGPCuj2TdAe01NlejzWRvNMpnszKd2gJcczWYiArQD77ndroYFC7yI4ovDaS6XY3JSJp8v9AMXdfH/PZwaYTHwBhAFFurfssDfTI3nD+wE+xfxCKNpO+N8NAAAAABJRU5ErkJggg==)
    
    **PhonePe**
    
    [](data:image/png;base64,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)
    
    **Goldman Sachs**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAMAAABEpIrGAAAAaVBMVEX///8AAAANDQ2NjY3n5+csLCx9fX21tbX7+/vW1tZYWFiQkJB5eXnHx8ff39/BwcGvr69NTU3x8fE/Pz8hISHPz8+Xl5cYGBiGhoampqZjY2M7Ozvt7e25ublSUlKOjo5vb2+enp5GRkYqLTKpAAAA1klEQVQ4je2QWxaCMAxEZ6BAEZGXIIqouP9FmkA/WnQJ5idz0tt2JsC/gjIpm4RMgTZldyYZnmdkDwwcYXixQL8DcvKg/TLiwELVEgIdedV+PYK8qbIBYBixVNHmEJmpLEMHEU9OT6LHfYRYhsbpilHExIRAKsAdpp7nuZQoQrD+BcSS/iG/U5HhGwDqLa19KHHygMF5kHV066CQwdMDKpeil75NXuTRA6wcVA7YXpZVF76JkYylzQKse1SjvgegIVtgNac3bcJlt6v6zYmuuom3HP/y6wOtGgc/XzK7ggAAAABJRU5ErkJggg==)
    
    **Flipkart**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAMAAABEpIrGAAAAw1BMVEVHcEzbrSn35EPd1X7o0FP010XDlyHv3l7xvDDftDDcrS2OezjvyjPzwTAAAD0jbqr15k/15UmUch/U07tFNhL31zkAbr4Hb7v64TH55DD82TL45y/63zD63TEAg+TjsSf91DITid8PhNn1yi/9yTL9zTHqty/wxi782zDxwS8Fgdnqxi0FfdTovy35xTEIecz/3B3wxBD55S+PoZUAdtK1qmtxlqb450F8qLTrwR5NkMDVvVT/4iCsupLlz1Xu2UVHcEw4vXyjAAAAQXRSTlMA/O4cPnlJS/5vlBKy6QphtsskEhfggoH/////////////////////////////////////////////////////AEKm9AEAAAG/SURBVDiNdZOLcqowFEWjRRGttY/7sBRDJKQoIoq8odb//6t7ToKCervGGcZZm32OEAnp8qbpuvZGfkB7zj8k+bP+H633Pzrkg1v/0rGHw+H9vf/Q1Q951yly7ca3SjGft5vkdw6x5ucpL7eqCVj9Zv87Z30BFqB+S//KAV+nY1EUpwUgC6yOQxYFpXRJs71pmljx2Dq8Z3Fa0qWEQ+A3BBYXhaz20kNHFWGCkMlFruC7uTrK+9MoijYbZpoa0S5OIgtoXW43gMeYQfRWIt/oq2iLAc/jbED0K78/UsehcYkB8FwMiHZWioIuHZriAhvwnBtkopqPBW5Oqe8AcK1lAXfhlTKTIeK7kFJBU08FJvCgpDdZHfsAWrhQ28aAO4UHZTDG6zSO4wyoMFRlWWrb2xACY3wZnDFvW5bwKaM48B0/toHPzzUPcQJWCEhIoioIgiTtoR+NQvdRHYipEGItiXwIBL1zIGxO1KsrhCsDdQJ+pyaM1uHwfCaHLhACabLb7TK7KTDaY90k3BgCSdwUdDxMGWFEVBhIVcGQXDMOIRDAhESuOH66+3M+GdMaV4Ade+Nfd1plZrO/f2bDK/sPkkNkoehHrzwAAAAASUVORK5CYII=)
    
    **Paytm**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAADqklEQVRYhb2XMWwbZRTHf98lbuvBqe0BCZ/cnLARbdMqtpRkIKpqWaKQLXQoDCDSpYIitUlgQQKsRB2QGkRcCXc0JRtLmoVALKgTiaUeeoOreoilK5GTzXZsqEsb+xgO7By203Nw8pdO373vu/f+//fefffpBADLFQWhxxG1ALpwctAQ4i41McWYXRMsVxSk6oNDITaJoEhNCkoI/ZtDJwfQcSL0uOCnP3WrPiGXxHl3DyF3D4pdoNgFAMUdHbWko5Zr3MntoJZr1gIKipYEhFwSEf8RQm7JUtxkvsbM+jOShRcL2VOA0yaI+GxM9vdaIv4v5h8/Zya7Q/F5+xzbClDsgsXgUQIOa1m3g1qu8faDv9AqrUW0jO60dYccIOCQWAwexWkT1gVEfLaukO8WEfG1bmMTS8gl7bvne2Gy39byJW6aifiPdJ28Httn21tAwCFZ3mr7Qcjd0xTfZE3I+y99cce4XijC1WOyTYyDu168UrlCOrMFgFd2ctxhJ53ZMt2fOfky6cwWz3yvMJWBiB+UY4a/9hQCDtAqEHI3OM67Jci2ERDoa2yVH395yPXPf6Cv7xijQ37Gwqe5GUuwsVngyvvnWP41zacfvcHc7QRn5z5DLUFUM3zVklENZ68x3htpiFDse7TA2Wveq17ZxZX3zrFdfsL2HxVGR3z16gBsbBYAiJ81no/4jXFSMQjnT4Fih8eVRsx/z496BcT0Fw3r4demxY1cgblYgnfGh7gZSzAWPgPAW+EBfktlmYsl8MouOsVuTlMLtFweRW40zCu7WIx/iNfj4tXX0/X54w47o8M+fvfk2S4/7Yi8WK6YbFMLtH9KCnBCdjEWHsDrMTK8deMSAnh3fKie9QnZza0blwCYkI1yj78Eg33G2G835vvtDQ71Uc4kQIjT0/VTInL1ApGP3+woo04RXVhj6qulum2qwGoq2+TQbdxZSplsk4BkKkvyAEUk76+jPtpsLwBg9tufD0zAbGylaa5JQDKVJfr9WtfJowtrLavb8uSZia2gZjZbLe0LaibHTIvs2woolitcvBbvigg1k+Pite8oliot19uevVouT3gi9r/aEV1YI3z5Nlou3/YZ03egHULDPr68eoHQiN8ScfL+OrOxFUs7SoiB6QI6lv6MAic9fDA+zOBrHgKnZJwO4xOn5fJouTyrqSyrHW5lIQY+uYeuhyx7dBX6kqRXq5cRFA+dW1DUa/qkRGZe06u1IHD3sIgRIqlXa0Ey89rfAkNGhhJTtQMAAAAASUVORK5CYII=)
    
    **Adobe**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAACrElEQVRYhcWXzU8TQRiHn9nudmtaYlFAA9FoDJFPwS8OmCiJRA9gTA98JChBwBj+Cy8evHj0ICiKEjCif4Q3RC3a2AOJFw0iYABpwba0Ox6qtQv0C0v7Jpvded+Z+T07M/vOjuCPzdmpsWgMC6iToAmyazJ62wCmw2F6Sv14AQTAjwJ6pYVBQMmybiIzjAj9B3wMizk7NarGhxyKAyDB2AhTLRacTAk4k0vxOIhJseAkJEDLBwAQUsifOBKsSrZXeyYmyPHC2852BGC/fZeiZWm67Hfu7QhALDr/5og0G+g6hZ4vKMUlJr/8ucJSZRny13pGABmPgPVq2xZxALHXie5qz7S7zAFsfQOJY72JY1kBUKtPoDU0Jo6fbkA9mVlOywhg89uHP31Eriyb6/Tc2h0A4ShAb+sy+QIP7xN8MWry6e1dCGdh9gH0zm6EoyBWlutrBCfGCDx+YAa17cHWcT37ALYb5qENvhxH+lYJez2E370x1+0bAJFejk0LQGs8j1pVa/IFRgb/PT8dMsUs5RVo5y5kD2DL4vN6CL+djJWDE2NIv8/cJs1PMiWAUlSMtcVl8m2ed7nmJ/jqucmnt7pQDpb+P4Ct+yZC1+PUJHJxHq2pGa2pGUv58SjUpmlA07Bd600JkHwvUBQK3Z+xHD6SsEr4/RQrFxsAcL52o9bWx2LG7FeW6o5CJJJYIhmd9XJrUnEA9dRZLMfKAQiODps7LzuE9VJL0vZJAZLl/XjTXR0ABMZHtuyGqfpQE0aEIDgyRPDZo5QAxvx3ILolr3ZeQdm3Py5oRHOC3H6mM/4fyLYp+VSXRNfARh4ZQgownUcAt/jmoEpT8ZDro5nEwKBSKfXjNSL0SzByKS4Mekp8zMT2zFkHFZrKEwH1Eqy7dDwPAW4idJf4mAH4DWN90QFmwa7KAAAAAElFTkSuQmCC)
    
    **⚡54**
    
    Solved
    
    Medium
    
    Topics
    
    !premium lock icon
    
    Companies
    
    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
    
    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes `p` and `q` as the lowest node in `T` that has both `p` and `q` as descendants (where we allow **a node to be a descendant of itself**).”
    
    **Example 1:**
    
    ![](https://assets.leetcode.com/uploads/2018/12/14/binarytree.png)
    
    ```
    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    Output: 3
    Explanation: The LCA of nodes 5 and 1 is 3.
    ```
    
    **Example 2:**
    
    ![](https://assets.leetcode.com/uploads/2018/12/14/binarytree.png)
    
    ```
    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    Output: 5
    Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
    ```
    
    **Example 3:**
    
    ```
    Input: root = [1,2], p = 1, q = 2
    Output: 1
    ```
    
    **Constraints:**
    
    - The number of nodes in the tree is in the range `[2, 105]`.
    - `109 <= Node.val <= 109`
    - All `Node.val` are **nique**.
    - `p != q`
    - `p` and `q` will exist in the tree.

        https://www.youtube.com/watch?v=Oi3_06ultic
    
*/