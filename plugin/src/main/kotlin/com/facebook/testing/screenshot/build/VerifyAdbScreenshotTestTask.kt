/*
 * Copyright (c) Facebook, Inc. and its affiliates.
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

package com.facebook.testing.screenshot.build

import com.android.build.gradle.api.TestVariant

open class VerifyAdbScreenshotTestTask : RunScreenshotTestTask() {
    companion object {
        fun taskName(variant: TestVariant) = "verifyAdb${variant.name.capitalize()}ScreenshotTest"
    }

    init {
        description = "Installs and runs screenshot tests locally, " +
            "then verifies their output against previously recorded screenshots. " +
            "Ignores referenceDir and predefinedCiDevice parameters."
        group = ScreenshotsPlugin.GROUP
        verify = true
    }

    override fun init(variant: TestVariant, extension: ScreenshotsPluginExtension) {
        super.init(
            variant,
            cloneExtension(extension)
                .apply {
                    predefinedCiDevice = null
                    referenceDir = null
                }
        )
    }
}
