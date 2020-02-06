package com.hugeyurt.mvc;
import java.util.List;
public class MethodInfo
{
	private String url;
	private String className;
	private String methodName;
	private String action;
	private List<String> params;//new ArrayList<String>();
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public List<String> getParams() {
		return params;
	}
	public void setParams(List<String> params) {
		this.params = params;
	}
	@Override
	public String toString() {
		return "MethodInfo [url=" + url + ", className=" + className + ", methodName=" + methodName + ", params="
				+ params + "]";
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

}
