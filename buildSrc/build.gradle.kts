plugins {
	`kotlin-dsl`
}

repositories {
	gradlePluginPortal()
}

dependencies {
	implementation(libs.plugin.changelog)
}

gradlePlugin {
	plugins {
		register("buildProperties") {
			id = "dev.jaronline.build-properties"
			implementationClass = "dev.jaronline.gradle.BuildPropertiesPlugin"
		}
		register("changelog") {
			id = "dev.jaronline.changelog"
			implementationClass = "dev.jaronline.gradle.ChangelogPlugin"
		}
	}
}

sourceSets {
	named("main") {
		java.setSrcDirs(listOf<String>())
		groovy.setSrcDirs(listOf<String>())
		resources.setSrcDirs(listOf<String>())
	}
	named("test") {
		java.setSrcDirs(listOf<String>())
		kotlin.setSrcDirs(listOf<String>())
		groovy.setSrcDirs(listOf<String>())
		resources.setSrcDirs(listOf<String>())
	}
}