package spinedemo.build

import com.acornui.build.*
import java.io.File
import java.util.*

fun main(args: Array<String>) {
	val allModules = ArrayList(ALL_ACORNUI_MODULES)
	allModules.addAll(arrayListOf(SpineDemoCore, SpineDemoJs, SpineDemoJvm))
	BuildUtil.execute(allModules, args)
}


object SpineDemoCore : CoreModule(File("Shell/core"), name = "SpineDemoCore") {
	init {
		resources += skin("basic")
		moduleDependencies = arrayListOf(AcornUtils, AcornUiCore, AcornGame, AcornSpine)
	}
}

object SpineDemoJs : JsModule(File("Shell/js"), name = "SpineDemoJs") {
	init {
		//minimize = false
		moduleDependencies = arrayListOf(SpineDemoCore, AcornUtils, AcornUiCore, AcornUiJsBackend)
	}
}

object SpineDemoJvm : JvmModule(File("Shell/jvm"), name = "SpineDemoJvm") {
	init {
		mainClass = "spinedemo.jvm.SpineDemoJvmKt"
		moduleDependencies = arrayListOf(SpineDemoCore, AcornUtils, AcornUiCore, AcornUiLwjglBackend)
	}
}