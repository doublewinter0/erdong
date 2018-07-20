package ren.erdong;

/*
 *	去除数组中重复的元素
 *		举例:
 *			{4,3,4,5,2,5}
 *		结果
 * 			{4,3,5,2}
 */
public class Test001 {
	public static void main(String[] args) throws Exception {
		int[] arr = {4, 3, 4, 5, 2, 5, 6, 3, 5, 9};
		int[] newArray = delDuplicatedEle(arr);
		printArr(newArray);

	}

	public static int[] delDuplicatedEle(int[] arr) throws Exception {
		if (arr == null)
			throw new Exception("you silly b!");
		int[] tempArr = new int[arr.length];
		tempArr[0] = arr[0];
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			int j = 0;
			for (j = 0; j < i; j++) {
				if (tempArr[j] == arr[i])
					break;
			}
			if (j == i) {
				count++;
				tempArr[count] = arr[i];
			}
		}
		int index = count + 1;
		int[] newArr = new int[index];
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = tempArr[i];
		}
		return newArr;
	}

	public static void printArr(int[] arr) {
		System.out.print("the ultimate array:" + "\n" + "[");
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 1)
				System.out.print(arr[i] + ", ");
			else
				System.out.print(arr[i] + "]");
		}
	}
}