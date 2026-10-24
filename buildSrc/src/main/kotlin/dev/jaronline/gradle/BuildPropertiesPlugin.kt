package dev.jaronline.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.create

class BuildPropertiesPlugin : Plugin<Project> {
	override fun apply(project: Project) {
		project.extensions.create<BuildPropertiesExtension>("buildProperties", project)
	}
}

abstract class BuildPropertiesExtension(private val project: Project) {
	val githubUrl = gradleProperty("github_url")

	fun gradleProperty(propertyName: String): Provider<String> {
		return project.providers.gradleProperty(propertyName)
	}
}