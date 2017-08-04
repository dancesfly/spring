package com.spring.mybatis;

public class Group {

	int count;
	String name;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Group [count=" + count + ", name=" + name + "]";
	}
}
