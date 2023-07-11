package com.yedam.app.emp.controller;

public class BoxOffice {
	BoxOfficeResult boxOfficeResult;

	public BoxOfficeResult getBoxOfficeResult() {
		return boxOfficeResult;
	}

	public void setBoxOfficeResult(BoxOfficeResult boxOfficeResult) {
		this.boxOfficeResult = boxOfficeResult;
	}

	@Override
	public String toString() {
		return "BoxOffice [boxOfficeResult=" + boxOfficeResult + "]";
	}
	
}
