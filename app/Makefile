.DEFAULT_GOAL := build

build:
	./gradlew clean build

run-dist:
	./build/install/app/bin/app src/test/resources/filepath1.json src/test/resources/filepath2.json

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

build: build

.PHONY: build