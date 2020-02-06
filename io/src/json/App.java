package json;

import net.sf.json.JSONObject;

@SuppressWarnings("unused")
public class App {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException 
	{
		Point point =new Point(3.00000000001,4);
		//JSONObject js=JSONObject.fromObject(point);
		System.out.println(JSONUtil.toString(point));

	}

}
