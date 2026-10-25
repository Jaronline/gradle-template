plugins {
    id("dev.jaronline.project")
    id("dev.jaronline.test")
    alias(libs.plugins.java.formatting)
}

javaFormatting {
    val targets = providers.environmentVariable("SPOTLESS_TARGETS")
        .map { it ->
            it.split("\n")
                .filter { it.endsWith(".java") }
        }
        .orElse(listOf("*/src/*/java/dev/jaronline/gradle/**/*.java"))

    target(targets)
    all()
}

repositories {
    mavenCentral()
}