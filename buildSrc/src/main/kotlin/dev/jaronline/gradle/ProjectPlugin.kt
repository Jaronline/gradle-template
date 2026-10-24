package dev.jaronline.gradle

import com.diffplug.spotless.changelog.gradle.ChangelogExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the

class ProjectPlugin : Plugin<Project> {
	override fun apply(project: Project) {
		project.configureProject()
	}
}

private fun Project.configureProject() {
	pluginManager.apply(ChangelogPlugin::class.java)

	val spotlessChangelog = the<ChangelogExtension>()

	version = spotlessChangelog.versionNext
}