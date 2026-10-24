package dev.jaronline.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.the
import org.jetbrains.changelog.ChangelogPlugin as JBChangelogPlugin
import org.jetbrains.changelog.ChangelogPluginExtension

class ChangelogPlugin : Plugin<Project> {
	override fun apply(project: Project) {
		project.configureChangelog()
	}
}

private fun Project.configureChangelog() {
	pluginManager.apply(BuildPropertiesPlugin::class.java)
	pluginManager.apply(JBChangelogPlugin::class.java)

	val buildProperties = the<BuildPropertiesExtension>()

	extensions.configure<ChangelogPluginExtension> {
		versionPrefix.set(if (project == rootProject) "v" else "${project.name}@")
		version.set(project.version.toString())
		introduction.set("""
			All notable changes to this project will be documented in this file.
			
			The format is based on [Keep a Changelog](https://keepachangelog.com/en/2.0.0/), and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).
		""".trimIndent())
		repositoryUrl.set(buildProperties.githubUrl)
		outputFile.set(file("release-notes.txt"))
	}
}