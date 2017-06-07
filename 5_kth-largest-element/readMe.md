```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/kth-largest-element
@Language: Markdown
@Datetime: 17-04-10 04:07
```

1.快速排序因为使用了递归，所以我们一定要注意指针的界限，否则很容易引发死循环爆栈，partition永远是按照数组中某个数将数组分成大于等于次数和小于等于此数的两个区间然后返回这个数当前在数组中位置，然后再处理左右部分，所以我们这个时候在进行下一步递归的时候，一定要考虑corner case，假如前一步处理的数组已经是排好序的，那么很可能我们partition返回的点就是当前的starting point，那么如果形如
```
int k = partition(nums, start, end);
if ( k == target) {
	return nums[k];
} else if (k < target) {
	return qs(nums, k, end, target);
} else {
	return qs(nums, start, k, target);
}
```
这样的代码可能导致partition之后返回的k值和start一样，所以我们应该使用下面的代码，对corner case处理，不从k开始，而从k+1或者k-1开始
```
int k = partition(nums, start, end);
if ( k == target) {
	return nums[k];
} else if (k < target) {
	return qs(nums, k + 1, end, target);
} else {
	return qs(nums, start, k - 1, target);
}
```
2.使用quickselect的方法的时间复杂度为O(n)