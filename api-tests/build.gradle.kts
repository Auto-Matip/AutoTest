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
   implementation("org.assertj:assertj-core:3.27.7")
    implementation("io.rest-assured:rest-assured:5.5.6")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.22.1")
    //testImplementation("org.junit.jupiter:junit-jupiter:5.12.2")
    // testImplementation("org.junit.platform:junit-platform-suite:1.12.2")
    implementation("org.seleniumhq.selenium:selenium-java:4.46.0")
    implementation("com.codeborne:selenide:7.17.0")
}

tasks.test {
    useJUnitPlatform()
}


tasks.register<Test>("resttest") {
    group = "api"
    useJUnitPlatform {
        includeTags("Rest")
    }
}

tasks.register<Test>("uitest") {
    group = "ui"
    useJUnitPlatform {
        includeTags("ui")
    }
}

tasks.register<Test>("RunAllTests") {
    group = "apiTest"
    useJUnitPlatform {
        includeTags("Create","GetGoods","GetGoodById","ChangeGood","DeleteGood")
    }
}



val CreateTest by tasks.registering(Test::class) {
    group = "apiTest"
    useJUnitPlatform {
        includeTags("Create")
    }
}

val GetGoodsTest by tasks.registering(Test::class) {
    group = "apiTest"
    useJUnitPlatform {
        includeTags("GetGoods")
    }

    mustRunAfter(CreateTest)
}

val GetGoodByIdTest by tasks.registering(Test::class) {
    group = "apiTest"
    useJUnitPlatform {
        includeTags("GetGoodById")
    }

    mustRunAfter(CreateTest, GetGoodsTest)
}

val ChangeGoodTest by tasks.registering(Test::class) {
    group = "apiTest"
    useJUnitPlatform {
        includeTags("ChangeGood")
    }

    mustRunAfter(CreateTest, GetGoodsTest, GetGoodByIdTest)
}

val DeleteGoodTest by tasks.registering(Test::class) {
    group = "apiTest"
    useJUnitPlatform {
        includeTags("DeleteGood")
    }
    mustRunAfter(CreateTest, GetGoodsTest, GetGoodByIdTest, ChangeGoodTest)
}


tasks.register<Test>("runTagsInOrder") {
    group = "verification"
    description = "Запуск тестов по очереди"

    dependsOn(CreateTest, GetGoodsTest, GetGoodByIdTest, ChangeGoodTest, DeleteGoodTest)
}

val CrTest by tasks.registering(Test::class) {
    group = "apiTest"
    useJUnitPlatform {
        includeTags("CR")
    }
}

val DeleteTest by tasks.registering(Test::class) {
    group = "apiTest"
    useJUnitPlatform {
        includeTags("Del")
    }
    mustRunAfter(CrTest)
}

tasks.register<Test>("runTags") {
    group = "apiTest"
    description = "Запуск тестов по очереди"

    dependsOn(CrTest, DeleteTest)
}
