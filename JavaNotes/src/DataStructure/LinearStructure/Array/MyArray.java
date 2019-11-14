package DataStructure.LinearStructure.Array;

import java.util.Arrays;

/**
 * 面向对象的数组封装
 */
public class MyArray {

    // 用于存储数据的数组
    private int[] elements;

    public MyArray() {
        elements = new int[0];
    }

    // 获取数组长度
    public int size() {
        return elements.length;
    }

    // 往数组的末尾添加一个元素
    public void add(int element) {
        // 创建一个新的数组
        int[] newArr = new int[this.elements.length + 1];
        // 复制原数组中的元素到新数组
        for (int i=0; i<this.elements.length; i++) {
            newArr[i] = this.elements[i];
        }
        // 把添加的元素放入新数组中
        newArr[this.elements.length] = element;
        // 新数组替换原数组
        this.elements = newArr;
    }

    // 插入元素
    public void insert(int index, int element) {
        // 判断下标是否越界
        if (index < 0 || index > this.elements.length) {
            throw new RuntimeException("Wrong index");
        }
        // 创建一个新数组
        int[] newArr = new int[this.elements.length + 1];
        // 将原数组复制到新数组
        for (int i=0; i<this.elements.length; i++) {
            if (i < index) {
                newArr[i] = this.elements[i];
            } else {
                // 空出新元素的位置
                newArr[i + 1] = this.elements[i];
            }
        }
        // 插入新元素
        newArr[index] = element;
        // 替换
        this.elements = newArr;
    }

    // 删除数组中的元素
    public void delete(int index) {
        // 判断下标是否越界
        if (index < 0 || index > this.elements.length - 1) {
            throw new RuntimeException("Index out of range");
        }
        // 创建一个新的数组
        int[] newArr = new int[this.elements.length - 1];
        // 复制原数据到新数组
        for (int i=0; i<newArr.length; i++) {
            if (i < index) {
                newArr[i] = this.elements[i];
            } else {
                newArr[i] = this.elements[i + 1];
            }
        }
        // 替换
        this.elements = newArr;
    }

    // 替换指定元素
    public void set(int index, int element) {
        // 判断下标是否越界
        if (index < 0 || index > this.elements.length - 1) {
            throw new RuntimeException("Index out of range");
        }
        this.elements[index] = element;
    }

    // 获取某个元素
    public int get(int index) {
        // 判断下标是否越界
        if (index < 0 || index > this.elements.length - 1) {
            throw new RuntimeException("Index out of range");
        }
        return this.elements[index];
    }

    // 线性查找
    public int search(int target) {
        // 目标下标
        int index = -1;
        // 遍历
        for (int i=0; i<this.elements.length; i++) {
            if (this.elements[i] == target) {
                index = i;
                break;
            }
        }
        return index;
    }

    // 二分查找
    public int binarySearch(int target) {
        // 目标下标
        int index = -1;
        // 记录开始位置
        int begin = 0;
        // 记录结束位置
        int end = this.elements.length - 1;
        // 记录中间位置
        int mid = (begin + end)/2;
        // 循环查找
        while (true) {
            if (this.elements[mid] == target) {
                index = mid;
                break;
            } else if (begin >= end) {
                break;
            } else if (this.elements[mid] > target) {
                // 查找目标在中间元素左侧
                end = mid - 1;
            } else {
                // 查找目标在中间元素右侧
                begin = mid + 1;
            }
            mid = (begin + end)/2;
        }
        return index;
    }

    // 打印所有元素到控制台
    public void show() {
        System.out.println(Arrays.toString(this.elements));
    }
}
