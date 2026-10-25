plugins {
	`kotlin-dsl`
}

repositories {
	gradlePluginPortal()
}

dependencies {
	implementation(project(":build-properties"))
    implementation(kotlin("gradle-plugin", libs.versions.kotlin.get()))
	implementation(libs.plugin.dokka)
}

gradlePlugin {
	plugins {
		register("kotlin") {
			id = "dev.jaronline.kotlin"
			implementationClass = "dev.jaronline.gradle.kotlin.KotlinPlugin"
		}
	}
}

sourceSets {
	named("main") {
		java.setSrcDirs(listOf<String>())
		resources.setSrcDirs(listOf<String>())
	}
	named("test") {
		java.setSrcDirs(listOf<String>())
		kotlin.setSrcDirs(listOf<String>())
		resources.setSrcDirs(listOf<String>())
	}
}