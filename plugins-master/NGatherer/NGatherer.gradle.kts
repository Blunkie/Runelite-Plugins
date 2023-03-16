/*
 * Copyright (c) 2021-2022, Numb#1147 <https://github.com/NumbPlugins>
 * All rights reserved.
 * Licensed under GPL3, see LICENSE for the full scope.
 */
version = "0.0.1"

project.extra["PluginName"] = "NGatherer"
project.extra["PluginDescription"] = "Gathers from various nodes and banks or drops."
project.extra["PluginProvider"] = "ZTD#1147"
project.extra["PluginSupportUrl"] = "https://github.com/Anarchise/aplugins"
dependencies {
    compileOnly(project(":NUtils"))
}
buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }

}
tasks {
    jar {
        manifest {
            attributes(mapOf(
                "Plugin-Version" to project.version,
                "Plugin-Id" to nameToId(project.extra["PluginName"] as String),
                "Plugin-Provider" to project.extra["PluginProvider"],
                "Plugin-Dependencies" to
                        arrayOf(
                            nameToId("NUtils")
                        ).joinToString(),
                "Plugin-Description" to project.extra["PluginDescription"],
                "Plugin-License" to project.extra["PluginLicense"]
            ))
        }
    }
}