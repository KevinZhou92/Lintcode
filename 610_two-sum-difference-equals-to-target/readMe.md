```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/two-sum-difference-equals-to-target
@Language: Markdown
@Datetime: 17-04-05 23:44
```

1.注意这里是要求两个数之差，思路要转换过来，一般在求解两数之和的问题时，我们都是保持首尾两个指针向中间逼近，这是因为加法的特性，但是当问题变为减法时，我们要考虑变形
2.这里需要考虑corner case，最经典的边界情况，比如说数组引用为空，数组中只有一个数，同时需要考虑target为负数的情况，因为两数相减可能有一正一负两个结果，这和较大的数与较小的数的位置有关、对于相减和为负数的情况，我们采取一个很简单的数学原则，将所有target都转换为正数，这样我们只需要考虑数组从小到大的排列
3.由于本题要求我们返回两个值的位置，所以我们如果对原始数组排序然后用双指针扫描，这样只能得到对应的值，而无法得到对应的索引，这里我们新建一个custom的数据结构，包含数组中数的值和索引，然后用这个新的数据结构重新建立数组
4.对新的数组排序，注意comparator的使用
```
Arrays.sort(pairs, new Comparator<Pair>(){
		public int compare(Pair a, Pair b) {
			return a.num - b.num;
		}
  });
```
5.然后设置两个相邻的指针，递进扫描，这里利用了数组是从小到大的顺序的特性