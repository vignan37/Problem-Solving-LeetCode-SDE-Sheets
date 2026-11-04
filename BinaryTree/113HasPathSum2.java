- S
    
    ```java
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> answer = new ArrayList<>();
            buildPathAnswer(root, targetSum, new ArrayList<>(), answer);
            return answer;
        }
    
        private void buildPathAnswer(
            TreeNode root,
            int targetSum,
            List<Integer> path,
            List<List<Integer>> answer
        ) {
            if (root == null) return;
    
            // 1. Choose: add current node to path
            path.add(root.val);
    
            // 2. Check: have we reached a leaf?
            if (root.left == null && root.right == null) {
                if (targetSum == root.val) {
                    // Save a copy; don't store the shared path itself
                    answer.add(new ArrayList<>(path));
                }
            } else {
                // 3. Explore: subtract current value and visit children
                buildPathAnswer(root.left, targetSum - root.val, path, answer);
                buildPathAnswer(root.right, targetSum - root.val, path, answer);
            }
    
            // 4. Undo: remove current node before returning
            path.remove(path.size() - 1);
        }
    }
    
    /*
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> answer = new ArrayList<>();
            List<Integer> pathList = new ArrayList<>();
    
            // Start building paths from the root
            buildPathAnswer(root, targetSum, pathList, answer);
    
            return answer;
        }
    
        public static void buildPathAnswer(
            TreeNode root,
            int targetSum,
            List<Integer> pathList,
            List<List<Integer>> answer
        ) {
            // Base case: empty node
            if (root == null) {
                return;
            }
    
            // Create a copy so each recursive branch has its own path
            List<Integer> pathList2 = new ArrayList<>(pathList);
            pathList2.add(root.val);
    
            // Check only when we reach a leaf node
            if (root.left == null && root.right == null) {
                if (targetSum == root.val) {
                    answer.add(pathList2);
                }
                return;
            }
    
            // Explore left and right with the remaining target sum
            buildPathAnswer(root.left, targetSum - root.val, pathList2, answer);
            buildPathAnswer(root.right, targetSum - root.val, pathList2, answer);
        }
    }
    */
    ```
    

