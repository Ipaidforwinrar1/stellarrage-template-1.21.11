# Stellarrage Template (1.21.11)

Minimal Fabric Minecraft mod template based on the Stellarrage example.

## Summary
This repository contains a Gradle + Fabric Loom mod template for Minecraft `1.21.11`. Use the provided Gradle wrapper to build, run, and develop the mod on Linux.

## Requirements
- Java 17\+ (JDK)
- Gradle wrapper (use the included `./gradlew`)
- Internet access for dependency resolution (first run)
- Recommended IDE: IntelliJ IDEA

## Quick commands (from project root)
- Build: `./gradlew build`
- Run client: `./gradlew runClient`
- Run tests: `./gradlew test`
- Create remapped JAR (for distribution): `./gradlew remapJar` (if configured)

## IntelliJ setup
1. Open the project root in IntelliJ.
2. Let Gradle import the project or run `./gradlew --refresh-dependencies`.
3. Use the Gradle tool window to run `runClient` or configure a run configuration.

## Project layout
- `build.gradle`, `gradle.properties`, `settings.gradle` — build configuration
- `gradlew`, `gradlew.bat` — Gradle wrappers
- `src/` — source code and resources
  - `client/` and `main/` subfolders for client and common code
- `run/` — local game runtime files (logs, saves, etc.)
- `devlibs/`, `build/`, `libs/` — generated build artifacts and caches

## Developing
- Edit sources in `src/`.
- Use `./gradlew build` frequently to catch compilation errors.
- For mod distribution, produce the remapped artifact (see `remapJar`).

## Contributing
- Keep changes small and focused.
- Update resources and `mods.toml`/metadata as needed.

## License
See the `LICENSE` file in the project root for license details.
