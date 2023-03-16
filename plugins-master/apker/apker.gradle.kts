
version = "1.0.1"

project.extra["PluginName"] = "APker" // This is the name that is used in the external plugin manager panel
project.extra["PluginDescription"] = "Overpowered PvP tools based on Ben93riggs' pktools plugin." // This is the description that is used in the external plugin manager panel
project.extra["PluginProvider"] = "Anarchise"
project.extra["PluginSupportUrl"] = "https://discord.com/invite/KwJnhKQJVc"
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