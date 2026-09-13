import kotlin.io.path.absolutePathString

plugins {
        id("dev.isxander.modstitch.base") version "0.8.5"
}

fun prop(name: String, consumer: (prop: String) -> Unit) {
        (findProperty(name) as? String?)
                ?.let(consumer)
}

val minecraft = property("deps.minecraft") as String

modstitch {
        if (isLoom) base.archivesName = "tide-fabric-$minecraft"
        if (isModDevGradleRegular) base.archivesName = "tide-neoforge-$minecraft"
        if (isModDevGradleLegacy) base.archivesName = "tide-forge-$minecraft"

        minecraftVersion = minecraft

        // If parchment doesn't exist for a version yet, you can safely
        // omit the "deps.parchment" property from your versioned gradle.properties
        parchment {
                prop("deps.parchment") { mappingsVersion = it }
        }

        // This metadata is used to fill out the information inside
        // the metadata files found in the templates folder.
        metadata {
                modId = "tide"
                modName = "Tide"
                modVersion = "2.1.1"
                modGroup = "com.li64.tide"
                modAuthor = "Lightning64"
                modDescription = "Expands the fishing system and adds 100+ new fish."
                modLicense = "MPL-2.0"

                fun <K : Any, V: Any> MapProperty<K, V>.populate(block: MapProperty<K, V>.() -> Unit) {
                block()
                }

                replacementProperties.populate {
                // You can put any other replacement properties/metadata here that
                // modstitch doesn't initially support. Some examples below.
                put("mod_homepage", "https://www.curseforge.com/minecraft/mc-mods/tide")
                put("mod_issue_tracker", "https://github.com/Lightning-64/Tide-2/issues")
                put("pack_format", when (property("deps.minecraft")) {
                        "1.20.1" -> 15
                        "1.21.1" -> 34
                        "26.2" -> 88
                        else -> throw IllegalArgumentException("Please store the resource pack version for ${property("deps.minecraft")} in build.gradle.kts! https://minecraft.wiki/w/Pack_format")
                }.toString())
                put("mc_version", minecraft)
                }
        }

        // Fabric Loom (Fabric)
        loom {
                // It's not recommended to store the Fabric Loader version in properties.
                // Make sure it's up to date.
                fabricLoaderVersion = "0.19.3"

                // Configure loom like normal in this block.
                configureLoom {
                        val aw = rootProject.file("src/main/resources/accesswideners/tide-$minecraft.accesswidener")
                        if (aw.exists()) accessWidenerPath = aw

                        runs {
                                create("data") {
                                client()

                                name = "Data Generation"
                                runDir = "build/datagen"

                                vmArg("-Dfabric-api.datagen")
                                vmArg("-Dfabric-api.datagen.output-dir=" + project.rootDir.toPath().resolve("src/generated-$minecraft/resources"))
                                vmArg("-Dfabric-api.datagen.modid=tide")
                                }
                        }
                        mixin {
                                useLegacyMixinAp = false
                        }
                }
        }

        // ModDevGradle (NeoForge, Forge, Forgelike)
        val datagenPath =
                if (isModDevGradleRegular) "src/generated-$minecraft/neoforge-resources"
                else "src/generated-$minecraft/forge-resources"


        moddevgradle {
                prop("deps.forge") { forgeVersion = it }
                prop("deps.neoform") { neoFormVersion = it }
                prop("deps.neoforge") { neoForgeVersion = it }
                prop("deps.mcp") { mcpVersion = it }

                // Configures client and server runs for MDG, it is not done by default
                defaultRuns()

                // This block configures the `neoforge` extension that MDG exposes by default,
                // you can configure MDG like normal from here
                configureNeoForge {
                        sourceSets["main"].resources.srcDir(rootProject.file(datagenPath))
                        val at = rootProject.file("src/main/resources/accesstransformers/$minecraft.cfg")
                        if (at.exists()) accessTransformers.from(at)
                }
        }

        if (isModDevGradle) {
                tasks.matching { it.name == "createMinecraftArtifacts" }.configureEach {
                dependsOn("stonecutterGenerate")
                }
        }

        runs {
                if (isModDevGradle) {
                        create("data") {
                                client()
                                datagen = true
                                programArgs.addAll("--mod", metadata.modId.get(), "--all",
                                "--output", project.rootDir.toPath().resolve("src/generated-$minecraft/neoforge-resources").absolutePathString())
                        }
                }
        }

        mixin {
                // You do not need to specify mixins in any mods.json/toml file if this is set to
                // true, it will automatically be generated.
                addMixinsToModManifest = true

                configs.register("tide")
                if (isModDevGradle) configs.register("tide-neoforge")
        }

}

sourceSets["main"].resources.srcDir(rootProject.file("src/generated-$minecraft/resources"))
sourceSets["main"].resources.srcDir(rootProject.file("src/main/resources-$minecraft"))

// Stonecutter constants for mod loaders.
// See https://stonecutter.kikugie.dev/stonecutter/guide/comments#condition-constants
var constraint: String = name.split("-")[1]
stonecutter.constants {
        put("fabric", constraint == "fabric")
        put("neoforge", constraint == "neoforge")
        put("forge", constraint == "forge")
        put("vanilla", constraint == "vanilla")
}

