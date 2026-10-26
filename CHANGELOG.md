# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/2.0.0/), and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Fixed

- GitHub: use GH_TOKEN environment variable instead of GITHUB_TOKEN for the GitHub CLI in release workflow

## [0.1.0] - 2026-10-26

### Added

- buildSrc: Report aggregation plugin with JaCoCo and PITest
- buildSrc: Kotlin formatting plugin
- buildSrc: Test coverage plugin with JaCoCo and PITest
- buildSrc: Mockito plugin for test mocking
- buildSrc: Kotlin project plugin
- buildSrc: Test plugin with JUnit Platform 
- GitHub: Release workflow with SSH signing
- buildSrc: Project plugin with automatic version
- buildSrc: Changelog configuration and plugin with `org.jetbrains.changelog` and `com.diffplug.spotless-changelog`
- buildSrc: Build properties plugin
- GitHub: Miscellaneous issue template
- GitHub: Bug report issue template
- GitHub: Gradle continuous integration with build and check jobs
- GitHub: Automatic issue and PR labels configuration and workflow
- GitHub: Automatic label synchronization configuration and workflow
- Automatic Git hooks configuration to `.githooks/`
- Java formatting with `net.mezzdev.java-formatting`
- Basic `.gitattributes` for Java projects
- Basic `.gitignore` for Java with Gradle projects

[Unreleased]: https://github.com/Jaronline/gradle-template/compare/v0.1.0...HEAD
[0.1.0]: https://github.com/Jaronline/gradle-template/commits/v0.1.0
