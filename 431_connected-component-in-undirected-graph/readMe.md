```
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/connected-component-in-undirected-graph
@Language: Markdown
@Datetime: 17-02-18 17:49
```

1.Remember to sort each result list
2.Can use union-find to solve this problem, the key component of the problem is : all the connected component will have the same root, connecting two compnents is just connecting the roots. Here is an example for union two components : 
```java
public void union(int x, int y) {
	int rootx = find(x);
	int rooty = find(y);
	if (xfa != yfa) {
		father.put(rooty, rootx);
	}
}
```
**Note here we must connect the root of y to the root of y, not only the y point, otherwise we just did connect y to the component that x belongs to, rather than the component y belongs to to the component x is in.**
3.Be carefun for every corner case and think before you code.

--------


1.结果需要排序
2.并查集, 过于复杂，并不需要舍近求远
3.要仔细，要bug free的目标