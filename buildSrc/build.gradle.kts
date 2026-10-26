plugins {
	`kotlin-dsl` apply false
}

repositories {
	gradlePluginPortal()
	mavenCentral()
}

dependencies {
	subprojects.forEach(this::runtimeOnly)
}
