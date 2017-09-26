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

package spinedemo

import com.acornui.component.button
import com.acornui.component.layout.algorithm.CanvasLayoutContainer
import com.acornui.component.layout.algorithm.vGroup
import com.acornui.component.stage
import com.acornui.core.di.Owned
import com.acornui.core.di.inject
import com.acornui.core.graphics.PerspectiveCamera
import com.acornui.core.input.interaction.click
import com.acornui.core.tween.Tween
import com.acornui.graphics.Color
import com.acornui.math.Pad
import com.acornui.skins.BasicUiSkin
import com.acornui.skins.Theme
import com.esotericsoftware.spine.component.SkeletonComponent
import com.esotericsoftware.spine.component.skeletonComponent
import com.esotericsoftware.spine.component.spineScene

/**
 * @author nbilyk
 */
class SpineDemo(owner: Owned) : CanvasLayoutContainer(owner) {

	private var raptor: SkeletonComponent? = null

	init {
		Tween.prepare()
		val theme = inject(Theme)
		theme.bgColor = Color(0.1f, 0.1f, 0.1f, 1f)
		BasicUiSkin(stage).apply()

//		cameraOverride = PerspectiveCamera()

		println("SpineDemo#onInitialized")
		val r = this

		+spineScene {

			scaleX = 0.5f
			scaleY = 0.5f

			loadSkeleton("assets/raptor/raptor.json", "assets/raptor/raptorAssets.json") {
				r.raptor = +skeletonComponent(it) {
					animationState.data.defaultMix = 0.25f
					animationState.setAnimation(0, "walk", loop = true)
				}
			}
		} layout {
			horizontalCenter = 0f
			bottom = 0f
		}

		+vGroup {
			style.padding = Pad(4f)
			val shoot = +button()
			shoot.label = "Draw"
			shoot.click().add {
				it.handled = true
				r.raptor?.animationState?.setAnimation(1, "gungrab")
			}
		}

		click().add {
			if (!it.handled) {
				raptor?.animationState?.setAnimation(0, "jump")
				raptor?.animationState?.addAnimation(0, "walk", loop = true)
			}
		}

	}
}

