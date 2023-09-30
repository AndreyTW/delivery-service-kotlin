plugins {
    kotlin("jvm")
    id("java")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

group = "ru.andreyTw.delivery"
version = "1.0"

val springVersion: String by project
val springBootVersion: String by project
val springDependencyManagementPluginVersion: String by project
val junitVersion: String by project
val junitPlatformVersion: String by project
val mockitoVersion: String by project
val mockitoKotlinVersion: String by project
val cucumberVersion: String by project
val lombokVersion: String by project

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.springframework.boot:spring-boot-starter-web:$springBootVersion")
    implementation("org.mockito:mockito-core:$mockitoVersion")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.4")
    runtimeOnly("com.h2database:h2")

    testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")
    testImplementation("org.mockito.kotlin:mockito-kotlin:$mockitoKotlinVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
    testImplementation("org.springframework:spring-test:$springVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation("org.junit.platform:junit-platform-commons:$junitPlatformVersion")

    testImplementation("io.cucumber:cucumber-java:$cucumberVersion")
    testImplementation("io.cucumber:cucumber-junit:$cucumberVersion")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:$cucumberVersion")

}

tasks.withType<Test> {
    useJUnitPlatform()
}