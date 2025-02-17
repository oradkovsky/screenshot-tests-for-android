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
import org.gradle.api.DefaultTask

open class ScreenshotTask : DefaultTask() {
    protected lateinit var extension: ScreenshotsPluginExtension
    protected lateinit var variant: TestVariant

    open fun init(variant: TestVariant, extension: ScreenshotsPluginExtension) {
        this.extension = extension
        this.variant = variant
    }

    protected fun cloneExtension(extension: ScreenshotsPluginExtension): ScreenshotsPluginExtension {
        return ScreenshotsPluginExtension()
            .apply {
                recordDir = extension.recordDir
                addDeps = extension.addDeps
                multipleDevices = extension.multipleDevices
                predefinedCiDevice = extension.predefinedCiDevice
                pythonExecutable = extension.pythonExecutable
                referenceDir = extension.referenceDir
                failureDir = extension.failureDir
            }
    }
}
