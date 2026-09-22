rootProject.name = "TurkSinema"

val disabled = setOf("_template")

File(rootDir, ".").listFiles()
    ?.filter { it.isDirectory && !disabled.contains(it.name) }
    ?.filter { File(it, "build.gradle.kts").exists() }
    ?.forEach { include(it.name) }
