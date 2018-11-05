package com.helloworld.action.typeconverter;

import com.helloworld.model.Point;

public class PointAction {
	
	private Point point;

	//	获取页面坐标点
	public String execute() {
		System.out.println("x=" + point.getX() + ", y=" + point.getY());
		return "success";
	}
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
}
