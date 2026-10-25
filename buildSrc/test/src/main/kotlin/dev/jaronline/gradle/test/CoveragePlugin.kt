package dev.jaronline.gradle.test

import dev.jaronline.gradle.BuildPropertiesExtension
import dev.jaronline.gradle.BuildPropertiesPlugin
import info.solidsoft.gradle.pitest.PitestPlugin
import info.solidsoft.gradle.pitest.PitestPluginExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.named
import org.gradle.kotlin.dsl.the
import org.gradle.testing.jacoco.plugins.JacocoPlugin

class CoveragePlugin : Plugin<Project> {
	override fun apply(project: Project) {
		project.configureTestCoverage()
	}
}

private fun Project.configureTestCoverage() {
	pluginManager.apply(BuildPropertiesPlugin::class.java)
	pluginManager.apply(JacocoPlugin::class.java)
	pluginManager.apply(PitestPlugin::class.java)

	val buildProperties = the<BuildPropertiesExtension>()

	tasks.named<Test>("test") {
		finalizedBy(tasks.named("jacocoTestReport"), tasks.named("pitest"))
	}

	extensions.configure<PitestPluginExtension> {
		exportLineCoverage.set(true)
		outputFormats.set(listOf("XML"))
		junit5PluginVersion.set(buildProperties.pitestJunit5Version.version)
	}
}