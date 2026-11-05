
    class Solution {
        private int maxLength = 0;
    
        public int longestZigZag(TreeNode root) {
            dfs(root, "left", 0);
            dfs(root, "right", 0);
            return maxLength;
        }
    
        private void dfs(TreeNode root, String direction, int length) {
            if (root == null) return;
    
            maxLength = Math.max(maxLength, length);
    
            // Move to the left child
            if (root.left != null) {
                if (direction.equals("right")) {
                    // Alternating direction: continue the ZigZag
                    dfs(root.left, "left", length + 1);
                } else {
                    // Same direction repeated: start a new ZigZag
                    dfs(root.left, "left", 1);
                }
            }
    
            // Move to the right child
            if (root.right != null) {
                if (direction.equals("left")) {
                    // Alternating direction: continue the ZigZag
                    dfs(root.right, "right", length + 1);
                } else {
                    // Same direction repeated: start a new ZigZag
                    dfs(root.right, "right", 1);
                }
            }
        }
    }
    ```
    

/*

- Q
    
    # **1372. Longest ZigZag Path in a Binary Tree**
    
    **Bloomberg**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAEjUlEQVRYhbWXX0xTdxTHP7e0BS3eysgFY9Za2MgIPkjIFqeLPkhIfHBmT5KQPcynEeODCe97GiGThBeDLyabPhND9Mlggg+LREtcJIaJA6Rhe2kbGm+hBW7be/bwK5WW/rnV7ZuctPeXc885v3PO79zvT8MZGoEvgJPAhfzv58AnQANgAsvAAvAUeA6sAdsO7VdEE9AH3AKWgB1AaogFLAJ3gfPA4Q9xrAEBYAz4G8g4cFwqOSAK/AKcyNt0hIZ85DP53dTruFSywGPgTN52TeffAq/zO/hY5/uz8TpvuygIreT/18CvQPfeos/n49KlSxw/frxi1CJCIpFgfX2dV69ekUwmyWQy5VSXgB+B3/OBFeEEKlVFOzcMQ2ZmZmRnZ6eibG9vy9bWliQSCZmbm5Pr169LS0tLpUzMoPqrCIdRzZItfckwDHny5InUg83NTRkfHxe/31/plIyhThjufABfAj/goEnS6TSLi4ukUqnCWnNzM8FgkLa2tsLz8PAw4XCY+/fvY9v2fhMe4HtgCvgD4BDqzJZtutIMLC0tyblz58QwjIJ0dHTIwMCAPHr0SLLZbEH33r174vP5ymUhg5otjW6gA/gKcNXaPUAul2NjY4N4PF5Yi8fjRCIRTNOkt7eX9vZ2ADo7O/F4POXMuIEBoNsFnAa6nDivBhHh7du3mKZZFKzIgWbfQwjocQHfoOry0eju7sYwjMJzOBxmd3e3knojcMENnKrHSUNDA7quc/To0cKa1+vl7Nmz3LhxA13XERGWl5d58OBBtQAATrqpM/3BYJDbt2+TTqcLARmGQVtbG83NzViWxYsXLxgbG+PZs2fVSsCe76pjtJ45YNu2LCwsyODgoOi6LpqmOflOHBw+HxqAiIhlWRKLxeTOnTvS1dVVMwg3kADed04NrK6uMjExQSwWK6z5/X6CwSD9/f309fVhGAZXr17F5/Nx7do13r17V8mcCTBXTwbC4bCEQqEiHZfLJV6vV9rb22VyclJs2xYREdM0ZWhoqFoG5l0o9vJRsG0by7KIRqNMTU0RjUYBOHLkCBcvXsTtdld6dcEFzAJVz0o9ME2Tra0tADRNo7W1Fa/XW041Azx1AX8Ckf/CuaZpBAKBomGUTqexLKuc+jLw3I0iCY+Bz3j/dawbuq7T29vLyMgIuq4DsLu7y8uXL8lms6XqNjAPrLlR6f8N+A74tJajUCjE6OgoyWSysNbU1MSxY8fo6ekhEAigaYpoRSIRpqeny5nZQDGvAm1vQpGEAyS03BzI5XJFstf1+wfS2tqaXLlyRTweT7nhc5MydD2AoksHKNns7OwBp6WSyWQklUpJPB6X6elp6e/vL+c8hyr3iT2n+2v+D/BzPpACKU2n0zx8+JA3b95ULU0ymWR1dZX5+XlWVlZIpVKlTAjgL+AnYL2SnQbgMv8fLb+Mw7vBGVSqqn4nHIqFKu15J873oKHqdBOIfWA2Mqhr3RiqrI6vZvtxOB/5XdTIdnJV20HNlluoi21TrZ06wSEUeT2NonCnUGTCj8pOAljJBzmLmq5LOBjx/wI2h34g730GlwAAAABJRU5ErkJggg==)
    
    **Meta**
    
    **Apple**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAEiklEQVRYha2XW2wUVRzGf7OX2SVt2d1ut11cMrVkt4XAA0oLiURC4UHI8iDpi4oJobXFRjCRRAJKTBDpW8VwEVGIwcjFd0OCSRHKMxEoCbSYmm7YsL1QdrdAZ/Yy40OnWNqZ7QzyPc75zv/79uw5/4tw+/ZdbOI14E0gBpTr354A94G/gKSdYC6LvAjQCrzvdruWeb1ePB4Rh8MBgKqqKEoOWZbJ5wv3gAvAGStmhHlOwA98DXRUV1d5/P6FeDxiyYCKkiOdzjIyMqYAPwJfAemXMbABOBcKBcM1NVUIglBSeDY0TWN4eIzR0Ucp4EOgx4jnMNnfAfwhSZFwOByyLQ4gCALhcAhJioSBy8BOqwY6Kyv9p2Kx150+X4UlMVVVOX/+At3d385Z8/kqiMXqnJWV/h+AzvkMbASOBYMBvF6vJXFZlmltbWPfvv309fUZcrxeD8FgAOCYrmFowA+ck6SI0+v1WBIHOHr0GFeu/AnA9u3bTXlerwdJijiBX3WtOQYOhULBGqvHDlO//vTpMwDs2vUJzc3rS/J9vgpCoWCYqZcF/PcKJOD+ihUN4nwXbnDwH1S1SF1dHU6nkyNHvqOpqZFoNMrDhykqKwPU1taa7tc0jTt3+nPAEiA5nYh2VFdXlRTv7b1Od3c3fX13UFWVhoZ64vE4tbUSZ8/+Qm/vdSYnJxFFkbVr3+LAgS+JxWJz4giCQHV1lTgyMvYRcHD6BO7W1y9ZapZkrl69xo4drRSLxZKnMxOxWIxLl37H45l7nxQlx8DAYD+w1AEsdrtdpuJPnz5l//4vbImXlZXR1XUYUTSO6fGIuN2uBmCxA1hZ6sldu9ZLMmmrvtDR0c6aNatLJjBdc6UDiJXK7zdu3LAlDrB586Z5ObpmvQOomK5qRpiYmLAlLgiCpSSma5abK+sIBAK2DGiaRn//gGW+A5hQVdWUsHz5clsGAI4fP0GhUCjJ0TWfOID7ipIzJTY1NVquC9O4desW7e07SSQSphxdc8AB3JRl2ZS4aNEi1q1725YBgJ6enuc1wgi65k0H8CCfL9wrdQqdnR/bNhAIBNi69V3DNUXJkc8XBoAH05fwYjqdNQ22atUqWlpabBnYu/dzfD6f4Vomk4WpvvF5Nfx5ZGQsr2maacBDhw4SjUYticfjcbZt+8BwTW/VcsBPAM7Ozl0AGaBG01hdXl5muFEURTZu3MDg4CAAzc3r2bPnM9ra2mhsbESWZVwuF1u2xOnqOozLZdxwDw+P8ezZ5EngN3ixKfUD9yQpYqsnsINMZoJEIpkClqF3yjMTURrYlkgki7KsvHJxWVZIJJJFpjrk52367EzYA+x+9Ogxr9KELCuMjz8G2M2s9tzojzo5Pp5Wx8fTJyQpYrkzNkM2O8HQULIIfAqcnL1uVgtOAe8kEslUKjVKqddhBk3TSKVGGRpKpoBNwPdGPCuj2TdAe01NlejzWRvNMpnszKd2gJcczWYiArQD77ndroYFC7yI4ovDaS6XY3JSJp8v9AMXdfH/PZwaYTHwBhAFFurfssDfTI3nD+wE+xfxCKNpO+N8NAAAAABJRU5ErkJggg==)
    
    **Myntra**
    
    [](data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsUFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5OjcBCgoKDQwNGg8PGjclHyM3Nzc3Nzc3NzU3Nzc3Nzc3NzcyNzA3Nzc0Nzc3Nzc3Nzc1NzU3Nzc3Nzc1MSw4Nzc4Mf/AABEIACAAIAMBEQACEQEDEQH/xAAZAAADAAMAAAAAAAAAAAAAAAAAAwYCBAf/xAAnEAABAwIFBAIDAAAAAAAAAAABAgMRAAQGEiExQRNRYZEFFGJxof/EABoBAQACAwEAAAAAAAAAAAAAAAADBQECBgT/xAAsEQABAgMFBQkAAAAAAAAAAAAAAQIDBBEFITEy8BNBYXGBEiJCUZGhwdHh/9oADAMBAAIRAxEAPwDthVFAGvJ9UASeD7oACpoBYOp9VkEq1ipT2Irhhsj6FusMqMbkyCufBBH6BPIjzzkR0q6Ersr69MKF0tlKko2Iudb6cPLXI17HGLj2KPrOZR8Y+rosHLqFjZU85p24lPmZZV6TMJ72+FadKJfrcSRbH7EntEzpeqcPz7LInUeq3KEU4VdNYbMLIOU+aGW0qlcCT+Owq7aYZetFOIN86ouFQnKDEAd4j+k1HajEnW0bdTAvY9rtiTiRETuJd811uF32EHV4etre2cbTfsuF3qGQCpUSJieE6/iK3s1qSjOw6+uOvY2g2y1Jtz3ouzclKctL6llJMTvuayc+YE0AZj2oAzHtQADFAf/Z)
    
    **Oracle**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAEoklEQVRYhbWXTYgdRRDHf1Xd72M3ZmM+BMFLVBDRKHgSScSjGlASjBoRBBMRPXjIQQXxKIh6iOghomI8BBFjIOIhns3m4kFJQDCioARviclqNvvem+kqDz2zb968jcS4KRh6uru6//+u7qqultfeeJ2miDdrEaEHHgFQz99YDBhWJZWOjnslf179VxoAeFWP0hgANgUQzYBymcAESTHcDWRMAK8hsp5WJKhKrVRDVcZgTQJNU2Twno0qZZtScTXcvNU6PV+pMKpWLCgdg16CmCBuGJQTK24S6CRjxpzgNu4TYwypmPuyOamsWZtbPVshKSx1oBQlGnQTrCmgkyDesnBpZQJA8JIZH9KxMcnxXmZJPtngMmkBcUgCo5jLYEq/hLWjTCTeeOmvKZPVe6yU23oM7w1e3gr0gZa9DWs35S0QYAD8AnxnMF+E3NtJmcBsURFYP7owRUBhPdhLYDtU0t2KheW+Jp4YWNE6hBNekFw4acJXmngvGBe6Sekl6JYQHOTM7u2T4M4+4B3EAhgiMgaj7aaGeAGSGpyWueIy3rJglNF5OSZ9t5MyuDpEpHkIOWzCrgkAndxjbdWMCMQVFcTHbgdEg/2lcl8SnqwWS2wcvC+gCb4s3wDfAn/C9CF0X9GNBVivwgM4D9ZWszz+CQQDnqJB/Rng8dYkx4AXgd9XQrhCeRPYDBwAHmq07wa+Bj5ToAd80Bp4ENj+P8Fr+Q14GPi01f4h0FHy6mcaHT8Be1YBuC3PAqcb9TXA0wrsaCm+cg3Aa3m1Vd+pwJZGw0XyobtWcqzCqGWLApsaDaeBYrXQxKFj+VMHF0Yu/NyI3pui6ERokfYk07fdlUsw6Bd50qUOFAJJUK36guW4ebYx5nayV6yKuEARoNAcA1zom3BbKbltFDmrwKnGmFngkdUiMAxwoQ/nZ2CQI86jwGxSWOzCQo+TChxpjXt7tQh4tdJiHCzfgnwtDyJc7HJEgUNA806+GTi8GgRClXz0S+gYXwZjc70tg8j5Sx0+VyAxHXh2AceBO1aBx53AfFIeS5o9o5dgbsiejUtYfRccAT5pEdkG/AicAI6LyrmVZv8XL9mYlPsLZWsN3LGciFw/4KPZgqMxQVy7lEgKSdmbBE/KXgCtPNLdtwJbpX0N1gT88m5qkH1QchzoGPRLPp4b8jwDoIQ4d3EIAUY9WIo8NxROuLA/GOsApM7xLoPjPp0t16JWEchZ8EK/YN/agoM0UpBI6uWc3aBwGDkHk3AoqL6gsFORu9QnouUkgcsxAwo4VwqngKMKBzpCUQj06qRJIC7MbqQIOVINIowClEohIu9H44euyz3BuElEJgJU2/QrbMWoCPyxGPk+KfPdAIsB/g7Qj9k7gkP8dd0GUiNilQFKAVRQmO8lmQ/OODe8cgIU1XsgaX6E9FJ+C3RTPg/iEE/dMLc8oAqXlAopZMAgglwlgfpdWFmbaONP6qT0zHWzBM9BI1oelBSKKJjk56leJYG21KAwLuNiVwmVfzYtUVbZsCbJ5voPBGqPNfJimul5XdbacRRyZpo0W0HIA2oFrZm3VjMVfxr14NOgzWd63ecC/wDOqvk4G7oeyQAAAABJRU5ErkJggg==)
    
    **Swiggy**
    
    [](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAACdklEQVRYhbWXv2/aQBTHP2cxlcVLWePMVApT18LOQKmUrGWsOtD8BTb9B5pImRvSLUhtqdTOuGu6JFKYY1Yy9CoVRq7D2bFdftw5gq90knl8797X5/fe3ROsgGpRR9BCsAfUYrMbD1tEKCQggRsUQzEk/J8kco5f0ULxAfAKOCqCCEEgPnORGJwH5218FF936BzAQ9FXbfzEIGLnr4HzHTpexoKGGBImO+BvJO8Cjn5hoVrUcRhZTyy70OxCtQ5PPW27j+DuBn6cwDSyF7GgIdRLThB0rSY0u3AYaBHrMAjgsmcnQHFaAg6syIc+HAUWvJhjJ8JzEBa5XfHsnGdFVOtmnuDAwaa4vN2QIB+PIbpeth/ZxbWDKe8rHjyrr/9/LuGvXLZX6+DVlu15uI6JYbHIelT2jAJKxkWeWJT/+0mafnOpn8chXH0zTjULmK/Y3iyqL+A21GMuYRaPVXGxAkK1URsZZRc+/bZaLIdpBG/2jTRzDMykfrsdwSwA4Jf5Wy5hEGxRwKivd6IIxj+3KGAmYWBZ30ELtjyUzEGYRdnVJ2ByGM2krnjPWylnGoHfsBZgTsMsvBq8z5zcoz7M/uQ54UWhI9lBXxrtMA43Z8Q0gsvAejlAlmIB9rfdQS89G7JbD3B+XMQ5gLQLwizGIXw/1c9lN42HUR+uhsXWUlqAXc3MYhDkv/M0KpYlKaSDYlJ42kzCWSf9fdYpdhdMcVP8UppF853+BMUCL8WCRtIX3LHbhmQVIvGFfSdW0jGQtw9BAHEpjpvGR0XRI9FL+sN8c6pbNJ9dNqcLOtkuWaxiPbTnumdw46t7EVFJWw5wjWKyrj3/B1Ytx1GY6pYIAAAAAElFTkSuQmCC)
    
    **⚡94**
    
    Solved
    
    Medium
    
    Topics
    
    !premium lock icon
    
    Companies
    
    Hint
    
    You are given the `root` of a binary tree.
    
    A ZigZag path for a binary tree is defined as follow:
    
    - Choose **any** node in the binary tree and a direction (right or left).
    - If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
    - Change the direction from right to left or from left to right.
    - Repeat the second and third steps until you can't move in the tree.
    
    Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
    
    Return *the longest **ZigZag** path contained in that tree*.
    
    **Example 1:**
    
    ![](https://assets.leetcode.com/uploads/2020/01/22/sample_1_1702.png)
    
    ```
    Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
    Output: 3
    Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
    ```
    
    **Example 2:**
    
    ![](https://assets.leetcode.com/uploads/2020/01/22/sample_2_1702.png)
    
    ```
    Input: root = [1,1,1,null,1,null,null,1,1,null,1]
    Output: 4
    Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
    ```
    
    **Example 3:**
    
    ```
    Input: root = [1]
    Output: 0
    ```
    
    **Constraints:**
    
    - The number of nodes in the tree is in the range `[1, 5 * 104]`.
    - `1 <= Node.val <= 100`

    - solution video
    
    https://www.youtube.com/watch?v=jdArJOUsIYg
    

*/