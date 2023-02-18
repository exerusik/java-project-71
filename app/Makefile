run-dist:
	./build/install/app/bin/app src/main/resources/file.json src/main/resources/file1.json

run-plain:
	./build/install/app/bin/app -f plain src/main/resources/file2.json src/main/resources/file3.json

run-json:
	./build/install/app/bin/app -f json src/main/resources/file.json src/main/resources/file1.json

build:
	./gradlew clean build

report:
	./gradlew jacocoTestReport

.PHONY: build
