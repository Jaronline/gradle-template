# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/2.0.0/), and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added

### Changed

### Deprecated

### Removed

### Fixed

### Security

## [0.2.1] - 2026-10-26

I once again forgot to add the GH_TOKEN environment variable correctly. Oops...

### Fixed

- GitHub: added missing GH_TOKEN environment variable to prerelease in release workflow

## [0.2.0] - 2026-10-26

### Added

- GitHub: release workflow now automatically detects and creates prerelease GitHub releases

## [0.1.2] - 2026-10-26

### Fixed

- GitHub: fix usage of GITHUB_TOKEN in release workflow

## [0.1.1] - 2026-10-26

**Warning:** This release has not fixed the bug from version 0.1.0 and should not be used!

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

[Unreleased]: https://github.com/Jaronline/gradle-template/compare/v0.2.1...HEAD
[0.2.1]: https://github.com/Jaronline/gradle-template/compare/v0.2.0...v0.2.1
[0.2.0]: https://github.com/Jaronline/gradle-template/compare/v0.1.2...v0.2.0
[0.1.2]: https://github.com/Jaronline/gradle-template/compare/v0.1.1...v0.1.2
[0.1.1]: https://github.com/Jaronline/gradle-template/compare/v0.1.0...v0.1.1
[0.1.0]: https://github.com/Jaronline/gradle-template/commits/v0.1.0
