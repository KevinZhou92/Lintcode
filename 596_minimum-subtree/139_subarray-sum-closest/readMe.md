```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/subarray-sum-closest
@Language: Markdown
@Datetime: 17-03-20 03:38
```

### 1. brute-force, 此解法会超时，但是用来熟悉数组下标操作非常好,注意这里要对数组中只有一个元素的情况特殊处理一下，这个点要注意
```java
if (nums == null) {
            return new int[0];
        }
        int[] res = new int[2];
        if (nums.length == 1) {
            res[0] = 0;
            res[1] = 0;
            return res;
        }
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <=nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                if (min > Math.abs(sum[j] - sum[i])) {
                    min = Math.abs(sum[j] - sum[i]);
                    res[0] = i;
                    res[1] = j - 1;
                }
            }
        }

```

### 2.  同样对只有一个元素的特殊情况处理一下，然后构造一个自定义的数据结构存储每个索引位置的和以及当前的索引，然后还是统计到每个位置的总和， 构建一个新的数组，对这个数组排序，注意这里使用了自定义的comparatot，对这个写法要多加练习，然后就是最核心的比较逻辑，在排序之后，数组是将以索引0为开头的所有子数组的和从小到大排序了，这个情况下， 数组中任意两个相邻元素的值都是最接近的，最小绝对值的子数组将会在这些两两相邻的数组元素中求得，这个情况下，sum[0]也是参与排序的，sum[0]两边一定是和其值最接近的值，也就是以0位起始位置的子数组的最小值可以求得， 所以这种情况不会漏掉任何可能性