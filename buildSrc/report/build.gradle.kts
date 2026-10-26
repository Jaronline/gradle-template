plugins {
	`kotlin-dsl`
}

repositories {
	gradlePluginPortal()
}

dependencies {
	implementation(project(":build-properties"))
	implementation(libs.plugin.pitest.aggregator)
}

gradlePlugin {
	plugins {
		register("aggregation") {
			id = "dev.jaronline.report.aggregation"
			implementationClass = "dev.jaronline.gradle.test.AggregationPlugin"
		}
		register("coverage") {
			id = "dev.jaronline.report.coverage"
			implementationClass = "dev.jaronline.gradle.test.CoveragePlugin"
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
