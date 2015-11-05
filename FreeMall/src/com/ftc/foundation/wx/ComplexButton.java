package com.ftc.foundation.wx;

/**
 * 复杂按钮（父按钮）
 * 
 * @author JenkGan
 * @date 2015-10-20
 */
public class ComplexButton extends Button {
	private Button[] sub_button;

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
}
