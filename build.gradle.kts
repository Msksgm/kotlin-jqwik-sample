import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    /**
     * AssertJ
     *
     * URL
     * - https://assertj.github.io/doc/
     * MavenCentral
     * - https://mvnrepository.com/artifact/org.assertj/assertj-core
     * Main用途
     * - JUnitでassertThat(xxx).isEqualTo(yyy)みたいな感じで比較時に使う
     * Sub用途
     * - 特になし
     * 概要
     * - JUnit等を直感的に利用するためのライブラリ
     */
    testImplementation("org.assertj:assertj-core:3.23.1")

    /**
     * jqwik
     *
     * URL
     * - https://jqwik.net/
     * MavenCentral
     * - https://mvnrepository.com/artifact/net.jqwik/jqwik
     * - https://mvnrepository.com/artifact/net.jqwik/jqwik-kotlin
     * Main用途
     * - Property Based Testing(pbt)
     * 概要
     * - Property Based Testingをするのに便利なライブラリ
     * 参考
     * - https://medium.com/criteo-engineering/introduction-to-property-based-testing-f5236229d237
     * - https://johanneslink.net/property-based-testing-in-kotlin/#jqwiks-kotlin-support
     */
    testImplementation("net.jqwik:jqwik:1.6.5")
    testImplementation("net.jqwik:jqwik-kotlin:1.6.5")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}