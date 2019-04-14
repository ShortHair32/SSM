package com.imooc.o2o.dto;

public class Result<T> {
private boolean success;
private T data;
private String errorMsg;
private int errorCode;
public Result(){
	
}
public Result(boolean success,T data) {
	this.success=success;
	this.data=data;
}
public Result(boolean success,int errorCode,String errMsg) {
	this.success=success;
	this.errorMsg=errorMsg;
	this.errorCode=errorCode;
}
public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success=success;
}
}
