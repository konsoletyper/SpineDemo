/*
 * Copyright 2015 Nicholas Bilyk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package spinedemo.js

import com.acornui.js.gl.WebGlApplication
import spinedemo.SpineDemo
import spinedemo.config

fun main(args: Array<String>) {
	WebGlApplication("spineDemoRoot", config) {
		it.addElement(SpineDemo(it)) // Ignore the inspection error, this is because we're mixing module types.
	}
}


