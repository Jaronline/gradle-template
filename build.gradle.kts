plugins {
    id("dev.jaronline.project")
    id("dev.jaronline.test")
    alias(libs.plugins.java.formatting)
}

spotless {
    ratchetFrom = "origin/main"
}

javaFormatting {
    target("*/src/*/java/dev/jaronline/**/*.java")
    all()
}

repositories {
    mavenCentral()
}