// All dependencies should be specified through modstitch's proxy configuration.
// Wondering where the "repositories" block is? Go to "stonecutter.gradle.kts"
// If you want to create proxy configurations for more source sets, such as client source sets,
// use the modstitch.createProxyConfigurations(sourceSets["client"]) function.
dependencies {
    modstitch.loom {
        if (minecraft == "26.2") {
                // fabric 26.2
                modstitchModApi("me.shedaniel.cloth:cloth-config-fabric:26.2.155") { exclude("net.fabricmc.fabric-api") }
                modstitchModImplementation("net.fabricmc.fabric-api:fabric-api:0.157.0+26.2")
                modstitchModImplementation("com.terraformersmc:modmenu:20.0.0-beta.2")
                modstitchModCompileOnly("eu.pb4:trinkets:4.1.0-beta.3+26.2")
                modstitchModCompileOnly("curse.maven:fabric-seasons-413523:5789846")
                modstitchModCompileOnly("curse.maven:serene-seasons-291874:6182595")
                modstitchModCompileOnly("curse.maven:fishing-real-348834:6465669")
                modstitchModCompileOnly("curse.maven:hybrid-aquatic-834427:7694020")
                modstitchModCompileOnly("com.geckolib:geckolib-fabric-26.2:5.5.4")
        }

        if (minecraft == "1.21.1") {
            // fabric 1.21.1
            modstitchModApi("me.shedaniel.cloth:cloth-config-fabric:15.0.140") { exclude("net.fabricmc.fabric-api") }
            modstitchModImplementation("net.fabricmc.fabric-api:fabric-api:0.116.0+1.21.1")
            modstitchModImplementation("com.terraformersmc:modmenu:11.0.3")
            modstitchModCompileOnly("dev.emi:trinkets:3.10.0")
            modstitchModCompileOnly("curse.maven:fabric-seasons-413523:5789846")
            modstitchModCompileOnly("curse.maven:serene-seasons-291874:6182595")
            modstitchModCompileOnly("curse.maven:fishing-real-348834:6465669")
            modstitchModCompileOnly("curse.maven:hybrid-aquatic-834427:7694020")
            modstitchModCompileOnly("software.bernie.geckolib:geckolib-fabric-1.21.1:4.8.2")
        }


        if (minecraft == "1.20.1") {
            // fabric 1.20.1
            modstitchModImplementation("net.fabricmc.fabric-api:fabric-api:0.92.6+1.20.1")
            modstitchModApi("me.shedaniel.cloth:cloth-config-fabric:11.1.136") { exclude("net.fabricmc.fabric-api") }
            modstitchModImplementation("com.terraformersmc:modmenu:7.2.2")
            modstitchModCompileOnly("dev.emi:trinkets:3.7.2")
            modstitchModCompileOnly("curse.maven:fabric-seasons-413523:5788996")
            modstitchModCompileOnly("curse.maven:serene-seasons-291874:6398228")
            modstitchModCompileOnly("curse.maven:fishing-real-348834:6475356")
            modstitchModCompileOnly("curse.maven:hybrid-aquatic-834427:8216583")
            modstitchModCompileOnly("software.bernie.geckolib:geckolib-fabric-1.20.1:4.8.2")
            modstitchCompileOnly("com.eliotlash.mclib:mclib:20")
            modstitchModCompileOnly("maven.modrinth:9wJhd9x6:HWz0cRcl") // Stardew Fishing Fabric
        }
    }

    modstitch.moddevgradle {
        if (minecraft == "1.21.1") {
            // neo 1.21.1
            modstitchModApi("me.shedaniel.cloth:cloth-config-neoforge:15.0.140")
            modstitchModApi("top.theillusivec4.curios:curios-neoforge:9.5.1+1.21.1:api")
            modstitchModRuntimeOnly("top.theillusivec4.curios:curios-neoforge:9.5.1+1.21.1")
            modstitchModCompileOnly("curse.maven:serene-seasons-291874:6182596")
            modstitchModCompileOnly("curse.maven:ecliptic-seasons-1118306:7304586")
            modstitchModCompileOnly("curse.maven:stardew-fishing-1066037:7266308")
            modstitchModCompileOnly("curse.maven:starcatcher-1357603:8431589")
            modstitchModCompileOnly("curse.maven:fishing-real-348834:6465668")
            modstitchModCompileOnly("curse.maven:hybrid-aquatic-834427:7694018")
            modstitchModCompileOnly("software.bernie.geckolib:geckolib-neoforge-1.21.1:4.8.2")
        }
        if (minecraft == "1.20.1") {
            // forge 1.20.1
            modstitchModApi("me.shedaniel.cloth:cloth-config-forge:11.1.136")
            modstitchModApi("top.theillusivec4.curios:curios-forge:5.14.1+1.20.1:api")
            // modstitchModRuntimeOnly("top.theillusivec4.curios:curios-forge:5.14.1+1.20.1")
            modstitchModCompileOnly("curse.maven:serene-seasons-291874:6398227")
            modstitchModCompileOnly("curse.maven:ecliptic-seasons-1118306:7304569")
            modstitchModCompileOnly("curse.maven:stardew-fishing-1066037:7266346")
            modstitchModCompileOnly("curse.maven:fishing-real-348834:6475355")
            modstitchModCompileOnly("curse.maven:hybrid-aquatic-834427:8216589")
            modstitchModCompileOnly("software.bernie.geckolib:geckolib-forge-1.20.1:4.8.2")
            modstitchCompileOnly("com.eliotlash.mclib:mclib:20")
            modstitchCompileOnly("org.jetbrains:annotations:24.0.0")
        }
    }
}
