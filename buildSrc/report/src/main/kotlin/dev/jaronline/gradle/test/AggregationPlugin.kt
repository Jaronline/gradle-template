package dev.jaronline.gradle.test

import info.solidsoft.gradle.pitest.PitestAggregatorPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.reporting.ReportingExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.named
import org.gradle.kotlin.dsl.create
import org.gradle.testing.jacoco.plugins.JacocoCoverageReport
import org.gradle.testing.jacoco.plugins.JacocoReportAggregationPlugin

class AggregationPlugin : Plugin<Project> {
	override fun apply(project: Project) {
		project.configureJacocoAggregation()
	}
}

private fun Project.configureJacocoAggregation() {
    @Suppress("UnstableApiUsage")
	pluginManager.apply(JacocoReportAggregationPlugin::class.java)
    @Suppress("UnstableApiUsage")
	pluginManager.apply(PitestAggregatorPlugin::class.java)

	extensions.configure<ReportingExtension> {
        @Suppress("UnstableApiUsage")
		reports {
			named<JacocoCoverageReport>("testCodeCoverageReport") {
				testSuiteName.set("test")
			}
		}
	}

	val pitestReportAggregate = tasks.named("pitestReportAggregate") {
		dependsOn(subprojects.mapNotNull { it.tasks.findByName("pitest") })
	}

	val configureTestTask: Task.() -> Unit = {
		dependsOn(subprojects.mapNotNull { it.tasks.findByName("test") })
		finalizedBy(tasks.named("testCodeCoverageReport"), pitestReportAggregate)
	}

	if (tasks.findByName("test") == null)
		tasks.register("test", configureTestTask)
	else
		tasks.named("test", configureTestTask)
}