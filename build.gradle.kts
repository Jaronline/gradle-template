plugins {
	id("dev.jaronline.project")
	id("dev.jaronline.test")
	alias(libs.plugins.java.formatting)
}

spotless {
	ratchetFrom = "origin/main"

	kotlinGradle {
		target(
			"*.gradle.kts",
			"buildSrc/*.gradle.kts",
			"buildSrc/*/*.gradle.kts",
			// Remove this line if you don't have any subprojects
			*subprojects.map { "${it.projectDir.name}/*.gradle.kts" }.toTypedArray(),
		)
		ktlint()
		leadingSpacesToTabs()
		endWithNewline()
	}
}

javaFormatting {
	target("*/src/*/java/dev/jaronline/**/*.java")
	all()
}

repositories {
	mavenCentral()
}
