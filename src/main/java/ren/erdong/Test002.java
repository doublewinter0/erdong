package ren.erdong;

/*
 * 去除数组中重复的元素
		举例:
			{4,3,4,5,2,5}
		结果
			{4,3,5,2}
			
		分析:
			1,定义一个数组int[] arr = {4,3,4,5,2,5}
			2,重新定义一个数组,数组长度和源数组长度一致,用于存储不重复的元素
			3,遍历源数组,获取每一个元素,拿到元素后和新数组中所有的元素做比较,如果不相同,添加到新数组中
			4,新数组就是最终的结果
 */
public class Test002 {
	public static void main(String[] args) {
		//定义一个数组int[] arr = {4,3,4,5,2,5}
		int[] arr = {4, 3, 4, 5, 2, 5};
		//重新定义一个数组,数组长度和源数组长度一致,用于存储不重复的元素
		int[] newArr = new int[arr.length];

		//定义一个标记
		boolean flag = false;

		int count = 0;//用来计数
		//遍历源数组,获取每一个元素,拿到元素后和新数组中所有的元素做比较,如果不相同,添加到新数组中
		for (int i = 0; i < arr.length; i++) {
			//arr[i]
			for (int j = 0; j < newArr.length; j++) {
				//newArr[j]
				if (arr[i] == newArr[j]) {
					flag = true;
					break;
				}
			}

			if (flag) {
				flag = false;
			} else {
				newArr[count] = arr[i];
				count++;
			}
		}

		//遍历数组
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + " ");
		}
	}
}