/*

- Q
    
    # **113. Path Sum II**
    
    **Netflix**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAMAAABEpIrGAAAASFBMVEVHcExtAAvkCBPkCBPxCBTmBxPlCBKvBQ6RAg2pBQ7kCBPjBxLiBxSxBg6xBRCxBg/kCBPoCBOtBQ6lBA6YAw3KBhGKAgx9AQw5Oy15AAAAD3RSTlMAcYK4GpXzgH7H001mlDgTbMunAAAA0UlEQVQ4jXXTSw7DIAwEUDdfkrSl2Ibc/6ZVGLJoxXgVKU8zliVEMJ868/W5xjryOxmCA00VHBwgYqQgxnR3EGBY4skBOnYKtK050R0cHYMEAizXiEWC9oF66wjWB7G0cz+cAMcpFgqsVJC2on2gBafIp/VBdEPE6QycAFYIsPPu0D7QsiGiWB9EfywVRKdgxrEKARam+j+59oEGQUc2CgZ0eB/EVdDxMWVAdpzCKHi2CArwCBPdQWREh1JwIIKD9tDzP9i212t9X5/HMMzjfoMvsuUfHwIsu3wAAAAASUVORK5CYII=)
    
    **Goldman Sachs**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAMAAABEpIrGAAAAaVBMVEX///8AAAANDQ2NjY3n5+csLCx9fX21tbX7+/vW1tZYWFiQkJB5eXnHx8ff39/BwcGvr69NTU3x8fE/Pz8hISHPz8+Xl5cYGBiGhoampqZjY2M7Ozvt7e25ublSUlKOjo5vb2+enp5GRkYqLTKpAAAA1klEQVQ4je2QWxaCMAxEZ6BAEZGXIIqouP9FmkA/WnQJ5idz0tt2JsC/gjIpm4RMgTZldyYZnmdkDwwcYXixQL8DcvKg/TLiwELVEgIdedV+PYK8qbIBYBixVNHmEJmpLEMHEU9OT6LHfYRYhsbpilHExIRAKsAdpp7nuZQoQrD+BcSS/iG/U5HhGwDqLa19KHHygMF5kHV066CQwdMDKpeil75NXuTRA6wcVA7YXpZVF76JkYylzQKse1SjvgegIVtgNac3bcJlt6v6zYmuuom3HP/y6wOtGgc/XzK7ggAAAABJRU5ErkJggg==)
    
    **Groww**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAE7ElEQVRYhbWXXWxURRTHf2fu3bu73W1LqRAMlGAtgpGYlAcf/YAS0caqWeEBDSbGWD4SMEYeiL4SjRpDYmKUBB/RWKOIEj+QhgQRNXxUPkQJLRQIGKBN2717d/fuvTM+3FJaStsF2vM4c+b//8+ZmXPOCGXaqrWmphjSYmC5CI3AHCA1OO0BF0F3GK1+sDS72rZLbzm4MpFDptXMN+jNglphO6QxoDUYDcYMggiIAqUixMDHxfClsnmn7WM5c4cCjGTW6K22rTbEHPCLoMMbpGMCCigLnDiUfAhLbP3qU94AueXKWwp4bo2ZZxn2piqpL+QhDMYnHcssGxJJyGXpDIWmnZ/IuQkFPL/GLFKGjkQFVsEDwIwltAwzgCRSUMgRBMZf/O22+PExBTy7ztTZIV3xJHYxf1fEo4TEk0gxT6gM9W3b5Pz1CTXcyw5oT6YmnRxAinlMMoWlhXYwQ9hDAjKt5r1UNQ35XLRgEsmHRORzkKri/hde5f2hQYAVr5m5yqHbGAiDSd/9MAkYW5BYCbTHvB07pFsBaOGtmDN026eKHBUgzjU4lfFp277nbQBpecVUxmLmkmVL+k6fWznklg9xF45mznJiZScUtIsXzrYdhxY7JumgNHXkdhFiefhj9WlON/8LfhISlWl87xnbGJqNmTjD3TF5HqwS/Np6knOPd0E+AaGAo1HKNNvAYq2nhjwWJTL2bezg0iMXwEuAFsCAH6CRxTZQZ8oUYPlROLUNQWL4ax5N7rgQxGHf64e4uugy5G5aEASAqVNARTnhj2ehmArpeuIy1+pd4lmwC2P4DkAxbdiz+SBXF/0HueRotdqASIU9LquAhJDsg8sPuRxYd5j8jH4IHer3zeXhbxaSvqYopqOoACQGIDszYO+mg+Rm94ObGJ8i02pcEVKjojB4e50c/P3kJQ6/fAyUAS8GloaET2wgyaKdC1jQPge7AFYAVxoKtG86SLHWAzc+NrMSCE1eMq3mlLJYqMOR804OjII/V5+ia2kn+DEoWiPTVDyEWInqM/fw4E/1lJIBf2X+IaguQNYZP6U5MSiWTtsIR5QaJsBAcgCyM0P2rz9E7wNXoqcTyGjAogW+Rf99ffy+/lA05lsTkwM4NqoQHLGNZrcIq1CgSpDshwuN/RxYexh/Wh7c5NCR3NIMkLej4zFEl20i8sHeTaN320HAd6LIJgIqJQvHWi7Q8eKJCGy8M7zZ9G2UkIQDrucSBLvUrs8kG/P4wqqA/etO0PFSB/gKcrHyAW/XVBpl1OfUPj2gAFIuW75/8yTdj14GL2EoWVNVEw3JOOChQ7bAYEOy/Wvp7q07+yHcC1pNDTWAIFg1qKz3ATVLu6OhIW1GyP5yhsraetyeqWhKDOlaIdvTSdWyhuuDN3pCEUPoLyHbo0lPG6wYk0k+TXB7QgKWDJ8Y0ZRS09xNII24fSHpWhmMwd0IMQiQrhXcvhBxGpm+7PxwBzVqyfSmY9h2A9meLlKzIOHc+VEkHCE1C9zeLkI9n/Rjx292GRvcGFEDe7bqqtQGqADtQsGPPobjmVLRO1dpwEMNeB/pqqaNyG18zUZY/8/zlchmDSuprEhdbyYIgqikQlRYbBscO4J0PVcJbTov7zKj6fR48OWHt/+36Ui+RQlPaaOj77mSKE8b42G4qIwc1Vr/iNK7qF5e1vf8fw30Ay+dTvE1AAAAAElFTkSuQmCC)
    
    **Paytm**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAADqklEQVRYhb2XMWwbZRTHf98lbuvBqe0BCZ/cnLARbdMqtpRkIKpqWaKQLXQoDCDSpYIitUlgQQKsRB2QGkRcCXc0JRtLmoVALKgTiaUeeoOreoilK5GTzXZsqEsb+xgO7By203Nw8pdO373vu/f+//fefffpBADLFQWhxxG1ALpwctAQ4i41McWYXRMsVxSk6oNDITaJoEhNCkoI/ZtDJwfQcSL0uOCnP3WrPiGXxHl3DyF3D4pdoNgFAMUdHbWko5Zr3MntoJZr1gIKipYEhFwSEf8RQm7JUtxkvsbM+jOShRcL2VOA0yaI+GxM9vdaIv4v5h8/Zya7Q/F5+xzbClDsgsXgUQIOa1m3g1qu8faDv9AqrUW0jO60dYccIOCQWAwexWkT1gVEfLaukO8WEfG1bmMTS8gl7bvne2Gy39byJW6aifiPdJ28Httn21tAwCFZ3mr7Qcjd0xTfZE3I+y99cce4XijC1WOyTYyDu168UrlCOrMFgFd2ctxhJ53ZMt2fOfky6cwWz3yvMJWBiB+UY4a/9hQCDtAqEHI3OM67Jci2ERDoa2yVH395yPXPf6Cv7xijQ37Gwqe5GUuwsVngyvvnWP41zacfvcHc7QRn5z5DLUFUM3zVklENZ68x3htpiFDse7TA2Wveq17ZxZX3zrFdfsL2HxVGR3z16gBsbBYAiJ81no/4jXFSMQjnT4Fih8eVRsx/z496BcT0Fw3r4demxY1cgblYgnfGh7gZSzAWPgPAW+EBfktlmYsl8MouOsVuTlMLtFweRW40zCu7WIx/iNfj4tXX0/X54w47o8M+fvfk2S4/7Yi8WK6YbFMLtH9KCnBCdjEWHsDrMTK8deMSAnh3fKie9QnZza0blwCYkI1yj78Eg33G2G835vvtDQ71Uc4kQIjT0/VTInL1ApGP3+woo04RXVhj6qulum2qwGoq2+TQbdxZSplsk4BkKkvyAEUk76+jPtpsLwBg9tufD0zAbGylaa5JQDKVJfr9WtfJowtrLavb8uSZia2gZjZbLe0LaibHTIvs2woolitcvBbvigg1k+Pite8oliot19uevVouT3gi9r/aEV1YI3z5Nlou3/YZ03egHULDPr68eoHQiN8ScfL+OrOxFUs7SoiB6QI6lv6MAic9fDA+zOBrHgKnZJwO4xOn5fJouTyrqSyrHW5lIQY+uYeuhyx7dBX6kqRXq5cRFA+dW1DUa/qkRGZe06u1IHD3sIgRIqlXa0Ey89rfAkNGhhJTtQMAAAAASUVORK5CYII=)
    
    **Adobe**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAACrElEQVRYhcWXzU8TQRiHn9nudmtaYlFAA9FoDJFPwS8OmCiJRA9gTA98JChBwBj+Cy8evHj0ICiKEjCif4Q3RC3a2AOJFw0iYABpwba0Ox6qtQv0C0v7Jpvded+Z+T07M/vOjuCPzdmpsWgMC6iToAmyazJ62wCmw2F6Sv14AQTAjwJ6pYVBQMmybiIzjAj9B3wMizk7NarGhxyKAyDB2AhTLRacTAk4k0vxOIhJseAkJEDLBwAQUsifOBKsSrZXeyYmyPHC2852BGC/fZeiZWm67Hfu7QhALDr/5og0G+g6hZ4vKMUlJr/8ucJSZRny13pGABmPgPVq2xZxALHXie5qz7S7zAFsfQOJY72JY1kBUKtPoDU0Jo6fbkA9mVlOywhg89uHP31Eriyb6/Tc2h0A4ShAb+sy+QIP7xN8MWry6e1dCGdh9gH0zm6EoyBWlutrBCfGCDx+YAa17cHWcT37ALYb5qENvhxH+lYJez2E370x1+0bAJFejk0LQGs8j1pVa/IFRgb/PT8dMsUs5RVo5y5kD2DL4vN6CL+djJWDE2NIv8/cJs1PMiWAUlSMtcVl8m2ed7nmJ/jqucmnt7pQDpb+P4Ct+yZC1+PUJHJxHq2pGa2pGUv58SjUpmlA07Bd600JkHwvUBQK3Z+xHD6SsEr4/RQrFxsAcL52o9bWx2LG7FeW6o5CJJJYIhmd9XJrUnEA9dRZLMfKAQiODps7LzuE9VJL0vZJAZLl/XjTXR0ABMZHtuyGqfpQE0aEIDgyRPDZo5QAxvx3ILolr3ZeQdm3Py5oRHOC3H6mM/4fyLYp+VSXRNfARh4ZQgownUcAt/jmoEpT8ZDro5nEwKBSKfXjNSL0SzByKS4Mekp8zMT2zFkHFZrKEwH1Eqy7dDwPAW4idJf4mAH4DWN90QFmwa7KAAAAAElFTkSuQmCC)
    
    **Oracle**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAEoklEQVRYhbWXTYgdRRDHf1Xd72M3ZmM+BMFLVBDRKHgSScSjGlASjBoRBBMRPXjIQQXxKIh6iOghomI8BBFjIOIhns3m4kFJQDCioARviclqNvvem+kqDz2zb968jcS4KRh6uru6//+u7qqultfeeJ2miDdrEaEHHgFQz99YDBhWJZWOjnslf179VxoAeFWP0hgANgUQzYBymcAESTHcDWRMAK8hsp5WJKhKrVRDVcZgTQJNU2Twno0qZZtScTXcvNU6PV+pMKpWLCgdg16CmCBuGJQTK24S6CRjxpzgNu4TYwypmPuyOamsWZtbPVshKSx1oBQlGnQTrCmgkyDesnBpZQJA8JIZH9KxMcnxXmZJPtngMmkBcUgCo5jLYEq/hLWjTCTeeOmvKZPVe6yU23oM7w1e3gr0gZa9DWs35S0QYAD8AnxnMF+E3NtJmcBsURFYP7owRUBhPdhLYDtU0t2KheW+Jp4YWNE6hBNekFw4acJXmngvGBe6Sekl6JYQHOTM7u2T4M4+4B3EAhgiMgaj7aaGeAGSGpyWueIy3rJglNF5OSZ9t5MyuDpEpHkIOWzCrgkAndxjbdWMCMQVFcTHbgdEg/2lcl8SnqwWS2wcvC+gCb4s3wDfAn/C9CF0X9GNBVivwgM4D9ZWszz+CQQDnqJB/Rng8dYkx4AXgd9XQrhCeRPYDBwAHmq07wa+Bj5ToAd80Bp4ENj+P8Fr+Q14GPi01f4h0FHy6mcaHT8Be1YBuC3PAqcb9TXA0wrsaCm+cg3Aa3m1Vd+pwJZGw0XyobtWcqzCqGWLApsaDaeBYrXQxKFj+VMHF0Yu/NyI3pui6ERokfYk07fdlUsw6Bd50qUOFAJJUK36guW4ebYx5nayV6yKuEARoNAcA1zom3BbKbltFDmrwKnGmFngkdUiMAxwoQ/nZ2CQI86jwGxSWOzCQo+TChxpjXt7tQh4tdJiHCzfgnwtDyJc7HJEgUNA806+GTi8GgRClXz0S+gYXwZjc70tg8j5Sx0+VyAxHXh2AceBO1aBx53AfFIeS5o9o5dgbsiejUtYfRccAT5pEdkG/AicAI6LyrmVZv8XL9mYlPsLZWsN3LGciFw/4KPZgqMxQVy7lEgKSdmbBE/KXgCtPNLdtwJbpX0N1gT88m5qkH1QchzoGPRLPp4b8jwDoIQ4d3EIAUY9WIo8NxROuLA/GOsApM7xLoPjPp0t16JWEchZ8EK/YN/agoM0UpBI6uWc3aBwGDkHk3AoqL6gsFORu9QnouUkgcsxAwo4VwqngKMKBzpCUQj06qRJIC7MbqQIOVINIowClEohIu9H44euyz3BuElEJgJU2/QrbMWoCPyxGPk+KfPdAIsB/g7Qj9k7gkP8dd0GUiNilQFKAVRQmO8lmQ/OODe8cgIU1XsgaX6E9FJ+C3RTPg/iEE/dMLc8oAqXlAopZMAgglwlgfpdWFmbaONP6qT0zHWzBM9BI1oelBSKKJjk56leJYG21KAwLuNiVwmVfzYtUVbZsCbJ5voPBGqPNfJimul5XdbacRRyZpo0W0HIA2oFrZm3VjMVfxr14NOgzWd63ecC/wDOqvk4G7oeyQAAAABJRU5ErkJggg==)
    
    **Myntra**
    
    [](data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsUFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5OjcBCgoKDQwNGg8PGjclHyM3Nzc3Nzc3NzU3Nzc3Nzc3NzcyNzA3Nzc0Nzc3Nzc3Nzc1NzU3Nzc3Nzc1MSw4Nzc4Mf/AABEIACAAIAMBEQACEQEDEQH/xAAZAAADAAMAAAAAAAAAAAAAAAAAAwYCBAf/xAAnEAABAwIFBAIDAAAAAAAAAAABAgMRAAQGEiExQRNRYZEFFGJxof/EABoBAQACAwEAAAAAAAAAAAAAAAADBQECBgT/xAAsEQABAgMFBQkAAAAAAAAAAAAAAQIDBBEFITEy8BNBYXGBEiJCUZGhwdHh/9oADAMBAAIRAxEAPwDthVFAGvJ9UASeD7oACpoBYOp9VkEq1ipT2Irhhsj6FusMqMbkyCufBBH6BPIjzzkR0q6Ersr69MKF0tlKko2Iudb6cPLXI17HGLj2KPrOZR8Y+rosHLqFjZU85p24lPmZZV6TMJ72+FadKJfrcSRbH7EntEzpeqcPz7LInUeq3KEU4VdNYbMLIOU+aGW0qlcCT+Owq7aYZetFOIN86ouFQnKDEAd4j+k1HajEnW0bdTAvY9rtiTiRETuJd811uF32EHV4etre2cbTfsuF3qGQCpUSJieE6/iK3s1qSjOw6+uOvY2g2y1Jtz3ouzclKctL6llJMTvuayc+YE0AZj2oAzHtQADFAf/Z)
    
    **⚡67**
    
    Solved
    
    Medium
    
    Topics
    
    !premium lock icon
    
    Companies
    
    Given the `root` of a binary tree and an integer `targetSum`, return *all **root-to-leaf** paths where the sum of the node values in the path equals* `targetSum`*. Each path should be returned as a list of the node **values**, not node references*.
    
    A **root-to-leaf** path is a path starting from the root and ending at any leaf node. A **leaf** is a node with no children.
    
    **Example 1:**
    
    ![](https://assets.leetcode.com/uploads/2021/01/18/pathsumii1.jpg)
    
    ```
    Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
    Output: [[5,4,11,2],[5,8,4,5]]
    Explanation: There are two paths whose sum equals targetSum:
    5 + 4 + 11 + 2 = 22
    5 + 8 + 4 + 5 = 22
    ```
    
    **Example 2:**
    
    ![](https://assets.leetcode.com/uploads/2021/01/18/pathsum2.jpg)
    
    ```
    Input: root = [1,2,3], targetSum = 5
    Output: []
    ```
    
    **Example 3:**
    
    ```
    Input: root = [1,2], targetSum = 0
    Output: []
    ```
    
    **Constraints:**
    
    - The number of nodes in the tree is in the range `[0, 5000]`.
    - `1000 <= Node.val <= 1000`
    - `1000 <= targetSum <= 1000`

*/