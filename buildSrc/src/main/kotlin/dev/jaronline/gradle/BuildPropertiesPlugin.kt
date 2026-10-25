package dev.jaronline.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.artifacts.VersionConstraint
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.the

class BuildPropertiesPlugin : Plugin<Project> {
	override fun apply(project: Project) {
		project.extensions.create<BuildPropertiesExtension>("buildProperties", project)
	}
}

abstract class BuildPropertiesExtension(private val project: Project) {
    val libs = findVersionCatalog("libs")

	val groupId = gradleProperty("group_id")
	val githubUrl = gradleProperty("github_url")

	val javaVersion = versionLookup("java")

	fun gradleProperty(propertyName: String): Provider<String> {
		return project.providers.gradleProperty(propertyName)
	}

    fun versionLookup(id: String): GeoVersionConstraint {
        return GeoVersionConstraint(project.provider {
            libs.findVersion(id)
                .orElseThrow {
                    NoSuchElementException(
                        "Version '${
                            id.replace(
                                '.',
                                '-'
                            )
                        }' does not exist in version catalogue '${libs.name}'!"
                    )
                }
        })
    }

    fun libraryLookup(id: String): Provider<MinimalExternalModuleDependency> {
        return libs.findLibrary(id)
            .orElseThrow {
                NoSuchElementException(
                    "Library '${
                        id.replace(
                            '.',
                            '-'
                        )
                    }' does not exist in version catalogue '${libs.name}'!"
                )
            }
    }

    fun findVersionCatalog(name: String): VersionCatalog {
        return project.the<VersionCatalogsExtension>().find(name).orElseThrow {
            NoSuchElementException("No version catalogue '$name' exists!")
        }
    }

    class GeoVersionConstraint(private val constraint: Provider<VersionConstraint>) :
        Provider<VersionConstraint> by constraint {
        val version: String
            get() {
                val constraint = get()
                val version = constraint.preferredVersion

                if (version.isEmpty())
                    return constraint.requiredVersion

                return version
            }

        val range: String
            get() {
                val constraint = get()
                var range = constraint.requiredVersion

                if (range.isEmpty()) {
                    range = constraint.strictVersion

                    if (range.isEmpty())
                        throw IllegalArgumentException("Version constraint '${constraint.displayName}' does not have a required or strict version declared!")
                }

                return range
            }

        override fun toString(): String {
            return version
        }
    }
}