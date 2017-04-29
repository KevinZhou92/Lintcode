```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/sort-colors-ii
@Language: Markdown
@Datetime: 17-04-04 01:59
```

1.最简单的two-pass方法就是计数排序，扫描两遍，然后按照每个位置出现的次数重置原数组
2.如果不使用额外的存储空间, 使用快排不行，栈的调用占用额外空间
3.存在一个O（nk）的方法，扫描数组k次 ，每次扫描出当前最小的元素和当前最大的元素，因为总共有k个不同可能，所以为o(k/2 * n），注意这里指针的使用
```java
if (colors[current] == min) {
		swap(colors, start, current);
		start++;
		current++;
		}
else {
		swap(colors, end, current);
		end--;
}
```
注意这里当对于头指针操作时，因为current和start追踪的数开始是一样的，并且如果当前的数一样的话，那么都会一起自增1，那么我们可以保证一定是当前的数比我们要追踪的数不一样了，才导致current和start指针的值出现差异，所以我们交换了之后两个指针均要加1，而不用担心current原来的值，对于end则不一样，因为其实位置不一样，所以我们要检查交换后的值
4.最后还有一种O（nlogk）的方法，🌈彩虹排序，其实就是快排的变种，只是我们此处指定了partition point，这样避免了特殊情况造成快排不稳定的情况,这种情况同样要注意指针的使用，因为我们是将原数组每次分成左右两个数组来进行处理，所以我们一定要保证递归时分出的子数组和原来数组不一样，否则会陷入死循环爆栈，那么这里对于首尾两个指针的设置注意**一定要让start指针移动，否则很有可能end和start最后都位于开头，那么右半部分的递归就还是原数组，一定死循环了**，注意到第二个递归是`quicksort(colors, start, r, mid + 1, colorEnd);`此处r为递归传入的end point， 如果start不变的话，那么就和上层递归一样了，这样重复调用了，因为我们取中点时永远是取在两数中较小的数上的，所以中点可能刚好取在start上，所以我们一定要保证start点移动起来