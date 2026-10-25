plugins {
	`kotlin-dsl`
}

repositories {
	gradlePluginPortal()
}

dependencies {
	implementation(libs.plugin.changelog)
	implementation(libs.plugin.spotless.changelog)
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
		register("project") {
			id = "dev.jaronline.project"
			implementationClass = "dev.jaronline.gradle.ProjectPlugin"
		}
		register("test") {
			id = "dev.jaronline.test"
			implementationClass = "dev.jaronline.gradle.TestPlugin"
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