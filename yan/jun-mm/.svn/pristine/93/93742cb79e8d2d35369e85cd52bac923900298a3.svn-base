package com.junkj.common.utils;

/**
 * 微信模板消息
 *
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年11月07日
 */
public class Template {

    /**
     * 默认颜色
     */
    private String DEFAULT_COLOR = "#333333";

    /**
     * 模板id
     */
    private String id;

    /**
     * 模板字段名称
     */
    private String name;

    /**
     * 显示颜色
     */
    private String color;

    /**
     * 显示数据
     */
    private String value;

    public Template() {
    }

    public Template(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Template(String name, String color, String value) {
        this.name = name;
        this.color = color;
        this.value = value;
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 组装模板数据
     */
    public String templateData() {
    	if(color==null){
    		color = DEFAULT_COLOR;
    	}
        StringBuffer data = new StringBuffer("\"" + name + "\":{");
        data.append("\"value\":\"").append(value).append("\",");
        data.append("\"color\":\"").append(color).append("\"}");
        return data.toString();
    }

}
