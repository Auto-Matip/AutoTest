plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // Source: https://mvnrepository.com/artifact/org.assertj/assertj-core
    testImplementation("org.assertj:assertj-core:3.27.7")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<Test>("runtest") {
    //group = "practic"
    useJUnitPlatform {
        includeTags("Smoke")
    }
}

tasks.register<Test>("launch") {
    group = "practic"
    useJUnitPlatform {
        includeTags("Assert")
    }
    }



tasks.named("launch") {
    dependsOn("affterLaunch")

}

tasks.register("affterLaunch"){
    group = "practic"
    println("Test run is over!")
}


tasks.register<Test>("smoke") {
    systemProperty("CIRCUIT", System.getProperty("circuit","DEV"))
    useJUnitPlatform {
        includeTags("Smoke")
    }

}