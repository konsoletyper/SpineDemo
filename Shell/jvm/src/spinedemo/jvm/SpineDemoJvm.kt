package spinedemo.jvm

import com.acornui.jvm.LwjglApplication
import spinedemo.SpineDemo
import spinedemo.config

fun main(args: Array<String>) {
	LwjglApplication(config) {
		it.addElement(SpineDemo(it))
	}
}